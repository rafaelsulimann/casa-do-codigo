package com.sulimann.casadocodigo.validators.cep;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = CepValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Cep {

    String message() default "CEP inválido";
    Class<?>[] groups() default {}; //PADRÃO
    Class<? extends Payload>[] payload() default {}; //PADRÃO
    
}
