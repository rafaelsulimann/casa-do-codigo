package com.sulimann.casadocodigo.usecases.criarcategoria;

import com.sulimann.casadocodigo.models.Categoria;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CriarCategoriaResponse {

    private Long id;
    private String nome;

    public CriarCategoriaResponse(Categoria entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

}
