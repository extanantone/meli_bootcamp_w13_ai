package com.sprint.SocialMeli.dto;

import com.sprint.SocialMeli.model.Post;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class FollowedPostListDto {
    int user_id;
    List<PostDtoOut> posts;
}
