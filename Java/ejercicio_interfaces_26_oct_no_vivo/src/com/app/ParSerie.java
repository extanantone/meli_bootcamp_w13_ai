package com.app;

public class ParSerie extends Serie{

    private int val;

    public ParSerie(){
        val = 1;
    }

    @Override
    public int next() {
        int current = 2*val;
        val++;
        return current;
    }
    
}
