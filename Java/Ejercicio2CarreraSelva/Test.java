package Ejercicio2CarreraSelva;

import java.util.Map;

public class Test {

    public static void main(String[] args) {

        Competencia c = new Competencia();

        Participante p1 = new Participante(1010,"Juan","Guerrero",26,20394059,123,"O+");

        Participante p2 = new Participante(1010,"Fito","Paez",50,4343434,2,"A+");

        Participante pMenor = new Participante(1010,"menor","menor",10,20394059,13,"O-");

        c.agregarParticipante(p1,Categorias.CHICO);

        c.agregarParticipante(p2,Categorias.MEDIO);

        Map<Integer,Participante> participantes = c.listarParticipantes();

        participantes.forEach((id, participante) -> {
            System.out.println("llave : " + id + "\nObjeto: " + participante);
        });



    }

}
