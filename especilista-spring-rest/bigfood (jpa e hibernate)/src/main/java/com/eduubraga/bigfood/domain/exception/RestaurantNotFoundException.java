package com.eduubraga.bigfood.domain.exception;

public class RestaurantNotFoundException extends RuntimeException {

    public RestaurantNotFoundException(String message) {
        super(message);
    }

}
