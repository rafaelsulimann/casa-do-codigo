package com.sulimann.casadocodigo.usecases.obterdetalhelivro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sulimann.casadocodigo.models.Livro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ObterDetalheLivroResponse implements Serializable{

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

    private AutorResponseInObterDetalheLivro autor;

    public ObterDetalheLivroResponse(Livro entity) {
        this.id = entity.getId();
        this.titulo = entity.getTitulo();
        this.resumo = entity.getResumo();
        this.sumario = entity.getSumario();
        this.preco = entity.getPreco();
        this.numeroPaginas = entity.getNumeroPaginas();
        this.isbn = entity.getIsbn();
        this.dataPublicacao = entity.getDataPublicacao();
        this.autor = new AutorResponseInObterDetalheLivro(entity.getAutor());
    }

}
