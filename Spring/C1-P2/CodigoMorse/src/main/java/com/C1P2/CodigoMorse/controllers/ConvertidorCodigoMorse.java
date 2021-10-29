package com.C1P2.CodigoMorse.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ConvertidorCodigoMorse {

    @GetMapping("/{codigo}")
    public String convertirCodigoMorse(@PathVariable String codigo) {
        String resultado = "";

        String [] palabras = codigo.split("_");

        for (String palabra : palabras){
            String [] caracteres = palabra.split(" ");

            for(String caracter : caracteres){
                resultado += this.convertirCaracter(caracter);
            }

            resultado += " ";
        }

        return resultado;

    }

    private Character convertirCaracter(String caracter){

        HashMap<String, Character> codigos = new HashMap<>();
        codigos.put(".-",'A');
        codigos.put("-...",'B');
        codigos.put("-.-.",'C');
        codigos.put("-..",'D');
        codigos.put(".",'E');
        codigos.put("..-.",'F');
        codigos.put("--.",'G');
        codigos.put("....",'H');
        codigos.put("..",'I');
        codigos.put(".---",'J');
        codigos.put("-.-",'K');
        codigos.put(".-..",'L');
        codigos.put("--",'M');
        codigos.put("-.",'N');
        codigos.put("---",'O');
        codigos.put(".--.",'P');
        codigos.put("--.-",'Q');
        codigos.put(".-.",'R');
        codigos.put("...",'S');
        codigos.put("-",'T');
        codigos.put("..-",'U');
        codigos.put("...-",'V');
        codigos.put(".--",'W');
        codigos.put("-..-",'X');
        codigos.put("-.--",'Y');
        codigos.put("--..",'Z');
        codigos.put("-----",'0');
        codigos.put(".----",'1');
        codigos.put("..---",'2');
        codigos.put("...--",'3');
        codigos.put("....-",'4');
        codigos.put(".....",'5');
        codigos.put("-....",'6');
        codigos.put("--...",'7');
        codigos.put("---..",'8');
        codigos.put("----.",'9');
        codigos.put("..--..",'?');
        codigos.put("-.-.--",'!');
        codigos.put(".-.-.-",'.');
        codigos.put("--..--",',');


        return codigos.get(caracter);
    }


}