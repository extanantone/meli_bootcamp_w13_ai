package com.example.socialmeli.dto;

import lombok.Data;

import javax.validation.constraints.Digits;
import java.time.LocalDate;

@Data
public class DemoDTO {
    @Digits(integer = 2, fraction = 0, message = "se puede convertir")
    Integer n;

}
