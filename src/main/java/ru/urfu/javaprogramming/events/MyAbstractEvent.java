package ru.urfu.javaprogramming.events;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class MyAbstractEvent {

    private String message;
}
