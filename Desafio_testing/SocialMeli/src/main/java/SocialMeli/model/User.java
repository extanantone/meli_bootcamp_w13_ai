package SocialMeli.model;

import lombok.Getter;

@Getter
public abstract class User {
    int userId;
    String userName;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
