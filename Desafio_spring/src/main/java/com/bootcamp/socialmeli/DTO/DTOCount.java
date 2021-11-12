package com.bootcamp.socialmeli.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOCount {

    private int userId;
    private String name;
    private int followersCount;

}
