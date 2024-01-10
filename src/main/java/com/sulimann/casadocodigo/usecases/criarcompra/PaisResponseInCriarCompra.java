package com.sulimann.casadocodigo.usecases.criarcompra;

import java.io.Serializable;

import com.sulimann.casadocodigo.models.Pais;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaisResponseInCriarCompra implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;

    public PaisResponseInCriarCompra(Pais entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

}
