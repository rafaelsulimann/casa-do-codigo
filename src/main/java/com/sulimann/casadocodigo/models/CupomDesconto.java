package com.sulimann.casadocodigo.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.util.Assert;

import com.sulimann.casadocodigo.utils.TableName;

import lombok.Getter;

@Entity
@Table(name = TableName.CUPOM_DESCONTO)
@Getter
public class CupomDesconto implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private BigDecimal percentual;
    private LocalDate validade;

    public CupomDesconto(String codigo, BigDecimal percentual, LocalDate validade) {
        Assert.isTrue(codigo != null && !codigo.isBlank(), "Código não poder ser nulo ou em branco");
        Assert.isTrue(percentual != null && percentual.doubleValue() > 0, "Percentual não pode ser nulo ou menor que zero");
        Assert.isTrue(validade != null && validade.compareTo(LocalDate.now()) >= 0, "Validade não pode ser nulo e precisa ser no futuro");

        this.codigo = codigo;
        this.percentual = percentual;
        this.validade = validade;
    }

    
    
}
