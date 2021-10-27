import java.util.List;


public class Garaje {

    long identificador;
    List<Vehiculo> lista;

    public Garaje(long identificador, List<Vehiculo> lista) {
        this.identificador = identificador;
        this.lista = lista;
    }

    public Garaje(){}

    public Garaje(long identificador){
        this.identificador = identificador;
    }


    public long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    }

    public List<Vehiculo> getLista() {
        return lista;
    }

    public void setLista(List<Vehiculo> lista) {
        this.lista = lista;
    }


}
