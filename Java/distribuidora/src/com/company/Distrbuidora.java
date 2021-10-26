package com.company;

import java.util.ArrayList;

public class Distrbuidora {

    public static void main(String[] args) {
        ArrayList<Producto> arrProducto= new ArrayList<>();
        String [] nombrePerecederos ={"Leche","Sardinas","Atun","Queso","Kumis"};
        String [] nombreNoPerecederos ={"Huvos","Jabon","Shampoo","Arroz","Frijoles"};
        
        int [] diasvenPerecederos = {1,2,3,4,5};
        String [] tipoNoPerecederos ={"Comida","Aseo","Aseo","Comida","Comida"};
        
        double [] precioPerecederos = {1800.00,900.00,3550.00,2860.00,5000.00};
        double [] precioNoPerecederos = {5000.00,4000.00,3000.00,2000.00,1000.00};

        double valFinalPer = 0.00;
        double valFinalNoPer = 0.00;

        for (int i=0;i<5;i++){
            //Crea perecederos
            String nombPerecederos=nombrePerecederos[i];
            double precPerecederos=precioPerecederos[i];
            int diasPerecederos=diasvenPerecederos[i];
            Perecederos perecederos = new Perecederos(nombPerecederos,precPerecederos,diasPerecederos);
            arrProducto.add(perecederos);
            double valPer = perecederos.calcular(5);
            System.out.println("Producto perecedero: "+nombPerecederos+" valor final "+valPer);
            valFinalPer += valPer;

            //Crea no perecederos
            String nombNoPerecederos=nombreNoPerecederos[i];
            double precNoPerecederos=precioNoPerecederos[i];
            String tipNoPerecederos=tipoNoPerecederos[i];
            NoPerecederos noPerecederos = new NoPerecederos(nombNoPerecederos,precNoPerecederos,tipNoPerecederos);
            arrProducto.add(noPerecederos);
            double valNoPer = noPerecederos.calcular(5);
            System.out.println("Producto no perecedero: "+nombNoPerecederos+" valor final "+valNoPer);
            valFinalNoPer += valNoPer;
        }

        System.out.println("El valor total de venta para alimentos no perecederos es de $ "+valFinalNoPer);
        System.out.println("El valor total de venta para alimentos perecederos es de $ "+valFinalPer);

    }
}
