package com.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PostDTO {

    private long postId;

    @Pattern(regexp = "(\\d{2}-\\d{2}-\\d{4})")
    private String date;

    private int category;

    @DecimalMax(value = "10000000.0")
    private double price;

    private long userId;

    private @Valid ProductDTO detail;
}
