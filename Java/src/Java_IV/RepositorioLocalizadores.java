package Java_IV;

import java.util.ArrayList;

public class RepositorioLocalizadores {
    private ArrayList<Localizador> listaLocalizador = new ArrayList<>();

    public void addLocalizador(Localizador localizador) {
        listaLocalizador.add(localizador);
    }

    public ArrayList<Localizador> getListaLocalizador() {
        return listaLocalizador;
    }

    @Override
    public String toString() {
        return "RepositorioLocalizadores:" + "\n" +
                  listaLocalizador +"\n"
                ;
    }
}
