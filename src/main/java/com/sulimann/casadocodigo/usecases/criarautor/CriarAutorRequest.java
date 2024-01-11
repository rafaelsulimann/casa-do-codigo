package com.sulimann.casadocodigo.usecases.criarautor;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sulimann.casadocodigo.models.Autor;
import com.sulimann.casadocodigo.utils.ErrorMessage;
import com.sulimann.casadocodigo.validators.uniquevalue.UniqueValue;

import lombok.Getter;

@Getter
public class CriarAutorRequest implements Serializable{

    private static final long serialVersionUID = 1L;

    @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @UniqueValue(domainClass = Autor.class, fieldName = "nome", message = "Autor já existente")
    private String nome;
    
    @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @Email(message = "Email inválido")
    @UniqueValue(domainClass = Autor.class, fieldName = "email", message = "Email já existente")
    private String email;

    @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @Size(max = 400)
    private String descricao;

    public Autor toModel() {
        return new Autor(this.nome, this.email, this.descricao);
    }

}
