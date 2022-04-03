package ru.urfu.javaprogramming.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodosList {
    private String name;
    private List<Todo> todos;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Todo {
        private String name;
        private String description;
        private ZonedDateTime timestamp;
    }
}
