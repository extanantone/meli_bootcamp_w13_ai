package com.mercadolibre;

public class Person {

    int id;
    long dni;
    String name;
    int age;

    public Person(int id, long dni, String name, int age) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", dni=" + dni +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
