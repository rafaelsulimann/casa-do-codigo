package com.sulimann.casadocodigo.usecases.criarlivro;

import java.io.Serializable;

import com.sulimann.casadocodigo.models.Autor;

import lombok.Getter;

@Getter
public class AutorResponseInCriarLivro implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;

    public AutorResponseInCriarLivro(Autor entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

}
