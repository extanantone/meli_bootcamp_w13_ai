package com.introSpringP2.codigoMorse.model;

import java.util.StringTokenizer;

public class TraductorMorse {

    private static final DiccionarioMorse dm = new DiccionarioMorse();

    public static String traducir(String morse){
        String salida = "";

        String[] palabras = morse.split("   ");

        for (String palabra: palabras) {
            StringTokenizer st = new StringTokenizer(palabra," ");

            while (st.hasMoreTokens()){

                String letra = st.nextToken();

                salida = salida + dm.getTraduccion(letra);

            }
            salida=salida+" ";
        }

        return salida;
    }
}
