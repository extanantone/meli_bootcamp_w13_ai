package Supermercado;

public interface CRUD<T, K> {
    public void alta(T data);
    public T consulta(K info);
    public void modificacion(T data);
    public T baja(K info);
}
