package com.sulimann.casadocodigo.usecases.criarestado;

import java.io.Serializable;

import com.sulimann.casadocodigo.models.Estado;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CriarEstadoResponse implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private PaisResponseInCriarEstado pais;

    public CriarEstadoResponse(Estado entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.pais = new PaisResponseInCriarEstado(entity.getPais());
    }

}
