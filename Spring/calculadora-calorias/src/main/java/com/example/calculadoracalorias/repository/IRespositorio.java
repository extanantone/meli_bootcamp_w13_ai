package com.example.calculadoracalorias.repository;

public interface IRespositorio<T> {
    T guardarElemento(T t);
    T obtenerElementoPorNombre(String nombreElemento);
}
