package com.Meli.CodigoMorse.Service;

import com.Meli.CodigoMorse.Entity.Morse;

public class MorseService {

    public static String getTexto(String palabraMorse){
        Morse mors = new Morse();
        String morse[] = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
                "|", ".---", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----"};
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ 1234567890";

        StringBuilder salida = new StringBuilder();

        String palabrasDivididas[] = palabraMorse.split("   ");
        for (String pd : palabrasDivididas) {
            String letrasDivididas[] = pd.split(" ");
            for (String ld : letrasDivididas) {
                salida.append(alphabet.charAt(j));


                /*for (int j = 0; j < morse.length; j++) {
                    System.out.println(morse[j].equals(ld));
                    if (morse[j].equals(ld)) {
                        salida.append(alphabet.charAt(j));
                    }
                }*/

            }
            salida.append(" ");
        }
        return salida.toString().toUpperCase();
    }
}
