package com.bootcamp.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private long user_id;
    private String user_name;
    private boolean seller;
    private Integer followers_count;
    private List<User> followers;
    private List<User> followed;

}
