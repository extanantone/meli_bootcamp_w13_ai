package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<Integer,Participante> participantes = new HashMap<Integer, Participante>();
        HashMap<String,Categorias> categorias = new HashMap<String,Categorias>();
        HashMap<Participante,Categorias> partInscritos = new HashMap<Participante,Categorias>();

        int opc = Integer.MAX_VALUE;

        //Valores categorias
        creaCategorias(categorias);

        Scanner captura = new Scanner(System.in);

        System.out.println("Ingrese una opción: (valores permitidos del 0 al 4)");
        System.out.println("1 - Añadir participante");
        System.out.println("2 - Inscribir participante a categoria");
        System.out.println("3 - Eliminar participante de una categoria");
        System.out.println("4 - Mostrar participantes de una categoria");
        System.out.println("");
        System.out.println("0 - Salir del programa");
        opc = captura.nextInt();

        while (opc != 0) {

            switch (opc) {

                case 1:
                    crearParticipante(participantes);
                    break;
                case 2:
                    inscribirParticipante(partInscritos,participantes,categorias);
                    break;
                case 3:
                    elimianrParticipante(partInscritos);
                    break;
                case 4:
                    listarParticipantes(partInscritos,categorias);
                    break;
                default:
                    System.out.println("Error al ingresar por teclado, intente nuevamente");
                    break;
            }

            System.out.println("Ingrese un valor entre 0 y 5");
            opc = captura.nextInt();
        }

        return;
    }

    private static void listarParticipantes(HashMap<Participante,Categorias> listaParticipantes,
                                                        HashMap<String,Categorias> categorias) {
        System.out.println("Lista de categorias");

        for(Map.Entry<String,Categorias> lista : categorias.entrySet()) {
            Categorias l = lista.getValue();
            System.out.println("Codigo: "+l.getCodcar()+" Categoria: "+l.getTipo());
        }

        System.out.println("Ingrese el CODIGO de la categoria a listar: ");
        Scanner captura1 = new Scanner(System.in);
        int codCateg = captura1.nextInt();

        for(Map.Entry<Participante,Categorias> entrada : listaParticipantes.entrySet()) {

            Categorias l = entrada.getValue();

            System.out.println("Lista de participantes");


            System.out.println("ID Inscripción: "+entrada.getKey().getIdPer()+" DNI: "+entrada.getKey().getDni()+" Nombre: " + entrada.getKey().getNombre()+ " Apellido: "+entrada.getKey().getApellido()+ " Edad: "+ entrada.getKey().getEdad());
        }
    }

    private static void elimianrParticipante(HashMap<Participante,Categorias> listaParticipantes) {
        for(Map.Entry<Participante,Categorias> entrada : listaParticipantes.entrySet()) {
            System.out.println("Lista de participantes");
            System.out.println("ID Inscripción: "+entrada.getKey().getIdPer()+" DNI: "+entrada.getKey().getDni()+" Nombre: " + entrada.getKey().getNombre()+ " Apellido: "+entrada.getKey().getApellido());
        }
        System.out.println("Ingrese el DNI del participante a eliminar: ");
        Scanner captura1 = new Scanner(System.in);
        int dniPart = captura1.nextInt();
        listaParticipantes.remove(dniPart);
    }

    private static void creaCategorias(HashMap<String, Categorias> categorias) {
        //CategoriaChicos
        String tipo = "Chico";
        double valMayEdad = 1300.00;
        double valMenEdad = 1500.00;
        Categorias categoria = new Categorias(tipo,valMayEdad,valMenEdad);
        categorias.put(tipo,categoria);

        //CategoriaMedios
        String tipo1 = "Medio";
        double valMayEdad1 = 2000.00;
        double valMenEdad1 = 2300.00;
        Categorias categoria1= new Categorias(tipo1,valMayEdad1,valMenEdad1);
        categorias.put(tipo1,categoria1);

        //CategoriaAvanzados
        String tipo2 = "Avanzado";
        double valMayEdad2 = 0.00;
        double valMenEdad2 = 2800.00;
        Categorias categoria2 = new Categorias(tipo2,valMayEdad2,valMenEdad2);
        categorias.put(tipo2,categoria2);

    }
    private static void inscribirParticipante(HashMap<Participante,Categorias> participanteCategorias,
                                                    HashMap<Integer,Participante> participantes,
                                                    HashMap<String,Categorias> categorias) {
        System.out.println("Lista de participantes: ");

        for (Map.Entry<Integer,Participante> entrada : participantes.entrySet()){
            Participante p = entrada.getValue();
            System.out.println("ID Inscripción: "+p.getIdPer()+" DNI: "+p.getDni() + " Nombre: "+p.getNombre() + " Apellido: " + p.getApellido());
        }

        System.out.println("Ingrese el numero de dni del participante a seleccionar: ");
        Scanner captura2 = new Scanner(System.in);
        int dniPar = captura2.nextInt();

        Participante participante  = participantes.get(dniPar);


        System.out.println("Lista de categorias: ");

        for(Map.Entry<String,Categorias> entrada : categorias.entrySet()) {
            Categorias c = entrada.getValue();
            System.out.println("Codigo: "+c.getCodcar()+ " Categoria: "+c.getTipo()+ " Valor +18 años: " +c.getValorMayorEdad()+ " Valor -18 años: "+c.getValorMenorEdad());
        }

        System.out.println("Seleccione el CODIGO de carrera al que desea asignar al participante");
        Scanner categ = new Scanner(System.in);
        int codCatego = categ.nextInt();

        Categorias categoria  = categorias.get(codCatego);

        participanteCategorias.put(participante,categoria);
    }



    private static void crearParticipante(HashMap<Integer,Participante> participantes) {

        Scanner captura3= new Scanner(System.in);

        System.out.println("Ingrese dni: ");
        int dni = captura3.nextInt();
        System.out.println("Ingrese nombre: ");
        String nombre = captura3.next();
        System.out.println("Ingrese apellido: ");
        String apellido = captura3.next();
        System.out.println("Ingrese número celular de emergencia: ");
        int numeroEmerg = captura3.nextInt();
        System.out.println("Ingrese grupo sanguineo: ");
        String grupoSanguineo = captura3.next();
        System.out.println("Ingrese celular principal: ");
        int celular = captura3.nextInt();
        System.out.println("Ingrese edad: ");
        int edad = captura3.nextInt();
        double valorInscripcion= 0.00;


        Participante participante = new Participante(dni,nombre,apellido,edad,celular,numeroEmerg,grupoSanguineo,valorInscripcion);

        participantes.put(dni,participante);

    }
}