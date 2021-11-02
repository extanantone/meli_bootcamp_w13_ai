package com.bootcamp.Prueba.Service;

import java.util.HashMap;
import java.util.Map;

public class AbcMorse {
    public StringBuilder ObtenerMorse(String a) {
        StringBuilder morse = cargarMap(a);
        return morse;
    }

    public StringBuilder cargarMap(String clave) {

        Map<String, String> pasaje = new HashMap<>();
        pasaje.put("A", ".-");
        pasaje.put("B", "-...");
        pasaje.put("C", "-.-.");
        pasaje.put("CH", "----");
        pasaje.put("D", "-..");
        pasaje.put("E", ".");
        pasaje.put("F", "..-.");
        pasaje.put("G", "--.");
        pasaje.put("H", "....");
        pasaje.put("I", "..");
        pasaje.put("J", ".---");
        pasaje.put("K", "-.-");
        pasaje.put("L", ".-..");
        pasaje.put("M", "--");
        pasaje.put("N", "-.");
        pasaje.put("Ñ", "--.--");
        pasaje.put("O", "---");
        pasaje.put("P", ".--.");
        pasaje.put("Q", "--.-");
        pasaje.put("R", ".-.");
        pasaje.put("S", "...");
        pasaje.put("T", "-");
        pasaje.put("U", "..-");
        pasaje.put("V", "...-");
        pasaje.put("W", ".--");
        pasaje.put("X", "-..-");
        pasaje.put("Y", "-.--");
        pasaje.put("Z", "--..");
        pasaje.put("0", "-----");
        pasaje.put("1", ".----");
        pasaje.put("2", "..---");
        pasaje.put("3", "...--");
        pasaje.put("4", "....-");
        pasaje.put("5", ".....");
        pasaje.put("6", "-....");
        pasaje.put("7", "--...");
        pasaje.put("8", "---..");
        pasaje.put("9", "----.");
        pasaje.put(".", ".-.-.-");
        pasaje.put(",", "--..--");
        pasaje.put(":", "---...");
        pasaje.put("?", "..--..");
        pasaje.put("'", ".----.");
        pasaje.put("-", "-....-");
        pasaje.put("/", "-..-.");
        pasaje.put("\"", ".-..-.");
        pasaje.put("@", ".--.-.");
        pasaje.put("=", "-...-");
        pasaje.put("!", "−.−.−−");

        String[] letrasMorse = clave.split("");
        StringBuilder sb = new StringBuilder();
        for (String p : letrasMorse){
            sb.append(pasaje.get(p));
        }

        return sb;
    }
}
