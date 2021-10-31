package com.example.morse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    @GetMapping("/{morse}")
    public String getUnmorsed(@PathVariable String morse) {
        StringBuilder phrase = new StringBuilder();
        String[] morseWords = morse.split("  ");

        for (String word : morseWords) {
            phrase.append(Unmorser.unmorser(word.split(" ")));
            phrase.append(" ");
        }
        return phrase.toString().trim();
    }
}
