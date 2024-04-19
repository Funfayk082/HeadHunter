package com.adventurer.webapp.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String email) {
        super(String.format("Не найден пользователь с почтой или логином " + email + "!!!"));
        System.out.println(email);
    }
}
