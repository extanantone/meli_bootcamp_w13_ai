package com.example.socialmeli.unit.utils;

import com.example.socialmeli.Models.DetalleProduct;
import com.example.socialmeli.Models.Product;
import com.example.socialmeli.Models.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Hashtable;


public class UtilsProductService {
    static  final DetalleProduct detail1 = new DetalleProduct(1, "Car", "Racer", "Audi", "Red", "Super Fast");
    static String str = "15-11-2021";
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    static LocalDate dateTime = LocalDate.parse(str, formatter);
    private static final Product product1 = new Product(1, 1, dateTime, detail1, 100, 200000);

    private static final DetalleProduct detail2 = new DetalleProduct(2, "Car 4x4", "Montero", "Toyota", "Black", "Super Powerfull");
    static  String str2 = "16-11-2021";
    static  LocalDate dateTime2 = LocalDate.parse(str2, formatter);
    private static final Product product2 = new Product(1, 2, dateTime2, detail2, 100, 500000);

    private static final DetalleProduct detail3 = new DetalleProduct(3, "Car 4x4", "Montero", "Toyota", "Black", "Super Powerfull");
    static  String str3 = "08-11-2021";
    static  LocalDate dateTime3 = LocalDate.parse(str3, formatter);
    private static final Product product3 = new Product(3, 3, dateTime3, detail3, 100, 500000);

    private static final ArrayList<Product> arrayListProducts  = new ArrayList<>();
    static User user1 = new User("Lina");
    static User user2 = new User("Carlos");
    static User user3 = new User("Francisco");

    public  static ArrayList<Product> getArrayListOfProducts() {

        arrayListProducts.add(product1);
        arrayListProducts.add(product2);
        arrayListProducts.add(product3);

        return arrayListProducts;
    }

    public static void cleanArrayOfProducts(){
        arrayListProducts.clear();
    }




    public static User getUser2(){
        Hashtable<Integer, User> tableUsersFolloweed = new Hashtable<>();
        Hashtable<Integer, User> tableUsersFollowers = new Hashtable<>();

        // set followers of 2
        tableUsersFollowers.put(user1.getUserId(), user1);
        tableUsersFollowers.put(user3.getUserId(), user3);
        user2.setFollowers(tableUsersFollowers);

        // set followees of 2
        tableUsersFolloweed.put(user1.getUserId(), user1);
        tableUsersFolloweed.put(user3.getUserId(), user3);
        user2.setFollowees(tableUsersFolloweed);
        return user2;
    }

    public static User getUser1(){
        getUser2();
        return user1;
    }
}
