package com.sulimann.casadocodigo.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sulimann.casadocodigo.utils.TableName;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = TableName.CATEGORIA)
@Getter
@NoArgsConstructor
public class Categoria implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    
    public Categoria(String nome){
        this.nome = nome;
    }
}
