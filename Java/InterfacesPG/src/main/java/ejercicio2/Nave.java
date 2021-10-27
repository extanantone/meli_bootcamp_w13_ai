package ejercicio2;

public class Nave implements Apuntable {
    private String nombre;
    private int x;
    private int y;

    public Nave(String nombre, int x, int y) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
    }

    public String getNombre() {
        return nombre;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public double getDistance(int targetX,int targetY) {
        return Math.sqrt(Math.pow(getX()-targetX,2)+Math.pow(getY()-targetY,2));
    }

}
