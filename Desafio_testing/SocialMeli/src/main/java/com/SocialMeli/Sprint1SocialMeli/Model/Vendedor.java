package com.SocialMeli.Sprint1SocialMeli.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class Vendedor extends Usuario{

    List<Publicacion> posts;
    List<Integer> followers;



    public Vendedor(int userID, String user_name) {
        super(userID, user_name);
        this.posts = new ArrayList<>();
        this.followers = new ArrayList<>();
    }

    public void addFollower(Integer id_comprador)
    {
        followers.add(id_comprador);
    }
    public void deleteFollower(Integer id_comprador)
    {
        followers.remove(id_comprador);
    }
}
