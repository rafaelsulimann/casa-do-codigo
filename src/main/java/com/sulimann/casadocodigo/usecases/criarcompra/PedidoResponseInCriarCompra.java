package com.sulimann.casadocodigo.usecases.criarcompra;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

import com.sulimann.casadocodigo.models.Pedido;

import lombok.Getter;

@Getter
public class PedidoResponseInCriarCompra implements Serializable{

    private static final long serialVersionUID = 1L;

    private BigDecimal total;
    private Set<ItemPedidoResponseInCriarCompra> itens;

    public PedidoResponseInCriarCompra(Pedido entity) {
        this.total = entity.getTotal();
        this.itens = entity.getItens().stream().map(ItemPedidoResponseInCriarCompra::new).collect(Collectors.toSet());

    }

}
