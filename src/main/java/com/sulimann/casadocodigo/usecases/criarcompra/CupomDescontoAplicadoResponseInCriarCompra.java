package com.sulimann.casadocodigo.usecases.criarcompra;

import java.io.Serializable;
import java.math.BigDecimal;

import com.sulimann.casadocodigo.models.CupomDescontoAplicado;

import lombok.Getter;

@Getter
public class CupomDescontoAplicadoResponseInCriarCompra implements Serializable{

    private static final long serialVersionUID = 1L;

    private String codigo;
    private BigDecimal percentual;

    public CupomDescontoAplicadoResponseInCriarCompra(CupomDescontoAplicado entity){
        this.codigo = entity.getCodigo();
        this.percentual = entity.getPercentual();
    }

}
