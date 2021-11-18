package com.example.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter @Getter
public class UserDTO {

    private Integer userId;
    private String userName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Integer> followersId = new ArrayList<>();
}
