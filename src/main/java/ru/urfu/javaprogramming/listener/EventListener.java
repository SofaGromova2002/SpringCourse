package ru.urfu.javaprogramming.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import ru.urfu.javaprogramming.events.AsyncEvent;
import ru.urfu.javaprogramming.events.CommonEvent;
import ru.urfu.javaprogramming.events.MyAbstractEvent;
import ru.urfu.javaprogramming.events.TransactionalEvent;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class EventListener {

    @org.springframework.context.event.EventListener
    public void processCommonEvent(CommonEvent event) {
        log.info("Получили обычное событие {}", event);
    }

    @Async
    @org.springframework.context.event.EventListener
    public void processAsyncEvent(AsyncEvent event) {
        log.info("Получили асинхронное событие {}", event);
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void processTransactionalEvent(TransactionalEvent event) throws Throwable {
        log.info("Получили транзакционное событие {}", event);
        if (event.getThrowable() != null) {
            log.error("Транзакционное событие генерирует исключение", event.getThrowable());
            throw event.getThrowable();
        }
    }
}
