package com.mercadolibre.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Follow {
    private int userId;
    private int idUserToFollow;

    @Override
    public String toString() {
        return "Follow{" +
                "userId=" + userId +
                ", idUserToFollow=" + idUserToFollow +
                '}';
    }
}
