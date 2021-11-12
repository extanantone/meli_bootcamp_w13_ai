package com.sprint.SocialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Getter
public abstract class Usuario {
    int user_id;
    String user_name;

    abstract TipoUsuario getUserType();
}
