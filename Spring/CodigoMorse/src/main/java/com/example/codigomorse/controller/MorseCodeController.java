package com.example.codigomorse.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

import static java.util.Map.entry;

@RestController
public class MorseCodeController
{
    @GetMapping("/{input}")
    public String MorseParser(@PathVariable("input") String input)
    {

        Map<String, String> morseDict = Map.ofEntries(
                entry(".-", "A"),
                entry("-...", "B"),
                entry("-.-.", "C"),
                entry("-..", "D"),
                entry(".", "E"),
                entry("..-.", "F"),
                entry("--.", "G"),
                entry("....", "H"),
                entry("..", "I"),
                entry(".---", "J"),
                entry("-.-", "K"),
                entry(".-..", "L"),
                entry("--", "M"),
                entry("-.", "N"),
                entry("---", "O"),
                entry(".--.", "P"),
                entry("--.-", "Q"),
                entry(".-.", "R"),
                entry("...", "S"),
                entry("-", "T"),
                entry("..-", "U"),
                entry("...-", "V"),
                entry(".--", "W"),
                entry("-..-", "X"),
                entry("-.--", "Y"),
                entry("--..", "Z"),
                entry(".----", "1"),
                entry("..---", "2"),
                entry("...--", "3"),
                entry("....-", "4"),
                entry(".....", "5"),
                entry("-....", "6"),
                entry("--...", "7"),
                entry("---..", "8"),
                entry("----.", "9"),
                entry("-----", "0"),
                entry("..--..", "?"),
                entry("-.-.--", "!"),
                entry(".-.-.-", "."),
                entry("--..--", ","),
                entry("[SPACE]", " ")
        );
        System.out.printf("String original %s\n", input);

        input = input.replaceAll("\\s{3}", " [SPACE] ");
        System.out.printf("String después de reemplazar 3 espacios seguidos por un caracter especial\n: %s\n", input);

        String[] inputArray = input.split(" ");
        StringBuilder result = new StringBuilder();

        System.out.printf("Arreglo separado por espacios: %s\n", input);
        Arrays.stream(inputArray).forEach(System.out::println);

        System.out.printf("Letras equivalentes del diccionario: %s\n", input);
        Arrays.stream(inputArray).forEach((x) -> System.out.printf("%s equivale a %s\n", x, morseDict.get(x)));

        Arrays.stream(inputArray).forEach((x) -> result.append(morseDict.get(x)));
        return (result.toString());
    }
}
