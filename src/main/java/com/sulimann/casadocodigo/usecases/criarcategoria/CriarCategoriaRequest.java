package com.sulimann.casadocodigo.usecases.criarcategoria;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.sulimann.casadocodigo.models.Categoria;
import com.sulimann.casadocodigo.utils.ErrorMessage;
import com.sulimann.casadocodigo.validators.uniquevalue.UniqueValue;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CriarCategoriaRequest implements Serializable{

    private static final long serialVersionUID = 1L;

    @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Categoria já existente")
    private String nome;

    public Categoria toModel() {
        return new Categoria(this.nome);
    }

}
