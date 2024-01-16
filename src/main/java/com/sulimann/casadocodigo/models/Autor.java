package com.sulimann.casadocodigo.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sulimann.casadocodigo.utils.Regex;
import com.sulimann.casadocodigo.utils.TableName;

import lombok.Getter;

@Entity
@Table(name = TableName.AUTOR)
@Getter
public class Autor implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String descricao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    /**
     * @Depecreated
     * Não utilizar!
     * Criado apenas pro obrigação do hibernate
     */
    @Deprecated
    public Autor(){
    }

    public Autor(String nome, String email, String descricao) {
        Assert.isTrue(Objects.nonNull(nome) && StringUtils.hasText(nome), "Nome não pode ser nulo ou em branco");
        Assert.isTrue(Objects.nonNull(email) && StringUtils.hasText(email) && email.matches(Regex.EMAIL), "Email não pode ser nulo ou em branco e precisa ser um email válido");
        Assert.isTrue(Objects.nonNull(descricao) && StringUtils.hasText(descricao), "Descrição não pode ser nulo ou em branco");

        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

}
