package ru.urfu.javaprogramming.todos;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.urfu.javaprogramming.jpa.entity.TodoEntity;
import ru.urfu.javaprogramming.jpa.entity.TodoListEntity;
import ru.urfu.javaprogramming.jpa.repository.TodoListRepository;
import ru.urfu.javaprogramming.model.TodosList;
import ru.urfu.javaprogramming.web.BadRequestException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoListRepository todoListRepository;

    @Transactional
    public TodoListEntity saveNewTodoList(TodosList todos) throws BadRequestException {
        checkRequestIsValid(todos);
        TodoListEntity todoList = mapTodosToEntity(todos);
        return todoListRepository.save(todoList);
    }

    public List<TodosList> getAllTodos() {
        List<TodoListEntity> listEntities = todoListRepository.findAll();
        return listEntities.stream().map(this::mapEntityToTodos).collect(Collectors.toList());
    }

    private void checkRequestIsValid(TodosList todos) throws BadRequestException {
        if (todoListRepository.existsByName(todos.getName())) {
            throw new BadRequestException(String.format("Список дел с именем %s уже существует в базе", todos.getName()));
        }
        if (todos.getTodos().stream().map(TodosList.Todo::getName).collect(Collectors.toSet()).size() < todos.getTodos().size()) {
            throw new BadRequestException(String.format("Список дел с именем %s содержит дела с неуникальными названиями", todos.getName()));
        }
    }

    private TodoListEntity mapTodosToEntity(TodosList todos) {
        TodoListEntity todoListEntity = new TodoListEntity();
        todoListEntity.setId(UUID.randomUUID());
        todoListEntity.setName(todos.getName());

        todos.getTodos().forEach(todo -> {
            TodoEntity todoEntity = TodoEntity.builder()
                                              .id(UUID.randomUUID())
                                              .name(todo.getName())
                                              .description(todo.getDescription())
                                              .timestamp(todo.getTimestamp())
                                              .todoList(todoListEntity)
                                              .build();

            todoListEntity.getTodos().add(todoEntity);
        });

        return todoListEntity;
    }

    private TodosList mapEntityToTodos(TodoListEntity todos) {
        TodosList todoList = new TodosList();
        todoList.setName(todos.getName());
        todoList.setTodos(new ArrayList<>());

        todos.getTodos().forEach(todoEntity -> {
            TodosList.Todo todo = TodosList.Todo.builder()
                                                .name(todoEntity.getName())
                                                .description(todoEntity.getDescription())
                                                .timestamp(todoEntity.getTimestamp())
                                                .build();

            todoList.getTodos().add(todo);
        });

        return todoList;
    }
}
