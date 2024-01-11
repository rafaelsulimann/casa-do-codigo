package com.sulimann.casadocodigo.usecases.criarestado;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.sulimann.casadocodigo.models.Estado;
import com.sulimann.casadocodigo.models.Pais;
import com.sulimann.casadocodigo.utils.ErrorMessage;
import com.sulimann.casadocodigo.validators.existsbyid.ExistsById;
import com.sulimann.casadocodigo.validators.uniquevalue.UniqueValue;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CriarEstadoRequest implements Serializable{

    private static final long serialVersionUID = 1L;

    @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @UniqueValue(domainClass = Estado.class, fieldName = "nome", message = "Estado já existente")
    private String nome;

    @NotNull(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @ExistsById(domainClass = Pais.class, fieldName = "id", message = "Pais não encontrado")
    private Long paisId;

    public Estado toModel(EntityManager manager) {
        Pais pais = manager.find(Pais.class, this.paisId);
        return new Estado(this.nome, pais);
    }

}
