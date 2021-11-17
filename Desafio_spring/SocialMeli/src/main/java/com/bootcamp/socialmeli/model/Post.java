package com.bootcamp.socialmeli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private long id;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;

    private long userId;
    private long productId;

    public Post(LocalDate date, int category, double price, long userId, long productId) {
        this.date = date;
        this.category = category;
        this.price = price;
        this.userId = userId;
        this.productId = productId;
        this.hasPromo = false;
        this.discount = 0.0;
    }

    public Post(LocalDate date, int category, double price, long userId, long productId, boolean hasPromo, double discount) {
        this.date = date;
        this.category = category;
        this.price = price;
        this.userId = userId;
        this.productId = productId;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public boolean hasPromo() {
        return hasPromo;
    }
}
