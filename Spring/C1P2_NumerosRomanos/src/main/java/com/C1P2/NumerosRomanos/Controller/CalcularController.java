package com.C1P2.NumerosRomanos.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcularController {


    @GetMapping("/{numero}")
    public String calcularNumero(@PathVariable Integer numero){
        String messsage = "El valor introducido no puede ser procesado";

        if(numero >0 && numero < 4000){
            int[] values = {1000, 900, 500, 400, 100, 90, 50,40, 10, 9 ,5, 4, 1};
            String[] romanLiterals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

            String numRomano = "";

            int cantidadRestante = numero;

            do{
                for (int i = 0; i < values.length; i++){
                    if(cantidadRestante >= values[i]){
                        cantidadRestante -= values[i];
                        numRomano += romanLiterals[i];
                        break;
                    }
                }
                System.out.println(numRomano);
            }while (cantidadRestante > 0);


            messsage = "Número Decimal: " + numero +
                    " ------ " +
                    "Número Romano: " + numRomano;
        }

        return messsage;

    }
}
