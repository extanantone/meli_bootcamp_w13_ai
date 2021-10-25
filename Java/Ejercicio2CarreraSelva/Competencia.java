package Ejercicio2CarreraSelva;

import java.util.HashMap;

public class Competencia {

    private int idParticipante;

    private HashMap<Integer,Participante> participantes;

    private static int contadorParticipantes;

    public Competencia(){
        this.participantes = new HashMap<>();
    }

    public int agregarParticipante(Participante p, Categorias c){

        p.setCategoria(c);

        switch (c){
            case CHICO:
                p.setCostoInscripcion((p.getEdad()<18)?1300:1500);
                this.idParticipante=++Competencia.contadorParticipantes;
                participantes.put(idParticipante,p);
                return 0;
            case MEDIO:
                p.setCostoInscripcion((p.getEdad()<18)?2000:2300);
                this.idParticipante=++Competencia.contadorParticipantes;
                participantes.put(idParticipante,p);
                return 0;
            case AVANZADO:

                if(p.getEdad()<18){
                    return -1;
                }else{
                    p.setCostoInscripcion(2800);
                    this.idParticipante=++Competencia.contadorParticipantes;
                    participantes.put(idParticipante,p);
                    return 0;
                }

        }
        return -1;
    }

    public HashMap listarParticipantes(){
        return (HashMap) participantes.clone();
    }







}
