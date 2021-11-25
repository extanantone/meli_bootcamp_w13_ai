package com.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserCreationDTO {

    @NotNull(message = "Can't be empty")
    @NotBlank(message = "Can't be empty")
    @Size(max = 15, message = "Max size 15")
    @Pattern(regexp = "[A-Za-z0-9_.]*", message = "Can't have special characters nor spaces")
    private String username;

    @Email
    private String email;

    @Size(min = 8, max = 16, message = "Size must be between 8 and 16 characters")
    private String password;
}
