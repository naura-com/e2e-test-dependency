package com.naura.db.entity.converter;

import com.naura.db.entity.Job;

import javax.persistence.AttributeConverter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JobDefinitionConverter implements AttributeConverter<List<Job.Routes>, String> {
    @Override
    public String convertToDatabaseColumn(List<Job.Routes> attribute) {
        return attribute.stream().map(Job.Routes::encode).collect(Collectors.joining(":"));
    }

    @Override
    public List<Job.Routes> convertToEntityAttribute(String dbData) {
        return Arrays.stream(dbData.split(":")).map(Job.Routes::decode).collect(Collectors.toCollection(ArrayList::new));
    }
}
