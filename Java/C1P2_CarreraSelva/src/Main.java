import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner entradaEscaner = new Scanner(System.in);

    List<Competidor> cChico = new ArrayList<Competidor>();
    List<Competidor> cMedio = new ArrayList<Competidor>();
    List<Competidor> cAvanzado = new ArrayList<Competidor>();

    public Competidor inscribirCompetidor(){
        System.out.println("Ingrese DNI: ");
        int dni = entradaEscaner.nextInt();
        System.out.println("Ingrese nombre: ");
        String nombre = entradaEscaner.next();
        System.out.println("Ingrese apellido: ");
        String apellido = entradaEscaner.next();
        System.out.println("Ingrese edad: ");
        int edad = entradaEscaner.nextInt();
        System.out.println("Ingrese celular: ");
        int celular = entradaEscaner.nextInt();
        System.out.println("Ingrese número de emergencia: ");
        int numEmergencia = entradaEscaner.nextInt();
        System.out.println("Ingrese grupo sanguieo: ");
        String gsanguineo = entradaEscaner.next();

        Competidor comp = new Competidor(dni,nombre,apellido,edad,celular,numEmergencia,gsanguineo);

        return comp;
    }

    public Boolean verificarCompetidor( Competidor comp ){
        boolean band = false;
        for( int i = 0; i < cChico.size(); i++){
            if( cChico.get(i).getDni() == comp.getDni() ){
                System.out.println("El participante con DNI " +
                        comp.getDni() +
                        " ya se encuentra inscrito en el circuito chico.");
                band = true;
            }

        }

        for( int i = 0; i < cMedio.size(); i++){
            if( cMedio.get(i).getDni() == comp.getDni() ){
                System.out.println("El participante con DNI " +
                        comp.getDni() +
                        " ya se encuentra inscrito en el circuito medio.");
                band = true;
            }

        }

        for( int i = 0; i < cAvanzado.size(); i++){
            if( cAvanzado.get(i).getDni() == comp.getDni() ){
                System.out.println("El participante con DNI " +
                        comp.getDni() +
                        " ya se encuentra inscrito en el circuito avanzado.");
                band = true;
            }

        }
        return band;
    }

    public void inscribirCompetidor(Competidor comp){
        System.out.println("Ingrese tipo circuito: 1-Chico; 2-Medio; 3-Avanzado ->");
        int tipoCircuito = entradaEscaner.nextInt();
        int numCompetidor = 0;
        switch (tipoCircuito){

            case 1:
                numCompetidor = cChico.size() + 1;
                comp.setNumParticipante(numCompetidor);

                if( comp.getEdad() < 18 ){
                    comp.setPagoInscripcion(1300);
                }else{
                    comp.setPagoInscripcion(1500);
                }

                cChico.add(comp);
                System.out.println("Competidor inscrito en Circuito Chico con número " +
                        cChico.get(numCompetidor-1).getNumParticipante());
                System.out.println("El participante debe pagar: $" + cChico.get(numCompetidor-1).getPagoInscripcion());
                break;
            case 2:
                numCompetidor = cMedio.size() + 1;
                comp.setNumParticipante(numCompetidor);

                if( comp.getEdad() < 18 ){
                    comp.setPagoInscripcion(2000);
                }else{
                    comp.setPagoInscripcion(2300);
                }

                cMedio.add(comp);
                System.out.println("Competidor inscrito en Circuito Médio con número " +
                        cMedio.get(numCompetidor-1).getNumParticipante());
                System.out.println("El participante debe pagar: $" + cMedio.get(numCompetidor-1).getPagoInscripcion());
                break;
            case 3:
                numCompetidor = cAvanzado.size() + 1;
                comp.setNumParticipante(numCompetidor);

                if( comp.getEdad() < 18 ){
                    System.out.println("El participante no puede competir por ser menor de edad");
                }else{
                    comp.setPagoInscripcion(2800);
                    cAvanzado.add(comp);
                    System.out.println("Competidor inscrito en Circuito Avanzado con número " +
                            cAvanzado.get(numCompetidor-1).getNumParticipante());
                    System.out.println("El participante debe pagar: $" + cAvanzado.get(numCompetidor-1).getPagoInscripcion());
                }

                break;
            default:
                System.out.println("¡Introdujo una opción incorrecta!");
        }
    }

    public void mostrarInscritos(){
        System.out.println("Ingrese tipo circuito: 1-Chico; 2-Medio; 3-Avanzado ->");
        int tipoCircuito = entradaEscaner.nextInt();
        List<Competidor> competidores = new ArrayList<Competidor>();

        switch (tipoCircuito){
            case 1:
                competidores = cChico;
                break;
            case 2:
                competidores = cMedio;
                break;
            case 3:
                competidores = cAvanzado;
                break;
            default:
                System.out.println("¡Introdujo una opción incorrecta!");
        }

        System.out.println("# \t DNI \t Nombre \t Edad");
        for(Competidor comp : competidores){
            System.out.println(comp.getNumParticipante() + "\t" + comp.getDni() +"\t" + comp.getNombre() + "\t" + comp.getEdad());
        }
    }

    public void eliminarCompetidor(){
        System.out.println("Ingrese tipo circuito: 1-Chico; 2-Medio; 3-Avanzado ->");
        int tipoCircuito = entradaEscaner.nextInt();

        System.out.println("Ingrese número competidor: ");
        int numCompetidor = entradaEscaner.nextInt();

        List<Competidor> competidores = new ArrayList<Competidor>();

        switch (tipoCircuito){
            case 1:
                competidores = cChico;
                break;
            case 2:
                competidores = cMedio;
                break;
            case 3:
                competidores = cAvanzado;
                break;
            default:
                System.out.println("¡Introdujo una opción incorrecta!");
        }

        competidores.remove(numCompetidor-1);

        for( int i = 1; i <= competidores.size(); i++){
            competidores.get(i-1).setNumParticipante(i);
        }
    }

    public void menu(){

        boolean salir = false;

        do {
            System.out.println("Ingrese opción: 1-Inscribir; 2-Mostrar; 3-Desincribir; 4-Salir ->");
            int opcion = entradaEscaner.nextInt();
            
            switch (opcion) {
                case 1:
                    Competidor comp = inscribirCompetidor();

                    boolean vCompetidor = verificarCompetidor(comp);

                    if (!vCompetidor) {
                        inscribirCompetidor(comp);
                    }

                    break;
                case 2:
                    mostrarInscritos();
                    break;
                case 3:
                    eliminarCompetidor();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("¡Introdujo una opción incorrecta!");

            }
        }while (!salir);
    }

    public static void main(String[] args){

        Main main = new Main();

        Competidor comp1 = new Competidor(1234,"Ana","Lopez",19,1234567,9876543,"O+");
        main.cAvanzado.add(comp1);

        main.menu();

    }

}
