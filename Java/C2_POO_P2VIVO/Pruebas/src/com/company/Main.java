package com.company;
public class Main {

    String dni = "12345678"; // dni de ejemplo
    double sueldoBase = 21000; // monto de ejemplo
    double sueldoConAumento;

    public void calcularSueldo() {

        // Tu codigo aqui
        if (sueldoBase<=20000) {
            sueldoConAumento = sueldoBase + 20 * sueldoBase/100;
        }
        else {
            if (sueldoBase<= 45000){
                sueldoConAumento = sueldoBase + 10 * sueldoBase/100;
            }
            else {
                sueldoConAumento = sueldoBase + 5 * sueldoBase/100;
            }
        }

        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
    }

    public static void main(String[] args) {
        new Main().calcularSueldo();
    }

}