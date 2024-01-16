package com.sulimann.casadocodigo.usecases.criarcompra;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
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
    @NotNull(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @NotEmpty(message = "Lista de itens precisa ter no mínimo 1 item")
    private Set<ItemPedidoRequest> itens;

    public Function<Compra, Pedido> toModel(EntityManager manager) {
        Assert.isTrue(Objects.nonNull(manager), "Manager não pode ser nulo");
        return compra -> {
            Set<ItemPedido> itensPedido = this.montaItensPedido(manager);
            return new Pedido(itensPedido, compra);
        };
    }

    public Set<ItemPedido> montaItensPedido(EntityManager manager) {
        Assert.isTrue(Objects.nonNull(manager), "Manager não pode ser nulo");
        return this.itens.stream().map(item -> item.toModel(manager)).collect(Collectors.toSet());
    }

}
