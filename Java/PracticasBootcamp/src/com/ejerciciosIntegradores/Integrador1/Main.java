package com.ejerciciosIntegradores.Integrador1;

import com.ejerciciosIntegradores.Integrador1.modelo.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    List<Cliente> clientes;
    static Main main = new Main();
    public static void main(String[] args) throws IOException {

       /* main.clientes = new ArrayList<>(Arrays.asList(new Cliente(1067853552, "Danuit", "Petro"),
                new Cliente(1067897521, "Lenys", "Cuervo"),
                new Cliente(1068597452, "Aimeeth", "Silva")));

      Scanner teclado = new Scanner(System.in);
      boolean estado = true;
      do{

          System.out.println("====Digete el nuemero de la que desea realizar =======\n " +
                             "1 -Listar \n 2 -Borrar \n 3 -Buscar \n 4 -Agregar \n 5 -Salir" );
          long opcion = teclado.nextLong();

          switch ((int) opcion){
              case 1:
                  main.listarClientes();
                  break;
              case 2:
                  main.eliminarCliente();
                  break;
              case 3:
                  main.buscarCliente();
                  break;
              case 4:
                  break;
              case 5:
                  estado= false;
                  break;
              default:
                  break;
          }
         main. limpiarPantalla();
      }while (estado);*/

       // IPaquetable paquete = new BoletoViaje(1200,new BoletoViaje(1200 ,new Comida(500,new Transporte(100,new PaqueteBase(100,"Completo"))));
       // IPaquetable paquete1 = new BoletoViaje(1200,new Transporte(100,new PaqueteBase(100,"Paquete des")));

        //System.out.println(paquete.getPaquete()+" "+paquete.getPrecio());
        //System.out.println(paquete1.getPaquete()+" "+paquete1.getPrecio());


    }


    public void eliminarCliente(){
        limpiarPantalla();
        Scanner tecla = new Scanner(System.in);
        boolean estado = true;

        do{
            System.out.println("Ingrese el documento de la persona a eliminar : ");
            long documentoEliminar = tecla.nextLong();

            if(clientes.stream().filter(cliente -> cliente.getDni()==documentoEliminar).count()>0){
                clientes.removeIf(cliente -> cliente.getDni()==documentoEliminar);
                System.out.println("Cliente eliminado exitosamente");
                estado = false;
            }else {
                System.out.println("El documento no existe desea intertarlo de nuevo:\n 1 -Para Si \n 2 -Para no ");
                Long opcion = tecla.nextLong();

                if(opcion==2) {
                    estado = false;
                }
            }

        }while (estado);

        Scanner scanner = new Scanner(System.in);
        String entrada  ="";
        do{
            entrada  = scanner.nextLine();
            System.out.println(entrada);
        }
        while(!entrada.equals(""));
    }

    public void buscarCliente(){
        limpiarPantalla();
        Scanner tecla = new Scanner(System.in);
        boolean estado = true;
        do{

            System.out.println("Ingrese el documento de la persona a Buscar : ");
            long documentoEliminar = tecla.nextLong();

            if(clientes.stream().filter(cliente -> cliente.getDni()==documentoEliminar).count()>0){
                clientes.stream().filter(cliente -> cliente.getDni()==documentoEliminar).forEach(System.out::println);
                estado = false;
            }else {
                System.out.println("El Cliente no existe desea intertarlo de nuevo:\n 1 -Para Si \n 2 -Para no ");
                Long opcion = tecla.nextLong();

                if(opcion==2) {
                    estado = false;
                }
            }

        }while (estado);

        Scanner scanner = new Scanner(System.in);
        String entrada  ="";
        do{
            entrada  = scanner.nextLine();
            System.out.println(entrada);
        }
        while(!entrada.equals(""));
    }

    public  void listarClientes()  {
        limpiarPantalla();
        System.out.println("======Lista de Clienbtes===========\n");
        clientes.forEach(System.out::println);
        Scanner scanner = new Scanner(System.in);
        String entrada  ="";
        do{
            entrada  = scanner.nextLine();
            System.out.println(entrada);
        }
        while(!entrada.equals(""));
    }

    public void agregarCliente(){
        System.out.println("===Agregar Cliente =========");
        Scanner tecla = new Scanner(System.in);
        boolean estado = true;
        do{

        }while (estado);

    }

    public void limpiarPantalla() {
        for (int i=0; i<5;i++)
            System.out.println();
    }
}
