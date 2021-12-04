package com.example.easynotes.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Utilizada para mapear una lista de forma template a través
 * de modelMapper
 *
 * link: https://www.baeldung.com/java-modelmapper-lists
 */
@Component
public class ListMapper {

    ModelMapper modelMapper;

    @Autowired
    ListMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <T, S> List<S> mapList(List<T> source, Class<S> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}
