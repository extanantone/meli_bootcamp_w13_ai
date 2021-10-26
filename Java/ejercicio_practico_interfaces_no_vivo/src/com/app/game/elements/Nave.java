package com.app.game.elements;

public class Nave extends Positionable {

    private Point position;
    private String name;

    public Nave(String name,Point position){
        this.position = position;
        this.name = name;
    }

    public Point getPosition() {
        return position;
    }

    @Override
    public double getDistance(Point point) {
        double partial=  Math.pow(Math.abs(point.getX()-position.getX()),2)+Math.pow(point.getY()-position.getY(), 2);
        return Math.sqrt(partial);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points){
        if(points>0) this.points+=points;

    }
    
}
