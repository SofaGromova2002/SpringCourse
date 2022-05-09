package ru.urfu.javaprogramming.model;

import lombok.Data;

import java.util.List;

@Data
public class LoggedUserResponse {

    private String username;

    private List<String> roles;
}
