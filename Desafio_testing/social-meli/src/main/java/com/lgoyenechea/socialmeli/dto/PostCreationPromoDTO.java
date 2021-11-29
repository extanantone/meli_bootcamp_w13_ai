package com.lgoyenechea.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostCreationPromoDTO extends PostCreationDTO {

    @NotNull(message = "{general.notnutll}")
    private Boolean hasPromo;

    @NotNull(message = "{general.notnutll}")
    @Positive
    private Double discount;
}
