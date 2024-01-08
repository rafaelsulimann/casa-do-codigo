package com.sulimann.casadocodigo.utils;

import com.sulimann.casadocodigo.handlers.controllerexceptionhandler.exceptions.ResourceNotFoundException;

public final class Assert {

    public static void isPresent(Object object, String message, Object... args){
        if(object == null){
            String formattedMessage = String.format(message, args);
            throw new ResourceNotFoundException(formattedMessage);
        }
    }

    private Assert() {
        throw new AssertionError("Não é permitido instanciar esta classe.");
    }
    
}
