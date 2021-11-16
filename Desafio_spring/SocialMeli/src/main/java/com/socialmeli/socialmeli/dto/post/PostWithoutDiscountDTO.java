package com.socialmeli.socialmeli.dto.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostWithoutDiscountDTO implements Comparable<PostWithoutDiscountDTO> {
    int user_id;
    int id_post;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate date;
    ProductDTO detail;
    int category;
    double price;

    @Override
    public int compareTo(PostWithoutDiscountDTO e) {
        return this.getDate().compareTo(e.getDate());
    }
}
