package com.sulimann.casadocodigo.usecases.criarestado;

import java.io.Serializable;

import com.sulimann.casadocodigo.models.Pais;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PaisResponseInCriarEstado implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;

    public PaisResponseInCriarEstado(Pais entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

}
