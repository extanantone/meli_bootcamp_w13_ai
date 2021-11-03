package com.codigomorse.codigoMorse.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@RestController
public class CodigoMorseController {
    @GetMapping("/{morseCode}")
    public String codigoMorse(@PathVariable("codigoMorse") String codigoMorse) {

        if (codigoMorse == null || codigoMorse.isEmpty()) return "El código morse no puede ser vacío ni nulo.";

        return "la decodificación es: " + codigoMorse;
    }

    private static final Map<String, String> dictionary = Map.ofEntries(
            Map.entry(".-", "A"),
            Map.entry("-...", "B"),
            Map.entry("-.-.", "C"),
            Map.entry("-..", "D"),
            Map.entry(".", "E"),
            Map.entry("..-.", "F"),
            Map.entry("--.", "G"),
            Map.entry("....", "H"),
            Map.entry("..", "I"),
            Map.entry(".---", "J"),
            Map.entry("-.-", "K"),
            Map.entry(".-..", "L"),
            Map.entry("--", "M"),
            Map.entry("-.", "N"),
            Map.entry("---", "O"),
            Map.entry(".--.", "P"),
            Map.entry("--.-", "Q"),
            Map.entry(".-.", "R"),
            Map.entry("...", "S"),
            Map.entry("-", "T"),
            Map.entry("..-", "U"),
            Map.entry("...-", "V"),
            Map.entry(".--", "W"),
            Map.entry("-..-", "X"),
            Map.entry("-.--", "Y"),
            Map.entry("--..", "Z"),
            Map.entry(".----", "1"),
            Map.entry("..---", "2"),
            Map.entry("...--", "3"),
            Map.entry("....-", "4"),
            Map.entry(".....", "5"),
            Map.entry("-....", "6"),
            Map.entry("--...", "7"),
            Map.entry("---..", "8"),
            Map.entry("----.", "9"),
            Map.entry("-----", "0"),
            Map.entry("..--..", "?"),
            Map.entry("-.-.--", "!"),
            Map.entry(".-.-.-", "."),
            Map.entry("--..--", ",")

    );
 public static String toString(String morse){
     StringBuilder translateMorse = new StringBuilder();
     ArrayList<String> aTraducir = new ArrayList<>(Arrays.asList(morse.split("")));
     for (String traducir : aTraducir){
         if(translateMorse.length() > 0) translateMorse.append(" ");
         ArrayList<String> letras = new ArrayList<>(Arrays.asList(traducir.split("")));
         for(String letra : letras)
             translateMorse.append(dictionary.get(letra));
     }
     return translateMorse.toString();
    }

}
