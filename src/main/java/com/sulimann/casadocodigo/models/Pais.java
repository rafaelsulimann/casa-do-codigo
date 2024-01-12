package com.sulimann.casadocodigo.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.util.Assert;

import com.sulimann.casadocodigo.utils.TableName;

import lombok.Getter;

@Entity
@Table(name = TableName.PAIS)
@Getter
public class Pais implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "pais", fetch = FetchType.EAGER)
    private Set<Estado> estados = new HashSet<>();

    /**
     * @Deprecated
     * Não utilizar!
     * Criado apenas para atender exigencias do hibernate
     */
    @Deprecated 
    public Pais(){
    }

    public Pais(String nome){
        Assert.isTrue(nome != null && !nome.isBlank(), "Nome não pode ser nulo ou em branco");
        this.nome = nome;
    }

    public boolean possuiEstados() {
        return !estados.isEmpty();
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
        Pais other = (Pais) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

}
