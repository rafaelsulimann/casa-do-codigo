package com.sulimann.casadocodigo.validators.telefone;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.sulimann.casadocodigo.utils.Regex;

public class TelefoneValidator implements ConstraintValidator<Telefone, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        return value.matches(Regex.CELULAR);
    }

    

}



