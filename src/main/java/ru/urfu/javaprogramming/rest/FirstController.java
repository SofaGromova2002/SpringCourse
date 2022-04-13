package ru.urfu.javaprogramming.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api1")
public class FirstController {

    @GetMapping
    public void simpleGet1() {
        log.info("Вызван simpleGet1 метод");
    }
}
