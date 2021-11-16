package com.SocialMeli.Sprint1SocialMeli.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Vendedor extends Usuario{

    List<Publicacion> posts;
    List<Integer> followers;



    public Vendedor(int userID, String userName) {
        super(userID, userName);
        this.posts = new ArrayList<>();
        this.followers = new ArrayList<>();
    }

    public void addFollower(Integer vendedorId)
    {
        followers.add(vendedorId);
    }
    public void deleteFollower(Integer vendedorId)
    {
        followers.remove(vendedorId);
    }
}
