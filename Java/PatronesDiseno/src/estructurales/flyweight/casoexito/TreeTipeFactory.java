package estructurales.flyweight.casoexito;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TreeTipeFactory {
    static Map<String,TreeType> tiposArboles = new HashMap<>();

    public static TreeType getTreeType(String nombre, Color color, String otraData){
        TreeType resultado = tiposArboles.get(nombre);
        if(resultado == null)
        {
            resultado = new TreeType(nombre,color,otraData);
            tiposArboles.put(nombre,resultado);
        }
        return resultado;
    }

}
