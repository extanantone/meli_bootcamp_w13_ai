package com.example.easynotes.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
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

    public <S, T> Set<T> mapSet(Set<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toSet());
    }

    public <S, T> List<Set<T>> mapListSet(List<Set<S>> source, Class<T> targetClass) {
        return source
                .stream()
                .map(setOrigin -> this.mapSet(setOrigin, targetClass))
                .collect(Collectors.toList());
    }
}
