package com.example.bootcampmeli.service;

import org.springframework.stereotype.Service;

@Service
public class RomanNumeralService {

    public String integerToRoman(int n) {
        if (n < 1 || n > 3999) return "Numero invalido";

        int[] valores = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] numerosRomanos = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder roman = new StringBuilder();

        for(int i=0; i<valores.length; i++) {
            while(n >= valores[i]) {
                n -= valores[i];
                roman.append(numerosRomanos[i]);
            }
        }
        return roman.toString();
    }
}
