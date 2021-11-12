package com.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDtoWithoutUser {
    private int postId;
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date;
    private DetailDto detail;
    private int category;
    private int price;
}
