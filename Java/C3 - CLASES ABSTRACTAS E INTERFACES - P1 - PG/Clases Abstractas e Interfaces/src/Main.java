import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Participante> participantes = new ArrayList<>();
        Participante participante1 = new Participante();
        Nave nave1 = new Nave("nave1", new Coordenadas(1, 1));
        participante1.setNaves(nave1);

        Participante participante2 = new Participante();
        List<ObjetoJuego> flota = new ArrayList<>();
        Nave nave2 = new Nave("nave2", new Coordenadas(10, 10));
        Nave nave3 = new Nave("nave3", new Coordenadas(9, 9));
        Nave nave4 = new Nave("nave4", new Coordenadas(8, 8));
        flota.add(nave2);
        flota.add(nave3);
        flota.add(nave4);
        Flota flotaParticipante2 = new Flota(flota);
        participante2.setNaves(flotaParticipante2);

        participantes.add(participante1);
        participantes.add(participante2);

        List<Coordenadas> coords = new ArrayList<>();
        coords.add(new Coordenadas(2, 3));

        double puntuacionNave1 = 0;
        double puntuacionNave2 = 0;
        for (Coordenadas coordenas: coords) {
            double distanciaParticipante1 = participante1.getNaves().calcularDistancia(coords.get(0).getPosX(), coords.get(0).getPosY());
            double distanciaParticipante2 = participante2.getNaves().calcularDistancia(coords.get(0).getPosX(), coords.get(0).getPosY());
            System.out.println("------------------------------------");
            System.out.println("Coordenadas: X="+coordenas.getPosX()+" Y="+coordenas.getPosY());
            if (distanciaParticipante1 < distanciaParticipante2) {
                puntuacionNave1++;
                System.out.println("Ganador participante 1");
            } else {
                puntuacionNave2++;
                System.out.println("Ganador participante 2");
            }
            System.out.println("------------------------------------");
        }
        System.out.println("\n------------------------------------");
        System.out.println("Nave 1: Puntuacion: "+ puntuacionNave1);
        System.out.println("Nave 2: Puntuacion: "+ puntuacionNave2);
        System.out.println("------------------------------------\n");
        System.out.println("Ganador "+ ((puntuacionNave1 > puntuacionNave2) ? "Nave 1" : "Nave 2"));
    }


}
