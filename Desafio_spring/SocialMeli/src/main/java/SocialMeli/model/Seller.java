package SocialMeli.model;

import lombok.Getter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
public class Seller extends User{
    Set<Integer> followersIdSet = new HashSet<>();
    Set<Integer> postIdSet = new HashSet<>();

    public Seller(int user_id, String user_name) {
        super(user_id, user_name);
    }
}
