package ru.urfu.javaprogramming.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "todo")

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TodoEntity {

    @Id
    private UUID id;

    private String name;

    private String description;

    private ZonedDateTime timestamp;

    @ManyToOne
    @JsonIgnore
    private TodoListEntity todoList;
}
