package com.sulimann.casadocodigo.usecases.criarautor;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sulimann.casadocodigo.models.Autor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Response implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String email;
    private String descricao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime dataCriacao;

    public Response(Autor entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.email = entity.getEmail();
        this.descricao = entity.getDescricao();
        this.dataCriacao = entity.getDataCriacao();
    }

}
