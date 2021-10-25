import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class main {
    private static List<Persona> circuitoChico = new ArrayList<Persona>();
    private static List<Persona> circuitoMediano = new ArrayList<Persona>();
    private static List<Persona> circuitoGrande = new ArrayList<Persona>();
    private static HashMap <Integer,Integer> map = new HashMap<>();
    private static int opt =4, i=0;
    public static void main(String[] args) throws IOException {
        menu();
    }
    public static void menu () throws IOException {
        Scanner reader = new Scanner(System.in);

        while(opt >0){

            System.out.println("Elija la opcion:");
            System.out.println("1. Inscribir participante");
            System.out.println("2. Mostrar inscritos");
            System.out.println("3. Eliminar inscripción del participante");
            System.out.println("4. Determinar monto de la inscripcion");
            opt = reader.nextInt();
            switch (opt){
                case 1: inscribir (reader);
                        break;
                case 2: mostrar();
                        break;
                case 3:eliminar(reader);
                        break;
                case 4: monto();
                        break;
            }
        }
    }
    public static void inscribir(Scanner reader) throws IOException {
        System.out.println("ingrese los datos:");
        i++;
        String apellido ="perez", rh ="a+" ;
        long celular = 80005252, emergencia_num = 8523697;
        System.out.println("dni:");
        int dni = reader.nextInt();
        System.out.println("nombre:");
        String e=reader.nextLine();
        String nombre=reader.nextLine();
        System.out.println("edad:");
        int  edad = reader.nextInt();
        System.out.println("circuito chico (1), mediano (2), o grande (3)");
        int grupo = reader.nextInt();
        switch (grupo){
            case 1: circuitoChico.add(new Persona(dni, nombre, apellido, edad, celular,emergencia_num, rh));
                    map.put(dni,1 );
                break;
            case 2: circuitoMediano.add(new Persona(dni, nombre, apellido, edad, celular,emergencia_num, rh));
                    map.put(dni,2 );
                break;
            case 3: circuitoGrande.add(new Persona(dni, nombre, apellido, edad, celular,emergencia_num, rh));
                    map.put(dni,3 );
                break;
        }
    }
    public static void mostrar(){
        System.out.println("Para el circuito chico estan:");
        for (Persona cc : circuitoChico) {
            System.out.println(cc.getDni() + "  -  "+cc.getNombre());
        }
        System.out.println("Para el circuito mediano estan:");
        for (Persona cc : circuitoMediano) {
            System.out.println(cc.getDni() + "  -  "+cc.getNombre());
        }
        System.out.println("Para el circuito grande estan:");
        for (Persona cc : circuitoGrande) {
            System.out.println(cc.getDni() + "  -  "+cc.getNombre());
        }
    }
    public static void eliminar(Scanner reader){
        int j=0;
        System.out.println("digite el dni del competidor que quiere eliminar:");
        int  dni = reader.nextInt();
        int grupo = map.get(dni);
        map.remove(dni);
    switch (grupo){
            case 1:
                 j=0;
                for (Persona cc : circuitoChico) {
                    if(cc.getDni()==dni){
                        circuitoChico.remove(j);
                        break;
                    }
                    j++;
                }
                break;
            case 2:
                 j=0;
                for (Persona cc : circuitoMediano) {
                    if(cc.getDni()==dni){
                        circuitoMediano.remove(j);
                        break;
                    }
                    j++;
                }
                break;
            case 3:
                 j=0;
                for (Persona cc : circuitoGrande) {
                    if(cc.getDni()==dni){
                        circuitoGrande.remove(j);
                        break;
                    }
                    j++;
                }
                break;
        }

    }
    public static void monto(){

    }
}
