package com.ej8.calcularedad.controllers;

import lombok.Getter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

@Getter
class RespuestaJson{
    String age;
    RespuestaJson(String age){
        this.age = age;
    }
}

@RestController
public class DateController {
    @GetMapping("/api/age/{birthdate}")
    public RespuestaJson dateToAge(@PathVariable String birthdate){
        String msg;
        try {
            LocalDate date = LocalDate.parse(birthdate);
            msg = "" + Period.between(date ,LocalDate.now()).getYears();
        } catch(DateTimeParseException e){
            msg = "Wrong date";
        }
        return new RespuestaJson(msg);
    }
}
