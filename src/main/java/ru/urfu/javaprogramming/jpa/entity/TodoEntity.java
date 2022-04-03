package ru.urfu.javaprogramming.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "todo")

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TodoEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "timestamp")
    private ZonedDateTime timestamp;

    @ManyToOne
    @JsonIgnore
    private TodoListEntity todoList;
}
