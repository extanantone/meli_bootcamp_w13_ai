package com.example.SocialMeli.mapper;

import com.example.SocialMeli.dto.PublicationDto;
import com.example.SocialMeli.model.Publication;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublicationMapper {

    PublicationMapper INSTANCE = Mappers.getMapper(PublicationMapper.class);

    PublicationDto publicationToPublicationDto(Publication publication);
}
