package com.bootcamp.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PostDTO {

    int user_id;
    int id_post;
    String  date;
    ProductDTO detail;
    int category;
    double price;



}
