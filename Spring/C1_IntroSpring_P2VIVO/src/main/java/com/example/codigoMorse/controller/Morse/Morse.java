package com.example.codigoMorse.controller.Morse;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Morse {

    public static String decodificarMorse(String morse){
        Map<String, String> diccionarioMorseMap = new HashMap<String,String>;
        String frase = "";
        String[] palabrasSeparadas = morse.split("   ");
        for (int i = 0;i<palabrasSeparadas.length;i++){
            String[] palabra = palabrasSeparadas[i].split(" ");
            for(int i=0;i<palabra.length();i++){
                frase+=diccionarioMorseMap.get(palabra[i]);
            }
            frase+=" ";
        }


        return frase;
    }
}
