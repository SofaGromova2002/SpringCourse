package ru.urfu.javaprogramming.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodosList {

    @NotBlank(message = "Не указано имя списка дел")
    private String name;

    @Valid
    private List<Todo> todos;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Todo {

        @NotBlank(message = "Не указано имя дела")
        private String name;

        @NotBlank(message = "Не указано описание дела")
        private String description;

        @NotNull(message = "Не указан срок выполнения дела")
        private ZonedDateTime timestamp;
    }
}
