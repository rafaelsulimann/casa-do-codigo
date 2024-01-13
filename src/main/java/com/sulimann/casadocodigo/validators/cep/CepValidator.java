package com.sulimann.casadocodigo.validators.cep;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.sulimann.casadocodigo.utils.Regex;

public class CepValidator implements ConstraintValidator<Cep, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        return value.matches(Regex.CEP);
    }

}


