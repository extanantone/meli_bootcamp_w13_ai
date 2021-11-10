package estructurales.flyweight.casoexito;

import java.awt.*;

public class TreeType {
    private String nombre;
    private Color color;
    private String otrosDatos;

    public TreeType(String nombre, Color color, String otrosDatos) {
        this.nombre = nombre;
        this.color = color;
        this.otrosDatos = otrosDatos;
    }

    public void dibujar(Graphics g,int x,int y){
        g.setColor(Color.BLACK);
        g.fillRect(x -1,y,3,5);
        g.setColor(color);
        g.fillOval(x-5,y-10,10,10);
    }


}
