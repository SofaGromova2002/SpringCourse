package ru.urfu.javaprogramming.rest;

import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api2")
public class SecondController {

    @Timed
    @GetMapping
    public void simpleGet2(@RequestParam Long millisToWait) throws InterruptedException {
        log.info("Вызван simpleGet2 метод");
        Thread.sleep(millisToWait);
        log.info("Метод simpleGet2 завершил работу");
    }
}
