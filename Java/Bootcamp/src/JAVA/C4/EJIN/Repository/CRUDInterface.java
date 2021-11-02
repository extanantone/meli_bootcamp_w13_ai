package JAVA.C4.EJIN.Repository;

import java.util.List;

public interface CRUDInterface<T> {
    public void alta(T objeto);

    public void baja(Integer identificador);

    public void consultaGeneral();

    public void consultaParticular(Integer identificador);

    public List<T> traerLista();
}
