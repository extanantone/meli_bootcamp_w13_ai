package com.bootcamp.codigoMorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class CodigoMorseController {
    @GetMapping("/{codigoMorse}")
    public String codigoMorseAEspanol(@PathVariable String codigoMorse) {

        HashMap<String, String> morseHashMap = new HashMap<>();

        morseHashMap.put(".-", "A");
        morseHashMap.put("-...", "B");
        morseHashMap.put("-.-.", "C");
        morseHashMap.put("-..", "D");
        morseHashMap.put(".", "E");
        morseHashMap.put("..-.", "F");
        morseHashMap.put("--.", "G");
        morseHashMap.put("....", "H");
        morseHashMap.put("..", "I");
        morseHashMap.put(".---", "J");
        morseHashMap.put("-.-", "K");
        morseHashMap.put(".-..", "L");
        morseHashMap.put("--", "M");
        morseHashMap.put("-.", "N");
        morseHashMap.put("---", "O");
        morseHashMap.put(".--.", "P");
        morseHashMap.put("--.-", "Q");
        morseHashMap.put(".-.", "R");
        morseHashMap.put("...", "S");
        morseHashMap.put("-", "T");
        morseHashMap.put("..-", "U");
        morseHashMap.put("...-", "V");
        morseHashMap.put(".--", "W");
        morseHashMap.put("-..-", "X");
        morseHashMap.put("-.--", "Y");
        morseHashMap.put("--..", "Z");
        morseHashMap.put(".----", "1");
        morseHashMap.put("..---", "2");
        morseHashMap.put("...--", "3");
        morseHashMap.put("....-", "4");
        morseHashMap.put(".....", "5");
        morseHashMap.put("-....", "6");
        morseHashMap.put("--...", "7");
        morseHashMap.put("---..", "8");
        morseHashMap.put("----.", "9");
        morseHashMap.put("-----", "0");
        morseHashMap.put("..--..", "?");
        morseHashMap.put("-.-.--", "!");
        morseHashMap.put(".-.-.-", ".");
        morseHashMap.put("--..--", ",");
        morseHashMap.put("[ESPACIO]", " ");

        codigoMorse = codigoMorse.replaceAll("\\s{3}", " [ESPACIO] ");
        String[] arrayCodigoMorse = codigoMorse.split("\\s");
        String palabra = "";

        for (String letra : arrayCodigoMorse) {
            palabra += morseHashMap.get(letra);
        }

        return palabra;
    }
}