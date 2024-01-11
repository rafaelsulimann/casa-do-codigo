package com.sulimann.casadocodigo.usecases.obterdetalhelivro;

import java.io.Serializable;

import com.sulimann.casadocodigo.models.Autor;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AutorResponseInObterDetalheLivro implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String descricao;

    public AutorResponseInObterDetalheLivro(Autor entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.descricao = entity.getDescricao();
    }

}
