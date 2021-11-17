package com.mercadolibre.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDTO {
    @JsonProperty("user_id")
    private int id;
    @JsonProperty("user_name")
    private String name;

    public UserDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
