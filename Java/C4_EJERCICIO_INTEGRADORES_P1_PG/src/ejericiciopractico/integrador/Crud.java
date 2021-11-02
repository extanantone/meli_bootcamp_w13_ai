package ejericiciopractico.integrador;

public interface Crud<T>{
    public boolean crear(T dato);
    public boolean modificar(T dato);
    public boolean delete(T dato);
    public T consultar(String uuid);
    public void consultaGeneral();
}
