package com.app;

public class Inscription {

    public int id;

    public int dni;

    public String nombre;

    public String apellido;

    public String celular;

    public int edad;

    public String emergencia;

    public Inscription(){

    }

    public Inscription(int dni,String nombre,String apellido,String celular,int edad,String emergencia){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido=apellido;
        this.celular=celular;
        this.edad=edad;
        this.emergencia = emergencia;

    }

    public int getPriceByCategory(String category){
        if(category.equals("Chico") && edad<18){
            return 1300;
        }else if(category.equals("Chico")){
            return 1500;
        }
        else if(category.equals("Medio") && edad<18){
            return 2000;
        }else if(category.equals("Medio")){
            return 2300;
        }
        else if(category.equals("Avanzado")){
            return 2800;
        }
        return 0;
    }
    
    public boolean equals(Object o){
        if(!(o instanceof Inscription)) return false;
        return ((Inscription) o).dni==dni;
    }
    
}
