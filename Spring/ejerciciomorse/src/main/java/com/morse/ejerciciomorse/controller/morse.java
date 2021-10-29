package com.morse.ejerciciomorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

public class morse {

    @RestController
    public static class ConvertirController {

        @GetMapping("/{morse}")
        public String getMorse(@PathVariable("morse") String morse){
            return morseaPalabra(morse);
        }

        public static String morseaPalabra(String codificado) {
            StringBuilder decodificado = new StringBuilder();
            String[] morse = codificado.split(" ");
            for (String morseActual : morse) {
                String morseaPal = morseaTexto(morseActual);
                decodificado.append(morseaPal);
            }
            return decodificado.toString();
        }

        public static String morseaTexto(String morseBuscado) {
            Hashtable<String, String> morseEqui = obtenerTexto();
            Set<String> keys = morseEqui.keySet();
            for (String key : keys) {
                String morse = morseEqui.get(key);
                if (morse.equals(morseBuscado)) {
                    return key;
                }
            }
            return " ";
        }

        public static Hashtable<String, String> obtenerTexto() {
            Hashtable<String, String> morse = new Hashtable<>();
            morse.put("A", ".-");
            morse.put("B", "-...");
            morse.put("C", "-.-.");
            morse.put("CH", "----");
            morse.put("D", "-..");
            morse.put("E", ".");
            morse.put("F", "..-.");
            morse.put("G", "--.");
            morse.put("H", "....");
            morse.put("I", "..");
            morse.put("J", ".---");
            morse.put("K", "-.-");
            morse.put("L", ".-..");
            morse.put("M", "--");
            morse.put("N", "-.");
            morse.put("Ñ", "--.--");
            morse.put("O", "---");
            morse.put("P", ".--.");
            morse.put("Q", "--.-");
            morse.put("R", ".-.");
            morse.put("S", "...");
            morse.put("T", "-");
            morse.put("U", "..-");
            morse.put("V", "...-");
            morse.put("W", ".--");
            morse.put("X", "-..-");
            morse.put("Y", "-.--");
            morse.put("Z", "--..");
            morse.put("0", "-----");
            morse.put("1", ".----");
            morse.put("2", "..---");
            morse.put("3", "...--");
            morse.put("4", "....-");
            morse.put("5", ".....");
            morse.put("6", "-....");
            morse.put("7", "--...");
            morse.put("8", "---..");
            morse.put("9", "----.");
            morse.put(".", ".-.-.-");
            morse.put(",", "--..--");
            morse.put(":", "---...");
            morse.put("?", "..--..");
            morse.put("'", ".----.");
            morse.put("-", "-....-");
            morse.put("/", "-..-.");
            morse.put("\"", ".-..-.");
            morse.put("@", ".--.-.");
            morse.put("=", "-...-");
            morse.put("!", "−.−.−−");
            morse.put(""," ");
            return morse;
        }
    }
}
