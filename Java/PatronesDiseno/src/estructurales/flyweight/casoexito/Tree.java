package estructurales.flyweight.casoexito;

import java.awt.*;

public class Tree {
    private int x;
    private int y;
    private TreeType tipoArbol;

    public Tree(int x, int y, TreeType tipoArbol) {
        this.x = x;
        this.y = y;
        this.tipoArbol = tipoArbol;
    }

    public void dibujar(Graphics g){
        tipoArbol.dibujar(g,x,y);
    }
}
