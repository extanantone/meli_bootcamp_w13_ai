package com.mercadolibre.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublicationsFollowDTO {
    private int userId;
    List<PublicationDTO> posts;

    @Override
    public String toString() {
        return "PublicationsFollowDTO{" +
                "userId=" + userId +
                ", posts=" + posts +
                '}';
    }
}
