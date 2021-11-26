package com.mercadolibre.socialmeli.model;

import lombok.*;

@Getter
@Setter
@Data
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
