package com.bootcamp.C1P2EJ1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumeroRomanoConverterController {
    /*@GetMapping("/{numeroRomano}")
    public static int devolverNumero(@PathVariable("numeroRomano") String numeroRomano) {
        if (numeroRomano.isEmpty()) return 0;
        if (numeroRomano.startsWith("M"))  return 1000 + devolverNumero(numeroRomano.substring(1));
        else if (numeroRomano.startsWith("CM")) return 900  + devolverNumero(numeroRomano.substring(2));
        else if (numeroRomano.startsWith("D"))  return 500  + devolverNumero(numeroRomano.substring(1));
        else if (numeroRomano.startsWith("CD")) return 400  + devolverNumero(numeroRomano.substring(2));
        else if (numeroRomano.startsWith("C"))  return 100  + devolverNumero(numeroRomano.substring(1));
        else if (numeroRomano.startsWith("XC")) return 90   + devolverNumero(numeroRomano.substring(2));
        else if (numeroRomano.startsWith("L"))  return 50   + devolverNumero(numeroRomano.substring(1));
        else if (numeroRomano.startsWith("XL")) return 40   + devolverNumero(numeroRomano.substring(2));
        else if (numeroRomano.startsWith("X"))  return 10   + devolverNumero(numeroRomano.substring(1));
        else if (numeroRomano.startsWith("IX")) return 9    + devolverNumero(numeroRomano.substring(2));
        else if (numeroRomano.startsWith("V"))  return 5    + devolverNumero(numeroRomano.substring(1));
        else if (numeroRomano.startsWith("IV")) return 4    + devolverNumero(numeroRomano.substring(2));
        else if (numeroRomano.startsWith("I"))  return 1    + devolverNumero(numeroRomano.substring(1));
        throw new IllegalArgumentException("Número romano inexistente");
    }

    public static int convert(String s) {
        if (s == null || s.isEmpty() || !s.matches("^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$"))
            return -1;
        return devolverNumero(s);
    }*/
    @GetMapping("/{numero}")
    public static String devolverNumeroRomano(@PathVariable("numero") int numero) {
        StringBuilder sb = new StringBuilder();
        int times = 0;
        String[] romans = new String[]{"I", "IV", "V", "IX", "X", "XL", "L",
                "XC", "C", "CD", "D", "CM", "M"};
        int[] ints = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500,
                900, 1000};
        for (int i = ints.length - 1; i >= 0; i--) {
            times = numero / ints[i];
            numero %= ints[i];
            while (times > 0) {
                sb.append(romans[i]);
                times--;
            }
        }
        return sb.toString();
    }
}
