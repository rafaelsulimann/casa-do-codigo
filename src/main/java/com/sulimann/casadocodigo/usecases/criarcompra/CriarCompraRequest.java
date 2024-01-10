package com.sulimann.casadocodigo.usecases.criarcompra;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.sulimann.casadocodigo.models.Compra;
import com.sulimann.casadocodigo.models.Estado;
import com.sulimann.casadocodigo.models.Pais;
import com.sulimann.casadocodigo.utils.ErrorMessage;
import com.sulimann.casadocodigo.validators.cep.Cep;
import com.sulimann.casadocodigo.validators.cpforcnpj.CpfOrCnpj;
import com.sulimann.casadocodigo.validators.existsbyid.ExistsById;
import com.sulimann.casadocodigo.validators.telefone.Telefone;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CriarCompraRequest implements Serializable{

    private static final long serialVersionUID = 1L;

    @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
    private String nome;

    @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
    private String sobrenome;

    @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @CpfOrCnpj(message = "Documento deve ser um CPF ou CNPJ")
    private String documento;

    @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
    private String endereco;

    @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
    private String complemento;

    @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
    private String cidade;

    @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @Telefone(message = "Telefone precisa ter formato válido")
    private String telefone;

    @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @Cep(message = "CEP precisa ter formato válido")
    private String cep;

    @NotNull(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @ExistsById(domainClass = Pais.class, fieldName = "id", message = "Pais não encontrado")
    private Long paisId;

    @ExistsById(domainClass = Estado.class, fieldName = "id", message = "Estado não encontrado")
    private Long estadoId;

    public Compra toModel(EntityManager manager) {
        Pais pais = manager.find(Pais.class, this.paisId);

        Compra compra = new Compra(
            this.email, 
            this.nome, 
            this.sobrenome, 
            this.documento,
            this.endereco, 
            this.complemento, 
            this.cidade, 
            this.telefone, 
            this.cep, 
            pais
        );

        if(this.estadoId != null){
            Estado estado = manager.find(Estado.class, this.estadoId);
            compra.setEstado(estado);
        }

        return compra;
    }

}
