package com.bootcamp.demo.demo.service;

import com.bootcamp.demo.demo.exceptions.NegativeNumberException;
import com.bootcamp.demo.demo.exceptions.RomanNumbersException;
import org.springframework.http.HttpStatus;

public class RomanNumbersService {
    public static String getRomanFromDecimal(int decimal) {
        int[] decimals = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanos = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < decimals.length; i++) {
            while(decimal >= decimals[i]) {
                decimal -= decimals[i];
                result.append(romanos[i]);
            }
        }


        return String.valueOf(result);
    }
}
