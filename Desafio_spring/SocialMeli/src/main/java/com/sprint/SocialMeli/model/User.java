package com.sprint.SocialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Getter
public abstract class User {
    int user_id;
    String user_name;

    // Clase a sobreescribir según el Buyer o Seller, para así poder identificar a que clase pertenecen
    public abstract UserType getUserType();
}
