package estructurales.adapter;


public class HuecoRedondo {

    private double radio;

    public HuecoRedondo(int radio) {
        this.radio = radio;
    }

    public double getRadio(){
        return this.radio;
    }

    public boolean medir(PiezaRedonda pieza){
        return (this.getRadio() >= pieza.getRadio());
    }

    public void probarCabe(PiezaRedonda pieza){
        if(medir(pieza))
            System.out.println(" si cabe!");
        else
            System.out.println("no cabe");
    }
}
