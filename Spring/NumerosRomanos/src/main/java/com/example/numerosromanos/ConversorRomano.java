package com.example.numerosromanos;

public class ConversorRomano {

    public static String toRoman(int number) {
        String romanNumber = "";
        int[] arrayValores = {
                1000, 900, 500, 400,
                100, 90, 50, 40,
                10, 9, 5, 4, 1
        };

        String[] arrayRomanos = {
                "M", "CM", "D", "CD",
                "C", "XC", "L", "XL",
                "X", "IX", "V", "IV",
                "I"
        };

        for(int i = 0; number > 0; i++) {
            for(;number / arrayValores[i] != 0; number -= arrayValores[i]) {
                romanNumber += arrayRomanos[i];
            }
        }

        return romanNumber;
    }
}
