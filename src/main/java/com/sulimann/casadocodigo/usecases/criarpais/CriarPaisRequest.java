package com.sulimann.casadocodigo.usecases.criarpais;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.sulimann.casadocodigo.models.Pais;
import com.sulimann.casadocodigo.utils.ErrorMessage;
import com.sulimann.casadocodigo.validators.uniquevalue.UniqueValue;

import lombok.Getter;

@Getter
public class CriarPaisRequest implements Serializable{

    private static final long serialVersionUID = 1L;

    @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "Pais já existente")
    private String nome;

    public Pais toModel() {
        return new Pais(this.nome);
    }

}
