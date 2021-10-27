package ejericiciopractico.e2;

import java.util.ArrayList;
import java.util.List;

/**
 * la flota sabe como ubicar a sus naves integrantes y definir su ubicacion promedio
 */
public class CompositeFlota extends EntidadEspacial implements Puntuable{

    List<NaveSimple> listaNaves = new ArrayList<>();

    public CompositeFlota(String nombre) {
        super(nombre);
    }

    public void anadirNave(NaveSimple nave){
        listaNaves.add(nave);
    }

    @Override
    public double calcularDistancia(int targetX, int targetY) {
        if(!listaNaves.isEmpty())
        {
            double sumaDistancias = 0;
            for(NaveSimple nave:listaNaves)
            {
                sumaDistancias += nave.calcularDistancia(targetX,targetY);
            }
            return sumaDistancias/listaNaves.size();
        }
        else
            return -1;
    }

    @Override
    public void puntuar() {
        setPuntuacion(getPuntuacion()+1);
    }

    @Override
    public Long obtenerPuntuacion() {
        return getPuntuacion();
    }

    @Override
    public String obtenerIdentificacion() {
        return getNombre();
    }
}
