package com.SocialMeli.Sprint1SocialMeli.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CompradorPublicacionesVendedorListDTO {

    private Integer userID;
    List<PublicacionSinUserIdDTO> posts;
}
