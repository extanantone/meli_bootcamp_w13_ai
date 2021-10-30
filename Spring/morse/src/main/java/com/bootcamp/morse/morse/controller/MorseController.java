package com.bootcamp.morse.morse.controller;

import com.bootcamp.morse.morse.service.MorseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {
    @GetMapping("/{morse}")
    public static String morseATexto(@PathVariable String morse){
        return MorseService.morseATexto(morse);
    }
}
