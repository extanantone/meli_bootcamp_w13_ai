package com.mercadolibre.socialmeli.model;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Publication {
    private int userId;
    private int id;
    private LocalDate date;
    private Product product;
    private int category;
    private double price;

    public Publication(int userId, int id, LocalDate date, Product product, int category, double price) {
        this.userId = userId;
        this.id = id;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }
}
