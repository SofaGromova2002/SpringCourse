package ru.urfu.javaprogramming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.urfu.javaprogramming.config.UsersProperties;

@SpringBootApplication
@EnableConfigurationProperties(UsersProperties.class)
public class JavaProgrammingApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaProgrammingApplication.class, args);
    }

}
