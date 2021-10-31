package com.example.morse;

import java.util.HashMap;

public class Unmorser {

    public static String unmorser(String[] morse) {
        StringBuilder unmorsedWord = new StringBuilder();

        HashMap<String, String> equivalenceMap = new HashMap<>();

        equivalenceMap.put(".-", "A");
        equivalenceMap.put("-...", "B");
        equivalenceMap.put("-.-.", "C");
        equivalenceMap.put("-..", "D");
        equivalenceMap.put(".", "E");
        equivalenceMap.put("..-.", "F");
        equivalenceMap.put("--.", "G");
        equivalenceMap.put("....", "H");
        equivalenceMap.put("..", "I");
        equivalenceMap.put(".---", "J");
        equivalenceMap.put("-.-", "K");
        equivalenceMap.put(".-..", "L");
        equivalenceMap.put("--", "M");
        equivalenceMap.put("-.", "N");
        equivalenceMap.put("---", "O");
        equivalenceMap.put(".--.", "P");
        equivalenceMap.put("--.-", "Q");
        equivalenceMap.put(".-.", "R");
        equivalenceMap.put("...", "S");
        equivalenceMap.put("-", "T");
        equivalenceMap.put("..-", "U");
        equivalenceMap.put("...-", "V");
        equivalenceMap.put(".--", "W");
        equivalenceMap.put("-..-", "X");
        equivalenceMap.put("-.--", "Y");
        equivalenceMap.put("--..", "Z");
        equivalenceMap.put(".----", "1");
        equivalenceMap.put("..---", "2");
        equivalenceMap.put("...--", "3");
        equivalenceMap.put("....-", "4");
        equivalenceMap.put(".....", "5");
        equivalenceMap.put("-....", "6");
        equivalenceMap.put("--...", "7");
        equivalenceMap.put("---..", "8");
        equivalenceMap.put("----.", "9");
        equivalenceMap.put("-----", "0");
        equivalenceMap.put("..--..", "?");
        equivalenceMap.put("-.-.--", "!");
        equivalenceMap.put(".-.-.-", ".");
        equivalenceMap.put("--..--", ",");

        for (String dots : morse) unmorsedWord.append(equivalenceMap.get(dots));

        return unmorsedWord.toString();
    }
}
