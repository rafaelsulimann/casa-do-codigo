package com.sulimann.casadocodigo.usecases.criarcompra;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sulimann.casadocodigo.models.Estado;
import com.sulimann.casadocodigo.models.Pais;

@Component
public class EstadoPertenceAPaisValidator implements Validator{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> clazz) {
        return CriarCompraRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        CriarCompraRequest request = (CriarCompraRequest) target;

        Pais pais = this.manager.find(Pais.class, request.getPaisId());

        if(pais.possuiEstados() && !request.temEstado()){
            errors.rejectValue("estadoId", null, "Este pais possui estados, favor informar um estado");
            return;
        }

        if(!request.temEstado()){
            return ;
        }

        Estado estado = this.manager.find(Estado.class, request.getEstadoId());

        if(!estado.pertenceAoPais(pais)){
            errors.rejectValue("estadoId", null, "Estado não pertence a este país");
        }
    }

}
