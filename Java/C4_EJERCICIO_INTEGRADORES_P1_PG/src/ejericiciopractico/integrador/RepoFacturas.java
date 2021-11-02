package ejericiciopractico.integrador;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RepoFacturas implements Crud<Factura>{

    private static final List<Factura> facturasCreadas = new ArrayList<>();
    private static final Logger LOG = Logger.getLogger(RepoFacturas.class.getName());

    @Override
    public boolean crear(Factura dato) {
        if(facturasCreadas.stream().anyMatch(x->x.getNumeroFactura().equals(dato.getNumeroFactura())))
            return false;
        else
        {
            facturasCreadas.add(dato);
            return true;
        }
    }

    @Override
    public boolean modificar(Factura dato) {
        List<Factura> datosAntiguos = facturasCreadas.stream().filter(x->x.getNumeroFactura().equals(dato.getNumeroFactura())).toList();
        if(datosAntiguos.isEmpty())
            return false;
        else
        {
            Factura vieja = datosAntiguos.get(0);
            facturasCreadas.remove(vieja);
            facturasCreadas.add(dato);
            return true;
        }
    }

    @Override
    public boolean delete(Factura dato) {
        List<Factura> datosAntiguos = facturasCreadas.stream().filter(x->x.getNumeroFactura().equals(dato.getNumeroFactura())).toList();
        if(datosAntiguos.isEmpty())
            return false;
        else
        {
            Factura vieja = datosAntiguos.get(0);
            facturasCreadas.remove(vieja);
            return true;
        }
    }

    @Override
    public Factura consultar(String uuid) {
        if(uuid!=null)
        {
            AtomicLong numeroConsulta = new AtomicLong(-1);
            try{
                numeroConsulta.set(Long.parseLong(uuid));
            } catch(NumberFormatException e) {
                LOG.log(Level.SEVERE,"no se puedo convertir el dato a un uuid correcto");
                return null;
            }
            return facturasCreadas.stream().filter(x->x.getNumeroFactura().equals(numeroConsulta.get())).toList().get(0);
        }
        else
            return null;
    }

    @Override
    public void consultaGeneral() {
        System.out.println("La lsita de Facturas actuales son: ");
        for(Factura dato:facturasCreadas)
        {
            System.out.println(dato);
        }
    }
}
