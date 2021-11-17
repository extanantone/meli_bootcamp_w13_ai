package com.bootcamp.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromoPostsDTO {
    int userId;
    String userName;
    private List<PostDTO> posts;

    public PromoPostsDTO(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.posts = new ArrayList<>();
    }
}
