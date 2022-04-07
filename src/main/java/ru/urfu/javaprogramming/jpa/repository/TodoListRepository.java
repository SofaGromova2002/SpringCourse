package ru.urfu.javaprogramming.jpa.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;
import ru.urfu.javaprogramming.jpa.entity.TodoListEntity;

import java.util.UUID;

@Repository
public interface TodoListRepository extends JpaRepositoryImplementation<TodoListEntity, UUID> {
    boolean existsByName(String name);
}
