package com.sulimann.casadocodigo.usecases.criarcupom;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sulimann.casadocodigo.models.CupomDesconto;

import lombok.Getter;

@Getter
public class CriarCupomResponse implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private String codigo;
    private BigDecimal percentual;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate validade;

    public CriarCupomResponse(CupomDesconto entity) {
        this.id = entity.getId();
        this.codigo = entity.getCodigo();
        this.percentual = entity.getPercentual().setScale(2);
        this.validade = entity.getValidade();
    }

}
