package com.Meli.Deportista.Model;

public class Sport {
    private String name;
    private String level;

    public void Sport(){
        this.name="";
        this.level = "";
    }

    public Sport(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
