package com.bootcamp.SocialMeli.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CountDTO extends UserDTO implements Serializable {
    private Integer count;

    public CountDTO(Integer user_id, String user_name, Integer fCount) {
        super(user_id, user_name);
        this.count = fCount;
    }
}
