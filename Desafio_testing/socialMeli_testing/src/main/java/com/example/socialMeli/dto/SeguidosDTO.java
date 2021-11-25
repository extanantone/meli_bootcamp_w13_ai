package com.example.socialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeguidosDTO {
    private int user_id;
    @NotNull(message = "El nombre del usuario no puede estar vacío")
    @Size(max=15, message = "El nombre no puede tener una longitud mayor a quince")
    @Pattern(regexp = "^[a-zA-Z0-9_ ]*$", message = "El nombre no puede contener caracteres especiales")
    private String user_name;
    private List<CompradoresDTO> followed;
}
