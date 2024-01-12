package com.sulimann.casadocodigo.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sulimann.casadocodigo.utils.TableName;

import lombok.Getter;

@Entity
@Table(name = TableName.LIVRO)
@Getter
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroPaginas;
    private String isbn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataPublicacao;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    /**
     * @Deprecated
     * Não utilizar!
     * Criado apenas por obrigação do hibernate
     */
    @Deprecated
    public Livro(){
    }

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroPaginas, String isbn,
            LocalDate dataPublicacao, Categoria categoria, Autor autor) {
        Assert.isTrue(titulo != null && !titulo.isBlank(), "Título não pode ser nulo ou em branco");
        Assert.isTrue(resumo != null && !resumo.isBlank(), "Resumo não pode ser nulo ou em branco");
        Assert.isTrue(sumario != null && !sumario.isBlank(), "Sumário não pode ser nulo ou em branco");
        Assert.isTrue(preco != null && preco.doubleValue() > 0, "Preço não pode ser nulo e ser menor que zero");
        Assert.isTrue(numeroPaginas != null && numeroPaginas > 0, "Número de páginas não pode ser nulo e ser menor que zero");
        Assert.isTrue(isbn != null && !isbn.isBlank(), "ISBN não pode ser nulo ou em branco");
        Assert.isTrue(dataPublicacao != null && dataPublicacao.compareTo(LocalDate.now()) >= 0, "Data de publicação não pode ser nulo e preciser ser no futuro");
        Assert.notNull(categoria, "Categoria não pode ser nulo");
        Assert.notNull(autor, "Autor não pode ser nulo");
        
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

}
