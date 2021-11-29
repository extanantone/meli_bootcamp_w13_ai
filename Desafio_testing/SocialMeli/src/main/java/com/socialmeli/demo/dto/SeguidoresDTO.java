package com.socialmeli.demo.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SeguidoresDTO {

    @NotNull(message = "Debe introducir un id del seguidor")
    @Positive(message = "EL id del usuario debe ser un número mayor a 0")
    private Integer user_id;

    private String user_name;
    private List<CompradoresDTO> followers;
}
