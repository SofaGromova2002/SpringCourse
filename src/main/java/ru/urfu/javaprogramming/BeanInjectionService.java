package ru.urfu.javaprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Slf4j
@Service
public class BeanInjectionService {
    // внедрение через поле
    @Autowired
    private TestService1 testService1;

    private TestService2 testService2;

    private TestService3 testService3;

    private TestInterface testInterface1;

    private TestInterface testInterface2;

    // внедрение через конструктор
    public BeanInjectionService(TestService2 testService3,
                                // внедрение бинов разных классов, реализующих один интерфейс
                                @Qualifier("testInterfaceImpl1")
                                TestInterface testInterface1,
                                @Qualifier("testInterfaceImpl2")
                                TestInterface testInterface2) {
        log.info("Внедрение бинов через конструктор");
        this.testService2 = testService3;
        this.testInterface1 = testInterface1;
        this.testInterface2 = testInterface2;
    }

    // внедрение через сеттер
    @Autowired
    public void setTestService3(TestService3 testService3) {
        log.info("Внедрение бинов через сеттер");
        this.testService3 = testService3;
    }


    // вывод сообщений в лог после создания и перед разрушением бина
    @PostConstruct
    public void postConstruct() {
        log.info("Создание бина {}", this.getClass().getSimpleName());
    }

    @PreDestroy
    public void preDestroy() {
        log.info("Разрушение бина {}", this.getClass().getSimpleName());
    }
}
