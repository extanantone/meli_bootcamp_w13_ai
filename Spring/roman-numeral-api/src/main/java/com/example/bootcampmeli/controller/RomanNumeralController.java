package com.example.bootcampmeli.controller;

import com.example.bootcampmeli.service.RomanNumeralService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumeralController {
    private final RomanNumeralService romanNumeralService;

    public RomanNumeralController(RomanNumeralService romanNumeralService) {
        this.romanNumeralService = romanNumeralService;
    }

    @GetMapping("/{number}")
    public String integerToRoman(@PathVariable Integer number) {
        return "Number: " + number +
                " - " +
                "Roman: " + romanNumeralService.integerToRoman(number);
    }
}
