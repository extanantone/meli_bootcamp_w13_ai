package com.SocialMeli.SocialMeli.service;

import com.SocialMeli.SocialMeli.dto.PostDTO;
import com.SocialMeli.SocialMeli.dto.ProductDTO;
import com.SocialMeli.SocialMeli.model.Buyer;
import com.SocialMeli.SocialMeli.model.Seller;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Utils {


    public Buyer OkOrden(){
        String date1= "14-11-2021";
        List<String> date = new ArrayList<>();
        date.add(date1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate fecha = LocalDate.parse(date1, formatter);


        Buyer buy = new Buyer("Tom", 1);
        Seller sell = new Seller("Raul",23);


        ProductDTO prod = new ProductDTO(1,"mesa","pino", "pa","blanca","coto");
        PostDTO post = new PostDTO(1,2,fecha, prod,100,1000);
        sell.getPosts().add(post);
        buy.getFollowed().add(sell);

        return buy;
    }

    public Buyer OkOrder(){
        String date1= "14-11-2021";
        List<String> date = new ArrayList<>();
        date.add(date1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate fecha = LocalDate.parse(date1, formatter);


        Buyer buy = new Buyer("Tom", 1);
        Seller sell = new Seller("Raul",23);


        ProductDTO prod = new ProductDTO(1,"mesa","pino", "pa","blanca","coto");
        PostDTO post = new PostDTO(1,2,fecha, prod,100,1000);
        sell.getPosts().add(post);
        buy.getFollowed().add(sell);

        return buy;
    }

    public String returDate(){
        String date= "14-11-2021";
        return date;
    }
    public List<String> returDateDesc(){
        String date1= "14-11-2021";
        List<String> date = new ArrayList<>();
        date.add(date1);
        return date;
    }
}
