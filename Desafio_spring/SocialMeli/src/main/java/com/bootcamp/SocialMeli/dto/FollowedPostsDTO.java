package com.bootcamp.SocialMeli.dto;

import com.bootcamp.SocialMeli.model.Post;
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
public class FollowedPostsDTO {
    private int userId;
    private List<PostDTO> posts;

    public FollowedPostsDTO(int userId) {
        this.userId = userId;
        this.posts = new ArrayList<>();
    }

    public void addPost(PostDTO post) {
        this.posts.add(post);
    }
}
