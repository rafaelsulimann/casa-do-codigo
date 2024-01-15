package com.sulimann.casadocodigo.usecases.obterdetalhecompra;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sulimann.casadocodigo.models.CupomDescontoAplicado;

import lombok.Getter;

@Getter
public class CupomAplicadoResponseInObterDetalheCompra implements Serializable{

    private static final long serialVersionUID = 1L;

    private String codigo;
    private BigDecimal percentual;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate validade;

    public CupomAplicadoResponseInObterDetalheCompra(CupomDescontoAplicado entity){
        this.codigo = entity.getCodigo();
        this.percentual = entity.getPercentual();
        this.validade = entity.getValidade();
    }

}
