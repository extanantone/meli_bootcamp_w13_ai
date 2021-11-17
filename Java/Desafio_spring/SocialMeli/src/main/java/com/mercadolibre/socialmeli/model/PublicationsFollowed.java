package com.mercadolibre.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicationsFollowed {
    private int userId;
    private List<Publication> publications;

    @Override
    public String toString() {
        return "PublicatiosFollowed{" +
                "userId=" + userId +
                ", publications=" + publications +
                '}';
    }
}
