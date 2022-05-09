package ru.urfu.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProducerController {
    private final JmsTemplate mqTemplate;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/sendMessage")
    public void sendMessage(@RequestParam(required = false, defaultValue = "${mq.defaultTopic}") String topic, @RequestParam String message) {
        try {
            log.info("Отправка сообщения в топик {}", topic);
            mqTemplate.convertAndSend(topic, message);
        } catch (Throwable t) {
            log.error("Ошибка при отправке сообщения в топик {}", topic, t);
            throw t;
        }
    }
}
