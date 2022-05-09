package ru.urfu.conumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.Message;
import javax.jms.MessageListener;

@Slf4j
@Service
public class MqConsumer implements MessageListener {

    @Override
    @JmsListener(destination = "${mq.topic}")
    public void onMessage(Message message) {
        try {
            ActiveMQTextMessage textMessage = (ActiveMQTextMessage) message;
            log.info("Получено сообщение {}", textMessage.getText());
        } catch (Throwable t) {
            log.error("Ошибка при получении сообщения", t);
        }
    }
}
