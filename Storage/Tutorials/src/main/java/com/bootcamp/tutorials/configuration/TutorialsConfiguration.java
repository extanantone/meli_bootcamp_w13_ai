package com.bootcamp.tutorials.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TutorialsConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper =  new ModelMapper();

        modelMapper.getConfiguration().setFieldMatchingEnabled(true);

        return modelMapper;
    }

}