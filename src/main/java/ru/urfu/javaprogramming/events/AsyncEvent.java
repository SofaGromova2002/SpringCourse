package ru.urfu.javaprogramming.events;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AsyncEvent extends MyAbstractEvent {

    public AsyncEvent(String message) {
        super(message);
    }
}
