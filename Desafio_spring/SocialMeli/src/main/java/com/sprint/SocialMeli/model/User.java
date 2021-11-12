package com.sprint.SocialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Getter
public abstract class User {
    int user_id;
    String user_name;

    public abstract UserType getUserType();
}
