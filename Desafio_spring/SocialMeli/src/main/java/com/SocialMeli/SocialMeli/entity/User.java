package com.SocialMeli.SocialMeli.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter @Setter
public abstract class User {
    protected int id;
    protected String userName;
    protected Map<Integer, User> followed;
}
