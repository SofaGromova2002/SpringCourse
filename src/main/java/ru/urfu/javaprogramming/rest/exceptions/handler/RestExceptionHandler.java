package ru.urfu.javaprogramming.rest.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.urfu.javaprogramming.rest.exceptions.BadGatewayException;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(BadGatewayException.class)
    public ResponseEntity<String> badGatewayHandler(BadGatewayException e) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
    }
}
