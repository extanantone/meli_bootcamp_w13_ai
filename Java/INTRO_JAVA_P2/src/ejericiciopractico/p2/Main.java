package ejericiciopractico.p2;

import java.util.*;

/*
jaiChavez
ejercicio practico de la segunda clase de Java Bootcamp intro java p2
No pemito el uso de Clases para definir objetos solo uso collections
 */
public class Main {

    public static Map<Long,Categorias> categorias = new HashMap<>();
    public static int contador;

    // se usa para evitar que los participates se peudan repetir entre las diferentes listas
    // solo van los dnis

    public static void main(String[] args) {
        contador = 0;
        // defino las categorias fijas y sus caracteristicas solo usando collections
        // valores de las 3 categorias

        Categorias cat1 = new Categorias("Chico",1300.00,1500.00,(long)1);
        Categorias cat2 = new Categorias("Medio",2000.00,2300.00,(long)2);
        Categorias cat3 = new Categorias("Avanzado",null,2800.00,(long)3);

        anadirCategorias(cat1);
        anadirCategorias(cat2);
        anadirCategorias(cat3);

        // creo participatnes x para hacer las pruebas

        Participante part1 = new Participante(123456781,"ricardo","chavez",
                27,321123456,1234567890,"A positivo",2300);
        Participante part2 = new Participante(123456782,"ricardo2","chavez",
                27,321123456,1234567890,"B positivo",2300);
        Participante part3 = new Participante(123456783,"ricard3","chavez",
                27,321123456,1234567890,"B negativo",2300);
        Participante part4 = new Participante(123456784,"ricard4","chavez",
                27,321123456,1234567890,"A negativo",2300);

        contador=cat1.anadirParticipante(part1,contador);
        contador=cat1.anadirParticipante(part4,contador);
        contador=cat2.anadirParticipante(part2,contador);
        contador=cat3.anadirParticipante(part3,contador);

        // menu de la aplicacion
        menuPrincipal();

    }

    /*
        metodo para controlar las categorias que se anaden al proceso
     */
    private static void anadirCategorias(Categorias cat) {
        if(categorias.containsKey(cat.getIndiceCategoria()))
            System.out.println("No se puede crear la categoria ya existe una categoria con ese indice unico");
        else
            categorias.put(cat.getIndiceCategoria(),cat);
    }


    public static void menuPrincipal(){

        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("Buen dia");
        System.out.println("Indique la accion a realizar: ");
        System.out.println("1. Inscribir participante en categoria ");
        System.out.println("2. Listar datos participantes categoria ");
        System.out.println("3. Des-inscribir participante");
        System.out.println("4. Determinar costo de inscripcion");

        int opcion = scan.nextInt();

        switch (opcion) {
            case 1 -> inscribirParticipante();
            case 2 -> listarParticipantes();
            case 3 -> desInscribirParticipante();
            case 4 -> determinarCostoInscripcion();
            default -> System.out.println("por favor seleccione una opción valida para continuar");
        }
        System.out.println("Presione una tecla para continuar...");
        scan.nextLine();
        scan.nextLine();
        menuPrincipal();
    }

    /**
     * en base a la edad y la categoria se le indica al usuario el costo de su inscripcion
     */
    private static void determinarCostoInscripcion() {
        System.out.println();
        Scanner scan = new Scanner(System.in);
        Double valorInscripcion;

        if(categorias.isEmpty())
            System.out.println("no hay categorias definidas");
        else
        {
            System.out.println("indique el numero de la categoria deseada: " + listarCategorias());
            Long indiceCategoria = scan.nextLong();
            if(!categorias.containsKey(indiceCategoria))
            {
                System.out.println("Indique una categoria correcta");
                return;
            }
            System.out.println("indique su edad: ");
            int edad = scan.nextInt();

            if(edad<18)
                valorInscripcion = categorias.get(indiceCategoria).getValorMenoresEdad();
            else
                valorInscripcion = categorias.get(indiceCategoria).getValorMayoresEdad();

            if(valorInscripcion == null) {
                System.out.println("No puede participar en esta categoria, no cumple los requisitos de edad");
            }
            else
                System.out.println("El valor a pagar será: " + valorInscripcion);
        }
    }

    private static String listarCategorias() {
        StringBuilder cates = new StringBuilder();
        if(categorias.isEmpty())
        {
            System.out.println("No se han definido correctamente las categorias por favor verifque");
            System.exit(0);
        }
        else
        {
            for(Long indiceCat: categorias.keySet())
            {
                cates.append(indiceCat).append(" ").append(categorias.get(indiceCat).getTipo()).append(" ,");
            }
        }
        return cates.substring(0,cates.length()-2);
    }

    /*
        elimina de la lista de aprtiicpantes y de la lista de la categoria correspondiente al participante
     */
    private static void desInscribirParticipante() {
        Scanner scan = new Scanner(System.in);
        System.out.println("ingrese el dni del participante a eliminar:");
        long dni = scan.nextLong();

        for(Map.Entry<Long,Categorias> categoria:categorias.entrySet())
        {
            if(categoria.getValue().getListaParts().containsKey(dni))
                categoria.getValue().borrarParticipante(dni);
        }
    }

    private static void listarParticipantes() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el indicador de categoria que desea ver: " + listarCategorias());
        Long indiceCategoria = scan.nextLong();
        Categorias cateActual = categorias.get(indiceCategoria);
        if(cateActual!=null)
        {
            // creo un metodo para organizar el map antes de msotrarlo en consola
            for(Map.Entry<Long,Participante> parts: cateActual.getListaParts().entrySet())
            {
                System.out.println("id: " + parts.getValue().getConsecutivoUnico() + ", nombre: " + parts.getValue().getNombre() + " , dni: "+parts.getValue().getDni());
            }
        }
        else
            System.out.println("Se desconoce el indice de categoria ingresado");
    }

    private static void inscribirParticipante() {
        Scanner scan = new Scanner(System.in);
        long dni;
        String nombre;
        String apellido;
        int edad;
        long celular;
        long numeroEmerg;
        String grupoSanguineo;
        double valorInscripcion;
        long indCategoria;
        System.out.println("ingrese los datos del participante nuevo:");
        System.out.println("ingrese dni:");
        dni = scan.nextLong();
        System.out.println("ingrese nombre:");
        scan.nextLine();
        nombre = scan.nextLine();
        System.out.println("ingrese apellido:");
        apellido = scan.nextLine();
        System.out.println("ingrese edad:");
        edad = scan.nextInt();
        System.out.println("ingrese celular:");
        celular = scan.nextLong();
        System.out.println("ingrese numero Emergencias:");
        numeroEmerg = scan.nextLong();
        System.out.println("ingrese grupo Sanguineo:");
        scan.nextLine();
        grupoSanguineo = scan.nextLine();
        System.out.println("ingrese valor Inscripcion:");
        valorInscripcion = scan.nextDouble();
        System.out.println("ingrese categoria: " + listarCategorias());
        indCategoria = scan.nextLong();


        Participante nuevo = new Participante(dni,nombre,apellido,edad,celular,numeroEmerg,grupoSanguineo,valorInscripcion);
        contador = categorias.get(indCategoria).anadirParticipante(nuevo,contador);

    }
}
