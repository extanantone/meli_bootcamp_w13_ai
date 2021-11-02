package com.app;

public class ThirdSerie extends Serie{

    private int val;

    public ThirdSerie(){
        restart();;
    }

    @Override
    public int next() {
        int current = 3*val;
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
