package com.sulimann.casadocodigo.usecases.obterdetalhecompra;

import java.io.Serializable;
import java.math.BigDecimal;

import com.sulimann.casadocodigo.models.ItemPedido;

import lombok.Getter;

@Getter
public class ItemPedidoResponseInObterDetalheCompra implements Serializable{

    private static final long serialVersionUID = 1L;

    private String nomeProduto;
    private Integer quantidade;
    private BigDecimal precoProduto;
    private BigDecimal subTotal;

    public ItemPedidoResponseInObterDetalheCompra(ItemPedido entity){
        this.nomeProduto = entity.getLivro().getTitulo();
        this.quantidade = entity.getQuantidade();
        this.precoProduto = entity.getPreco();
        this.subTotal = entity.getSubTotal();
    }

}
