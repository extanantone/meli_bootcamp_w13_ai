package com.app.crud;

import java.util.List;

public interface CrudRepository<T,M> {
    public void add(T elm);
    public List<T> getAll();
    public T getOne(M id); 
}
