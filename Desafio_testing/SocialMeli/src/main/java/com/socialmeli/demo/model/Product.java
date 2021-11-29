package com.socialmeli.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @NotNull(message = "The product_id cannot be empty")
    private Integer productId;

    @NotBlank(message = "The product_name cannot be empty")
    @Size(max = 40, message = "The product_name length cannot be over 40")
    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "The product_name cannot contain special characters")
    private String productName;

    @NotBlank(message = "The brand cannot be empty")
    @Size(max = 15, message = "The type length cannot be over 15")
    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "The type cannot contain special characters")
    private String type;

    @NotBlank(message = "The brand cannot be empty")
    @Size(max = 25, message = "The brand length cannot be over 25")
    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "The brand cannot contain special characters")
    private String brand;

    @NotBlank(message = "The color cannot be empty")
    @Size(max = 15, message = "The color length cannot be over 15")
    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "The color cannot contain special characters")
    private String color;

    @Size(max = 80, message = "The notes length cannot be over 80")
    @Pattern(regexp = "^[A-Za-z0-9,.; ]*$", message = "The notes cannot contain special characters")
    private String notes;

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
