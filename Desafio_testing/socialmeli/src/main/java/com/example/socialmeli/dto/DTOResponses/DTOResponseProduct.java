package com.example.socialmeli.dto.DTOResponses;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
@Setter @Getter
@ToString
public class DTOResponseProduct {
    Integer user_id;
    String user_name;
    ArrayList<DTOProductoResponse> posts = new ArrayList<>();

    public DTOResponseProduct(Integer user_id, ArrayList<DTOProductoResponse> listProducts, String  user_name) {
        this.user_id = user_id;
        this.posts = listProducts;
        this.user_name = user_name;
    }
}
