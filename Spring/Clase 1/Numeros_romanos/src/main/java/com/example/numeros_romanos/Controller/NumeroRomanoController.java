package com.example.numeros_romanos.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumeroRomanoController {
    @GetMapping("/{numero}")
    public String index(@PathVariable Integer numero) {
        System.out.println("\nNumero: " + numero);
        int numeroInt = numero;
        String numeroRomano = "";

        int unidad = numeroInt % 10;
        int decena = (numeroInt / 10) % 10;
        int centena = (numeroInt / 100) % 10;
        int millar = (numeroInt / 1000);

        System.out.println("Unidad: " + unidad);
        System.out.println("Decena: " + decena);
        System.out.println("Centena: " + centena);
        System.out.println("Millar: " + millar);

        for (int i = 0; i < millar; i++) {
            numeroRomano += "M";
        }

        if (centena == 9) {
            numeroRomano += "CM";
        }else if (centena == 4) {
            numeroRomano += "CD";
        }else if (centena >= 5) {
            numeroRomano += "D";
            for (int i = 0; i < centena - 5; i++) {
                numeroRomano += "C";
            }
        }else {
            for (int i = 0; i < centena; i++) {
                numeroRomano += "C";
            }
        }
        if (decena == 9) {
            numeroRomano += "XC";
        }else if (decena == 4) {
            numeroRomano += "XL";
        }else if (decena >= 5) {
            numeroRomano += "L";
            for (int i = 0; i < decena - 5; i++) {
                numeroRomano += "X";
            }
        }
        else {
            for (int i = 0; i < decena; i++) {
                numeroRomano += "X";
            }
        }
        if (unidad == 9) {
            numeroRomano += "IX";
        }else if (unidad == 4) {
            numeroRomano += "IV";
        }else if (unidad >= 5) {
            numeroRomano += "V";
            for (int i = 0; i < unidad - 5; i++) {
                numeroRomano += "I";
            }
        }else {
            for (int i = 0; i < unidad; i++) {
                numeroRomano += "I";
            }
        }
        System.out.println("Numero Romano: " + numeroRomano);
        return numeroRomano;

    }
}
