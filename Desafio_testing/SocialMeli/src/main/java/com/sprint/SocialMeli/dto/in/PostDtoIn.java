package com.sprint.SocialMeli.dto.in;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sprint.SocialMeli.dto.DetailPostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Validated
public class PostDtoIn {
    @NotNull(message = "El id no puede estar vacío")
    @Positive(message = "El id debe ser mayor a cero")
    Integer userId;
    @NotNull(message = "La id no puede estar vacía.")
    // Lo que sea numérico no sería necesario agregar una validación aparte
    Integer idPost;
    @NotNull(message = "La fecha no puede estar vacía.")
    // Si estuviera como String deberia ser @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$", message = "La fecha debe estar en formato dd-mm-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    LocalDate date;
    @Valid
    DetailPostDto detail;
    @NotNull(message = "El campo no puede estar vacío.")
    Integer category;
    @NotNull(message = "El campo no puede estar vacío.")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000.")
    Double price;

}
