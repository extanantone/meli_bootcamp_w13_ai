package com.socialmeli.socialmeli.dto.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostWithoutDiscountDTO implements Comparable<PostWithoutDiscountDTO> {
    @Min(value=0, message = "El id de usuario debe ser mayor a cero")
    int user_id;
    @Min(value=0, message = "El id de usuario debe ser mayor a cero")
    int id_post;
    @JsonFormat(pattern = "dd-MM-yyyy")
    //@Pattern(regexp="/^(((0[1-9]|[12]\\d|3[01])\\/(0[13578]|1[02])\\/((19|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)\\/(0[13456789]|1[012])\\/((19|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])\\/02\\/((19|[2-9]\\d)\\d{2}))|(29\\/02\\/((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$/g" , message = "La fecha debe cumplir con el formato: dd-mm-yyyy")
    LocalDate date;
    @Valid
    ProductDTO detail;

    int category;
    @Min(value=0, message = "Price must be greater than zero")
    @Max(value=10000000, message = "Price must be lower than one millon")
    double price;

    @Override
    public int compareTo(PostWithoutDiscountDTO e) {
        return this.getDate().compareTo(e.getDate());
    }
}
