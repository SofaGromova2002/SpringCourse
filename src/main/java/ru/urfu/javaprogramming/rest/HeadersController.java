package ru.urfu.javaprogramming.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@Controller
public class HeadersController {

    @GetMapping("/headers")
    public String getHeaders(@RequestHeader Map<String, String> headers, Model model) {
        model.addAttribute("headers", headers);
        return "headers";
    }
}
