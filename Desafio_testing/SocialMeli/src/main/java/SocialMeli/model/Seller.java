package SocialMeli.model;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Seller extends User {
    Set<Integer> followersIdSet = new HashSet<>();
    Set<Integer> postIdSet = new HashSet<>();

    public Seller(int userId, String userName) {
        super(userId, userName);
    }

    public Seller(User user) {
        super(user.getUserId(), user.getUserName());
    }
}
