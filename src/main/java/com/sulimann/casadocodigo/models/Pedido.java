package com.sulimann.casadocodigo.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.util.Assert;

import com.sulimann.casadocodigo.utils.TableName;

import lombok.Getter;

@Entity
@Table(name = TableName.PEDIDO)
@Getter
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal total;

    @ElementCollection
    private Set<ItemPedido> itens;

    @OneToOne
    private Compra compra;

    public Pedido(Set<ItemPedido> itens, Compra compra) {
        Assert.isTrue(!itens.isEmpty(), "Lista de Itens não pode ser vazia");
        Assert.notNull(compra, "Compra não pode ser nulo");

        this.itens = itens;
        this.compra = compra;
        this.total = this.obterTotal();
    }

    private BigDecimal obterTotal() {
        return itens.stream().map(ItemPedido::getSubTotal).reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    public boolean totalIgual(BigDecimal totalInformado){
        return this.total.equals(totalInformado);
    }

    public void aplicaDesconto(CupomDescontoAplicado cupom){
        this.total = this.total.subtract(this.total.multiply(cupom.getPercentual().divide(new BigDecimal(100))));
    }

}
