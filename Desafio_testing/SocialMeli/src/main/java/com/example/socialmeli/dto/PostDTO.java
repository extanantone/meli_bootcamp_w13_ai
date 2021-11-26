package com.example.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PostDTO {

    //TODO revisar patterns ids y precio  regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$"

    @NotNull(message = "userId must be numeric and can not be null or empty or negative")
    @Min(value = 0, message = "userId must be numeric and can not be null, empty, zero or negative")
    private Integer userId;

    @NotNull(message = "idPost must be numeric and can not be null or empty or negative")
    @Positive(message = "idPost must be numeric and can not be null or empty or negative")
    private Integer idPost;

    // date can not be null
    @NotNull(message = "date can not be null")
    @Past(message = "date can not be in the future")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;

    @NotNull(message = "detail must not be null or empty")
    private ProductDTO detail;

    @NotNull(message = "productName can not be null or empty")
    private int category;

    @NotNull(message = "price can not be null or empty")
    @DecimalMax(value = "10000000.00", message = "price can not be greater than 10.000.000,00")
    private double price;

    private boolean hasPromo = false;

    private double discount = 0.0;
}
