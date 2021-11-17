package com.example.socialmeli.dto.DTORequest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOproductsRequest {
    Integer user_id;
    Integer id_post;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate date;
    DTOdetailRequest detail;
    Integer category;
    double price;
    Boolean has_promo;
    double discount;
}
