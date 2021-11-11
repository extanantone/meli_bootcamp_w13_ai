package com.bootcamp.morse.morse.service;
import java.util.HashMap;
import java.util.Map;

public class MorseService {

    private static Map getMorseMap() {
        Map<String, Character> morseMap = new HashMap();

        morseMap.put(".-", 'A');
        morseMap.put("-...", 'B');
        morseMap.put("-.-.", 'C');
        morseMap.put("-..", 'D');
        morseMap.put(".", 'E');
        morseMap.put("..-.", 'F');
        morseMap.put("--.", 'G');
        morseMap.put("....", 'H');
        morseMap.put("..", 'I');
        morseMap.put(".---", 'J');
        morseMap.put("-.-", 'K');
        morseMap.put(".-..", 'L');
        morseMap.put("--", 'M');
        morseMap.put("-.", 'N');
        morseMap.put("---", 'O');
        morseMap.put(".--.", 'P');
        morseMap.put("--.-", 'Q');
        morseMap.put(".-.", 'R');
        morseMap.put("...", 'S');
        morseMap.put("-", 'T');
        morseMap.put("..-", 'U');
        morseMap.put("...-", 'V');
        morseMap.put(".--", 'W');
        morseMap.put("-..-", 'X');
        morseMap.put("-.--", 'Y');
        morseMap.put("--..", 'Z');
        morseMap.put("-----", '0');
        morseMap.put(".----", '1');
        morseMap.put("..---", '2');
        morseMap.put("...--", '3');
        morseMap.put("....-", '4');
        morseMap.put(".....", '5');
        morseMap.put("-....", '6');
        morseMap.put("--...", '7');
        morseMap.put("---..", '8');
        morseMap.put("----.", '9');
        morseMap.put(".-.-", '.');
        morseMap.put("--..--", ',');
        morseMap.put("..--..", '?');
        return morseMap;
    }

    private static char morseCharATexto(String morseChar, Map morseMap) {

        return (char) morseMap.get(morseChar);
    }

    public static String morseATexto (String morseString) {
        Map morseMap = MorseService.getMorseMap();
        StringBuilder texto = new StringBuilder();

        String[] morseWords = morseString.split("   ");

        for (String morseWord : morseWords)
        {
            for (String morseChar : morseWord.split(" "))
            {
                char letra = MorseService.morseCharATexto(morseChar, morseMap);
                texto.append(letra);
            }
            texto.append(" ");
        }

        return texto.toString();

    }
}