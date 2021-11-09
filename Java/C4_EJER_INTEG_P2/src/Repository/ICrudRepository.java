package Repository;

import java.util.List;

public interface ICrudRepository<T>
{
    boolean create(T object);

    T read(Long id);

    boolean update(Long codigo, T object);

    boolean delete(Long codigo);

    List<T> readAll();
}
