package com.bootcamp.SocialMeli.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data

public abstract class User {

    private int userId;
    private String userName;

}
