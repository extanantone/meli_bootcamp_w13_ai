package com.bootcamp.socialmeli.entitiy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class Purchaser extends User {

    private List<Integer> followed;

    public Purchaser(int userID, String userName) {
        super(userID, userName);
        this.followed = new ArrayList<>();

        int copyList[] = new int[followed.size()];

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
