package com.example.easynotes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
        @JsonProperty("first_name")
        @NotEmpty
        private String firstName;

        @JsonProperty("last_name")
        @NotEmpty
        private String lastName;

}
