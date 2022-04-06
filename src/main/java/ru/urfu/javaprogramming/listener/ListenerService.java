package ru.urfu.javaprogramming.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import ru.urfu.javaprogramming.events.AsyncEvent;
import ru.urfu.javaprogramming.events.CommonEvent;
import ru.urfu.javaprogramming.events.TransactionalEvent;

@Slf4j
@Service
public class ListenerService {

    @EventListener
    public void processCommonEvent(CommonEvent event) {
        log.info("Получили обычное событие {}", event);
    }

    @Async
    @EventListener
    public void processAsyncEvent(AsyncEvent event) {
        log.info("Получили асинхронное событие {}", event);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void processTransactionalEvent(TransactionalEvent event) {
        log.info("Получили транзакционное событие {}", event);
    }
}
