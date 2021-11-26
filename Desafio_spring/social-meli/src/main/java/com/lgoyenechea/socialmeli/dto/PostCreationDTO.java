package com.lgoyenechea.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotNull;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@NoArgsConstructor
@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostCreationDTO {

    @NotNull(message = "{general.notnull}")
    @Min(value = 0, message = "{number.min.value.zero}")
    @Positive
    private Long userId;

    @NotEmpty(message = "{string.notempty}")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private String date;

    @Valid
    private ProductCreationDTO detail;

    @NotNull(message = "{general.notnutll}")
    private Integer category;

    @NotNull(message = "{general.notnutll}")
    @Max(value = 10000000, message = "{number.max.value.tenmillons}")
    @Positive
    private Double price;
}
