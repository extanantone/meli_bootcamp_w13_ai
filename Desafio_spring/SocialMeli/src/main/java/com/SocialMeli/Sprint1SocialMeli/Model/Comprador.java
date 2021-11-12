package com.SocialMeli.Sprint1SocialMeli.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class Comprador extends Usuario{


    private List<Integer> followeds;


    public Comprador(int userID, String user_name) {
        super(userID, user_name);
        this.followeds = new ArrayList<>();
    }

    public void addFollowed(Integer id_vendedor)
    {
        followeds.add(id_vendedor);
    }
    public void deleteFollowed(Integer id_Vendedor)
    {
        followeds.remove(id_Vendedor);
    }

}
