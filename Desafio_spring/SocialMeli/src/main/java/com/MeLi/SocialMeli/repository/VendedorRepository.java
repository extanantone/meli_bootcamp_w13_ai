package com.MeLi.SocialMeli.repository;

import com.MeLi.SocialMeli.exception.NotFoundVendedorException;
import com.MeLi.SocialMeli.model.Comprador;
import com.MeLi.SocialMeli.model.Usuario;
import com.MeLi.SocialMeli.model.Vendedor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Repository
public class VendedorRepository implements VendedorRepositoryImplement{

    HashMap<Integer, Vendedor> vendedores = new HashMap();

    public VendedorRepository(){
        Vendedor vendedor1 = new Vendedor(1,"Juan");
        vendedores.put(vendedor1.getId(),vendedor1);

        Vendedor vendedor2 = new Vendedor(2,"Camilo");
        vendedores.put(vendedor2.getId(),vendedor2);

        Vendedor vendedor3 = new Vendedor(3,"Andrés");
        vendedores.put(vendedor3.getId(),vendedor3);
    }

    @Override
    public Set<Map.Entry<Integer, Vendedor>> findAll() {
        return vendedores.entrySet();
    }

    @Override
    public Optional<Vendedor> find(Integer id){
        if( vendedores.containsKey( id ) ) {
            return Optional.of(vendedores.get(id));
        }
        return Optional.empty();
    }
}
