package ru.urfu.javaprogramming.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "todo_list")

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TodoListEntity {

    @Id
    private UUID id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "todo_list_id")
    @ToString.Exclude
    private List<TodoEntity> todos = new ArrayList<>();
}
