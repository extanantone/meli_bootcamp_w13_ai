package com.example.test.SpringAnottations.model;

public class Employee {


    private long legajo;

    public Employee(long legajo) {
        this.legajo = legajo;
    }

    public long getLegajo() {
        return legajo;
    }

    public void setLegajo(long legajo) {
        this.legajo = legajo;
    }
}
