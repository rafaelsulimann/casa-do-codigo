package com.sulimann.casadocodigo.usecases.criarcompra;

import java.time.LocalDate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sulimann.casadocodigo.models.CupomDesconto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CupomDescontoEstaNaValidadeValidator implements Validator{

    private final CupomDescontoRepository cupomDescontoRepository;

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

        if(request.possuiCupomDesconto()){
            CupomDesconto cupom = this.cupomDescontoRepository.findByCodigo(request.getCodigoCupom());

            if(cupom.isValido()){
                errors.rejectValue("codigoCupom", null, "Cupom de desconto não está mais válido");
            }
        }
    }

}
