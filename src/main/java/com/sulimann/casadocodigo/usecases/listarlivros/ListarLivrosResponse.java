package com.sulimann.casadocodigo.usecases.listarlivros;

import java.io.Serializable;

import com.sulimann.casadocodigo.models.Livro;

import lombok.Getter;

@Getter
public class ListarLivrosResponse implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private String titulo;
    private String isbn;

    public ListarLivrosResponse(Livro entity){
        this.id = entity.getId();
        this.titulo = entity.getTitulo();
        this.isbn = entity.getIsbn();
    }

}
