package com.naura.db.entity.converter;

import com.naura.db.entity.Route;

import javax.persistence.AttributeConverter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RouteDefinitionConverter implements AttributeConverter<List<Route.Step>, String> {
    @Override
    public String convertToDatabaseColumn(List<Route.Step> attribute) {
        return attribute.stream().map(Route.Step::encodeVisits).collect(Collectors.joining("*"));
    }

    @Override
    public List<Route.Step> convertToEntityAttribute(String dbData) {
        return Arrays.stream(dbData.split("\\*")).map(Route.Step::decode).collect(Collectors.toCollection(ArrayList::new));
    }
}
