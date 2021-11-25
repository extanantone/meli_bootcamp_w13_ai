package com.bootcamp.socialmeliSprint1.entitiy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Purchaser extends User {

    private List<Integer> followed;

    public Purchaser() {
        this.followed = new ArrayList<>();
    }

    public Purchaser(int userID, String userName) {
        super(userID, userName);
        this.followed = new ArrayList<>();
    }

    public void addFollowed(Integer userId)
    {
        followed.add(userId);
    }
    public void deleteFollowed(Integer userId)
    {
        followed.remove(userId);
    }

}
