package ru.urfu.javaprogramming.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api2")
public class SecondController {

    @GetMapping
    public void simpleGet2() {
        log.info("Вызван simpleGet2 метод");
    }
}
