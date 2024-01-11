package com.sulimann.casadocodigo.usecases.criarcompra;

import java.io.Serializable;

import com.sulimann.casadocodigo.models.Estado;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EstadoResponseInCriarCompra implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;

    public EstadoResponseInCriarCompra(Estado entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

}
