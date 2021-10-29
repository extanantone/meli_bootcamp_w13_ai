import java.util.ArrayList;
import java.util.List;

public class Localizadores {
    private List<Paquete> listaPaquetes;
    private double costo;

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Localizadores() {
        this.listaPaquetes = new ArrayList<Paquete>();
        this.costo = 0;
    }

    public List<Paquete> getListaPaquetes() {
        return listaPaquetes;
    }

    public void setListaPaquetes(Paquete listaPaquetes) {
        this.listaPaquetes.add(listaPaquetes);
        this.costo = this.costo + listaPaquetes.getCostoTotal();
    }

    public void aplicarDescuento(){
        int cantTipos[] = {0,0};
        for (Paquete r: listaPaquetes){
            if(r.isBoletos()){
                cantTipos[0]++;
            }else if (r.isHotel()){
                cantTipos[1]++;
            }
        }
        if (cantTipos[0] >=2 || cantTipos[1] >= 2){
            this.costo = 0;
            for (Paquete r: listaPaquetes){
                r.setCostoHotel(r.getCostoHotel()*0.95);
                r.setCostoBoletos(r.getCostoBoletos()*0.95);
                this.costo = this.costo + r.getCostoTotal();
            }
        }
    }
}
