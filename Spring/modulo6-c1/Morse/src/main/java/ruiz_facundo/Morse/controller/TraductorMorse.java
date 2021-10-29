package ruiz_facundo.Morse.controller;

import org.springframework.stereotype.Service;

import java.util.Map;
import static java.util.Map.entry;

@Service
public class TraductorMorse {
    private static final Map<String,String> diccionario = Map.ofEntries(
            entry(".-", "A"), entry("-...", "B"), entry("-.-.", "C"), entry("-..", "D"), entry(".", "E"), entry("..-.", "F"),
            entry("--.", "G"), entry("....", "H"), entry("..", "I"), entry(".---", "J"), entry("-.-", "K"), entry(".-..", "L"),
            entry("--", "M"), entry("-.", "N"), entry("---", "O"), entry(".--.", "P"), entry("--.-", "Q"), entry(".-.", "R"),
            entry("...", "S"), entry("-", "T"), entry("..-", "U"), entry("...-", "V"), entry(".--", "W"), entry("-..-", "X"),
            entry("-.--", "Y"), entry("--..", "Z"), entry(".----", "1"), entry("..---", "2"), entry("...--", "3"), entry("....-", "4"),
            entry(".....", "5"), entry("-....", "6"), entry("--...", "7"), entry("---..", "8"), entry("----.", "9"), entry("-----", "0"),
            entry("..--..", "?"), entry("-.-.--", "!"), entry(".-.-.-", "."), entry("--..--", ","));

    public static String traducirMorse(String inMorse) {
        String textoTraducido = "";
        String[] palabras = inMorse.split("   ");
        for (String palabra : palabras) {
            String[] codigos = palabra.split(" ");
            String palabraTraducida = "";
            for (String c : codigos) palabraTraducida+=diccionario.get(c);
            textoTraducido+=palabraTraducida+" ";
        }
        return textoTraducido.trim();
    }

}
