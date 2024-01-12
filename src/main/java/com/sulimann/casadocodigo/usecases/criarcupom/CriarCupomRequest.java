package com.sulimann.casadocodigo.usecases.criarcupom;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sulimann.casadocodigo.models.CupomDesconto;
import com.sulimann.casadocodigo.utils.ErrorMessage;
import com.sulimann.casadocodigo.validators.uniquevalue.UniqueValue;

import lombok.Getter;

@Getter
public class CriarCupomRequest implements Serializable{

    private static final long serialVersionUID = 1L;

    @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @UniqueValue(domainClass = CupomDesconto.class, fieldName = "codigo", message = "Cupom de desconto já existente")
    private String codigo;

    @NotNull(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @Positive(message = "Percentual deve ser um valor positivo")
    private BigDecimal percentual;

    @NotNull(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @Future(message = "Validade precisa ser no futuro")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate validade;

    public CupomDesconto toModel() {
        return new CupomDesconto(this.codigo, this.percentual, this.validade);
    }

}
