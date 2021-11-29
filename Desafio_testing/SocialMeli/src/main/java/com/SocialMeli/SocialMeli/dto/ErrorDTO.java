package com.SocialMeli.SocialMeli.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {

    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
}
