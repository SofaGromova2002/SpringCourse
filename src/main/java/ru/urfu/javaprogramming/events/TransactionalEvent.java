package ru.urfu.javaprogramming.events;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TransactionalEvent extends MyAbstractEvent {

    private Throwable throwable;

    public TransactionalEvent(String message, Throwable throwable) {
        super(message);
        this.throwable = throwable;
    }

    public TransactionalEvent(String message) {
        super(message);
    }
}
