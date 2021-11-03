package com.introspring.p2vivo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {

    Map<String, Character> morse;

    public MainController(){
        morse = new HashMap<String, Character>();
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

    @GetMapping("/{word}")
    public String controller(@PathVariable String word){
        StringBuilder decoded = new StringBuilder();
        StringBuilder letter = new StringBuilder();
        StringBuilder space = new StringBuilder();
        for (char c: word.toCharArray()) {
            if(c == ' ')
                if(space.length() == 2){
                    decoded.append(morse.get(letter.toString()));
                    decoded.append(" ");
                    space = new StringBuilder();
                    letter = new StringBuilder();
                }
                else
                    space.append(c);
            else if(space.length() == 1){
                decoded.append(morse.get(letter.toString()));
                letter = new StringBuilder();
                letter.append(c);
                space = new StringBuilder();
            }
            else
                letter.append(c);
        }
        decoded.append(morse.get(letter.toString()));

        return decoded.toString();
    }

}
