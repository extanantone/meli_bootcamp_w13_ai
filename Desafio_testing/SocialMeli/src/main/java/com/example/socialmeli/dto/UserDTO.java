package com.example.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)

public class UserDTO {

    @NotNull(message = "userId must be numeric and can not be null or empty or negative")
    @Positive(message = "userId must be numeric and can not be null or empty or negative")
    private Integer userId;

    @NotBlank(message = "userName can not be null or empty")
    @Size(max = 15, message = "userName can not be longer than 15 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "userName can not have special characters")
    private String userName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Integer> followersId = new ArrayList<>();
}
