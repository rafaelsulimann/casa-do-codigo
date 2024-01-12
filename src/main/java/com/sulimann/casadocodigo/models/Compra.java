package com.sulimann.casadocodigo.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.function.Function;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sulimann.casadocodigo.utils.Regex;
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

    @OneToOne(mappedBy="compra", cascade = CascadeType.ALL)
    private Pedido pedido;    

    public Compra(String email, String nome, String sobrenome, String documento, String endereco, String complemento,
            String cidade, String telefone, String cep, Pais pais, Function<Compra, Pedido> pedido) {
        Assert.isTrue(email != null && !email.isBlank() && email.matches(Regex.EMAIL), "Email não pode ser nulo ou em branco");
        Assert.isTrue(nome != null && !nome.isBlank(), "Nome não pode ser nulo ou em branco");
        Assert.isTrue(sobrenome != null && !sobrenome.isBlank(), "Sobrenome não pode ser nulo ou em branco");
        Assert.isTrue(documento != null && !documento.isBlank() && documento.matches(Regex.CPF_OU_CNPJ), "Documento não pode ser nulo ou em branco e precisa ser um documento válido");
        Assert.isTrue(endereco != null && !endereco.isBlank(), "Endereço não pode ser nulo ou em branco");
        Assert.isTrue(complemento != null && !complemento.isBlank(), "Complemento não pode ser nulo ou em branco");
        Assert.isTrue(cidade != null && !cidade.isBlank(), "Cidade não pode ser nulo ou em branco");
        Assert.isTrue(telefone != null && !telefone.isBlank() && telefone.matches(Regex.CELULAR), "Telefone não pode ser nulo ou em branco e precisa ser um telefone válido");
        Assert.isTrue(cep != null && !cep.isBlank() && cep.matches(Regex.CEP), "CEP não pode ser nulo ou em branco e precisa ser um cep válido");
        Assert.notNull(pais, "País não pode ser nulo");
        Assert.notNull(pedido, "Pedido não pode ser nulo");
        
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
        this.pedido = pedido.apply(this);
    }

    public void setEstado(Estado estado) {
        Assert.notNull(estado, "Estado não pode ser nulo");
        Assert.isTrue(estado.pertenceAoPais(this.pais), "Estado informado não pertence ao país da compra");
        this.estado = estado;
    }

}
