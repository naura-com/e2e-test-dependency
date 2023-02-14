package com.naura.test.entity.converter;

import javax.persistence.AttributeConverter;

public class JobModeDefinitionConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String attribute) {
        switch (attribute) {
            case "串行模式":
                return "1";
            case "管道模式":
                return "2";
            case "并行模式":
                return "3";
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        switch (dbData) {
            case "1":
                return "串行模式";
            case "2":
                return "管道模式";
            case "3":
                return "并行模式";
            default:
                throw new IllegalArgumentException();
        }
    }
}
