package com.sulimann.casadocodigo.usecases.criarlivro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sulimann.casadocodigo.models.Autor;
import com.sulimann.casadocodigo.models.Categoria;
import com.sulimann.casadocodigo.models.Livro;
import com.sulimann.casadocodigo.utils.ErrorMessage;
import com.sulimann.casadocodigo.validators.existsbyid.ExistsById;
import com.sulimann.casadocodigo.validators.uniquevalue.UniqueValue;

import lombok.Getter;

@Getter
public class CriarLivroRequest implements Serializable{

    private static final long serialVersionUID = 1L;

    @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "Título já existente")
    private String titulo;

    @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @Size(max = 500)
    private String resumo;

    @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
    private String sumario;

    @NotNull(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @Min(20)
    private BigDecimal preco;

    @NotNull(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @Min(100)
    private Integer numeroPaginas;

    @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn", message = "ISBN já existente")
    private String isbn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @Future(message = "A data de publicação precisa ser no futuro")
    private LocalDate dataPublicacao;

    @NotNull(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @ExistsById(domainClass = Categoria.class, fieldName = "id", message = "Categoria não encontrado")
    private Long categoriaId;

    @NotNull(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @ExistsById(domainClass = Autor.class, fieldName = "id", message = "Autor não encontrado")
    private Long autorId;

    public Livro toModel(EntityManager manager) {
        Assert.notNull(manager, "Entity Manager não pode ser nulo");
        Categoria categoria = manager.find(Categoria.class, this.categoriaId);
        Autor autor = manager.find(Autor.class, this.autorId);

        return new Livro(
            this.titulo, 
            this.resumo, 
            this.sumario, 
            this.preco, 
            this.numeroPaginas, 
            this.isbn, 
            this.dataPublicacao, 
            categoria, 
            autor
        );
    }

}
