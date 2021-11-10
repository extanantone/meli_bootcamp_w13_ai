package estructurales.flyweight.casoexito;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Bosque extends JFrame {
    private List<Tree> arboles = new ArrayList<>();

    public void agregarArbol(int x, int y, String nombre, Color color, String otraData){
        TreeType tipo = TreeTipeFactory.getTreeType(nombre,color,otraData);
        Tree arbol = new Tree(x,y,tipo);
        arboles.add(arbol);
    }

    @Override
    public void paint(Graphics g){
        for(Tree arbol:arboles)
        {
            arbol.dibujar(g);
        }
    }
}
