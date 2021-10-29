package com.morce.morce;

import org.springframework.stereotype.Service;
import java.util.Map;
import static java.util.Map.entry;

@Service
public class TraductorMorse {

    private static final Map<String,String> dictionary = Map.ofEntries(
            entry(".-", "A"), entry("-...", "B"), entry("-.-.", "C"), entry("-..", "D"), entry(".", "E"), entry("..-.", "F"),
            entry("--.", "G"), entry("....", "H"), entry("..", "I"), entry(".---", "J"), entry("-.-", "K"), entry(".-..", "L"),
            entry("--", "M"), entry("-.", "N"), entry("---", "O"), entry(".--.", "P"), entry("--.-", "Q"), entry(".-.", "R"),
            entry("...", "S"), entry("-", "T"),entry("..-", "U"), entry("...-", "V"), entry(".--", "W"), entry("-..-", "X"),
            entry("-.--", "Y"), entry("--..", "Z"), entry(".----", "1"), entry("..---", "2"), entry("...--", "3"), entry("....-", "4"),
            entry(".....", "5"), entry("-....", "6"), entry("--...", "7"), entry("---..", "8"), entry("----.", "9"), entry("-----", "0"),
            entry("..--..", "?"), entry("-.-.--", "!"), entry(".-.-.-", "."), entry("--..--", ",")
    );


    public  String traduccion(String morse){

        String[] phrases = morse.split("   ");
        String endPhrase = "";
        for (String p: phrases){
            String[] letras = p.split(" ");
            for (String letra: letras)endPhrase=endPhrase+dictionary.get(letra);
            endPhrase=endPhrase+" ";
        }
        return endPhrase.trim();
    }
}
