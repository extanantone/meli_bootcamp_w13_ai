package com.bootcamp.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class PostListDTO {

    int id_post;
    LocalDate date;
    ProductDTO detail;
    int category;
    double price;

}
