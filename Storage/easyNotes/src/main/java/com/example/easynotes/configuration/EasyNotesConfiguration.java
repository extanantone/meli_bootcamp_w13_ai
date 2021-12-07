package com.example.easynotes.configuration;

import com.example.easynotes.dto.NoteRequestDTO;
import com.example.easynotes.dto.NoteResponseDTO;
import com.example.easynotes.dto.UserResponseWithCantNotesDTO;
import com.example.easynotes.model.Note;
import com.example.easynotes.model.User;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class EasyNotesConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper =  new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        return modelMapper;
    }

}