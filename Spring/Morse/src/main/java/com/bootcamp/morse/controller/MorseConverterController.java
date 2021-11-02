package com.bootcamp.morse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class MorseConverterController {

    @GetMapping("/")
    public String MorseToNormalConverter(@RequestParam String morseCode) {
        StringBuilder convertedText = new StringBuilder();
        Map<String, String> morseCodeDict = Stream.of(new String[][] {
                { ".-", "A" },
                { "-...", "B" },
                {"-.-.", "C"},
                {"-..", "D"},
                {".", "E"},
                {"..-.", "F"},
                {"--.", "G"},
                {"....", "H"},
                {"..", "I"},
                {".---", "J"},
                {"-.-", "K"},
                {".-..", "L"},
                {"--", "M"},
                {"-.", "N"},
                {"---", "O"},
                {".--.", "P"},
                {"--.-", "Q"},
                {".-.", "R"},
                {"...", "S"},
                {"-", "T"},
                {"..-", "U"},
                {"...-", "V"},
                {".--", "W"},
                {"-..-", "X"},
                {"-.--", "Y"},
                {"--..", "Z"}
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        List<List<String>> modularMorseCode = new ArrayList<>();
        String[] morseWords = morseCode.split("   ");
        for (String word: morseWords) {
            modularMorseCode.add(Arrays.asList(word.split(" ")));
        }
        for (List<String> word: modularMorseCode) {
            for (String letter: word) {
                convertedText.append(morseCodeDict.get(letter));
            }
            convertedText.append(" ");
        }
        return convertedText.toString();
    }
}
