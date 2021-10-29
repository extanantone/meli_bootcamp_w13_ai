package com.example.morse.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import static java.util.Map.entry;

public class MorseService {

    private MorseService(){

    }

    private static final Map<String,String> dictionary = Map.ofEntries(
            entry(".-", "A"), entry("-...", "B"), entry("-.-.", "C"), entry("-..", "D"), entry(".", "E"), entry("..-.", "F"),
            entry("--.", "G"), entry("....", "H"), entry("..", "I"), entry(".---", "J"), entry("-.-", "K"), entry(".-..", "L"),
            entry("--", "M"), entry("-.", "N"), entry("---", "O"), entry(".--.", "P"), entry("--.-", "Q"), entry(".-.", "R"),
            entry("...", "S"), entry("-", "T"), entry("..-", "U"), entry("...-", "V"), entry(".--", "W"), entry("-..-", "X"),
            entry("-.--", "Y"), entry("--..", "Z"), entry(".----", "1"), entry("..---", "2"), entry("...--", "3"), entry("....-", "4"),
            entry(".....", "5"), entry("-....", "6"), entry("--...", "7"), entry("---..", "8"), entry("----.", "9"), entry("-----", "0"),
            entry("..--..", "?"), entry("-.-.--", "!"), entry(".-.-.-", "."), entry("--..--", ",")
    );

    public static String toString(String morse){
        StringBuilder transformedMorse = new StringBuilder();
        ArrayList<String> palabras = new ArrayList<>(Arrays.asList(morse.split("   ")));
        for(String palabra : palabras){
            if(transformedMorse.length() > 0) transformedMorse.append(" ");
            ArrayList<String> letras = new ArrayList<>(Arrays.asList(palabra.split(" ")));
            for(String letra : letras) transformedMorse.append(dictionary.get(letra));
        }
        return transformedMorse.toString();
    }
}
