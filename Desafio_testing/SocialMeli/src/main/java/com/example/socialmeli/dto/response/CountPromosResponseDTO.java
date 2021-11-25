package com.example.socialmeli.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CountPromosResponseDTO {

    private Integer userId;
    private String userName;
    private Integer promoproductsCount;

}
