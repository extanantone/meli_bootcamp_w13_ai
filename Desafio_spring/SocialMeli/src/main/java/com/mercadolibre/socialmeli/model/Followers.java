package com.mercadolibre.socialmeli.model;

import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true) //TODO que hace esto
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Followers extends User{
    private List<User>users;

    public Followers(int id, String name, List<User> users) {
        super(id, name);
        this.users = users;
    }

}
