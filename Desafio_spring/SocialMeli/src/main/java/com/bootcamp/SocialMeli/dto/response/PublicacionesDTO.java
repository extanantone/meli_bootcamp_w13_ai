package com.bootcamp.SocialMeli.dto.response;

import com.bootcamp.SocialMeli.dto.PublicacionDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublicacionesDTO {
    private Integer userId; //id del cliente
    private List<PublicacionDTO> posts;
}
