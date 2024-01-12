package com.sulimann.casadocodigo.usecases.criarcompra;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.util.Assert;

import com.sulimann.casadocodigo.models.Compra;
import com.sulimann.casadocodigo.models.ItemPedido;
import com.sulimann.casadocodigo.models.Pedido;
import com.sulimann.casadocodigo.utils.ErrorMessage;

import lombok.Getter;

@Getter
public class PedidoRequest implements Serializable{

    private static final long serialVersionUID = 1L;

    @NotNull(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @Positive(message = "O total deve ser maior que zero")
    private BigDecimal total;

    @Valid
    @NotEmpty(message = "Lista de itens precisa ter no mínimo 1 item")
    private Set<ItemPedidoRequest> itens;

    public Function<Compra, Pedido> toModel(EntityManager manager) {
        return compra -> {
            Set<ItemPedido> itensPedido = this.montaItensPedido(manager);
            Pedido pedido = new Pedido(itensPedido, compra);

            Assert.isTrue(pedido.totalIgual(this.total), "O Valor total informado é diferente do valor calculado");

            return new Pedido(itensPedido, compra);
        };
    }

    private Set<ItemPedido> montaItensPedido(EntityManager manager) {
        return this.itens.stream().map(item -> item.toModel(manager)).collect(Collectors.toSet());
    }

}
