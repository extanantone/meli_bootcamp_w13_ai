package com.example.socialmeli.utils;

@FunctionalInterface
public interface Sorter <T>{
    int sort(T first , T second);
}
