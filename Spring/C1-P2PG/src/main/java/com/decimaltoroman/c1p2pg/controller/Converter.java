package com.decimaltoroman.c1p2pg.controller;

public class Converter {
    static String converter(String sRoman) {
        String result = "El número introducido es: " + sRoman + ", y su equivalente en romano es: ";
        int iRoman = Integer.valueOf(sRoman);
        int i = 0;
        int decimal[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String roman[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        if (iRoman == 0) {
            return "No existe representación para el '0' en números romanos";
        }
        if (iRoman < 0 || iRoman > 3999){
            return "El número debe ser mayor a 0, y menor a 3999";
        }

        while (iRoman > 0) {
            if (iRoman >= decimal[i]) {
                System.out.println("NUM: " + iRoman);
                result += roman[i];
                iRoman -= decimal[i];
            } else {
                i = i + 1;
            }
        }
        return result;
    }
}
