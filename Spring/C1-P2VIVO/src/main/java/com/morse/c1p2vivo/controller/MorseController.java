package com.morse.c1p2vivo.controller;

import com.morse.c1p2vivo.service.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    @Autowired
    MorseService morseService;

    @GetMapping("/api/{morseCode}")
    public String getAlfanumericFromMorse(@PathVariable String morseCode){
        return morseService.getAlfanumericFromMorse(morseCode);
    }
}
