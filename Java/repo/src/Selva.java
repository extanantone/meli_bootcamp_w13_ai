import java.util.Scanner;

public class Selva {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String menu = "Seleccione una opción:\n";
        menu += "1) Inscribir participante\n";
        menu += "2) Mostrar inscriptos de categoría\n";
        menu += "3) Desinscribir participante\n";
        menu += "4) Calcular monto de participante\n";
        menu += "5) Reiniciar inscripciones de demostración\n";
        menu += "\nIngrese cualquier otro valor para salir.";

        Carrera carrera = new Carrera();
        carrera.demo();

        boolean finalizar = false;
        Participante p;
        int categoria, dni;
        while (!finalizar) {
            System.out.println(menu);
            try {
                int opcion = entrada.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese en sucesión los datos de la persona:");
                        try {
                            dni = entrada.nextInt();
                            String nombre = entrada.next();
                            String apellido = entrada.next();
                            int edad = entrada.nextInt();
                            long celular = entrada.nextLong();
                            long emergencia = entrada.nextLong();
                            String sanguineo = entrada.next();
                            p = new Participante(dni, nombre, apellido, edad, celular, emergencia, sanguineo);
                            System.out.println("Ingrese la categoría del circuito:");
                            try {
                                categoria = entrada.nextInt();
                                categoria = ((categoria-1) % 3) + 1;
                                carrera.inscribir(p, categoria);
                            }
                            catch (Exception e) {
                                System.out.println("Categoría inválida");
                            }
                        }
                        catch (Exception e) {
                            System.out.println("Datos inválidos");

                        }
                        break;
                    case 2:
                        System.out.println("Ingrese la categoría del circuito:");
                        try {
                            categoria = entrada.nextInt();
                            categoria = ((categoria-1) % 3) + 1;
                            carrera.printInscriptosDe(categoria);
                        }
                        catch (Exception e) {
                            System.out.println("Categoría inválida");
                        }
                        break;
                    case 3:
                        System.out.println("Ingrese el dni de la inscripción:");
                        try {
                            dni = entrada.nextInt();
                            carrera.desinsciribir(dni);
                        }
                        catch (Exception e) {
                            System.out.println("DNI inválido");
                        }
                        break;
                    case 4:
                        System.out.println("Ingrese el dni de la inscripción:");
                        try {
                            dni = entrada.nextInt();
                            int monto = carrera.montoDe(dni);
                            if (monto >= 0) System.out.println("Monto a abonar: " + monto);
                        }
                        catch (Exception e) {
                            System.out.print("DNI inválido");
                        }
                        break;
                    case 5:
                        System.out.println("Reiniciando inscripciones");
                        carrera.demo();
                        break;
                    default:
                        System.out.println("Fin");
                        finalizar = true;
                        break;
                }
            }
            catch (Exception e) {
                finalizar = true;
            }
        }
    }
}
