package com.mercadolibre;

public class Person {

    String name;
    int age;
    String dni;
    double weight;
    double height;

    public Person() {}

    public Person(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Person(String name, int age, String dni, double weight, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }

    public int calculateBMI() {
        double bmi = weight/(Math.pow(height, 2.0));
        if (bmi < 20.0) {
            return -1;
        } else if (bmi <= 25.0) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean isAdult() {
        return age >= 18;
    }

    @Override
    public String toString() {
        return name + " DNI=" + dni + ".";
    }
}
