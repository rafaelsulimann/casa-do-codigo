package com.sulimann.casadocodigo.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.springframework.util.Assert;

import lombok.Getter;

@Embeddable
@Getter
public class CupomDescontoAplicado implements Serializable{

    private static final long serialVersionUID = 1L;

    @ManyToOne
    private CupomDesconto cupom;

    private String codigo;
    private BigDecimal percentual;
    private LocalDate validade;

    /**
     * @Deprecated
     * Não utilizar!
     * Criado apenas por obrigação do hibernate
     */
    @Deprecated
    public CupomDescontoAplicado(){
    }

    public CupomDescontoAplicado(CupomDesconto entity){
        Assert.isTrue(Objects.nonNull(entity) && Objects.nonNull(entity.getPercentual()) && Objects.nonNull(entity.getValidade()) && Objects.nonNull(entity.getCodigo()), "Cupom de desconto não pode ser nulo");
        Assert.isTrue(entity.getPercentual().doubleValue() > 0, "Percentual de desconto não pode ser nulo e precisa ser maior que zero");
        Assert.isTrue(entity.getValidade().atTime(00, 01).compareTo(LocalDate.now().atTime(00, 00)) >= 0, "Valida precisa ser no futuro");

        this.cupom = entity;
        this.codigo = entity.getCodigo();
        this.percentual = entity.getPercentual();
        this.validade = entity.getValidade();
    }

}
