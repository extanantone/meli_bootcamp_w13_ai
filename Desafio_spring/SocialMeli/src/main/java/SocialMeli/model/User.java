package SocialMeli.model;

import lombok.Getter;

@Getter
public abstract class User {
    int user_id;
    String user_name;

    public User(int user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
    }
}
