package ru.urfu.javaprogramming.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.urfu.javaprogramming.events.AsyncEvent;
import ru.urfu.javaprogramming.events.CommonEvent;
import ru.urfu.javaprogramming.events.MyAbstractEvent;
import ru.urfu.javaprogramming.events.TransactionalEvent;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void publishCommonEvent() {
        this.publishEvent(new CommonEvent(String.format("Обычное событие %s", UUID.randomUUID())));
    }

    public void publishAsyncEvent() {
        this.publishEvent(new AsyncEvent(String.format("Асинхронное событие %s", UUID.randomUUID())));
    }

    @Transactional
    public void publishTransactionalSuccessEvent() {
        this.publishEvent(new TransactionalEvent(String.format("Транзакционное безошибочное событие %s", UUID.randomUUID())));
    }

    @Transactional
    public void publishTransactionalErrorEvent() {
        this.publishEvent(new TransactionalEvent(String.format("Транзакционное ошибочное событие %s", UUID.randomUUID())));
        throw new RuntimeException();
    }

    private void publishEvent(MyAbstractEvent event) {
        log.info("Публикуем событие {}", event);
        applicationEventPublisher.publishEvent(event);
    }
}
