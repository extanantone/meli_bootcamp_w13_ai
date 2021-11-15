package com.SocialMeli.SocialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Seller extends User {
    private List<Buyer> followers = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();

    public Seller(String user_name, int user_id) {
        super(user_name,user_id);
    }
}
