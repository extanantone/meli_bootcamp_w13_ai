package com.company.model.promocion;

import com.company.model.Localizador;
import com.company.model.item.ItemLocalizador;

import java.util.List;

public class LocalizadorX2 extends Promocion {
    List<Localizador> localizadorUser;

    public LocalizadorX2(List<Localizador> localizadorUser) {
        super(5);
        this.localizadorUser = localizadorUser;
    }

    @Override
    protected boolean cumpleCondicion() {
        return localizadorUser.size() > 2;
    }

}
