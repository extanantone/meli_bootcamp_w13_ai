package com.miprimerproyecto.pruebaspring.controller;

import com.miprimerproyecto.pruebaspring.model.Morse;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class HelloWordController {

    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name){

        String numeroRomano="";
        try {
            numeroRomano = ConvertirANumeroRomano(Integer.parseInt(name));
        }catch (Exception e){
            return  e.getMessage();
        }
        return  "El numero "+name + " En romano es "+numeroRomano;
    }

    @GetMapping("/morse/{palabra}")
    public String morse(@PathVariable String palabra){

        Morse codigo = new Morse();
        String palabras[]= palabra.split(" ");
        StringBuilder decodificado = new StringBuilder();

        for (String p: palabras) {
            decodificado.append(codigo.getMorse().get(p));
        }
        return decodificado.toString();
    }


    private String ConvertirANumeroRomano(int numero){

        int i, miles, centenas, decenas, unidades;
        String romano = "";

        //obtenemos cada cifra del número
        miles = numero / 1000;
        centenas = numero / 100 % 10;
        decenas = numero / 10 % 10;
        unidades = numero % 10;

        //millar
        for (i = 1; i <= miles; i++) {
            romano = romano + "M";
        }

        //centenas
        if (centenas == 9) {
            romano = romano + "CM";
        } else if (centenas >= 5) {
            romano = romano + "D";
            for (i = 6; i <= centenas; i++) {
                romano = romano + "C";
            }
        } else if (centenas == 4) {
            romano = romano + "CD";
        } else {
            for (i = 1; i <= centenas; i++) {
                romano = romano + "C";
            }
        }

        //decenas
        if (decenas == 9) {
            romano = romano + "XC";
        } else if (decenas >= 5) {
            romano = romano + "L";
            for (i = 6; i <= decenas; i++) {
                romano = romano + "X";
            }
        } else if (decenas == 4) {
            romano = romano + "XL";
        } else {
            for (i = 1; i <= decenas; i++) {
                romano = romano + "X";
            }
        }

        //unidades
        if (unidades == 9) {
            romano = romano + "IX";
        } else if (unidades >= 5) {
            romano = romano + "V";
            for (i = 6; i <= unidades; i++) {
                romano = romano + "I";
            }
        } else if (unidades == 4) {
            romano = romano + "IV";
        } else {
            for (i = 1; i <= unidades; i++) {
                romano = romano + "I";
            }
        }
        return romano;
    }

}
