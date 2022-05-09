package ru.urfu.javaprogramming.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.urfu.javaprogramming.SecurityUtils;
import ru.urfu.javaprogramming.model.LoggedUserResponse;

@Slf4j
@RestController
@RequestMapping("/admin/api")
public class AdminController {

    @GetMapping
    public LoggedUserResponse adminGet() {
        log.info("Запрос в апи admin");
        return SecurityUtils.getLoggedUserResponse();
    }
}
