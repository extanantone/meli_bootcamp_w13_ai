package com.example.socialmeli.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Data

public class User {

    private Integer userId;
    private String userName;
    private List<Integer> followersId ;
}
