package com.joyeria.mapper;

import com.joyeria.dto.JoyaDto;
import com.joyeria.dto.JoyaIdDto;
import com.joyeria.model.Joya;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class JoyaMapper {

    private ModelMapper mapper;

    public JoyaMapper(){
        mapper = new ModelMapper();
        mapper.createTypeMap(Joya.class,JoyaDto.class).addMappings((map)->{
            map.using(new MaterialConverterDto()).map(Joya::getMaterial,JoyaDto::setMaterial);
        });

        mapper.createTypeMap(JoyaDto.class,Joya.class).addMappings((map)->{
            map.using(new MaterialConverter()).map(JoyaDto::getMaterial,Joya::setMaterial);
        });
    }

    public Joya getJoya(JoyaDto dto){
        return mapper.map(dto,Joya.class);
    }

    public JoyaDto getJoyaDto(Joya joya){
        return  mapper.map(joya,JoyaDto.class);
    }

    public JoyaIdDto getJoyaIdDto(Joya joya){
        return mapper.map(joya,JoyaIdDto.class);
    }

}
