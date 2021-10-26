import java.io.*;

public  class Automovil {

    String marca;
    String color;
    double kilometros;

        /*public Automovils() {
                return marca + color + kilometros;
        }*/

    public Automovil(String marca, String color, double kilometros) {
        this.marca = marca;
        this.color = color;
        this.kilometros = kilometros;
    }

    public String mostrarMarcaYColor() {
        String marcaYColor = "La marca del auto es: " + this.marca + ". El color del auto es: " + this.color;

        return marcaYColor;

    }

    public static void main(String[] args)
    {
        System.out.println("main");
        Automovil auto = new Automovil("dd","dd", 44);
        System.out.println(auto.mostrarMarcaYColor());

    }

}