package com.bootcamp.demoWave13.controller;

public class Romanos {

    static String methodOne(int number) {
        String romano = "";
        // declare arrays for Roman numbers
        String[] thousands = { "", "M", "MM", "MMM" };
        String[] hundreds = { "", "C", "CC", "CCC", "CD", "D",
                "DC", "DCC", "DCCC", "CM" };
        String[] tens = { "", "X", "XX", "XXX", "XL", "L",
                "LX", "LXX", "LXXX", "XC" };
        String[] units = { "", "I", "II", "III", "IV", "V", "VI",
                "VII", "VIII", "IX", "X" };
        // get thousands in the decimal number
        int numberOfThousands = number / 1000;
        // get hundreds in the decimal number
        int numberOfHundreds = (number / 100) % 10;
        // get tens in the decimal number
        int numberOfTens = (number / 10) % 10;
        // get units in the decimal number
        int numberOfUnits = number % 10;
        // get the corresponding Roman digits and merge them
        String romanNumber = thousands[numberOfThousands] + hundreds[numberOfHundreds]
                + tens[numberOfTens] + units[numberOfUnits];
        return romanNumber;
        //System.out.println("Roman equivalent of " + number + " is " + romanNumber);
    }
}
