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

    public CupomDescontoAplicado(CupomDesconto cupomDesconto){
        Assert.isTrue(Objects.nonNull(cupomDesconto) && Objects.nonNull(cupomDesconto.getPercentual()) && Objects.nonNull(cupomDesconto.getValidade()) && Objects.nonNull(cupomDesconto.getCodigo()), "Cupom de desconto não pode ser nulo");
        Assert.isTrue(cupomDesconto.getPercentual().doubleValue() > 0, "Percentual de desconto não pode ser nulo e precisa ser maior que zero");
        Assert.isTrue(cupomDesconto.isValido(), "Valida precisa ser no futuro");

        this.cupom = cupomDesconto;
        this.codigo = cupomDesconto.getCodigo();
        this.percentual = cupomDesconto.getPercentual();
        this.validade = cupomDesconto.getValidade();
    }

}
