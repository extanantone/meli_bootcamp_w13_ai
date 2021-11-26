package com.lgoyenechea.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserCreationDTO {

    @NotEmpty(message = "{string.notempty}")
    @Size(max = 15, message = "{string.size.max.value.fifteen}")
    @Pattern(regexp = "\\A([A-Z]|[a-z]|[0-9]|ñ|Ñ|Á|É|Í|Ó|Ú|á|é|í|ó|ú)*$", message = "{string.specialcharacters}")
    private String userName;
}
