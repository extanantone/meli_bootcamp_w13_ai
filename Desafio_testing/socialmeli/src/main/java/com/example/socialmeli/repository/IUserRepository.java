package com.example.socialmeli.repository;

import com.example.socialmeli.Models.Product;
import com.example.socialmeli.Models.User;
import java.util.ArrayList;
import java.util.Hashtable;

public interface IUserRepository {

    User getUserbyId(Integer i);

    Integer createPost(Product request);

    Integer createPostPromo(Product request);

    ArrayList<Product> getListProducts();

    ArrayList<Product> getListProductsPromo();

    void setUsersList(Hashtable<Integer, User> usersList);
}
