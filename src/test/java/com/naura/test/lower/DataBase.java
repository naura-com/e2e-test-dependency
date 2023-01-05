package com.naura.test.lower;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import java.util.function.Consumer;

@Service
public class DataBase {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public void executeDB(Consumer<EntityManager> consumer) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        try {
            consumer.accept(manager);
            transaction.commit();
        } finally {
            try {
                transaction.rollback();
            } finally {
                manager.close();
            }
        }
    }

    public void cleanTable(String table) {
        executeDB(entityManager -> {
            if (entityManager.createNativeQuery(String.format("SHOW TABLES like '%s'", table)).executeUpdate() != 0) {
                entityManager.createNativeQuery("SET FOREIGN_KEY_CHECKS = 0").executeUpdate();
                entityManager.createNativeQuery("delete from " + table).executeUpdate();
                entityManager.createNativeQuery("ALTER TABLE " + table + " AUTO_INCREMENT = 1").executeUpdate();
                entityManager.createNativeQuery("SET FOREIGN_KEY_CHECKS = 1").executeUpdate();
            }
        });
    }
}
