package com.bootcamp.socialmeli.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DTOPostProduct {

    private int userId;
    private int idPost;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private DTOProduct detail;
    private int category;
    private double price;
    private Boolean hasPromo;
    private double discount;

}
