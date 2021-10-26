package com.app.game.elements;

public abstract class Positionable {

    protected int points = 0;

    public abstract double getDistance(Point point);

    public int getPoints() {
        return points;
    }

    public void addPoints(int points){
        this.points+=points;
    }
    
}
