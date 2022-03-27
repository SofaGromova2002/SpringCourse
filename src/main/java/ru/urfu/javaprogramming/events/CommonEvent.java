package ru.urfu.javaprogramming.events;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CommonEvent extends MyAbstractEvent {

    public CommonEvent(String message) {
        super(message);
    }
}
