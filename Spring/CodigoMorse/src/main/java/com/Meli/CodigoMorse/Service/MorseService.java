package com.Meli.CodigoMorse.Service;

import com.Meli.CodigoMorse.Entity.Morse;

public class MorseService {

    public static String getTexto(String palabraMorse){
        Morse morse = new Morse();
        StringBuilder salida = new StringBuilder();

        String palabrasDivididas[] = palabraMorse.split("   ");
        for (String pd : palabrasDivididas) {
            String letrasDivididas[] = pd.split(" ");
            for (String ld : letrasDivididas) {
                salida.append(morse.getLetra(ld));
            }
            salida.append(" ");
        }
        return salida.toString().toUpperCase();
    }
}
