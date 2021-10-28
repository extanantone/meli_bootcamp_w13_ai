package agenciaDeViajes;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String apellido;
    private String ci;
    private String email;
    private boolean tieneDescuento;
    private int cantLocalizadores;

    public Cliente(String nombre, String apellido, String ci, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
        this.email = email;
        this.tieneDescuento = false;
        this.cantLocalizadores = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCi() {
        return ci;
    }

    public String getEmail() {
        return email;
    }

    public boolean getTieneDescuento() {
        return tieneDescuento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTieneDescuento(boolean tieneDescuento) {
        this.tieneDescuento = tieneDescuento;
    }

    public void addLocalizador() {
        cantLocalizadores++;
        if (cantLocalizadores > 2) {
            this.tieneDescuento = true;
        }
    }

    public String toString() {
        return "Nombre: " + nombre +
                " Apellido: " + apellido +
                " CI: " + ci+
                " Email: " + email;
    }
}
