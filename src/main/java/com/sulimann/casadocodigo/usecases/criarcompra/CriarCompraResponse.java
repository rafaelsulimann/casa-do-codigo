package com.sulimann.casadocodigo.usecases.criarcompra;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sulimann.casadocodigo.models.Compra;

import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CriarCompraResponse implements Serializable{

    private static final long serialVersionUID = 1L;

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
    private LocalDateTime dataCompra;

    private PaisResponseInCriarCompra pais;
    private EstadoResponseInCriarCompra estado;
    private PedidoResponseInCriarCompra pedido;

    public CriarCompraResponse(Compra entity) {
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.nome = entity.getNome();
        this.sobrenome = entity.getSobrenome();
        this.documento = entity.getDocumento();
        this.endereco = entity.getEndereco();
        this.complemento = entity.getComplemento();
        this.cidade = entity.getCidade();
        this.telefone = entity.getTelefone();
        this.cep = entity.getCep();
        this.dataCompra = entity.getDataCompra();
        this.pais = new PaisResponseInCriarCompra(entity.getPais());
        this.estado = entity.getEstado() != null ? new EstadoResponseInCriarCompra(entity.getEstado()) : null;
        this.pedido = new PedidoResponseInCriarCompra(entity.getPedido());
    }

}
