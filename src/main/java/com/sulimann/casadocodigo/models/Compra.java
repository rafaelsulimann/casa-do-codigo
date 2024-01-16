package com.sulimann.casadocodigo.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.function.Function;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

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

    @Embedded
    private CupomDescontoAplicado cupom;

    /**
     * @deprecated
     * Não utilizar!
     * Criado apenas por obrigação do hibernate
     */
    @Deprecated
    public Compra(){
    }

    public Compra(String email, String nome, String sobrenome, String documento, String endereco, String complemento,
            String cidade, String telefone, String cep, Pais pais, Function<Compra, Pedido> pedido) {
        Assert.isTrue(StringUtils.hasText(email) && email.matches(Regex.EMAIL), "Email não pode ser nulo ou em branco");
        Assert.isTrue(StringUtils.hasText(nome), "Nome não pode ser nulo ou em branco");
        Assert.isTrue(StringUtils.hasText(sobrenome), "Sobrenome não pode ser nulo ou em branco");
        Assert.isTrue(StringUtils.hasText(documento) && documento.matches(Regex.CPF_OU_CNPJ), "Documento não pode ser nulo ou em branco e precisa ser um documento válido");
        Assert.isTrue(StringUtils.hasText(endereco), "Endereço não pode ser nulo ou em branco");
        Assert.isTrue(StringUtils.hasText(complemento), "Complemento não pode ser nulo ou em branco");
        Assert.isTrue(StringUtils.hasText(cidade), "Cidade não pode ser nulo ou em branco");
        Assert.isTrue(StringUtils.hasText(telefone) && telefone.matches(Regex.CELULAR), "Telefone não pode ser nulo ou em branco e precisa ser um telefone válido");
        Assert.isTrue(StringUtils.hasText(cep) && cep.matches(Regex.CEP), "CEP não pode ser nulo ou em branco e precisa ser um cep válido");
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

    public void aplicaCupomDesconto(CupomDesconto cupomEntity) {
        Assert.isTrue(Objects.nonNull(cupomEntity) && cupomEntity.getValidade().atTime(00, 01).compareTo(LocalDate.now().atTime(00, 00)) >= 0, "Cupom de desconto não pode ser nulo e validade precisa ser no futuro");
        Assert.isTrue(Objects.isNull(this.cupom), "Não é possível aplicar um cupom de desconto em uma compra que ja foi efetuada");
        this.cupom = new CupomDescontoAplicado(cupomEntity);
        this.pedido.aplicaDesconto(cupom);
    }

}
