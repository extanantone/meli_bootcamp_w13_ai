package com.app;

public class ThirdSerie extends Serie{

    private int val;

    public ThirdSerie(){
        val=1;
    }

    @Override
    public int next() {
        int current = 3*val;
        val++;
        return current;
    }
    
}
