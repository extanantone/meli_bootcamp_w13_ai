package com.bootcamp.codigomorse.controller;

import java.util.List;
import java.util.TreeMap;

public class CodigoMorse {
        private final static TreeMap<String, String> map = new TreeMap<>();

        static {
            map.put(".-","a");
            map.put("-...","b");
            map.put("-.-.","c");
            map.put("-..","d" );
            map.put(".", "e" );
            map.put("..-.", "f");
            map.put("--.", "g");
            map.put("....", "h");
            map.put("..", "i");
            map.put(".---", "j");
            map.put("-.-", "k");
            map.put(".-..", "l");
            map.put("--", "m");
            map.put("-.", "n");
            map.put("---", "o");
            map.put(".--.", "p");
            map.put("--.-", "q");
            map.put(".-.", "r");
            map.put("...", "s");
            map.put("-", "t");
            map.put("..-", "u");
            map.put("...-", "v");
            map.put(".--", "w");
            map.put("-..-", "x");
            map.put("-.--", "y");
            map.put("--..", "z");

            map.put(".----", "1");
            map.put("..---", "2");
            map.put("...--", "3");
            map.put("....-", "4");
            map.put(".....", "5");
            map.put("-....", "6");
            map.put("--...", "7");
            map.put("---..", "8");
            map.put("----.", "9");
            map.put("-----", "0");

            map.put("..--..", "?");
            map.put("-.-.--", "!");
            map.put(".-.-.-", ".");
            map.put("--..--", ",");

        }

    public static String translate(String phrase) {
        StringBuilder res = new StringBuilder();
        List<String> words = List.of(phrase.toUpperCase().split("   "));

        for (String word : words) {
            List<String> characters = List.of(word.split(" "));
            characters.stream().forEach(c -> res.append(map.get(c)));
            res.append(" ");
        }
        return res.toString();
    }
}