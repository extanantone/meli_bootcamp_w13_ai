package com.bootcamp.demoWave13.Service;

import java.util.HashMap;
import java.util.Map;

public class AbcMorse {
    public String ObtenerMorse(String a) {
        String morse = cargarMap(a);
        return morse;
    }

    public String cargarMap(String clave) {

        String claveCompleta="";

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

        for(char ch : clave.toCharArray()) { //Foreach descompone String en char

            String aux= String.valueOf(ch);
            String valor = pasaje.get(aux);

            if (valor == null) {
                return "La " + clave + " no existe";
            }
            claveCompleta=claveCompleta+valor; //concateno
        }


        return claveCompleta;
    }
}
