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
            BigDecimal totalSemDesconto = request.getPedido().montaItensPedido(manager).stream().map(ItemPedido::getSubTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal totalComCupomDeDesconto = totalSemDesconto.subtract(totalSemDesconto.multiply(cupom.getPercentual().divide(new BigDecimal(100))));
            if(totalComCupomDeDesconto.doubleValue() != request.getPedido().getTotal().doubleValue()){
                errors.rejectValue("pedido.total", null, "Total informado é diferente do total calculado");
            }
            return;
        }

        BigDecimal totalSemDesconto = request.getPedido().montaItensPedido(manager).stream().map(ItemPedido::getSubTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
        if(totalSemDesconto.doubleValue() != request.getPedido().getTotal().doubleValue()){
            errors.rejectValue("pedido.total", null, "Total informado é diferente do total calculado");
        }
    }

}
