package com.bootcamp.socialmeli.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Promotion extends Post{
    private boolean hasPromo;
    private Double discount;

    public Promotion(Long id, LocalDate date, PostProduct detail, Integer category, Double price, boolean hasPromo, Double discount) {
        super(id, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    @Override
    public boolean isHasPromo () { return this.hasPromo; }
}
