package com.Meli.CodigoMorse.Entity;

import java.util.HashMap;

public class Morse {
    HashMap<String, String> equivalencias = new HashMap<>();
    public Morse(){
        equivalencias.put(".-", "A");
        equivalencias.put("-...", "B");
        equivalencias.put("-.-.", "C");
        equivalencias.put("-..", "D");
        equivalencias.put(".", "E");
        equivalencias.put("..-.", "F");
        equivalencias.put("--.", "G");
        equivalencias.put("....", "H");
        equivalencias.put("..", "I");
        equivalencias.put(".---", "J");
        equivalencias.put("-.-", "K");
        equivalencias.put(".-..", "L");
        equivalencias.put("--", "M");
        equivalencias.put("-.", "N");
        equivalencias.put("---", "O");
        equivalencias.put(".--.", "P");
        equivalencias.put("--.-", "Q");
        equivalencias.put(".-.", "R");
        equivalencias.put("...", "S");
        equivalencias.put("-", "T");
        equivalencias.put("..-", "U");
        equivalencias.put("...-", "V");
        equivalencias.put(".--", "W");
        equivalencias.put("-..-", "X");
        equivalencias.put("-.--", "Y");
        equivalencias.put("--..", "Z");
    }

    public String getLetra(String letraMorse){
        return this.equivalencias.get(letraMorse);
    }
}
