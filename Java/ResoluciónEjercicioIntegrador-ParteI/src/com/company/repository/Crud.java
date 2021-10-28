package com.company.repository;

import java.util.List;
import java.util.Optional;

public interface Crud<T> {

    public void save (T obj);
    public void view();
    public Optional<T> search(Long id);
    public void delete(Long id);
    public List<T> get();
}
