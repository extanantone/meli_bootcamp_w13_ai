package com.example.socialmeli.repository;

import com.example.socialmeli.Models.Product;
import com.example.socialmeli.Models.User;
import com.example.socialmeli.dto.DTOproductsRequest;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface IUserRepository {

    User getUserbyId(Integer i);

    Integer createPost(Product request);

    ArrayList<Product> getListProducts();
}
