package com.astractasEinterfeces.Ejercicio2;

public class Curriculums implements IImprimible{

    private String nombre;
    private String Apellido;
    private int edad;
    private String profecion;
    private String estudios;
    private String correo;
    private String telefono;


    public Curriculums(String nombre, String apellido, int edad, String profecion, String estudios, String correo, String telefono) {
        this.nombre = nombre;
        Apellido = apellido;
        this.edad = edad;
        this.profecion = profecion;
        this.estudios = estudios;
        this.correo = correo;
        this.telefono = telefono;
    }


    @Override
    public void imprimri() {
        System.out.println( toString());
    }


    @Override
    public String toString() {
        return "Curriculums{" +
                "nombre='" + nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", edad=" + edad +
                ", profecion='" + profecion + '\'' +
                ", estudios='" + estudios + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
