package com.bootcamp.codigomorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.util.Map.entry;

@RestController
public class CodigoMorseController {

    private static final Map<String, String> codigoMorse = Map.ofEntries(entry(".-","A"), entry("-...","B"),
                                                                entry("-.-.","C"), entry("-..","D"),
                                                                entry(".","E"), entry("..-.","F"),
                                                                entry("--.","G"), entry("....","H"),
                                                                entry("..","I"), entry(".---","J"),
                                                                entry("-.-","K"), entry(".-..","L"),
                                                                entry("--","M"), entry("-.","N"),
                                                                entry("---","O"), entry(".--.","P"),
                                                                entry("--.-","Q"), entry(".-.","R"),
                                                                entry("...","S"), entry("-","T"),
                                                                entry("..-","U"), entry("...-","V"),
                                                                entry(".--","W"), entry("-..-","X"),
                                                                entry("-.--","Y"), entry("--..","Z"),
                                                                entry(".----","1"), entry("..---","2"),
                                                                entry("...--","3"), entry("....-","4"),
                                                                entry(".....","5"), entry("-....","6"),
                                                                entry("--...","7"), entry("---..","8"),
                                                                entry("----.","9"), entry("-----","0"),
                                                                entry("..--..","?"), entry("-.-.--","!"),
                                                                entry(".-.-.-","."), entry("--..--",","));

    @GetMapping("/{codigo}")
    public String traducirMorse(@PathVariable String codigo){

        String texto = "'" + codigo + "' significa '";

        String[] palabras = codigo.split("   "); //divido frase en palabras

        for (String word : palabras) {
            String[] caracteres = word.split(" "); //divido palabras en caracteres
            for (String car : caracteres) {
                if(codigoMorse.get(car) == null){
                    texto = "Su consulta no ha sido procesada debido a que ha ingresado un codigo invalido";
                    return texto;
                }
                texto += codigoMorse.get(car); //traduzco un caracter
            }
            texto += " ";
        }

        texto = texto.trim() + "'"; //elimina el espacio al final

        return texto;
    }

}
