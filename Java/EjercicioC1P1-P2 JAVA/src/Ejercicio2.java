import java.util.*;

/*
- Circuito chico: 2 km por selva y arroyos.
- Circuito Avanzado: 10 km por selva, arroyos, barro y escalada en piedra.
- Circuito medio: 5 km por selva, arroyos y barro.
Cada participante puede inscribirse únicamente a una categoría y necesita, para dicha inscripción,
proporcionar los siguientes datos: dni, nombre, apellido, edad, celular, número de emergencia y grupo sanguíneo.
A cada inscripto, a la vez, se le asigna un número de participante consecutivo con respecto a la inscripción anterior;
 por ejemplo, si un participante se inscribe y el anterior fue el número 36, se le va a asignar el número 37.
Para concluir con la inscripción, se debe calcular el monto a abonar por cada participante.
Para ello se tienen en cuenta los siguientes valores:
- Inscripción Circuito chico: Menores de 18 años $1300. Mayores de 18 años $1500.
- Inscripción Circuito medio: Menores de 18 años $2000. Mayores de 18 años $2300.
- Inscripción Circuito Avanzado: No se permite inscripciones a menores de 18 años. Mayores de 18 años $2800

A partir de estos datos brindados, los organizadores de la carrera manifestaron que necesitan de una aplicación que sea capaz de:
1. Inscribir a un nuevo participante en una categoría. (Tener en cuenta que cada categoría tiene una lista de
inscriptos diferente).
2. Mostrar por pantalla todos los inscriptos a una determinada categoría con sus correspondientes datos y número de inscripción.
3. Desinscribir a un participante de una categoría.
4. Determinar el monto que deberá abonar cada participante al inscribirse. Por ejemplo: si el participante se inscribe a la
categoría Circuito chico y tiene 21 años, el monto a abonar es de $1500.
*/
public class Ejercicio2 {
    public static void main(String[] args) {
        //creación del objeto que lee lo ingresado por teclado
        Scanner tecla = new Scanner(System.in);

        //variable que controla el menú principal
        int menuElegido = 0;
        //contador del número de participante
        int numeroParticipante = 0;
        //variable para asignar el monto de inscripción
        int montoInscripcion = 0;
        //variable inicializada que sirve para salir de los menús secundarios
        int salida = 0;
        List<Persona> listaCircuitoChico = new ArrayList<Persona>();
        List<Persona> listaCircuitoMedio = new ArrayList<Persona>();
        List<Persona> listaCircuitoAvanzado = new ArrayList<Persona>();
        HashMap<Integer, Persona> mapa = new HashMap<Integer, Persona>();
        Persona p;

        do {
            System.out.println("Ingrese el número que corresponda según al menú que desee ingresar." +
                    "\n     1. Agregar un participante." +
                    "\n     2. Eliminar un participante." +
                    "\n     3. Ver la lista de participantes según el circuito." +
                    "\n     En caso contrario presione cualquier tecla numérica para salir.");
            menuElegido = tecla.nextInt();

            switch (menuElegido) {
                case 1:
                    do {
                        p = new Persona();
                        System.out.println("Menu para ingresar una persona nueva en los distintos circuitos.");
                        //dni, nombre, apellido, edad, celular, número de emergencia y grupo sanguíneo
                        System.out.println("Ingrese el DNI del participante");
                        p.setDni(tecla.nextInt());
                        if (!mapa.containsKey(p.getNumeroParticipante())) {
                            System.out.println("Ingrese el APELLIDO del participante");
                            p.setApellido(tecla.next());
                            System.out.println("Ingrese el NOMBRE del participante");
                            p.setNombre(tecla.next());
                            System.out.println("Ingrese el EDAD del participante");
                            p.setEdad(tecla.nextInt());
                            System.out.println("Ingrese el CELULAR del participante");
                            p.setCelular(tecla.nextLong());
                            System.out.println("Ingrese el NÚMERO DE EMERGENCIA del participante");
                            p.setNumeroEmergencia(tecla.nextLong());
                            System.out.println("Ingrese el GRUPO SANGUÍNEO del participante");
                            p.setGrupoSanguineo(tecla.next());
                            System.out.println("Ingrese el número que corresponda según al circuito en el que desee ingresar un participante:" +
                                    "\n     1. Circuito chico." +
                                    "\n     2. Circuito medio." +
                                    "\n     3. Circuito avanzado." +
                                    "\n     En caso contrario presione cualquier tecla para salir.");
                            int circuitoElegido = tecla.nextInt();


                            switch (circuitoElegido) {
                                case 1:
                                    p.setNumeroParticipante(numeroParticipante++);
                                    listaCircuitoChico.add(p);
                                    mapa.put(p.getNumeroParticipante(), p);
                                    if (p.getEdad() >= 18) {
                                        montoInscripcion = 1500;
                                    } else {
                                        montoInscripcion = 1300;
                                    }
                                    break;
                                case 2:
                                    p.setNumeroParticipante(numeroParticipante++);
                                    listaCircuitoMedio.add(p);
                                    mapa.put(p.getNumeroParticipante(), p);
                                    if (p.getEdad() >= 18) {
                                        montoInscripcion = 2300;
                                    } else {
                                        montoInscripcion = 2000;
                                    }
                                    break;
                                case 3:
                                    p.setNumeroParticipante(numeroParticipante++);
                                    listaCircuitoAvanzado.add(p);
                                    mapa.put(p.getNumeroParticipante(), p);
                                    if (p.getEdad() >= 18) {
                                        montoInscripcion = 2800;
                                    } else {
                                        break;
                                    }
                                    break;
                                default:
                                    break;
                            }
                            //salida por pantalla del punto d)
                            System.out.println("El monto a abonar por el particopante número " + numeroParticipante + " es de $" + montoInscripcion);
                            System.out.println("¿Desea cargar otro participante? " +
                                    "\n 1. Sí." +
                                    "\n 2. Salir.");
                            salida = tecla.nextInt();
                        } else {
                            System.out.println("La persona ya existe en el sistema, intente cargando otra persona.");
                        }
                    } while (salida != 2);
                    break;


                case 2:
                    salida = 0;
                    do {
                        System.out.println("Menu para ingresar a la eliminación de una persona.");
                        System.out.println("Ingrese el número del participante que desea remover.");
                        int numeroParticipanteRemover = tecla.nextInt();
                        listaCircuitoChico.removeIf(persona -> persona.getNumeroParticipante() == numeroParticipanteRemover);
                        listaCircuitoMedio.removeIf(persona -> persona.getNumeroParticipante() == numeroParticipanteRemover);
                        listaCircuitoAvanzado.removeIf(persona -> persona.getNumeroParticipante() == numeroParticipanteRemover);
                        mapa.remove(numeroParticipanteRemover);
                        System.out.println("¿Desea eliminar otro participante? " +
                                "\n 1. Sí." +
                                "\n 2. Salir.");
                        salida = tecla.nextInt();
                    } while (salida != 2);
                    break;


                case 3:
                    salida = 0;
                    do {
                        System.out.println("Menu para visualizar los participantes de los distintos circuitos.");
                        System.out.println("Ingrese el número que corresponda según al circuito en el que desee ver los datos de los participantes:" +
                                "\n  1. Circuito chico." +
                                "\n  2. Circuito medio." +
                                "\n  3. Circuito avanzado." +
                                "\n  En caso contrario presione cualquier tecla para salir.");
                        int circuitoElegido = tecla.nextInt();
                        switch (circuitoElegido) {
                            case 1:
                                for (Persona pe : listaCircuitoChico) {
                                    System.out.println("Datos del participante NÚMERO " + pe.getNumeroParticipante() +
                                            "\n DNI del participante: " + pe.getDni() +
                                            "\n Apellido del participante: " + pe.getApellido() +
                                            "\n Nombre del participante: " + pe.getNombre() +
                                            "\n Edad del participante:  " + pe.getEdad() +
                                            "\n Grupo Sanguínero del participante " + pe.getGrupoSanguineo() +
                                            "\n Celular del participante " + pe.getCelular() +
                                            "\n Número de Emergencia del participante " + pe.getNumeroEmergencia() +
                                            "\n *************************");
                                }
                                break;
                            case 2:
                                for (Persona pe : listaCircuitoMedio) {
                                    System.out.println("Datos del participante NÚMERO " + pe.getNumeroParticipante() +
                                            "\n DNI del participante: " + pe.getDni() +
                                            "\n Apellido del participante: " + pe.getApellido() +
                                            "\n Nombre del participante: " + pe.getNombre() +
                                            "\n Edad del participante:  " + pe.getEdad() +
                                            "\n Grupo Sanguínero del participante " + pe.getGrupoSanguineo() +
                                            "\n Celular del participante " + pe.getCelular() +
                                            "\n Número de Emergencia del participante " + pe.getNumeroEmergencia() +
                                            "\n *************************");
                                }
                                break;
                            case 3:
                                for (Persona pe : listaCircuitoAvanzado) {
                                    System.out.println("Datos del participante NÚMERO " + pe.getNumeroParticipante() +
                                            "\n DNI del participante: " + pe.getDni() +
                                            "\n Apellido del participante: " + pe.getApellido() +
                                            "\n Nombre del participante: " + pe.getNombre() +
                                            "\n Edad del participante:  " + pe.getEdad() +
                                            "\n Grupo Sanguínero del participante " + pe.getGrupoSanguineo() +
                                            "\n Celular del participante " + pe.getCelular() +
                                            "\n Número de Emergencia del participante " + pe.getNumeroEmergencia() +
                                            "\n *************************");
                                }
                                break;
                            default:
                                break;
                        }
                        System.out.println("¿Desea ver otra lista de circuito? " +
                                "\n 1. Sí." +
                                "\n 2. Salir.");
                        salida = tecla.nextInt();
                    } while (salida != 2);
                    break;
                default:
                    break;
            }
        } while (menuElegido == 1 || menuElegido == 2 || menuElegido == 3);
    }
}
