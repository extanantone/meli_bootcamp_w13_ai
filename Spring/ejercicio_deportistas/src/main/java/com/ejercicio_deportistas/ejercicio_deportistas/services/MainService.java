package com.ejercicio_deportistas.ejercicio_deportistas.services;

import com.ejercicio_deportistas.ejercicio_deportistas.model.Person;
import com.ejercicio_deportistas.ejercicio_deportistas.model.Sport;

import java.util.ArrayList;
import java.util.List;

public class MainService {
    private Sport futbol=new Sport("futbol","Dificil");
    private Sport tenis=new Sport("tenis","Dificil");
    private Sport atletismo=new Sport("atletismo","Media");

    private ArrayList<Sport> sportList= new ArrayList<>();
    //ArrayList();//(ArrayList<Sport>) List.of(futbol,tenis,atletismo);


    private Person person1=new Person("Ivan","Arevalo",24, List.of(futbol,atletismo));
    private Person person2=new Person("Juana","Diaz",24, List.of(futbol));
    private Person person3=new Person("Miguel","Santana",24, List.of(tenis));

    private ArrayList<Person> personList=new ArrayList<>();

    public MainService() {
        sportList.add(futbol);
        sportList.add(tenis);
        sportList.add(atletismo);
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
    }

    public ArrayList<Sport> getSportList() {
        return sportList;
    }

    public void setSportList(ArrayList<Sport> sportList) {
        this.sportList = sportList;
    }

    public String levelSport(String name) {
        String level="";
        for (Sport sport: sportList
             ) {
            if(sport.getName().equals(name)){
                level=sport.getLevel();

            }
        }
        return level;
    }
}
