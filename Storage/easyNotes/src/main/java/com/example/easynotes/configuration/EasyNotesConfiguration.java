package com.example.easynotes.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class EasyNotesConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper =  new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true);

        return modelMapper;
    }

}