import java.util.Map;

public class main {
    public static void main(String[] args) {
        Categoria circuito_chico = new Categoria("Circuito chico",2,1300,1500);
        Categoria circuito_medio = new Categoria("Circuito medio",5,2000,2300);
        Categoria circuito_avanzado = new Categoria("Circuito avanzado",10,-1,2800);

        Persona p1 = new Persona(50989324,"Santiago","Acevedo", (short) 17);
        Persona p2 = new Persona(123123,"Roberto","Perez", (short) 18);
        Persona p3 = new Persona(321321,"Pablo","Gonzales", (short) 15);
        Persona p4 = new Persona(52345,"Damian","Diaz", (short) 18);
        Persona p5 = new Persona(235353512,"Jane","Doe", (short) 13);
        Persona p6 = new Persona(12312348,"Mario","Ferrari", (short) 18);

        circuito_medio.setParticipante(p1.getDni(),p1);
        circuito_medio.setParticipante(p2.getDni(),p2);
        circuito_chico.setParticipante(p3.getDni(),p3);
        circuito_chico.setParticipante(p4.getDni(),p4);
        circuito_avanzado.setParticipante(p5.getDni(),p5);
        circuito_avanzado.setParticipante(p6.getDni(),p6);

        for(Map.Entry<Integer,Persona> p : circuito_chico.getParticipantes().entrySet()){
            System.out.println("Participante " + p.getValue().getNombre() +" "+ p.getValue().getApellido());
        }

        circuito_chico.deleteParticipante(52345);

        for(Map.Entry<Integer,Persona> p : circuito_chico.getParticipantes().entrySet()){
            System.out.println("Participante " + p.getValue().getNombre() +" "+ p.getValue().getApellido());
        }
    }
}
