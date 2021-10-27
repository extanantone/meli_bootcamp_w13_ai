package com.app;

public class App{
    public static void main(String[] args) {
        Serie par = new ParSerie();
        System.out.println();
        System.out.println("Pares");
        for(int i=0;i<20;i++)System.out.println(par.next());
        Serie imparSerie = new ImparSerie();
        System.out.println();
        System.out.println("Impar serie");
        for(int i=0;i<20;i++) System.out.println(imparSerie.next());
        System.out.println();
        System.out.println("Third serie");
        Serie tSerie = new ThirdSerie();
        for(int i=0;i<20;i++) System.out.println(tSerie.next());
    }
}