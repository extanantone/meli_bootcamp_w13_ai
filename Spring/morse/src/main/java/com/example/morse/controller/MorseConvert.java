package com.example.morse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MorseConvert {

    @GetMapping("{morse}")
    public String codigoMorse(@PathVariable("morse") String morse){

        Map<String,String> morseCode = new HashMap<>();
        morseCode.put(".-","A");
        morseCode.put("....","H");
        morseCode.put("---","O");
        morseCode.put(".-..","L");

        String word = "";

        String[] morseData = morse.split(" ");

        for (String morseWord: morseData) {

            if(morseCode.containsKey(morseWord)) {
                word = word +  morseCode.get(morseWord);
            }


        }

        return  word;
    }
}
