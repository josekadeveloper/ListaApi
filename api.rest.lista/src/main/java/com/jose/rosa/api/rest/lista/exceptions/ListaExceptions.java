package com.jose.rosa.api.rest.lista.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ListaExceptions extends RuntimeException {
    
    private String message;
    private HttpStatus httpStatus;

    public ListaExceptions(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
