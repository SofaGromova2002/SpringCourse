package ru.urfu.javaprogramming.jpa.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "todo_list")

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TodoListEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "todo_list_id")
    @ToString.Exclude
    private List<TodoEntity> todos = new ArrayList<>();
}
