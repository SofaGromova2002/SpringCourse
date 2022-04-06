package ru.urfu.javaprogramming.web;

public class BadRequestException extends Exception {

    public BadRequestException(String message) {
        super(message);
    }
}
