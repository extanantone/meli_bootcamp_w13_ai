package com.morse.morse.model;

import java.util.HashMap;

public class DiccionarioMorse {

    private HashMap<String, String> codigoMorse;

    public DiccionarioMorse() {
        this.codigoMorse = new HashMap<>();
        llenar();
    }

    public String getTraduccion(String letraMorse){
        return codigoMorse.get(letraMorse);
    }

    private void llenar() {

        codigoMorse.put("-----", "0");
        codigoMorse.put(".----", "1");
        codigoMorse.put("..---", "2");
        codigoMorse.put("...--", "3");
        codigoMorse.put("....-", "4");
        codigoMorse.put(".....", "5");
        codigoMorse.put("-....", "6");
        codigoMorse.put("--...", "7");
        codigoMorse.put("---..", "8");
        codigoMorse.put("----.", "9");
        codigoMorse.put(".-", "a");
        codigoMorse.put("-...", "b");
        codigoMorse.put("-.-.", "c");
        codigoMorse.put("-..", "d");
        codigoMorse.put(".", "e");
        codigoMorse.put("..-.", "f");
        codigoMorse.put("--.", "g");
        codigoMorse.put("....", "h");
        codigoMorse.put("..", "i");
        codigoMorse.put(".---", "j");
        codigoMorse.put("-.-", "k");
        codigoMorse.put(".-..", "l");
        codigoMorse.put("--", "m");
        codigoMorse.put("-.", "n");
        codigoMorse.put("---", "o");
        codigoMorse.put(".--.", "p");
        codigoMorse.put("--.-", "q");
        codigoMorse.put(".-.", "r");
        codigoMorse.put("...", "s");
        codigoMorse.put("-", "t");
        codigoMorse.put("..-", "u");
        codigoMorse.put("...-", "v");
        codigoMorse.put(".--", "w");
        codigoMorse.put("-..-", "x");
        codigoMorse.put("-.--", "y");
        codigoMorse.put("--..", "z");
        codigoMorse.put(".-.-.-", ".");

        codigoMorse.put("--..--", ",");
        codigoMorse.put("..--..", "?");
        codigoMorse.put("-.-.--", "!");
        codigoMorse.put("-....-", "-");
        codigoMorse.put("-..-.", "/");
        codigoMorse.put(".--.-.", "@");
        codigoMorse.put("-.--.", "(");
        codigoMorse.put("-.--.-", ")");
    }

}
