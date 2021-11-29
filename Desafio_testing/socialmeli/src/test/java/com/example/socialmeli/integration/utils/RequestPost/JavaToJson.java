package com.example.socialmeli.integration.utils.RequestPost;

import com.example.socialmeli.dto.DTORequest.DTOproductsRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JavaToJson {

    public static void convertJavaToJson(DTOproductsRequest post){

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .writer();

        try{
            String payload = writer.writeValueAsString(post);
            /*System.out.println(jsonStr);*/
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
    }
}
