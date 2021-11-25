package com.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PromoPostDTO {

    @NotNull(message = "Can't be empty")
    private Long postId;

    @NotNull(message = "Can't be empty")
    @NotBlank(message = "Can't be empty")
    @Pattern(regexp = "(\\d{2}-\\d{2}-\\d{4})")
    private String date;

    @NotNull
    private Integer category;

    @NotNull(message = "Can't be empty")
    @DecimalMax(value = "10000000.0")
    private Double price;

    @NotNull(message = "Can't be empty")
    private Boolean hasPromo;

    @DecimalMax(value = "1.0", message = "Max value 1.0")
    @DecimalMin(value = "0.0", message = "Min value 0.0")
    private Double discount;

    @NotNull(message = "Can't be empty")
    private Long userId;

    private @Valid ProductDTO detail;

    public boolean hasPromo() {
        return hasPromo;
    }
}
