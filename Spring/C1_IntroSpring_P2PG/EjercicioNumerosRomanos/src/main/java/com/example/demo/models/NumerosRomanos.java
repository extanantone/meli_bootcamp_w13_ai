package com.example.demo.models;

import java.util.HashMap;
import java.util.Map;

public class NumerosRomanos {
    static char unidad ;
    static char decena ;
    static char centena ;
    static char unidadDeMil;

    public static String convertir(int numeroAConvertir){
        String numeroS = Integer.toString(numeroAConvertir);

        if(numeroAConvertir>=1000){
            unidadDeMil = numeroS.charAt(0);
            centena = numeroS.charAt(1);
            decena = numeroS.charAt(2);
            unidad = numeroS.charAt(3);
        } else{
            if(numeroAConvertir>=100){
                centena = numeroS.charAt(0);
                decena = numeroS.charAt(1);
                unidad = numeroS.charAt(2);
            } else {
                if(numeroAConvertir>=10){
                    decena = numeroS.charAt(0);
                    unidad = numeroS.charAt(1);
                } else{
                    unidad = numeroS.charAt(0);
                }
            }
        }
        //Resolvemos las unidades
        if(Character.getNumericValue(unidad)>8){
            numeroS = "IX";
        } else {
            if(Character.getNumericValue(unidad)>5){
                numeroS = "V"+"I".repeat(Character.getNumericValue(unidad)-5);
            } else {
                if(Character.getNumericValue(unidad)>3){
                    numeroS = "IV";

                } else{
                    numeroS = "I".repeat(Character.getNumericValue(unidad));
                }
            }
        }
        //Resolvemos las decenas
        if(Character.getNumericValue(unidad)==9){
            numeroS = "IX";
        } else {
            if(Character.getNumericValue(unidad)>5){
                numeroS = "V"+"I".repeat(Character.getNumericValue(unidad)-5);
            } else {
                if(Character.getNumericValue(unidad)==4){
                    numeroS = "IV";

                } else{
                    numeroS = "I".repeat(Character.getNumericValue(unidad));
                }
            }
        }
        //Resolvemos las decenas
        if(Character.getNumericValue(decena)==9){
            numeroS = "XC"+numeroS;
        } else {
            if(Character.getNumericValue(decena)>5){
                numeroS = "L"+"X".repeat(Character.getNumericValue(decena)-5)+numeroS;
            } else {
                if(Character.getNumericValue(decena)==4){
                    numeroS = "XL"+numeroS;

                } else{
                    numeroS = "X".repeat(Character.getNumericValue(unidad))+numeroS;
                }
            }
        }
        //Resolvemos las centenas
        if(Character.getNumericValue(centena)==9){
            numeroS = "CM"+numeroS;
        } else {
            if(Character.getNumericValue(centena)>5){
                numeroS = "D"+"C".repeat(Character.getNumericValue(centena)-5)+numeroS;
            } else {
                if(Character.getNumericValue(centena)==4){
                    numeroS = "CD"+numeroS;

                } else{
                    numeroS = "C".repeat(Character.getNumericValue(centena))+numeroS;
                }
            }
        }
        //Resolvemos las DE MIL
        if(numeroAConvertir>=1000){
            numeroS = "M".repeat(Character.getNumericValue(unidadDeMil)) + numeroS;
        }




        return numeroS;
    }

    public static String convertirARomano(int numero) {
        if(numero>=4000){
            return "No se puede convertir mayores de 4000";
        } else {
            return convertir(numero);
        }

    }
}
