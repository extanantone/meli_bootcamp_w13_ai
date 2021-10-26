package com.app.game;

import java.util.ArrayList;
import java.util.List;
import com.app.game.elements.Positionable;
import com.app.game.elements.Asteroid;
import com.app.game.elements.Nave;
import com.app.game.elements.NaveGroup;
import com.app.game.elements.Point;

public class Board {

    private List<Positionable> positionables;
    private List<Nave> naves;
    private List<NaveGroup> groups;
    private List<Asteroid> asteroids;
    private static int pointsWinner = 20;

    public Board(){
        positionables = new ArrayList<>();
        naves = new ArrayList<>();
        groups = new ArrayList<>();
        asteroids = List.of(new Asteroid(new Point(0, 0)),new Asteroid(new Point(100, 100)), new Asteroid(new Point(0, 100)));
    }

    public void Inscribe(Nave nave){
        naves.add(nave);
        positionables.add(nave);
    }

    public void Inscribe(NaveGroup group){
        groups.add(group);
        positionables.add(group);
    }

    public List<Nave> getNaves() {
        return naves;
    }

    public List<NaveGroup> getGroups() {
        return groups;
    }

    public void attackAsteroid(Point position){
        Asteroid asteroid = getAsteroid(position);
        if(asteroid!=null && !asteroid.isDestroy()){
            Positionable p = getMinDistance(position);
            p.addPoints(pointsWinner);
            asteroid.destroyAsteroid();
        }
    }

    private Positionable getMinDistance(Point position){
        Positionable p;
        double distance = Double.MAX_VALUE;
        if(positionables.size()==0)p=null;
        else p=positionables.get(0);
        for(Positionable positionable:positionables){
            double dp = positionable.getDistance(position);
            if(dp<distance){
                distance = dp;
                p = positionable;
            }
        }
        return p;

    }

    private Asteroid getAsteroid(Point point){
        for(Asteroid a:asteroids){
            if(a.getPosition().equals(point)) return a;
        }
        return null;
    }

    
}
