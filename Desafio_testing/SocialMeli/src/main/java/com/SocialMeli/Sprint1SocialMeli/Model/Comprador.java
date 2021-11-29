package com.SocialMeli.Sprint1SocialMeli.Model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class Comprador extends Usuario {


    private List<Integer> followeds;


    public Comprador(int userID, String userName) {
        super(userID, userName);
        this.followeds = new ArrayList<>();
    }

    public void addFollowed(Integer vendedorId) {
        followeds.add(vendedorId);
    }

    public void deleteFollowed(Integer vendedorId) {
        followeds.remove(vendedorId);
    }

}
