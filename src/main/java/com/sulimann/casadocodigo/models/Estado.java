package com.sulimann.casadocodigo.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.util.Assert;

import com.sulimann.casadocodigo.utils.TableName;

import lombok.Getter;

@Entity
@Table(name = TableName.ESTADO)
@Getter
public class Estado implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    /**
     * @Deprecated
     * Não utilizar!
     * Criado apenas para atender exigencias do hibernate
     */
    @Deprecated
    public Estado(){
    }

    public Estado(String nome, Pais pais) {
        Assert.isTrue(nome != null && !nome.isBlank(), "Nome não pode ser nulo ou em branco");
        Assert.notNull(pais, "País não pode ser nulo");
        this.nome = nome;
        this.pais = pais;
    }

    public boolean pertenceAoPais(Pais pais) {
        return this.pais.equals(pais);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
        Estado other = (Estado) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    

}
