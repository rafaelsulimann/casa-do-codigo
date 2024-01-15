package com.sulimann.casadocodigo.usecases.criarcompra;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sulimann.casadocodigo.models.CupomDesconto;
import com.sulimann.casadocodigo.models.ItemPedido;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TotalInformadoIgualAoCalculadoValidator implements Validator{

    @PersistenceContext
    private EntityManager manager;

    private final CupomDescontoRepository cupomDescontoRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CriarCompraRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        CriarCompraRequest request = (CriarCompraRequest) target;

        if(request.possuiCupomDesconto()){
            CupomDesconto cupom = this.cupomDescontoRepository.findByCodigo(request.getCodigoCupom());
            BigDecimal totalSemDesconto = this.obterTotalSemDesconto(request.getPedido(), this.manager);
            BigDecimal totalComCupomDeDesconto = this.aplicaDesconto(cupom, totalSemDesconto);
            if(this.totalIgual(request.getPedido().getTotal(), totalComCupomDeDesconto)){
                errors.rejectValue("pedido.total", null, "Total informado é diferente do total calculado");
            }
            return;
        }

        BigDecimal totalSemDesconto = this.obterTotalSemDesconto(request.getPedido(), this.manager);
        if(this.totalIgual(request.getPedido().getTotal(), totalSemDesconto)){
            errors.rejectValue("pedido.total", null, "Total informado é diferente do total calculado");
        }
    }

    private boolean totalIgual(BigDecimal totalInformado, BigDecimal totalCalculado) {
        return totalCalculado.doubleValue() != totalInformado.doubleValue();
    }

    private BigDecimal aplicaDesconto(CupomDesconto cupom, BigDecimal totalSemDesconto) {
        return totalSemDesconto.subtract(totalSemDesconto.multiply(cupom.getPercentual().divide(new BigDecimal(100))));
    }

    private BigDecimal obterTotalSemDesconto(PedidoRequest pedido, EntityManager manager) {
        return pedido.montaItensPedido(manager).stream().map(ItemPedido::getSubTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
