package com.example.socialmeli.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDto {

    private Integer idPost;

    private LocalDate date;


    private ProductDto detail;


    private Integer category;

    private Double price;

    private Boolean hasPromo;

    private Double discount;

    public PostDto(PostCreateDto postCreateDto) {
        this.idPost = postCreateDto.getIdPost();
        this.date = postCreateDto.getDate();
        this.detail = postCreateDto.getDetail();
        this.category = postCreateDto.getCategory();
        this.price = postCreateDto.getPrice();
        this.hasPromo = postCreateDto.getHasPromo();
        this.discount  = postCreateDto.getDiscount();
    }
}
