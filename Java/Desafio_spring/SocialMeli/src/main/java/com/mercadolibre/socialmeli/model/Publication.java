package com.mercadolibre.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publication {
    private int userId;
    private int id;
    private LocalDate date;
    private Product product;
    private int category;
    private double price;

    @Override
    public String toString() {
        return "Publication{" +
                "userId=" + userId +
                ", id=" + id +
                ", product=" + product +
                ", date=" + date +
                ", category=" + category +
                ", price=" + price +
                '}';
    }
}
