package com.example.socialmeli.unit.utils;

import com.example.socialmeli.Models.DetalleProduct;
import com.example.socialmeli.Models.Product;
import com.example.socialmeli.Models.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Hashtable;

public class UtilRepository {
    static User user1 = new User("Lina");
    static User user2 = new User("Carlos");
    static User user3 = new User("Francisco");
    static User user4 = new User("Juliana");
    Hashtable<Integer, User> tableUsers = new Hashtable<>();
    static  final DetalleProduct detail1 = new DetalleProduct(1, "Car", "Racer", "Audi", "Red", "Super Fast");
    static String str = "15-11-2021";
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    static LocalDate dateTime = LocalDate.parse(str, formatter);
    private static final Product product1 = new Product(1,1, dateTime, detail1, 100, 200000 );


    public static  User getUser2(){
        return user2;
    }

    public static Product getProduct1(){
        return product1;
    }




}
