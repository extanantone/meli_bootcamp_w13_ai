package ClasesAbstractasEInterfaces.Asteroides;

import java.util.ArrayList;
import java.util.List;

public class FlotaDeNaves extends Entidad implements Puntuable{

    List<Nave> listaNaves = new ArrayList<>();

    public FlotaDeNaves(String nombre){
        super(nombre);
    }

    public void aniadirNave(Nave nave){
        listaNaves.add(nave);
    }

    @Override
    public double calcularDistancia(int x, int y) {
        if(listaNaves.size() > 0)
        {
            double sumaDistancias = 0;
            for(Nave nave:listaNaves)
            {
                sumaDistancias += nave.calcularDistancia(x,y);
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
