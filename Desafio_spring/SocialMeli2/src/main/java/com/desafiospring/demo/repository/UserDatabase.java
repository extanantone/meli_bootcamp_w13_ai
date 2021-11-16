package com.desafiospring.demo.repository;

import java.util.HashMap;

public class UserDatabase {
// geenramos nuestra base de datos de usuario/vendedorres
   HashMap<Integer, String> mapUser = new HashMap<Integer, String>();

   UserDatabase() {


        this.mapUser.put(1, "Carolina");
        this.mapUser.put(2, "Pablo");
        mapUser.put(3, "Esteban");
        mapUser.put(4, "Ambar");
        mapUser.put(5, "Theo");
        mapUser.put(6, "Emilia");
        mapUser.put(7, "Joaquin");
        mapUser.put(8, "Leticia");
        mapUser.put(9, "Leo");
        mapUser.put(10, "Gonzalo");



    }
}
