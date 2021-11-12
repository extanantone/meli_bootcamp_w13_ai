package com.bootcamp.SocialMeli.DTO;

import com.bootcamp.SocialMeli.Model.DetallePublicacion;
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
public class PublicacionDTO {
    private int userId;
    private int idPost;
    private LocalDate date;
    private DetallePublicacionDTO detalleP;
    private int category;
    private double price;
}
