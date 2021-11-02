package com.bootcamp.demowave13.logica;

import java.util.*;

public class Morse {

    private static Map<String, String> traductor = new HashMap<>();
    private static Map<String, String> traductorReverse = new HashMap<>();

    static {
        traductor.put(".-", "A");
        traductor.put("-...", "B");
        traductor.put("-.-.", "C");
        traductor.put("-..", "D");
        traductor.put(".", "E");
        traductor.put("..-.", "F");
        traductor.put("--.", "G");
        traductor.put("....", "H");
        traductor.put("..", "I");
        traductor.put(".---", "J");
        traductor.put("-.-", "K");
        traductor.put(".-..", "L");
        traductor.put("--", "M");
        traductor.put("-.", "N");
        traductor.put("---", "O");
        traductor.put(".--.", "P");
        traductor.put("--.-", "Q");
        traductor.put(".-.", "R");
        traductor.put("...", "S");
        traductor.put("-", "T");
        traductor.put("..-", "U");
        traductor.put("...-", "V");
        traductor.put(".--", "W");
        traductor.put("-..-", "X");
        traductor.put("-.--", "Y");
        traductor.put("--..", "Z");
        traductorReverse.put( "A",".-");
        traductorReverse.put( "B","-...");
        traductorReverse.put( "C","-.-.");
        traductorReverse.put( "D","-..");
        traductorReverse.put( "E",".");
        traductorReverse.put( "F","..-.");
        traductorReverse.put( "G","--.");
        traductorReverse.put( "H","....");
        traductorReverse.put( "I","..");
        traductorReverse.put( "J",".---");
        traductorReverse.put( "K","-.-");
        traductorReverse.put( "L",".-..");
        traductorReverse.put( "M","--");
        traductorReverse.put( "N","-.");
        traductorReverse.put( "O","---");
        traductorReverse.put( "P",".--.");
        traductorReverse.put( "Q","--.-");
        traductorReverse.put( "R",".-.");
        traductorReverse.put( "S","...");
        traductorReverse.put( "T","-");
        traductorReverse.put( "U","..-");
        traductorReverse.put( "V","...-");
        traductorReverse.put( "W",".--");
        traductorReverse.put( "X","-..-");
        traductorReverse.put( "Y","-.--");
        traductorReverse.put( "Z","--..");

    }

    public static String traductor(String frase) {
        StringBuilder salida = new StringBuilder();
        List<String> fraseSeparada = List.of(frase.toUpperCase().split("   "));
        for (String palabra : fraseSeparada) {
            List<String> palSep = List.of(palabra.split(" "));
            palSep.stream().forEach(x -> salida.append(traductor.get(x)));
            salida.append(" ");
        }
            return salida.toString();
    }

    public static String traductorReverse(String frase) {
        StringBuilder salida = new StringBuilder();
        List<String> fraseSeparada = List.of(frase.toUpperCase().split(" "));
        for (String palabra : fraseSeparada) {
            List<String> palSep = List.of(palabra.split(""));
            palSep.stream().forEach(x -> salida.append(traductorReverse.get(x)).append(" "));
            salida.append("   ");
        }
        return salida.toString();
    }

}
