package com.mercadolibre.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FollowersCountDTO extends UserDTO{
    private int followersCount;

    public FollowersCountDTO(int id, String name, int followersCount) {
        super(id, name);
        this.followersCount = followersCount;
    }

    @Override
    public String toString() {
        return "FollowersCountDTO{" +
                "followersCount=" + followersCount +
                '}';
    }
}
