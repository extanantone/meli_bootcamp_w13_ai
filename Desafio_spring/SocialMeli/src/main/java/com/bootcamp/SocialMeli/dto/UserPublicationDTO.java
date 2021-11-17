package com.bootcamp.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserPublicationDTO implements Serializable {
    private Integer user_id;
    private List<PublicationDTO> publication;
}
