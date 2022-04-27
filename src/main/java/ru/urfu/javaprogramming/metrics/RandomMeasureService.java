package ru.urfu.javaprogramming.metrics;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@EnableScheduling
public class RandomMeasureService {

    private final Random RANDOM = new Random();

    private final Gauge firstGauge;

    private final Gauge secondGauge;

    public RandomMeasureService(MeterRegistry meterRegistry) {
        firstGauge = Gauge.builder("experiment", () -> RANDOM.nextInt(1000)).tags("name", "first").register(meterRegistry);
        secondGauge = Gauge.builder("experiment", () -> RANDOM.nextInt(1000)).tags("name", "second").register(meterRegistry);
    }

    @Scheduled(fixedDelay = 1000)
    public void makeRandomMeasure() {
        firstGauge.measure();
        secondGauge.measure();
    }
}
