package ejericiciopractico.p2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

public class Categorias {

    private String tipo;
    private Double valorMenoresEdad;
    private Double valorMayoresEdad;
    private Map<Long,Participante> listaParts;
    private Long indiceCategoria;

    public Categorias(String tipo, Double valorMenoresEdad, Double valorMayoresEdad, Long indiceCategoria) {
        this.tipo = tipo;
        this.valorMenoresEdad = valorMenoresEdad;
        this.valorMayoresEdad = valorMayoresEdad;
        this.listaParts = new HashMap<>();
        this.indiceCategoria = indiceCategoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValorMenoresEdad() {
        return valorMenoresEdad;
    }

    public void setValorMenoresEdad(Double valorMenoresEdad) {
        this.valorMenoresEdad = valorMenoresEdad;
    }

    public Double getValorMayoresEdad() {
        return valorMayoresEdad;
    }

    public void setValorMayoresEdad(Double valorMayoresEdad) {
        this.valorMayoresEdad = valorMayoresEdad;
    }

    public Map<Long, Participante> getListaParts() {
        return listaParts;
    }

    public Long getIndiceCategoria() {
        return indiceCategoria;
    }

    public void setIndiceCategoria(Long indiceCategoria) {
        this.indiceCategoria = indiceCategoria;
    }

    public int anadirParticipante(Participante part,int cont){
        this.listaParts.put(part.getDni(),part);
        part.setConsecutivoUnico(cont);
        return cont+1;
    }
    public void borrarParticipante(long dni){
        this.listaParts.remove(dni);
    }
}
