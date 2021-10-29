package com.morse.morse.model;

import java.util.StringTokenizer;

public class TraductorMorse {

    private String morse;

    private String salida;

    public TraductorMorse(String morse) {

        this.morse = morse;

        this.salida = "";

        traducir();

    }

    private void traducir(){

        String[] palabras=morse.split("   ");

        DiccionarioMorse dm = new DiccionarioMorse();

        for (String palabra: palabras) {
            StringTokenizer st = new StringTokenizer(palabra," ");

            while (st.hasMoreTokens()){

                String letra = st.nextToken();

                salida = salida + dm.getTraduccion(letra);

            }
            salida=salida+" ";
        }
    }

    public String getSalida() {
        return salida.toUpperCase();
    }
}
