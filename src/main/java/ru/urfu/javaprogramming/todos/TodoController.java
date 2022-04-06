package ru.urfu.javaprogramming.todos;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.urfu.javaprogramming.jpa.entity.TodoListEntity;
import ru.urfu.javaprogramming.model.TodosList;
import ru.urfu.javaprogramming.web.BadRequestException;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public TodoListEntity saveNewTodoList(@RequestBody @Valid TodosList todosList) throws BadRequestException {
        return todoService.saveNewTodoList(todosList);
    }

    @GetMapping
    public List<TodosList> getAllTodoLists() {
        return todoService.getAllTodos();
    }
}
