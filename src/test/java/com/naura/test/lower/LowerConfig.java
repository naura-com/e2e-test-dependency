package com.naura.test.lower;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LowerConfig {

    @Bean
    @ConfigurationProperties(prefix = "lower.pvd")
    public LowerConnection pvd() {
        return new LowerConnection();
    }

    @Bean
    @ConfigurationProperties(prefix = "lower.etch1.pm2")
    public LowerConnection etch1Pm2() {
        return new LowerConnection();
    }

    @Bean
    @ConfigurationProperties(prefix = "lower.etch1.ref")
    public LowerConnection etch1ref() {return new LowerConnection(); }
}
