package com.bootcamp.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class UserPromoAllDTO extends UserDTO implements Serializable {
    private List<PostDTO> post;

    public UserPromoAllDTO(long userId, String userName, List<PostDTO> post) {
        super(userId, userName);
        this.post = post;
    }

    public UserPromoAllDTO() {
    }
}
