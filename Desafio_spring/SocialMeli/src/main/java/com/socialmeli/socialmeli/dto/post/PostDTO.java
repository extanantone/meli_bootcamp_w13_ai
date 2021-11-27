package com.socialmeli.socialmeli.dto.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.socialmeli.socialmeli.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDTO implements Comparable<PostDTO> {
    @Min(value=0, message = "El id de usuario debe ser mayor a cero")
    int user_id;
    @Min(value=0, message = "El id de post debe ser mayor a cero")
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
