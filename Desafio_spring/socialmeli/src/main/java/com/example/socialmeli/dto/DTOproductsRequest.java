package com.example.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@ToString
public class DTOproductsRequest {
    Integer user_id;
    Integer id_post;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate date;
    DTOdetailRequest detail;
    Integer category;
    double price;
}
