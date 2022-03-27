package ru.urfu.javaprogramming;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

@Data
@Slf4j
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private List<String> list;

    private String envVariable;

    @PostConstruct
    public void postConstruct() {
        log.info("Параметры конфигурации: {}", this);
    }
}
