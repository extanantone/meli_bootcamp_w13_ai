package com.app.game.elements;

public class Asteroid{

    private Point position;

    private boolean destroy= false;

    public Asteroid(Point position){
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public boolean isDestroy() {
        return destroy;
    }

    public void destroyAsteroid(){
        this.destroy = true;
    }



}
