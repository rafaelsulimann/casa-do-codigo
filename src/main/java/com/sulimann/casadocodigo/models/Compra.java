package com.sulimann.casadocodigo.models;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@Table(name = TableName.COMPRA)
@Getter
public class Compra implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String nome;
    private String sobrenome;
    private String documento;
    private String endereco;
    private String complemento;
    private String cidade;
    private String telefone;
    private String cep;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime dataCompra = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    public Compra(String email, String nome, String sobrenome, String documento, String endereco, String complemento,
            String cidade, String telefone, String cep, Pais pais) {
        Assert.notNull(email, "Email não pode ser nulo");
        Assert.notNull(nome, "Nome não pode ser nulo");
        Assert.notNull(sobrenome, "Sobrenome não pode ser nulo");
        Assert.notNull(documento, "Documento não pode ser nulo");
        Assert.notNull(endereco, "Endereço não pode ser nulo");
        Assert.notNull(complemento, "Complemento não pode ser nulo");
        Assert.notNull(cidade, "Cidade não pode ser nulo");
        Assert.notNull(telefone, "Telefone não pode ser nulo");
        Assert.notNull(cep, "CEP não pode ser nulo");
        Assert.notNull(pais, "País não pode ser nulo");
        
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.pais = pais;
    }

    public void setEstado(Estado estado) {
        Assert.notNull(estado, "Estado não pode ser nulo");
        Assert.isTrue(estado.pertenceAoPais(this.pais), "Estado informado não pertence ao país da compra");
        this.estado = estado;
    }

}
