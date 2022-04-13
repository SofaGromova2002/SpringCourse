package ru.urfu.javaprogramming.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Aspect
@Component
public class MethodCallCountAspect {

    private final Long maxApiCallCount;

    public MethodCallCountAspect(@Value("${app.maxApiCallCount}") Long maxApiCallCount) {
        this.maxApiCallCount = maxApiCallCount;
    }

    AtomicLong counter = new AtomicLong(0);

    @Pointcut("execution(public * ru.urfu.javaprogramming.rest.*.*(..))")
    public void callApiMethod() {

    }

    @Before("callApiMethod()")
    public void beforeCallAnyMethod() {
        if (counter.incrementAndGet() > maxApiCallCount) {
            throw new RuntimeException();
        }
        log.info("Вызвается АПИ метод, {} из {}", counter.get(), maxApiCallCount);
    }
}
