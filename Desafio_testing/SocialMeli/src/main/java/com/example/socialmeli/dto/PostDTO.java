package com.example.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PostDTO {

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer userId;
    private Integer idPost;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;
    private ProductDTO detail;
    private int category;
    private double price;
    private boolean hasPromo = false;
    private double discount = 0.0;
}
