package vivo_I;

import vivo_I.reserva.Reserva;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Localizador  {

    private Double total;
    private HashMap<String,List<Reserva>> reservas = new HashMap<>();
    private String nombre;
    private String apellido;
    private String id;
    private Integer nroLocalizador;


    public void setTotal(Double total) {
        this.total = total;
    }

    public Localizador(String id,String nombre, String apellido, Double total, Integer nroLocalizador) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.total = total;
        this.id = id;
        this.nroLocalizador = nroLocalizador;
    }

    public Integer getNroLocalizador() {
        return nroLocalizador;
    }

    public void setNroLocalizador(Integer nroLocalizador) {
        this.nroLocalizador = nroLocalizador;
    }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, List<Reserva>> getReservas() {
        return reservas;
    }

    public void setReservas(HashMap<String, List<Reserva>> reservas) {
        this.reservas = reservas;
    }

    public Double getTotal() {
        return total;
    }

    @Override
   public String toString() {
        return "valor total de la reserva: " + total;

    }






}
