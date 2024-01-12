package com.sulimann.casadocodigo.validators.cep;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.sulimann.casadocodigo.utils.Regex;

public class CepValidator implements ConstraintValidator<Cep, String>{

    private final Pattern pattern = Pattern.compile(Regex.CEP);

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        return pattern.matcher(value).matches();
    }

}


