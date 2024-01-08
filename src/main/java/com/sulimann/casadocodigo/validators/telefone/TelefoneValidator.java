package com.sulimann.casadocodigo.validators.telefone;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TelefoneValidator implements ConstraintValidator<Telefone, String>{

    private final Pattern pattern = Pattern.compile("^\\d{2}9\\d{8}$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        return pattern.matcher(value).matches();
    }

    

}



