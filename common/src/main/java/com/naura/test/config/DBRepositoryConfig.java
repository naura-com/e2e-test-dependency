package com.naura.test.config;

import com.github.leeonky.jfactory.repo.JPADataRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Configuration
public class DBRepositoryConfig {
   
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Bean
    public JPADataRepository jpaDataRepository() {
        return new JPADataRepository(entityManagerFactory.createEntityManager());
    }
}
