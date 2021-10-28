package com.company;

import java.util.Scanner;

public class ValorInicial extends Prototipo{

    public ValorInicial(Integer numero) {
        super(numero);
    }

    @Override
    Integer numSiguiente() {
        Integer valor = 0;
        for (int i=0;i<6;i++){
            valor += this.getNumero();
            System.out.println("El numero siguiente es: "+valor);
        }
        return valor;
    }

    @Override
    Integer rinSerie() {
        return (Integer) (this.getNumero());
    }

    @Override
    Integer valInicial() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el numero inicial: ");
        Integer valor = setNumero(teclado.nextInt());
        return valor;
    }
}
