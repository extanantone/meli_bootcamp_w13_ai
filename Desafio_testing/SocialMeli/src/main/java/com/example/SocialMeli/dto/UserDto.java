package com.example.SocialMeli.dto;

import com.example.SocialMeli.model.Publication;
import com.example.SocialMeli.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class UserDto {

    private int userId;
    private String userName;
    private List<UserDto> followers;
    private List<UserDto> followed;
    private List<PublicationDto> posts;


    public UserDto(int userId, String userName) {

        this.userId = userId;
        this.userName = userName;
    }

    public UserDto() {
        this.followers = new ArrayList<>();
        this.followed = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public void addFollower(UserDto user){
        this.followers.add(user);
    }

    public void addFollowed(UserDto user){
        this.followed.add(user);
    }

    public void addPublication(PublicationDto publicationDto){
        this.posts.add(publicationDto);
    }
}
