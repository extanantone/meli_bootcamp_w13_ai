package com.example.socialmeli.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private int userId;
    private int idPost;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;

    public boolean hasPromo() { return false; }

    public void setPromo(boolean promo) {  }

    public double hasDiscount() { return 0.00; }

    public void setDiscount(Double discount) {  }

}
