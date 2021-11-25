package SocialMeli.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
@EqualsAndHashCode
public class Customer extends User {
    Set<Integer> followedsIdSet = new HashSet<>();

    public Customer(int userId, String userName) {
        super(userId, userName);
    }

    public Customer(User user) {
        super(user.getUserId(), user.getUserName());
    }
}
