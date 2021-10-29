package com.bootcamp.morse.controller;

import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class morseController {
    @GetMapping("/{palabras}")
    public String convertirMorse(@PathVariable("palabras") String palabras) {
        String morse[] = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
                "|", ".---", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----"};
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ 1234567890";

        StringBuilder salida = new StringBuilder();
        System.out.println(palabras);

        String palabrasDivididas[] = palabras.split("   ");
        for (String pd : palabrasDivididas) {
            String letrasDivididas[] = pd.split(" ");
            for (String ld : letrasDivididas) {
                for (int j = 0; j < morse.length; j++) {
                    // System.out.println(morse[j].equals(ld));
                    if (morse[j].equals(ld)) {
                        salida.append(alphabet.charAt(j));
                    }
                }
            }
            salida.append(" ");
        }
        return salida.toString().toUpperCase();
    }
}
