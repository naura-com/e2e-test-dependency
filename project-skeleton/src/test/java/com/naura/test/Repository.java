package com.naura.test;

import com.github.leeonky.jfactory.DataRepository;
import com.github.leeonky.jfactory.repo.JPADataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.Collection;
import java.util.Collections;

@Service
public class Repository implements DataRepository {

    @Autowired
    private JPADataRepository jpaDataRepository;

    @Override
    public <T> Collection<T> queryAll(Class<T> type) {
        if (type.getAnnotation(Entity.class) != null)
            return jpaDataRepository.queryAll(type);
        return Collections.emptyList();
    }

    @Override
    public void clear() {
        jpaDataRepository.clear();
    }

    @Override
    public void save(Object o) {
        if (o != null && o.getClass().getAnnotation(Entity.class) != null) {
            jpaDataRepository.save(o);
        }
    }
}
