package com.example.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Setter @Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserDTO {

    @NotNull(message = "La id no puede estar vacía. ")
    @Size(min =0,message = "El id debe ser mayor a cero. ")
    private Integer userId;

    private String userName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Integer> followersId = new ArrayList<>();
}
