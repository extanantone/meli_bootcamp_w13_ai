package com.example.socialmeli.dto;

import com.example.socialmeli.Models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Setter @Getter
public class DTOResponseProduct {
    Integer user_id;
    ArrayList<DTOProducto> posts = new ArrayList<>();

    public DTOResponseProduct(Integer user_id, ArrayList<DTOProducto> listProducts) {
        this.user_id = user_id;
        this.posts = listProducts;
    }
}
