package com.example.socialmeli.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter @Getter
public class User {

    private Integer userId;
    private String userName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Integer> followersId = new ArrayList<>();
}
