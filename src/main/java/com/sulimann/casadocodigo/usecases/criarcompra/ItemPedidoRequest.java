package com.sulimann.casadocodigo.usecases.criarcompra;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.util.Assert;

import com.sulimann.casadocodigo.models.ItemPedido;
import com.sulimann.casadocodigo.models.Livro;
import com.sulimann.casadocodigo.utils.ErrorMessage;
import com.sulimann.casadocodigo.validators.existsbyid.ExistsById;

import lombok.Getter;

@Getter
public class ItemPedidoRequest implements Serializable{

    private static final long serialVersionUID = 1L;

    @ExistsById(domainClass = Livro.class, fieldName = "id", message = "Livro não encontrado")
    @NotNull(message = ErrorMessage.CAMPO_OBRIGATORIO)
    private Long livroId;

    @NotNull(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @Positive(message = "A quantidade deve ser maior do que zero")
    private Integer quantidade;

    public ItemPedido toModel(EntityManager manager) {
        Assert.notNull(manager,"Entity Manager não poder ser nulo");
        Livro livro = manager.find(Livro.class, this.livroId);
        return new ItemPedido(livro, this.quantidade, livro.getPreco());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((livroId == null) ? 0 : livroId.hashCode());
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
        ItemPedidoRequest other = (ItemPedidoRequest) obj;
        if (livroId == null) {
            if (other.livroId != null)
                return false;
        } else if (!livroId.equals(other.livroId))
            return false;
        return true;
    }

}
