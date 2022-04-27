package ru.urfu.javaprogramming.actuator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@Endpoint(id = "logger")
public class LoggingActuator {

    @ReadOperation
    public String logOnAccess() {
        log.info("Вызов логирующего актуатора {}", LocalDateTime.now());
        return "Привет из логирующего актуатора";
    }
}
