package com.meli.obtenerdiploma.model;

import lombok.*;

import javax.validation.constraints.*;
import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SubjectDTO implements Serializable {
    @NotBlank(message = "El nombre de la materia no puede estar vacío.")
    @Pattern(regexp = "^[A-Z|À-Ù|Á-Ú|Ä-Ü].*$", message = "El nombre de la materia debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre de la materia no puede superar los 30 caracteres.")
    String name;

    @NotNull(message = "La nota de la materia no puede estar vacía.")
    @DecimalMax(value = "10.0", message = "La nota máxima de la materia es de 10 pts.")
    @DecimalMin(value = "0.0", message = "La nota mínima de la materia es de 0 pts.")
    Double score;
}
