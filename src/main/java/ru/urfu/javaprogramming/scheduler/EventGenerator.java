package ru.urfu.javaprogramming.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.urfu.javaprogramming.publisher.EventPublisher;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class EventGenerator {
    private final EventPublisher eventPublisher;
    private final Random random = new Random();

    @Scheduled(fixedDelay = 5000)
    public void generateRandomMessage() {
        int i = random.nextInt(4);
        switch (i) {
            case 0:
                eventPublisher.publishCommonEvent();
                break;
            case 1:
                eventPublisher.publishAsyncEvent();
                break;
            case 2:
                eventPublisher.publishTransactionalSuccessEvent();
                break;
            case 3:
                eventPublisher.publishTransactionalErrorEvent();
                break;
            default:
                break;
        }
    }
}
