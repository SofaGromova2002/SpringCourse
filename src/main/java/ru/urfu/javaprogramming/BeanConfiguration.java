package ru.urfu.javaprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Slf4j
@Configuration
public class BeanConfiguration {

    @Bean
    @Profile("test")
    public String testBean() {
        log.info("Создается бин, уникальный для профиля \"test\"");
        return "test";
    }

    @Bean
    @ConditionalOnBean(name = "testBean")
    public String beanConditionalOnTestBean() {
        log.info("Создается бин, который создается только если создан бин \"testBean\"");
        return "testConditional";
    }

    @Bean
    @ConditionalOnExpression("!\"default\".equals('${app.envVariable}')")
    public String nonDefaultEnvBean() {
        log.info("Создается бин, который создается только если envVariable != \"default\"");
        return "nonDefaultEnvBean";
    }
}
