package com.sulimann.casadocodigo.validators.telefone;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = TelefoneValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Telefone {

    String message() default "Telefone inválido";
    Class<?>[] groups() default {}; //PADRÃO
    Class<? extends Payload>[] payload() default {}; //PADRÃO
    
}

