package com.MeLi.SocialMeli.service;

import com.MeLi.SocialMeli.DTO.SeguidoresDTO;
import com.MeLi.SocialMeli.exception.NotFoundVendedorException;
import com.MeLi.SocialMeli.model.Vendedor;
import com.MeLi.SocialMeli.repository.VendedorRepositoryImplement;
import org.springframework.stereotype.Service;

@Service
public class VendedorService implements VendedorServiceImplement{

    private VendedorRepositoryImplement vendedorRepositoryImplement;

    public VendedorService(VendedorRepositoryImplement vendedorRepositoryImplement){
        this.vendedorRepositoryImplement = vendedorRepositoryImplement;
    }

    @Override
    public SeguidoresDTO contarSeguidores(int idVendedor) throws NotFoundVendedorException {
        Vendedor vendedor = vendedorRepositoryImplement.find(idVendedor).orElseThrow(() -> new NotFoundVendedorException(idVendedor));
        return new SeguidoresDTO(vendedor.getId(),vendedor.getNombre(),vendedor.getCantSeguidores());
    }
}
