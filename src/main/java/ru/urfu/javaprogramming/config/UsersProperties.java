package ru.urfu.javaprogramming.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "app.credentials")
public class UsersProperties {

    User admin;

    User support;

    @Getter
    @Setter
    public static class User {

        private String username;

        private String password;
    }
}
