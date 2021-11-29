package com.example.socialmeli.integration.utils.RequestPost;

import com.example.socialmeli.dto.DTORequest.DTOdetailRequest;
import com.example.socialmeli.dto.DTORequest.DTOproductsRequest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DTORequestPost {
    static DTOdetailRequest detail = new DTOdetailRequest(1, "tesla x", "deportivo","teslla", "negro", "Vehiculo Electrico");

    static LocalDate dateTime = LocalDate.of(2021,11,20);
    public static  DTOproductsRequest product1 = new DTOproductsRequest(1,1, dateTime, detail, 100, 200000);


    public static DTOproductsRequest getDtoProductRequest(){
        return product1;
    }
}
