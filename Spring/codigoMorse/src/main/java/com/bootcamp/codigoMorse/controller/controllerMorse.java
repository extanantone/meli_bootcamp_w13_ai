package com.bootcamp.codigoMorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class controllerMorse {
    @GetMapping("/{codigo}")
    public String helloSpring(@PathVariable("codigo") String input) {
        StringBuilder retorno = new StringBuilder();
        String morse[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..",
                "--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..",
                "|",".---","..---","...--","....-",".....","-....","--...","---..","----.","-----"};
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ 1234567890";
        String palabrasDivididas[ ]= input.split("   ");
        for(String pd : palabrasDivididas){
            String letras[] = pd.split(" ");
            for(String ld : letras){
                for (int j=0; j<morse.length; j++){
                    if(morse[j].equals(ld)){
                        retorno.append(alfabeto.charAt(j));
                    }
                }
            }
            retorno.append(" ");
        }

        return "LA FRASE QUE INTRODUJO ES: " + retorno;

    }
}
