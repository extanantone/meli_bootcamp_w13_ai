package com.bootcamp.tutorials.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InUpdateTutorialDTO {

    @NotNull(message = "must have tutorial id that you will modified")
    @Positive(message = "must be a positive integer")
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Size(max = 500, min = 1, message = "must be equals or less than 500 characters")
    @Pattern(regexp = "([A-Z]|[0-9]|[a-z])[\\\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|(\\ )]*$"
            , message = "must not have special characters")
    private String title;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Size(max = 2000, message = "must be equals or less than 2000 characters")
    @Pattern(regexp = "([A-Z]|[0-9]|[a-z])[\\\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|(\\ )]*$"
            , message = "must not have special characters")
    private String description;

}
