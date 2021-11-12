package SocialMeli.model;

import lombok.Getter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
public class Customer extends User {
    Set<Integer> followedsIdSet = new HashSet<>();

    public Customer(int user_id, String user_name) {
        super(user_id, user_name);
    }
}
