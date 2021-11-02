package estructurales.composite;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * clase composite tiene una lista de elementos de la interface
 */
public class Flota implements Espacial{

    private List<Espacial> listaNaves = new ArrayList<>();

    public Flota(Espacial... naves) {
        listaNaves.addAll(Arrays.asList(naves));
    }

    /*
        indica como se mueve la flota completa
         */
    @Override
    public void moverse(long posx, long posy) {
        for(Espacial nave:this.listaNaves)
        {
            nave.moverse(posx,posy);
        }
    }

    @Override
    public String toString() {
        return "\nFlota{" +
                "\nlistaNaves=" + listaNaves +
                '}';
    }
}
