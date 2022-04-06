package ru.urfu.javaprogramming.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.*;

@Configuration
public class TransactionalConfiguration {

    @Bean
    public TransactionManager transactionManager() {
        return new PlatformTransactionManager() {
            @Override
            public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
                return null;
            }

            @Override
            public void commit(TransactionStatus status) throws TransactionException {

            }

            @Override
            public void rollback(TransactionStatus status) throws TransactionException {

            }
        };
    }
}
