package com.mercadolibre.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Followers extends User{
    private List<User>users;

    public Followers(int id, String name, List<User> users) {
        super(id, name);
        this.users = users;
    }

    @Override
    public String toString() {
        return "Followers{" +
                "users=" + users +
                '}';
    }
}
