package com.bootcamp.socialmeli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
@Data
public class Post {

    private int userId;
    private int idPost;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;
    private Boolean hasPromo;
    private double discount;

}
