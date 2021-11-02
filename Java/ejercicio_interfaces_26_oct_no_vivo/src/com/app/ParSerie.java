package com.app;

public class ParSerie extends Serie{

    private int val;

    public ParSerie(){
        restart();
    }

    @Override
    public int next() {
        int current = 2*val;
        val++;
        return current;
    }

    @Override
    public void restart() {
        val=1;
        
    }

    @Override
    public void restarWithValue(Number n) {
        val = n.intValue();
        
    }
    
}
