package com.example.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProductDTO {

    @NotNull(message = "productId must be numeric and can not be null or empty or negative")
    @Positive(message = "productId must be numeric and can not be null or empty or negative")
    private Integer productId;

    @NotBlank(message = "productName can not be null or empty")
    @Size(max = 40, message = "productName can not be longer than 40 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "userName can not have special characters")
    private String productName;

    @NotBlank(message = "productName can not be null or empty")
    @Size(max = 15, message = "productName can not be longer than 15 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "userName can not have special characters")
    private String type;

    @NotBlank(message = "productName can not be null or empty")
    @Size(max = 15, message = "productName can not be longer than 15 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "userName can not have special characters")
    private String brand;

    @NotBlank(message = "productName can not be null or empty")
    @Size(max = 15, message = "productName can not be longer than 15 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "userName can not have special characters")
    private String color;

    @Size(max = 80, message = "productName can not be longer than 80 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "userName can not have special characters")
    private String notes;
}
