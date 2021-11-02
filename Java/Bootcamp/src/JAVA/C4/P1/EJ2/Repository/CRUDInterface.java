package JAVA.C4.P1.EJ2.Repository;

import java.util.List;

public interface CRUDInterface<T> {
    public void alta(T objeto);

    public void mostrarGeneral();

    public void mostrarParticular(Integer identificador);

    public List<T> devolverLista();
}
