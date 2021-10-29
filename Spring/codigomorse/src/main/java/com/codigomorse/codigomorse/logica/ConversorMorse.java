package com.codigomorse.codigomorse.logica;

import java.util.Map;
import java.util.regex.Pattern;

import static java.util.Map.entry;

public class ConversorMorse {
    private static final Map<String,String> dictionary = Map.ofEntries(
            entry(".-", "A"), entry("-...", "B"), entry("-.-.", "C"), entry("-..", "D"), entry(".", "E"), entry("..-.", "F"),
            entry("--.", "G"), entry("....", "H"), entry("..", "I"), entry(".---", "J"), entry("-.-", "K"), entry(".-..", "L"),
            entry("--", "M"), entry("-.", "N"), entry("---", "O"), entry(".--.", "P"), entry("--.-", "Q"), entry(".-.", "R"),
            entry("...", "S"), entry("-", "T"),entry("..-", "U"), entry("...-", "V"), entry(".--", "W"), entry("-..-", "X"),
            entry("-.--", "Y"), entry("--..", "Z"), entry(".----", "1"), entry("..---", "2"), entry("...--", "3"), entry("....-", "4"),
            entry(".....", "5"), entry("-....", "6"), entry("--...", "7"), entry("---..", "8"), entry("----.", "9"), entry("-----", "0"),
            entry("..--..", "?"), entry("-.-.--", "!"), entry(".-.-.-", "."), entry("--..--", ",")
    );

    public String convertir(String code){
        StringBuilder forReturn = new StringBuilder();
        String separadorPalabras = Pattern.quote("   ");
        String separadorLetra = Pattern.quote(" ");
        String[] palabras = code.split(separadorPalabras);
        for(String palabra : palabras){
            for(String caracter : palabra.split(separadorLetra)){
                forReturn.append(dictionary.get(caracter));
            };
            forReturn.append(" ");
        }
        return forReturn.toString();
    }

}
