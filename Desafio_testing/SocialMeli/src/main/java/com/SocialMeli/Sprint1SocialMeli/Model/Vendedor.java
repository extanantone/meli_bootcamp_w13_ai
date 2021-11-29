package com.SocialMeli.Sprint1SocialMeli.Model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class Vendedor extends Usuario {

    List<Publicacion> posts;
    List<Integer> followers;


    public Vendedor(int userID, String userName) {
        super(userID, userName);
        this.posts = new ArrayList<>();
        this.followers = new ArrayList<>();
    }

    public void addFollower(Integer vendedorId) {
        followers.add(vendedorId);
    }

    public void deleteFollower(Integer vendedorId) {
        followers.remove(vendedorId);
    }
}
