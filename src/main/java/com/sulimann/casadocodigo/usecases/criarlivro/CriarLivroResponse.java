package com.sulimann.casadocodigo.usecases.criarlivro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sulimann.casadocodigo.models.Livro;

import lombok.Getter;

@Getter
public class CriarLivroResponse implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroPaginas;
    private String isbn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataPublicacao;
    private CategoriaResponseInCriarLivro categoria;
    private AutorResponseInCriarLivro autor;

    public CriarLivroResponse(Livro entity) {
        this.id = entity.getId();
        this.titulo = entity.getTitulo();
        this.resumo = entity.getResumo();
        this.sumario = entity.getSumario();
        this.preco = entity.getPreco();
        this.numeroPaginas = entity.getNumeroPaginas();
        this.isbn = entity.getIsbn();
        this.dataPublicacao = entity.getDataPublicacao();
        this.categoria = new CategoriaResponseInCriarLivro(entity.getCategoria());
        this.autor = new AutorResponseInCriarLivro(entity.getAutor());
    }

}
