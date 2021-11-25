package com.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProductDTO {

    @NotNull(message = "Can't be empty")
    private Long productId;

    @NotNull(message = "Can't be empty")
    @NotBlank(message = "Can't be empty")
    @Size(max = 40, message = "Max size 40")
    @Pattern(regexp = "[a-zA-Z0-9., ]*", message = "Can't have special characters")
    private String productName;

    @NotNull(message = "Can't be empty")
    @NotBlank(message = "Can't be empty")
    @Size(max = 15, message = "Max size 15")
    @Pattern(regexp = "[a-zA-Z0-9., ]*", message = "Can't have special characters")
    private String type;

    @NotNull(message = "Can't be empty")
    @NotBlank(message = "Can't be empty")
    @Size(max = 25, message = "Max size 25")
    @Pattern(regexp = "[a-zA-Z0-9., ]*", message = "Can't have special characters")
    private String brand;

    @NotNull(message = "Can't be empty")
    @NotBlank(message = "Can't be empty")
    @Size(max = 15, message = "Max size 15")
    @Pattern(regexp = "[a-zA-Z0-9., ]*", message = "Can't have special characters")
    private String color;

    @Size(max = 80, message = "Max size 80")
    @Pattern(regexp = "[a-zA-Z0-9.,; ]*", message = "Can't have special characters")
    private String notes;
}
