package com.bootcamp.SocialMeli.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public abstract class User {
    private int id;
    private String name;
    private Map<Integer, Seller> followed;

    public void addFollowed(User user) {
        int userId = user.getId();
        if (this.followed.containsKey(userId)) throw new RuntimeException("followed already exists");
        //implementar excepciones y handler
        this.followed.put(userId, (Seller) user);
    }

    public void removeFollowed(int userId) {
        if (!this.followed.containsKey(userId)) throw new RuntimeException("followed doesn't exist");
        this.followed.remove(userId);
    }
}
