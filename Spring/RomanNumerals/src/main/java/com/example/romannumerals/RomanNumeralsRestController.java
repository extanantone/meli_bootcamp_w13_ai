package com.example.romannumerals;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class RomanNumeralsRestController {

    List<Integer> values = Arrays.asList(1000,900,500,400,100,90,50,40,10,9,5,4,1);
    List<String> romanLiterals = Arrays.asList("M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I");

    @GetMapping("/{number}")
    public String convertNumeber(@PathVariable Integer number){
        StringBuilder roman = new StringBuilder();

        for(int i=0;i<values.size();i++) {
            while(number >= values.get(i)) {
                number -= values.get(i);
                roman.append(romanLiterals.get(i));
            }
        }
        return  roman.toString();
    }
}
