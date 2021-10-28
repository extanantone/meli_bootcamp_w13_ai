package Ejercicio1AgenciaTurismo;

public class Viajero {

    private String documentoIdentidad;

    private String nombre;

    public Viajero(String documentoIdentidad, String nombre) {
        this.documentoIdentidad = documentoIdentidad;
        this.nombre = nombre;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
