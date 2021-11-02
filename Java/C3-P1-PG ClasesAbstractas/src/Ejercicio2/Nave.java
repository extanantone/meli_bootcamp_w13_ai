package Ejercicio2;

public class Nave {
    private String nombre;
    private double pos_X;
    private double pos_Y;
    private int puntuacion;

    public Nave(String nombre, double pos_X, double pos_Y) {
        this.nombre = nombre;
        this.pos_X = pos_X;
        this.pos_Y = pos_Y;
        this.puntuacion= 0;
    }

    public Nave() {
        this.nombre = "Nave defecto";
        this.pos_X = 0.0;
        this.pos_Y = 0.0;
        this.puntuacion= 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPos_X() {
        return pos_X;
    }

    public void setPos_X(double pos_X) {
        this.pos_X = pos_X;
    }

    public double getPos_Y() {
        return pos_Y;
    }

    public void setPos_Y(double pos_Y) {
        this.pos_Y = pos_Y;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Nave{" +
                "nombre='" + nombre + '\'' +
                ", pos_X=" + pos_X +
                ", pos_Y=" + pos_Y +
                ", puntuacion=" + puntuacion +
                '}';
    }


}
