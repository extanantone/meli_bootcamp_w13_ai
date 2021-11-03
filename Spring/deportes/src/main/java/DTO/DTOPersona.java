package DTO;

import com.example.deportes.model.Deporte;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DTOPersona implements Serializable {
    private String nombre;
    private String apellido;
    private int edad;
    private List<Deporte> deportes = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Deporte> getDeporte() {
        return deportes;
    }

    public void setDeporte(List<Deporte> deporte) {
        this.deportes = deporte;
    }
    public void agregarDeporte(Deporte deporte) {
        this.deportes.add(deporte);
    }
}
