package ru.urfu.javaprogramming.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.urfu.javaprogramming.SecurityUtils;
import ru.urfu.javaprogramming.model.LoggedUserResponse;

@Slf4j
@RestController
@RequestMapping("/support/api")
public class SupportController {

    @GetMapping
    public LoggedUserResponse supportGet() {
        log.info("Запрос в апи support");
        return SecurityUtils.getLoggedUserResponse();
    }
}
