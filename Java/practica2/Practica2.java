import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practica2 {

    public static final Map<Object, Object> categoriaName = Stream.of(new Object[][]{
            {1, "chico"},
            {2, "mediano"},
            {3, "avanzado"},
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
    public static LinkedList<Participante> listaCircuitoChico;
    public static LinkedList<Participante> listaCircuitoMediano;
    public static LinkedList<Participante> listaCircuitoAvanzado;
    public static int circuitoChicoLastID;
    public static int circuitoMedianoLastID;
    public static int circuitoAvanzadoLastID;
    public static HashMap<String, Integer> inscritos;

    public static void imprimirMenu() {
        System.out.println("Escoge una opcion:\n1)Inscribir participante\n2)Mostrar inscritos\n3)Desinscribir participante\n4)Salir\n\n");
    }

    public static void inscribirParticipante(Scanner in) {
        System.out.println("Escoge un circuito:\n1)Circuito chico\n2)Circuito mediano\n3)Circuito Avanzado\n4)Salir\n\n");
        String circuito = in.nextLine();
        if (circuito.equals("4")) return;
        System.out.println("Ingresa tu DNI:");
        String dni = in.nextLine();
        System.out.println("Ingresa tu Nombre:");
        String nombre = in.nextLine();
        System.out.println("Ingresa tu Apellido:");
        String apellido = in.nextLine();
        System.out.println("Ingresa tu Edad:");
        int edad = Integer.valueOf(in.nextLine());
        System.out.println("Ingresa tu Celular:");
        String celular = in.nextLine();
        System.out.println("Ingresa tu Numero de Emergencia:");
        String numeroDeEmergencia = in.nextLine();
        System.out.println("Ingresa tu Grupo sanguineo:");
        String grupoSanguíneo = in.nextLine();
        Participante nuevoParticipante = new Participante(0, dni, nombre, apellido, edad, celular, numeroDeEmergencia, grupoSanguíneo);
        Integer categoria = inscritos.get(dni);
        if (categoria != null) {
            System.out.println("Este participante ya esta inscito en la carrera " + categoriaName.get(categoria));
            return;
        }
        int nextID = 0;
        switch (circuito) {
            case "1":
                if (edad >= 18) System.out.println("El monto a abonar es $1500");
                else System.out.println("El monto a abonar es $1300");
                circuitoChicoLastID++;
                nuevoParticipante.setId(circuitoChicoLastID);
                listaCircuitoChico.add(nuevoParticipante);
                inscritos.put(dni, 1);
                break;
            case "2":
                if (edad >= 18) System.out.println("El monto a abonar es $2300");
                else System.out.println("El monto a abonar es $2000");
                circuitoMedianoLastID++;
                nuevoParticipante.setId(circuitoMedianoLastID);
                listaCircuitoMediano.add(nuevoParticipante);
                inscritos.put(dni, 2);
                break;
            case "3":
                if (edad >= 18) System.out.println("El monto a abonar es $2800");
                else break;
                circuitoAvanzadoLastID++;
                nuevoParticipante.setId(circuitoAvanzadoLastID);
                listaCircuitoAvanzado.add(nuevoParticipante);
                inscritos.put(dni, 3);
                break;
            case "4":
                return;
            default:
                System.out.println("Circuito invalido, por favor seleccione otro.");
                inscribirParticipante(in);
                break;
        }
    }

    public static void imprimirParticipante(LinkedList<Participante> lista, int index) {
        Participante current = lista.get(index);
        System.out.println("ID: " + current.getId());
        System.out.println("DNI: " + current.getDni());
        System.out.println("Nombre: " + current.getNombre());
        System.out.println("Apellido: " + current.getApellido());
        System.out.println("Edad: " + current.getEdad());
        System.out.println("Calular: " + current.getCelular());
        System.out.println("Numero de Emergencia: " + current.getNumeroDeEmergencia());
        System.out.println("Grupo Sanguineo: " + current.getGrupoSanguíneo());
    }

    public static void desinscribirParticipante(Scanner in) {
        System.out.println("Escoge un circuito:\n1)Circuito chico\n2)Circuito mediano\n3)Circuito Avanzado\n4)Salir\n\n");
        String circuito = in.nextLine();
        if (circuito.equals("4")) return;
        System.out.println("Ingresa el id de participante a eliminar:");
        Integer id = Integer.valueOf(in.nextLine());
        Participante participante = null;
        switch (circuito) {
            case "1":
                participante = listaCircuitoChico.stream()
                        .filter(aux -> id.equals(aux.getId()))
                        .findAny()
                        .orElse(null);
                if (participante != null) {
                    listaCircuitoChico.remove(participante);
                    System.out.println("Se ha eliminado correctamente al participante con ID " + id + " del circuito chico");
                } else {
                    System.out.println("No se encontro un participante el Id indicado " + id);
                }
                desinscribirParticipante(in);
                break;
            case "2":
                participante = listaCircuitoMediano.stream()
                        .filter(aux -> id.equals(aux.getId()))
                        .findAny()
                        .orElse(null);
                if (participante != null) {
                    listaCircuitoChico.remove(participante);
                    System.out.println("Se ha eliminado correctamente al participante con ID " + id + " del circuito chico");
                } else {
                    System.out.println("No se encontro un participante el Id indicado " + id);
                }
                desinscribirParticipante(in);
                break;
            case "3":
                participante = listaCircuitoAvanzado.stream()
                        .filter(aux -> id.equals(aux.getId()))
                        .findAny()
                        .orElse(null);
                if (participante != null) {
                    listaCircuitoChico.remove(participante);
                    System.out.println("Se ha eliminado correctamente al participante con ID " + id + " del circuito chico");
                } else {
                    System.out.println("No se encontro un participante el Id indicado " + id);
                }
                desinscribirParticipante(in);
                break;
            case "4":
                return;
            default:
                System.out.println("Circuito invalido, por favor seleccione otro.");
                desinscribirParticipante(in);
                break;
        }
    }

    public static void menu(Scanner in) {
        imprimirMenu();
        String option = in.nextLine();
        switch (option) {
            case "1":
                inscribirParticipante(in);
                menu(in);
                break;
            case "2":
                System.out.println("Participantes circuito chico:");
                for (int i = 0; i < listaCircuitoChico.size(); i++) imprimirParticipante(listaCircuitoChico, i);
                System.out.println("Participantes circuito mediano:");
                for (int i = 0; i < listaCircuitoMediano.size(); i++) imprimirParticipante(listaCircuitoMediano, i);
                System.out.println("Participantes circuito avanzado:");
                for (int i = 0; i < listaCircuitoAvanzado.size(); i++) imprimirParticipante(listaCircuitoAvanzado, i);
                menu(in);
                break;
            case "3":
                desinscribirParticipante(in);
                menu(in);
                break;
            case "4":
                return;
            default:
                System.out.println("Opcion invalida, por favor seleccione otra.");
                menu(in);
                break;
        }
    }

    public static void main(String[] args) {

        listaCircuitoChico = new LinkedList<>();
        listaCircuitoMediano = new LinkedList<>();
        listaCircuitoAvanzado = new LinkedList<>();

        circuitoChicoLastID = 0;
        circuitoMedianoLastID = 0;
        circuitoAvanzadoLastID = 0;

        inscritos = new HashMap<>();

        Scanner in = new Scanner(System.in);

        menu(in);

    }

    static class Participante {
        private int id;
        private String dni;
        private String nombre;
        private String apellido;
        private int edad;
        private String celular;
        private String numeroDeEmergencia;
        private String grupoSanguíneo;

        public Participante(int id, String dni, String nombre, String apellido, int edad, String celular, String numeroDeEmergencia, String grupoSanguíneo) {
            this.dni = dni;
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
            this.celular = celular;
            this.numeroDeEmergencia = numeroDeEmergencia;
            this.grupoSanguíneo = grupoSanguíneo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDni() {
            return dni;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public String getCelular() {
            return celular;
        }

        public void setCelular(String celular) {
            this.celular = celular;
        }

        public String getNumeroDeEmergencia() {
            return numeroDeEmergencia;
        }

        public void setNumeroDeEmergencia(String numeroDeEmergencia) {
            this.numeroDeEmergencia = numeroDeEmergencia;
        }

        public String getGrupoSanguíneo() {
            return grupoSanguíneo;
        }

        public void setGrupoSanguíneo(String grupoSanguíneo) {
            this.grupoSanguíneo = grupoSanguíneo;
        }
    }
}
