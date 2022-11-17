package com.jose.rosa.api.rest.lista.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ListaExceptions extends RuntimeException {
    
    private String message;
    private HttpStatus httpStatus;

    public ListaExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
