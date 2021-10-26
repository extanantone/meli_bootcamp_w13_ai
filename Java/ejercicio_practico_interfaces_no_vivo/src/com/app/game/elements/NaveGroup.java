package com.app.game.elements;

import java.util.ArrayList;
import java.util.List;

public class NaveGroup  extends Positionable{

    private static int number = 0;

    private List<Nave> naves;

    private int id;


    public NaveGroup(){
        this.naves = new ArrayList<>();
        this.id = number;
        number++;
    }

    public NaveGroup(List<Nave> naves){
        this.naves = naves;
    }

    public void addNave(Nave nave){
        naves.add(nave);
    }

    @Override
    public double getDistance(Point point) {
        if(naves.size()==0 || naves==null)return Double.MAX_VALUE;
        double acum = 0;
        for(Nave n:naves){
            acum+=n.getDistance(point);
        }
        return acum/naves.size();
    }

    public int getId() {
        return id;
    }

    
}
