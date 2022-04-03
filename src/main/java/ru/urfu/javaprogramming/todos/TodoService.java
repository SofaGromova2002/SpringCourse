package ru.urfu.javaprogramming.todos;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.urfu.javaprogramming.jpa.entity.TodoEntity;
import ru.urfu.javaprogramming.jpa.entity.TodoListEntity;
import ru.urfu.javaprogramming.jpa.repository.TodoListRepository;
import ru.urfu.javaprogramming.model.TodosList;

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
    public TodoListEntity saveNewTodoList(TodosList todos) {
        TodoListEntity todoList = mapTodosToEntity(todos);
        return todoListRepository.save(todoList);
    }

    public List<TodosList> getAllTodos() {
        List<TodoListEntity> listEntities = todoListRepository.findAll();
        return listEntities.stream().map(this::mapEntityToTodos).collect(Collectors.toList());
    }

    private TodoListEntity mapTodosToEntity(TodosList todos) {
        TodoListEntity todoListEntity = new TodoListEntity();
        todoListEntity.setId(UUID.randomUUID());
        todoListEntity.setName(todos.getName());

        todos.getTodos().forEach(todo -> {
            TodoEntity todoEntity = new TodoEntity();
            todoEntity.setId(UUID.randomUUID());
            todoEntity.setName(todo.getName());
            todoEntity.setDescription(todo.getDescription());
            todoEntity.setTimestamp(todo.getTimestamp());
            todoEntity.setTodoList(todoListEntity);

            todoListEntity.getTodos().add(todoEntity);
        });

        return todoListEntity;
    }

    private TodosList mapEntityToTodos(TodoListEntity todos) {
        TodosList todoList = new TodosList();
        todoList.setName(todos.getName());
        todoList.setTodos(new ArrayList<>());

        todos.getTodos().forEach(todoEntity -> {
            TodosList.Todo todo = new TodosList.Todo();
            todo.setName(todoEntity.getName());
            todo.setDescription(todoEntity.getDescription());
            todo.setTimestamp(todoEntity.getTimestamp());

            todoList.getTodos().add(todo);
        });

        return todoList;
    }
}
