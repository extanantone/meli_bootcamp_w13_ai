import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class carreraDeLaSelva {

    static List<participante> inscritosChico = new ArrayList<participante>();
    static List<participante> inscritosMedio = new ArrayList<participante>();
    static List<participante> inscritosAvanzado = new ArrayList<participante>();


    public static void mostrarInscritos(List<participante> lista){
            for (participante p : lista) {
                System.out.println("Inscripción: " +(lista.indexOf(p)+1)+ " "+ p.toString());
            }

    }

    public static void   eliminarParticipante(String dni){
       for(participante p: inscritosChico){
           if (p.getDni().equals(dni)){
               inscritosChico.remove(0);
           }
       }

    }
    public  static void ingresarDatosParticipante(){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese DNI: ");
        String dni = entrada.next();
        System.out.print("Ingrese nombre: ");
        String nombre= entrada.next();
        System.out.print("Ingrese apellido: ");
        String apellido= entrada.next();
        System.out.print("Ingrese edad: ");
        int edad= entrada.nextInt();
        System.out.print("Ingrese celular: ");
        String celular= entrada.next();
        System.out.print("Ingrese Número de emergencia: ");
        String numeroEmergencia= entrada.next();
        System.out.print("Ingrese Grupo sanguineo: ");
        String grupoSanguineo= entrada.next();
        System.out.print("Ingrese categoria (1)CHICO (2)MEDIO (3)AVANZADO: ");
        String categoria= entrada.next();

        participante persona = new participante(dni,nombre,apellido,edad,celular,numeroEmergencia,grupoSanguineo,categoria);
        ingresarInscripcion(persona);
    }

    public static void ingresarInscripcion(participante p){
        int pago = 0;
        switch (p.getCategoria()){
            case "1":{
                if (p.getEdad() < 18 ) {
                    pago = 1300;
                }
                else {
                    pago = 1500;
                    }
                p.setCategoria("chico");
                inscritosChico.add(p);
                System.out.println("Debe pagar: $" + pago);
                }
            break;
            case "2":{
            if (p.getEdad() < 18 ) {
                pago = 2000;
            }
            else {
                pago = 2300;
            }
                p.setCategoria("medio");
                inscritosMedio.add(p);
                System.out.println("Debe pagar: $" + pago);
            }
            break;
            case "3":{
                if(p.getEdad() < 18){
                    System.out.println("¡¡¡No se permiten inscripciones de menores de 18 al circuito avanzado!!!");
                    break;
                }
                else
                    pago = 2800;
                p.setCategoria("avanzado");
                inscritosAvanzado.add(p);
                System.out.println("Debe pagar: $" + pago);
                break;
            }
            default:
                System.out.println("Categoria no encontrada");
        }


    }

    public static void main(String[] args) {

        String resp;
        do{
            ingresarDatosParticipante();
            System.out.println("Desea cargar más datos (S/N)");
            Scanner sc = new Scanner(System.in);
            resp = sc.next();
        }while (resp.equals("S")||resp.equals("s"));

        System.out.println("Inscritos categoria CHICO: ");
        mostrarInscritos(inscritosChico);
        System.out.println("Inscritos categoria MEDIO: ");
        mostrarInscritos(inscritosMedio);
        System.out.println("Inscritos categoria AVANZADO: ");
        mostrarInscritos(inscritosAvanzado);

        eliminarParticipante("1");

    }
}


