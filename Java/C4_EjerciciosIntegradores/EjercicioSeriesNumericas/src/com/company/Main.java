package com.company;

import models.SerieDos;
import models.SerieGeneral;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SerieGeneral serie = new SerieGeneral(4);


        for(int i=1;i<=5;i++){
            serie.valorSiguiente();
            System.out.println(serie.mostrarValor());
        }

    }
}
