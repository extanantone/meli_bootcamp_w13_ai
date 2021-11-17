package com.sprint.SocialMeli.dto.out;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sprint.SocialMeli.dto.out.PostDtoOut;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class FollowedPostListDto {
    int userId;
    List<PostDtoOut> posts;
}
