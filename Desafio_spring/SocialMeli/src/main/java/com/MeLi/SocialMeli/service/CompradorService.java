package com.MeLi.SocialMeli.service;

import com.MeLi.SocialMeli.DTO.SeguimientoDTO;
import com.MeLi.SocialMeli.DTO.VendedorDTO;
import com.MeLi.SocialMeli.exception.NotFoundCompradorException;
import com.MeLi.SocialMeli.exception.NotFoundVendedorException;
import com.MeLi.SocialMeli.model.Comprador;
import com.MeLi.SocialMeli.model.Vendedor;
import com.MeLi.SocialMeli.repository.CompradorRepositoryImplement;
import com.MeLi.SocialMeli.repository.VendedorRepositoryImplement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompradorService implements CompradorServiceImplement {

    private CompradorRepositoryImplement compradorRepositoryImplement;
    private VendedorRepositoryImplement vendedorRepositoryImplement;

    public CompradorService(CompradorRepositoryImplement compradorRepositoryImplement, VendedorRepositoryImplement vendedorRepositoryImplement){
        this.compradorRepositoryImplement = compradorRepositoryImplement;
        this.vendedorRepositoryImplement = vendedorRepositoryImplement;
    }


    @Override
    public SeguimientoDTO seguir(int idSeguidor, int idSeguido) throws NotFoundCompradorException, NotFoundVendedorException {
        Comprador comprador = compradorRepositoryImplement.find(idSeguidor).orElseThrow(() -> new NotFoundCompradorException(idSeguidor));
        Vendedor vendedor = vendedorRepositoryImplement.find(idSeguido).orElseThrow(()->new NotFoundVendedorException(idSeguido));
        comprador.setSeguido(idSeguido,vendedor);
        vendedor.setSeguidor(idSeguidor,comprador);
        return new SeguimientoDTO(comprador.getId(),comprador.getNombre(),vendedor.getId(),vendedor.getNombre(),"Seguimiento exitoso.");
    }

    @Override
    public List<VendedorDTO> verSeguidos() {
        return null;
    }

    @Override
    public int getCantidadSeguidos() {
        return 0;
    }

    @Override
    public void anadirSeguido(Comprador comprador) {

    }
}
