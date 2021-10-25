package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App{

    public static int peoples = 0;

    public static Scanner s;

    public static Map<String,List<Inscription>> categories = Map.of("Chico", new ArrayList<Inscription>(),"Medio",new ArrayList<Inscription>(),"Avanzado",new ArrayList<Inscription>());

    public static void inscribir(){
        int selection;
        System.out.println("Seleccione la categoria:\n1 Chico\n2 Medio\n3 Avanzado\n\n");
        selection = Integer.parseInt(s.nextLine());
        if(selection<1 || selection>4){
            System.out.println("Invalido");
            return;
        }
        String key;
        if(selection==1) key="Chico";
        else if(selection==2) key="Medio";
        else key = "Avanzado";
        Inscription inscription = new Inscription();
        inscription.id = peoples;
        System.out.println("Nombres:");
        inscription.nombre = s.nextLine();
        System.out.println("Apellidos:");
        inscription.apellido = s.nextLine();
        System.out.println("DNI:");
        inscription.dni = Integer.parseInt(s.nextLine());
        System.out.println("Celular:");
        inscription.celular = s.nextLine();
        System.out.println("Edad: ");
        inscription.edad = Integer.parseInt(s.nextLine());
        System.out.println("Emergencia:");
        inscription.emergencia = s.nextLine();
        if(key=="Avanzado" && inscription.edad<18){
            System.out.println("Usuario invalido - no se puede inscribir alguien menor de 18 para esta categoria.");
            return;
        }
        categories.get(key).add(inscription);
        System.out.println("Se ha agregado correctamente");
        System.out.println();
        peoples++;
    }

    public static void listar(){
        int selection;
        System.out.println("Seleccione la categoria:\n1 Chico\n2 Medio\n3 Avanzado\n\n");
        selection = Integer.parseInt(s.nextLine());
        if(selection<1 || selection>4){
            System.out.println("Invalido");
            return;
        }
        String key;
        if(selection==1) key="Chico";
        else if(selection==2) key="Medio";
        else key = "Avanzado";
        List<Inscription> inscriptions = categories.get(key);
        System.out.println();
        System.out.println();
        System.out.println("---------------- Lista ------------------");
        for(Inscription i: inscriptions){
            System.out.println("ID:"+i.id+"\tNombre: "+i.nombre+"\tApellido: "+i.apellido+"\tDNI: "+i.dni+"\tEdad: "+i.edad+"\tprecio: "+i.getPriceByCategory(key));
        }
        System.out.println();

        System.out.println("---------------- Fin Lista ----------------");

    }

    public static void eliminarInscripcion(){
        int selection;
        System.out.println("Seleccione la categoria:\n1 Chico\n2 Medio\n3 Avanzado\n\n");
        selection = Integer.parseInt(s.nextLine());
        if(selection<1 || selection>4){
            System.out.println("Invalido");
            return;
        }
        String key;
        if(selection==1) key="Chico";
        else if(selection==2) key="Medio";
        else key = "Avanzado";
        System.out.println("---------------- Lista ------------------");
        List<Inscription> inscriptions = categories.get(key);
        for(Inscription i: inscriptions){
            System.out.println("ID:"+i.id+"\tNombre: "+i.nombre+"\tApellido: "+i.apellido+"\tDNI: "+i.dni+"\tEdad: "+i.edad+"\tprecio: "+i.getPriceByCategory(key));
        }
        System.out.println();

        System.out.println("---------------- Fin Lista ----------------");

        System.out.println("Ingrese id de la inscripcion a eliminar: ");
        int id = Integer.parseInt(s.nextLine());
        Inscription inscription = findIncriptionById(inscriptions, id);
        if(inscription==null){
            System.out.println("No existe inscripcion");
        }else{
            inscriptions.remove(inscription);
            System.out.println("Se ha eliminado correctamente.");

        }
        
    }

    public static Inscription findIncriptionById(List<Inscription> inscriptions,int id){
        for(Inscription i:inscriptions){
            if(i.id==id) return i;
        }
        return null;
    }

    public static void main(String[] args) {
        boolean isExit = false;
        s = new Scanner(System.in);
        while(!isExit){
            System.out.println();
            System.out.println("Seleccione la accion a realizar:");
            System.out.println("1 Inscribir");
            System.out.println("2 Listar");
            System.out.println("3 Eliminar");
            System.out.println("4 Salir");
            System.out.println();
            System.out.println("Escribe el numero de la seleccion.");
            int opt = Integer.parseInt(s.nextLine());
            if(opt==1) inscribir();
            else if(opt==2) listar();
            else if(opt==3) eliminarInscripcion();
            else if(opt==4) isExit = true;
        }
    }

}