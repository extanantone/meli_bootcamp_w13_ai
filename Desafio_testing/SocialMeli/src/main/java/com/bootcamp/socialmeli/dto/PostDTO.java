package com.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PostDTO {

    @NotNull(message = "Can't be empty")
    private Long postId;

    @NotNull(message = "Can't be empty")
    @NotBlank(message = "Can't be empty")
    @Pattern(regexp = "(\\d{2}-\\d{2}-\\d{4})", message = "Date must follow pattern dd-mm-yyyy")
    private String date;

    @NotNull(message = "Can't be empty")
    private Integer category;

    @NotNull(message = "Can't be empty")
    @DecimalMax(value = "10000000.0")
    private Double price;

    @NotNull(message = "Can't be empty")
    private Long userId;

    private @Valid ProductDTO detail;
}
