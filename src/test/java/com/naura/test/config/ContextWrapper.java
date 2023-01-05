package com.naura.test.config;

import lombok.Getter;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ContextWrapper {
    @Getter
    private static ApplicationContext applicationContext;

    public ContextWrapper(ApplicationContext applicationContext) {
        ContextWrapper.applicationContext = applicationContext;
    }
}
