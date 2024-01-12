package com.sulimann.casadocodigo.usecases.criarcompra;

import java.io.Serializable;
import java.math.BigDecimal;

import com.sulimann.casadocodigo.models.ItemPedido;

import lombok.Getter;

@Getter
public class ItemPedidoResponseInCriarCompra implements Serializable{

    private static final long serialVersionUID = 1L;

    private String nomeProduto;
    private Integer quantidade;
    private BigDecimal preco;
    private BigDecimal subTotal;

    public ItemPedidoResponseInCriarCompra(ItemPedido entity){
        this.nomeProduto = entity.getLivro().getTitulo();
        this.quantidade = entity.getQuantidade();
        this.preco = entity.getPreco();
        this.subTotal = entity.getSubTotal();
    }

}
