/*
 * Realizado con Linkedlist
 *
 * Funcionamiento:
 *   se crea un loop en consola y realiza las instrucciones pedidas en https://docs.google.com/document/d/1p0dsoyA-4xXG-nc1-eQ20UxB1fL3DguMGQNL8lV96rw/edit
 *
 * A correguir:  - Si los datos ingresados no corresponden al tipo crashea (por ejemplo letras en edad) [corroborar]
 *               - Si se pide eliminar un numero de registro que no existe crashea [corroborar]
 *
 * */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Participante {
    @Override
    public String toString() {
        return "Participante{" +
                "dni=" + dni +
                ", edad=" + edad +
                ", celular=" + celular +
                ", emergencia=" + emergencia +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", factor='" + factor + '\'' +
                ", carrera='" + carrera + '\'' +
                '}';
    }

    int dni,edad,celular,emergencia;
    String nombre,apellido,factor, carrera;
    public void setDni(int data){dni = data;}
    public void setEdad(int data){edad = data;}
    public void setCelular(int data){celular = data;}
    public void setEmergencia(int data){emergencia = data;}
    public void setNombre(String data){nombre = data;}
    public void setApellido(String data){apellido = data;}
    public void setFactor(String data){factor = data;}
    public void setCarrera(String data){carrera = data;}
}

public class Java_I_b {
    // Scaner
    static Scanner sc = new Scanner(System.in);

    static List<Participante> listaParticipantes = new LinkedList<Participante>();



    static void inscribir(){
        System.out.println("Inscribiendo...");
        sc.nextLine();
        Participante p = new Participante();
        System.out.print("Nombre: ");
        p.setNombre(sc.nextLine());
        System.out.print("Apellido: ");
        p.setApellido(sc.nextLine());
        System.out.print("Grupo Sanguineo: ");
        p.setFactor(sc.nextLine());
        System.out.print("Dni: ");
        p.setDni(sc.nextInt());
        System.out.print("Edad: ");
        p.setEdad(sc.nextInt());
        System.out.print("Celular: ");
        p.setCelular(sc.nextInt());
        System.out.print("Emergencia: ");
        p.setEmergencia(sc.nextInt());
        sc.nextLine();
        boolean invalid = true;
        while(invalid) {
            System.out.print("Circuito(chico,medio o avanzado): ");
            p.setCarrera(sc.nextLine());
            if(p.carrera.equals("chico") || p.carrera.equals("medio") || p.carrera.equals("avanzado")){invalid = false;}else{System.out.println("Dato no valido");}
        }
        if(p.edad < 18 && p.carrera.equals("avanzado")){System.out.println("Inscripcion cancelada, no pueden inscribirse menores en el circuito avanzado");}
        else{listaParticipantes.add(p);
            System.out.println("Inscripcion realizada");}
    }
    static void mostrar(){
        System.out.println("Mostrando");
        int inscripcion = 0;
        for(Participante p : listaParticipantes){
            System.out.println("Participante N: " + inscripcion);
            System.out.println(p.toString());
            inscripcion++;
        }
    }
    static void desinscribir(){
        System.out.println("Desinscribir");
        System.out.print("Numero: ");
        listaParticipantes.remove(sc.nextInt());
    }
    static void determinarMonto(){
        System.out.println("Determinar Monto");
        System.out.print("Numero: ");
        Participante p = listaParticipantes.get(sc.nextInt());
        int monto = 0;
        switch(p.carrera){
            case "chico":
                if(p.edad < 18){monto = 1300;}else{monto = 1500;}
                break;
            case "medio":
                if(p.edad < 18){monto = 2000;}else{monto = 2300;}
                break;
            case "avanzado":
                monto = 2800;
                break;
        }
        System.out.println("Monto: " + monto);
    }
    static void instrucciones(){
        System.out.println("---- COMANDOS -----");
        System.out.println("i => INFO");
        System.out.println("m => MOSTRAR");
        System.out.println("d => DESINSCRIBIR");
        System.out.println("n => INSCRIBIR");
        System.out.println("p => DETERMINAR MONTO");
        System.out.println("q => SALIR");
        System.out.println("------------------");
    }
    public static void main(String[] args) {
        char command = ' ';
        instrucciones();
        while(command != 'q') {
            System.out.println("----- INGRESE UN COMANDO (i = help) -----");
            command = sc.next().charAt(0);
            switch (command) {
                case 'p':
                    determinarMonto();
                    break;
                case 'd':
                    desinscribir();
                    break;
                case 'm':
                    mostrar();
                    break;
                case 'n':
                    inscribir();
                    break;
                case 'i':
                    instrucciones();
                    break;
                case 'q':
                    System.out.println("Cerrando");
                    break;
                default:
                    System.out.println("Comando desconocido");
                    break;
            }
        }
    }
}
