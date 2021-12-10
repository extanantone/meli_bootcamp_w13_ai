package com.bootcamp.tutorials.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InCreateTutorialDTO {

    @NotEmpty(message = "must not be empty")
    @Size(max = 500, message = "must be equals or less than 500 characters")
    @Pattern(regexp = "([A-Z]|[0-9]|[a-z])[\\\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|(\\ )]*$"
            , message = "must not have special characters")
    private String title;

    @NotEmpty(message = "must not be empty")
    @Size(max = 2000, message = "must be equals or less than 2000 characters")
    @Pattern(regexp = "([A-Z]|[0-9]|[a-z])[\\\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|(\\ )]*$"
            , message = "must not have special characters")
    private String description;

}
