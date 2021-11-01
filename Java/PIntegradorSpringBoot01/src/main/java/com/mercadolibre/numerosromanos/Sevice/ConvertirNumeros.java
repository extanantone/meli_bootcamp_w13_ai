package com.mercadolibre.numerosromanos.Sevice;

public class ConvertirNumeros {
    public int convertirLetraANumero(String numeroRomano) {
        int total = 0, number = 0;

        for (int i = 0; i < numeroRomano.length(); i++) {
            int numberNow = GetNumber(numeroRomano.charAt(i));

            if (number == 0){
                number = numberNow; continue;}
            if (number < numberNow)
                number = -number;
            total += number;
            number = numberNow;
        }
        return total + number;
    }

    private int GetNumber(char roman) {
        return roman == 'M' ? 1000 :
                roman == 'D' ? 500 :
                roman == 'C' ? 100 :
                roman == 'L' ? 50 :
                roman == 'X' ? 10 :
                roman == 'V' ? 5 :
                roman == 'I' ? 1 : 0;
    }
}
