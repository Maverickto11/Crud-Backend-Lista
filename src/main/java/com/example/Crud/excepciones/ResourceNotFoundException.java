package com.example.Crud.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVerId = 1L;

    public ResourceNotFoundException(String mensaje){
        super(mensaje);
    }
}