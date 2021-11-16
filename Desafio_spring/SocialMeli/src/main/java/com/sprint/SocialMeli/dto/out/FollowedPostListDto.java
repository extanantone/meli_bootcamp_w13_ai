package com.sprint.SocialMeli.dto.out;

import com.sprint.SocialMeli.dto.out.PostDtoOut;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter

public class FollowedPostListDto {
    int user_id;
    List<PostDtoOut> posts;
}
