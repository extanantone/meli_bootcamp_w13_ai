package com.bootcamp.SocialMeli.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublicUserDTO{
    @NotNull(message = "La ID no puede estar vacía.")
    @Min(value=1,message = "El ID debe ser mayor a 0")
    private  Integer userId;
    List<PublicacionDTO> posts;
}
