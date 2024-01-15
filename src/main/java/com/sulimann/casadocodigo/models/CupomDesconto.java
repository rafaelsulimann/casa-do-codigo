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

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate validade;

    /**
     * @deprecated
     * Não utilizar!
     * Criado apenas por obrigação do hibernate
     */
    @Deprecated
    public CupomDesconto(){
    }

    public CupomDesconto(String codigo, BigDecimal percentual, LocalDate validade) {
        Assert.isTrue(codigo != null && !codigo.isBlank(), "Código não poder ser nulo ou em branco");
        Assert.isTrue(percentual != null && percentual.doubleValue() > 0, "Percentual não pode ser nulo ou menor que zero");
        Assert.isTrue(validade != null && validade.compareTo(LocalDate.now()) >= 0, "Validade não pode ser nulo e precisa ser no futuro");

        this.codigo = codigo;
        this.percentual = percentual;
        this.validade = validade;
    }

    public boolean isValido() {
        return this.validade.atTime(00,01).compareTo(LocalDate.now().atTime(00, 00)) <= 0;
    }
    
}
