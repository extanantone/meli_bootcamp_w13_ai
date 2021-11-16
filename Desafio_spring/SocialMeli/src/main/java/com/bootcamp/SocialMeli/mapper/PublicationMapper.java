package com.bootcamp.SocialMeli.mapper;

import com.bootcamp.SocialMeli.dto.PublicationDTO;
import com.bootcamp.SocialMeli.model.Publication;
import org.springframework.stereotype.Component;

@Component
public class PublicationMapper {

    public Publication newPublication(PublicationDTO publicationDTO){
        Publication publication = new Publication();
        publication.setUser_id(publicationDTO.getUser_id());
        publication.setId_post(publicationDTO.getId_post());
        publication.setDate(publicationDTO.getDate());
        publication.setCategory(publicationDTO.getCategory());
        publication.setPrice(publicationDTO.getPrice());
        return publication;
    }
}
