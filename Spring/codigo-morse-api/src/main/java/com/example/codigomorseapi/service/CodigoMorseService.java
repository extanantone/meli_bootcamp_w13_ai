package com.example.codigomorseapi.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class CodigoMorseService {
    char[] caracter = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '?', '!', '.', ',', ' '
    };

    String[] codigo = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--..", "-----", ".----", "..---",
            "...--", "....-", ".....", "-....", "--...", "---..", "----.", "..--..",
            "-.-.--", ".-.-.-", "--..--", ""
    };

    public String morseAPalabra(@NotNull String morse) {
        String[] letrasMorse = morse.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String p : letrasMorse) {
            for (int i = 0; i < codigo.length; i++) {
                if (p.equals(codigo[i])) {
                    sb.append(caracter[i]);
                    break;
                }
            }
        }
        return sb.toString();
    }
}
