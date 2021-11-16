package com.socialmeli.socialmeli.dto.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.socialmeli.socialmeli.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDTO implements Comparable<PostDTO> {
    int user_id;
    int id_post;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate date;
    ProductDTO detail;
    int category;
    double price;
    boolean has_promo;
    double discount;


    @Override
    public int compareTo(PostDTO e) {
        return this.getDate().compareTo(e.getDate());
    }
}
