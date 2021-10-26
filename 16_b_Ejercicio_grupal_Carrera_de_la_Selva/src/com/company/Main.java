package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Inscripcion> listaCircuitoChico = new ArrayList<Inscripcion>();
        List<Inscripcion> listaCircuitoMedio = new ArrayList<Inscripcion>();
        List<Inscripcion> listaCircuitoAvanzado = new ArrayList<Inscripcion>();
        
        Person a = new Person(10203040, 111111, 222222, 10, "Andres", "Perez", "A+");
        Person b = new Person(14545, 111154511, 22222452, 47, "Juan", "Garcia", "A+");
        Person c = new Person(1654603040, 16565111, 5877222, 12, "Lucas", "Perez", "B+");
        Person d = new Person(14603040, 15111, 587222, 70, "Juan", "Garcia", "0+");
        Person e = new Person(54503040, 154511, 588672, 35, "Ricado", "Perez", "B+");
        Person f = new Person(154503040, 176711, 58678622, 25, "Marcelo", "Garcia", "0+");

        int precio;
        if (a.edad<18){precio=1300;}
        else{precio=1500;}
        Inscripcion aI = new Inscripcion(a,precio,true,1);
        listaCircuitoChico.add(aI);

        if (b.edad<18){precio=1300;}
        else{precio=1500;}
        Inscripcion bI = new Inscripcion(b,1500,true,2);
        listaCircuitoChico.add(bI);

        if (c.edad<18){precio=2000;}
        else{precio=2300;}
        Inscripcion cI = new Inscripcion(c,2000,true,1);
        listaCircuitoMedio.add(cI);

        if (d.edad<18){precio=2000;}
        else{precio=2300;}
        Inscripcion dI = new Inscripcion(d,2300,true,2);
        listaCircuitoMedio.add(dI);

        if (e.edad<18){System.out.println("Inscripcion no valida para menores de18 años"); }
        else{precio=2800;
        Inscripcion eI = new Inscripcion(e,2800,true,1);
        listaCircuitoAvanzado.add(eI);}

        if (f.edad<18){System.out.println("Inscripcion no valida para menores de18 años"); }
        else{precio=2800;
        Inscripcion fI = new Inscripcion(f,2800,true,2);
        listaCircuitoAvanzado.add(fI);}


        Scanner scan = new Scanner(System.in);
        int menu;
        System.out.println("// SE CARGARON POR DEFECTO 2 PARTICIPANTES POR CADA CIRCUITO //");
        System.out.println("// SE CARGARON POR DEFECTO 2 PARTICIPANTES POR CADA CIRCUITO //");
        System.out.println("// SE CARGARON POR DEFECTO 2 PARTICIPANTES POR CADA CIRCUITO //");

do {

    System.out.println("\nMenu: Ingrese Opcion Deseada");
    System.out.println("1- Mostrar todos los inscriptos de Circuito Chico");
    System.out.println("2- Mostrar todos los inscriptos de Circuito Medio");
    System.out.println("3- Mostrar todos los inscriptos de Circuito Avanzado");
    System.out.println("4- Anular Inscripcion Circuito Chico");
    System.out.println("5- Anular Inscripcion Circuito Medio");
    System.out.println("6- Anular Inscripcion Circuito Avanzado");
    System.out.println("7-SALIR");
    menu = scan.nextInt();

    switch (menu) {
        case 1: {
            for (Inscripcion p : listaCircuitoChico) {
                if (p.isConfirmado()){
                System.out.println("ID: " + p.getNroInscripto() + " Nombre: " +p.getP().nombre + " " + p.getP().apellido + " DNI:" + p.getP().dni + " Edad:" + p.getP().edad + " Precio:" + p.getPrecio() + " Confirmado;" + p.isConfirmado());
            }}
            break;
        }
        case 2: {
            for (Inscripcion p : listaCircuitoMedio) {
                if (p.isConfirmado()){
                System.out.println("ID: " + p.getNroInscripto() + " Nombre: " +p.getP().nombre + " " + p.getP().apellido + " DNI:" + p.getP().dni + " Edad:" + p.getP().edad + " Precio:" + p.getPrecio() + " Confirmado;" + p.isConfirmado());
            }}
            break;
        }
        case 3: {
            for (Inscripcion p : listaCircuitoAvanzado) {
                if (p.isConfirmado()){
                System.out.println("ID: " + p.getNroInscripto() + " Nombre: " +p.getP().nombre + " " + p.getP().apellido + " DNI:" + p.getP().dni + " Edad:" + p.getP().edad + " Precio:" + p.getPrecio() + " Confirmado;" + p.isConfirmado());
            }}
            break;

        }
        case 4: {

            for (Inscripcion p : listaCircuitoChico) {
                System.out.println("ID: " + p.getNroInscripto() + " " + p.getP().getNombre() + " " + p.getP().getApellido() + " Confirmado;" + p.isConfirmado());
            }
            System.out.println("INGRESE ID DE PARTICIPANTE");
                int inscripto= scan.nextInt();
             for(int i=0; i<listaCircuitoChico.size();i++)
             {
                 if(listaCircuitoChico.get(i).getNroInscripto()==inscripto)
                 {
                     listaCircuitoChico.get(i).setConfirmado(false);
                     System.out.println("Participante: "+listaCircuitoChico.get(i).getP().getNombre()+" "+listaCircuitoChico.get(i).getP().getApellido()+" DADO DE BAJA");
                 }
             }
             break;
        }
        case 5: {

            for (Inscripcion p : listaCircuitoMedio) {
                System.out.println("ID: " + p.getNroInscripto() + " " + p.getP().getNombre() + " " + p.getP().getApellido() + " Confirmado;" + p.isConfirmado());
            }
            System.out.println("INGRESE ID DE PARTICIPANTE");
            int inscripto= scan.nextInt();
            for(int i=0; i<listaCircuitoMedio.size();i++)
            {
                if(listaCircuitoMedio.get(i).getNroInscripto()==inscripto)
                {
                    listaCircuitoMedio.get(i).setConfirmado(false);
                    System.out.println("Participante: "+listaCircuitoMedio.get(i).getP().getNombre()+" "+listaCircuitoMedio.get(i).getP().getApellido()+" DADO DE BAJA");
                }
            }
            break;
        }
        case 6: {

            for (Inscripcion p : listaCircuitoAvanzado) {
                System.out.println("ID: " + p.getNroInscripto() + " " + p.getP().getNombre() + " " + p.getP().getApellido() + " Confirmado;" + p.isConfirmado());
            }
            System.out.println("INGRESE ID DE PARTICIPANTE");
            int inscripto= scan.nextInt();
            for(int i=0; i<listaCircuitoAvanzado.size();i++)
            {
                if(listaCircuitoAvanzado.get(i).getNroInscripto()==inscripto)
                {
                    listaCircuitoAvanzado.get(i).setConfirmado(false);
                    System.out.println("Participante: "+listaCircuitoAvanzado.get(i).getP().getNombre()+" "+listaCircuitoAvanzado.get(i).getP().getApellido()+" DADO DE BAJA");
                }
            }
        }
        break;

    }
}while (menu<=6) ;

        System.out.println("GRACIAS!!");

}
}
