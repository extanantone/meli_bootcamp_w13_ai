package com.example.socialmeli.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class User {

    public Integer userId;
    public String userName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public List<Integer> followersId = new ArrayList<>();
}
