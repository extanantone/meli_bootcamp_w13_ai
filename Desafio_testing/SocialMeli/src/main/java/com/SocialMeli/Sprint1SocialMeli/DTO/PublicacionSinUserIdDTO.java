package com.SocialMeli.Sprint1SocialMeli.DTO;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublicacionSinUserIdDTO {

    private int idPost, category;
    private double price;
    private LocalDate date;
    private ProductoDTO detail;
}
