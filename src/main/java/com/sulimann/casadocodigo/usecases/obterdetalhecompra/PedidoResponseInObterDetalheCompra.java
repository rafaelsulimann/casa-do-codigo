package com.sulimann.casadocodigo.usecases.obterdetalhecompra;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

import com.sulimann.casadocodigo.models.Pedido;

import lombok.Getter;

@Getter
public class PedidoResponseInObterDetalheCompra implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private BigDecimal total;
    private Set<ItemPedidoResponseInObterDetalheCompra> itens;

    public PedidoResponseInObterDetalheCompra(Pedido entity){
        this.id = entity.getId();
        this.total = entity.getTotal();
        this.itens = entity.getItens().stream().map(ItemPedidoResponseInObterDetalheCompra::new).collect(Collectors.toSet());
    }

}
