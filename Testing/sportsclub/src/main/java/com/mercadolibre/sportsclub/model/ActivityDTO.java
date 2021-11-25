package com.mercadolibre.sportsclub.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class ActivityDTO implements Serializable {
    @NotBlank(message = "Sport’s name must not be empty.")
    @Size(min = 0, max = 50, message = "Sport’s name max length is 50 characters.")
    private String sport;
    @NotNull(message = "Fee value must not be empty.")
    private Double fee;
}
