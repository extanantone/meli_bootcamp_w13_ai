package com.bootcamp.demoWave13.controller;

import java.util.HashMap;

public class Morse {

    public static String traduccionMorse(String cadena){

        HashMap<String, Character> codigos = new HashMap<>();

        codigos.put(".-",'A');
        codigos.put("-...",'B');
        codigos.put("-.-.",'C');
        codigos.put("-..",'D');
        codigos.put(".",'E');
        codigos.put("..-.",'F');
        codigos.put("--.",'G');
        codigos.put("....",'H');
        codigos.put("..",'I');
        codigos.put(".---",'J');
        codigos.put("-.-",'K');
        codigos.put(".-..",'L');
        codigos.put("--",'M');
        codigos.put("-.",'N');
        codigos.put("---",'O');
        codigos.put(".--.",'P');
        codigos.put("--.-",'Q');
        codigos.put(".-",'R');
        codigos.put("...",'S');
        codigos.put("-",'T');
        codigos.put("..-",'U');
        codigos.put("...-",'V');
        codigos.put(".--",'W');
        codigos.put("-..-",'X');
        codigos.put("-.--",'Y');
        codigos.put("--..",'Z');
        codigos.put("-----",'0');
        codigos.put(".----",'1');
        codigos.put("..---",'2');
        codigos.put("...--",'3');
        codigos.put("....-",'4');
        codigos.put(".....",'5');
        codigos.put("-....",'6');
        codigos.put("--...",'7');
        codigos.put("---..",'8');
        codigos.put("----.",'9');
        codigos.put("..--..",'?');
        codigos.put("-.-.--",'!');
        codigos.put(".-.-.-",'.');
        codigos.put("--..--",',');


        return null;
    }
}
