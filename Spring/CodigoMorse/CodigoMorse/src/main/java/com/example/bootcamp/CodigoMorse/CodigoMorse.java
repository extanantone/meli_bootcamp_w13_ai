package com.example.bootcamp.CodigoMorse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CodigoMorse {

    Map<String, Character> morse = new HashMap<String, Character>();

    public CodigoMorse(){
        morse.put(".-",'A');
        morse.put("-...",'B');
        morse.put("-.-.",'C');
        morse.put("-..",'D');
        morse.put(".",'E');
        morse.put("..-.",'F');
        morse.put("--.",'G');
        morse.put("....",'H');
        morse.put("..",'I');
        morse.put(".---",'J');
        morse.put("-.-",'K');
        morse.put(".-..",'L');
        morse.put("--",'M');
        morse.put("-.",'N');
        morse.put("---",'O');
        morse.put(".--.",'P');
        morse.put("--.-",'Q');
        morse.put(".-.",'R');
        morse.put("...",'S');
        morse.put("-",'T');
        morse.put("..-",'U');
        morse.put("...-",'V');
        morse.put(".--",'W');
        morse.put("-..-",'X');
        morse.put("-.--",'Y');
        morse.put("--..",'Z');
        morse.put(".----",'1');
        morse.put("..---",'2');
        morse.put("...--",'3');
        morse.put("....-",'4');
        morse.put(".....",'5');
        morse.put("-....",'6');
        morse.put("--...",'7');
        morse.put("---..",'8');
        morse.put("----.",'9');
        morse.put("-----",'0');
        morse.put("..--..",'?');
        morse.put("-.-.--",'!');
        morse.put(".-.-.-",'.');
        morse.put("--..--",',');

    }


    public String convertMorseToPhrase(String morseCode){

        String [] palabras = morseCode.split("   ");
        String [] letras;
        StringBuilder resultado = new StringBuilder();

        if(palabras.length>1) {
            for (String p : palabras) {

                letras = p.split(" ");

                for (String l : letras) {
                    Character c = morse.get(l);
                    resultado.append(c.toString());
                }

                resultado.append(" ");
            }
        }
        else
        {
            palabras = morseCode.split(" ");

            for (String l : palabras) {
                Character c = morse.get(l);
                resultado.append(c.toString());
            }


        }

        return resultado.toString();

    }



}
