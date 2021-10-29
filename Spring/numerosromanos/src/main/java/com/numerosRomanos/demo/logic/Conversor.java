package com.numerosRomanos.demo.logic;

import java.util.HashMap;
import java.util.Map;

public class Conversor {
    final String[] romanos = {"I", "V", "X", "L", "C", "D", "M"};
    final int[] decimales = {1, 5, 10, 50, 100, 500, 1000};

    public int romanoDecimal(String roman) {
        int decimal = 0;
        String romanNumeral = roman.toUpperCase();
        for(int x = 0;x<romanNumeral.length();x++)
        {
            char convertToDecimal = roman.charAt(x);

            switch (convertToDecimal)
            {
                case 'M':
                    decimal += 1000;
                    break;

                case 'D':
                    decimal += 500;
                    break;

                case 'C':
                    decimal += 100;
                    break;

                case 'L':
                    decimal += 50;
                    break;

                case 'X':
                    decimal += 10;
                    break;

                case 'V':
                    decimal += 5;
                    break;

                case 'I':
                    decimal += 1;
                    break;
            }
        }
        if (romanNumeral.contains("IV"))
        {
            decimal-=2;
        }
        if (romanNumeral.contains("IX"))
        {
            decimal-=2;
        }
        if (romanNumeral.contains("XL"))
        {
            decimal-=10;
        }
        if (romanNumeral.contains("XC"))
        {
            decimal-=10;
        }
        if (romanNumeral.contains("CD"))
        {
            decimal-=100;
        }
        if (romanNumeral.contains("CM"))
        {
            decimal-=100;
        }
        return decimal;
    }

    public String decimalRomano(int numero) {
        int i, miles, centenas, decenas, unidades;
        String romano = "";

        //obtenemos cada cifra del número
        miles = numero / 1000;
        centenas = numero / 100 % 10;
        decenas = numero / 10 % 10;
        unidades = numero % 10;

        //millar
        for (i = 1; i <= miles; i++) {
            romano = romano + "M";
        }

        //centenas
        if (centenas == 9) {
            romano = romano + "CM";
        } else if (centenas >= 5) {
            romano = romano + "D";
            for (i = 6; i <= centenas; i++) {
                romano = romano + "C";
            }
        } else if (centenas == 4) {
            romano = romano + "CD";
        } else {
            for (i = 1; i <= centenas; i++) {
                romano = romano + "C";
            }
        }

        //decenas
        if (decenas == 9) {
            romano = romano + "XC";
        } else if (decenas >= 5) {
            romano = romano + "L";
            for (i = 6; i <= decenas; i++) {
                romano = romano + "X";
            }
        } else if (decenas == 4) {
            romano = romano + "XL";
        } else {
            for (i = 1; i <= decenas; i++) {
                romano = romano + "X";
            }
        }

        //unidades
        if (unidades == 9) {
            romano = romano + "IX";
        } else if (unidades >= 5) {
            romano = romano + "V";
            for (i = 6; i <= unidades; i++) {
                romano = romano + "I";
            }
        } else if (unidades == 4) {
            romano = romano + "IV";
        } else {
            for (i = 1; i <= unidades; i++) {
                romano = romano + "I";
            }
        }
        return romano;
    }

}
