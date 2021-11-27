package com.socialmeli.socialmeli.dto.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.socialmeli.socialmeli.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDTO implements Comparable<PostDTO> {
    @Min(value=0, message = "El id de usuario debe ser mayor a cero")
    int user_id;
    @Min(value=0, message = "El id de usuario debe ser mayor a cero")
    int id_post;

    @JsonFormat(pattern = "dd-MM-yyyy")
    //@Pattern(regexp="^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$" , message = "La fecha debe cumplir con el formato: dd-mm-yyyy")
    LocalDate date;
    @Valid
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
