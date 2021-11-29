package com.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromoPostsListDTO extends UserDTO {
    private List<PromoPostDTO> promoPosts = new ArrayList<>();

    public PromoPostsListDTO(Integer userId, String userName) {
        super(userId, userName);
    }
}
