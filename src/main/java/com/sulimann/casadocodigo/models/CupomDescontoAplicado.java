package com.sulimann.casadocodigo.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

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
        Assert.isTrue(entity != null && entity.getPercentual() != null && entity.getValidade() != null, "Cupom de desconto não pode ser nulo");
        Assert.isTrue(entity.getCodigo() != null, "Código não pode ser nulo");
        Assert.isTrue(entity.getPercentual().doubleValue() > 0, "Percentual de desconto não pode ser nulo e precisa ser maior que zero");
        // Assert.isTrue(entity.getValidade().compareTo(LocalDate.now()) >= 0, "Valida precisa ser no futuro");

        this.cupom = entity;
        this.codigo = entity.getCodigo();
        this.percentual = entity.getPercentual();
        this.validade = entity.getValidade();
    }

}
