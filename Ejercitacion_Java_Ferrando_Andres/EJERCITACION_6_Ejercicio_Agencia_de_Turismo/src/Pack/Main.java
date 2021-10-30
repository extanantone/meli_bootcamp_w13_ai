package Pack;

import Reservas.*;
import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {



        Cliente c1= new Cliente("Juan","Perez",123456,1);
        Cliente c2= new Cliente("Pedro","Diaz",654321,2);

        Repositorio r1= new Repositorio(c1,null);
        Repositorio r2= new Repositorio(c2,null);

        ArrayList<Repositorio> arrayRepo = new ArrayList();
        arrayRepo.add(r1);
        arrayRepo.add(r2);


        Scanner sc = new Scanner(System.in);
        int menu;

        do{
            System.out.println("Menu de Agencia de Viajes");
            System.out.println("1- Cargar nueva Reserva de Viajes");
            System.out.println("2- Imprimir Repositorios");
            System.out.println("3- Salir");
            menu=sc.nextInt();

            switch (menu)
            {
                case 1: cargarReserva(arrayRepo);
                break;
                case 2: imprimirRepositorios();
            }
        }while(menu<3);

    }

    private static void imprimirRepositorios() {
    }

    private static Reserva cargarReserva(ArrayList arrayRepo) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\nINGRESE NUMERO DE CLIENTE");
        for (int i=0; i<arrayRepo.size();i++)
        {
            Repositorio aux= (Repositorio) arrayRepo.get(i);
            String cliente = aux.getCliente().toString();
            System.out.println(cliente);
            int nroCliente=sc.nextInt();

        }

        System.out.println("Ingrese Tipo Reserva");
        System.out.println("1- Aereo");
        System.out.println("2- Hotel");
        System.out.println("3- Transfer");
        System.out.println("4- Comida");
        //System.out.println("5- Paquete");
        int opc=sc.nextInt();
        System.out.println("Ingrese Cantidad de Personas");
        int pers=sc.nextInt();
        System.out.println("Ingrese Precio Total");
        double prec=sc.nextDouble();

        switch (opc)
        {
            case 1: {
                System.out.println("Ingrese compania Aerea");
                String compania=sc.next();
                System.out.println("Ingrese Origen");
                String origen=sc.next();
                System.out.println("Ingrese Destino");
                String destino=sc.next();

                Reserva reserva = new Aereo(prec,pers,compania,origen,destino);
                return reserva;
            }
            case 2:{
                System.out.println("Ingrese Destino");
                String destino=sc.next();
                System.out.println("Ingrese Nombre Hotel");
                String nomHotel=sc.next();

                Reserva reserva = new Hotel(prec,pers,destino,nomHotel);
                return reserva;
            }
            case 3:{
                System.out.println("Ingrese Destino");
                String destino=sc.next();

                Reserva reserva = new Transfer(prec,pers,destino);
                return reserva;
            }
            case 4:{
                System.out.println("Ingrese Destino");
                String destino=sc.next();

                Reserva reserva = new Comida(prec,pers,destino);
                return reserva;
            }
        }
        return null;
    }
}
