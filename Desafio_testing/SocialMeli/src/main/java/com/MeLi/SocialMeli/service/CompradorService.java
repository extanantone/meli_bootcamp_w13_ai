package com.MeLi.SocialMeli.service;

import com.MeLi.SocialMeli.DTO.*;
import com.MeLi.SocialMeli.exception.NotFoundCompradorException;
import com.MeLi.SocialMeli.exception.NotFoundVendedorException;
import com.MeLi.SocialMeli.mapper.InfoSeguidosMapper;
import com.MeLi.SocialMeli.mapper.VendedorMapper;
import com.MeLi.SocialMeli.model.Comprador;
import com.MeLi.SocialMeli.model.Vendedor;
import com.MeLi.SocialMeli.repository.CompradorRepositoryImplement;
import com.MeLi.SocialMeli.repository.VendedorRepositoryImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CompradorService implements CompradorServiceImplement {

    @Autowired
    private CompradorRepositoryImplement compradorRepositoryImplement;
    @Autowired
    private VendedorRepositoryImplement vendedorRepositoryImplement;

    @Override
    public SeguimientoDTO seguir(int idSeguidor, int idSeguido) throws NotFoundCompradorException, NotFoundVendedorException {
        Comprador comprador = compradorRepositoryImplement.find(idSeguidor).orElseThrow(() -> new NotFoundCompradorException(idSeguidor));
        Vendedor vendedor = vendedorRepositoryImplement.find(idSeguido).orElseThrow(()->new NotFoundVendedorException(idSeguido));
        comprador.setSeguido(vendedor);
        vendedor.setSeguidor(comprador);
        return new SeguimientoDTO(comprador.getId(),comprador.getNombre(),vendedor.getId(),vendedor.getNombre(),"Seguimiento exitoso");
    }

    @Override
    public InfoSeguidosDTO verSeguidos(int idComprador, String order) throws NotFoundCompradorException, NotFoundVendedorException {

        Comprador comprador = compradorRepositoryImplement.find(idComprador).orElseThrow(() -> new NotFoundCompradorException(idComprador));
        HashMap<Integer, String> seguidos = comprador.getSeguidos();
        List<VendedorDTO> seguidosDatos = new ArrayList<>();

        for (Map.Entry<Integer, String> entry : seguidos.entrySet()) {
            Vendedor vendedor = vendedorRepositoryImplement.find(entry.getKey()).orElseThrow(() -> new NotFoundVendedorException(entry.getKey()));
            seguidosDatos.add(VendedorMapper.vendedorToVendedorDTO(vendedor));
        }

        if(order.equals("name_desc")){
            seguidosDatos = seguidosDatos.stream().sorted(Comparator.comparing(VendedorDTO::getUser_name).reversed()).collect(Collectors.toList());
        }else if(order.equals("name_asc")){
            seguidosDatos = seguidosDatos.stream().sorted(Comparator.comparing(VendedorDTO::getUser_name)).collect(Collectors.toList());
        }

        return InfoSeguidosMapper.infoSeguidosToInfoSeguidosDTO(comprador, seguidosDatos);
    }

    @Override
    public int getCantidadSeguidos() {
        return 0;
    }

    @Override
    public void anadirSeguido(Comprador comprador) {

    }

    @Override
    public SeguimientoDTO dejarSeguir(int idSeguidor, int idSeguido) throws NotFoundVendedorException, NotFoundCompradorException{
        Comprador comprador = compradorRepositoryImplement.find(idSeguidor).orElseThrow(() -> new NotFoundCompradorException(idSeguidor));
        Vendedor vendedor = vendedorRepositoryImplement.find(idSeguido).orElseThrow(()->new NotFoundVendedorException(idSeguido));
        comprador.unfollow(vendedor);
        vendedor.unfollowed(comprador);
        return new SeguimientoDTO(comprador.getId(),comprador.getNombre(),vendedor.getId(),vendedor.getNombre(),comprador .getNombre() + " has dejado de seguir a " + vendedor.getNombre());
    }

}
