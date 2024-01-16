package com.sulimann.casadocodigo.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.springframework.util.Assert;

import lombok.Getter;

@Embeddable
@Getter
public class ItemPedido implements Serializable{

    private static final long serialVersionUID = 1L;

    @ManyToOne
    private Livro livro;
    private Integer quantidade;
    private BigDecimal preco;
    private BigDecimal subTotal;

    /**
     * @Deprecated
     * Não utilizar!
     * Criado apenas por obrigação do hibernate
     */
    @Deprecated
    public ItemPedido(){
    }

    public ItemPedido(Livro livro, Integer quantidade, BigDecimal preco) {
        Assert.notNull(livro, "Livro não pode ser nulo");
        Assert.isTrue(Objects.nonNull(quantidade) && quantidade > 0, "Quantidade não pode ser nulo ou menor que zero");
        Assert.isTrue(Objects.nonNull(preco) && preco.doubleValue() > 0, "Preço não pode ser nulo ou menor que zero");

        this.livro = livro;
        this.quantidade = quantidade;
        this.preco = preco;
        this.subTotal = this.obterSubTotal();
    }

    public BigDecimal obterSubTotal() {
        return this.preco.multiply(new BigDecimal(this.quantidade));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((livro == null) ? 0 : livro.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ItemPedido other = (ItemPedido) obj;
        if (livro == null) {
            if (other.livro != null)
                return false;
        } else if (!livro.equals(other.livro))
            return false;
        return true;
    }

}
