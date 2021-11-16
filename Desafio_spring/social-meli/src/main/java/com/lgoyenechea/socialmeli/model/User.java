package com.lgoyenechea.socialmeli.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class User {
    private Long id;
    private String name;
    private List<Long> followers;
    private List<Long> followed;

    public User() {
        followers = new ArrayList<>();
        followed = new ArrayList<>();
    }
}
