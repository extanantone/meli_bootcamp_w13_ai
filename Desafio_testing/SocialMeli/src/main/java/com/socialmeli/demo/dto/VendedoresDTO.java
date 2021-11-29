package com.socialmeli.demo.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class VendedoresDTO {

    @NotNull(message = "Debe introducir un id de un vendedor")
    @Min(value = 1,message="El valor minimo es 1")

    private Integer user_id;
    private String user_name;
    private List<PublicacionDTO> posts;

    public VendedoresDTO(Integer user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.posts = new ArrayList<>();
    }
}
