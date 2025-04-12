package com.eduubraga.bigfood.domain.exception;

public class ForeignKeyNotFoundException extends RuntimeException{

    public ForeignKeyNotFoundException(String message) {
        super(message);
    }

}
