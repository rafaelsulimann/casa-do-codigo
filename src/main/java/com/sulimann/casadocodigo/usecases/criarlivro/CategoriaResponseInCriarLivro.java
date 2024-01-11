package com.sulimann.casadocodigo.usecases.criarlivro;

import java.io.Serializable;

import com.sulimann.casadocodigo.models.Categoria;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategoriaResponseInCriarLivro implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;

    public CategoriaResponseInCriarLivro(Categoria entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

}
