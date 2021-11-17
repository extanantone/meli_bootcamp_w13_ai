package com.example.socialmeli.repository;

import com.example.socialmeli.Models.Product;
import com.example.socialmeli.Models.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Hashtable;


@Repository
@Getter
@Setter
public class RepositoryUser implements IUserRepository{
    private Hashtable<Integer, User> usersList = new Hashtable();
    private ArrayList<Product> publicaciones = new ArrayList();
    private ArrayList<Product> publicacionesPromo = new ArrayList();


    public RepositoryUser() {
        createUsers();
    }

    private void createUsers(){
        User user1 = new User("Pedro");
        User user2 = new User("Pablo");
        User user3 = new User("Camila");
        User user4 = new User("Diana");
        usersList.put(user1.getUserId(), user1);
        usersList.put(user2.getUserId(), user2);
        usersList.put(user3.getUserId(), user3);
        usersList.put(user4.getUserId(), user4);
    }

    @Override
    public User getUserbyId(Integer i){
       if (usersList.containsKey(i)){
           return usersList.get(i);
       }else{
           return null;
       }
    }

    @Override
    public Integer createPost(Product product) {
        for (Product currentProduct : publicaciones){
            if (product.getId_post() == currentProduct.getId_post()){
                return null;
            }
        }
        publicaciones.add(product);
        System.out.println(publicaciones);
        return 1;
    }

    @Override
    public Integer createPostPromo(Product product) {
        for (Product currentProduct : publicacionesPromo){
            if (product.getId_post() == currentProduct.getId_post()){
                return null;
            }
        }
        publicacionesPromo.add(product);
        return 1;
    }

    @Override
    public ArrayList<Product> getListProducts() {
        return publicaciones;
    }

    @Override
    public ArrayList<Product> getListProductsPromo() {
        return publicacionesPromo;
    }


}
