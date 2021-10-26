package com.app.game.elements;

public class Point {

    private int x;
    private int y;

    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Point)) return false;
        Point p = (Point) obj;
        return p.getX()==x && p.getY()==y;
    }

}
