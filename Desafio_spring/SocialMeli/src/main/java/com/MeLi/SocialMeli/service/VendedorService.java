package com.MeLi.SocialMeli.service;

import com.MeLi.SocialMeli.DTO.CompradorDTO;
import com.MeLi.SocialMeli.DTO.DatosSeguidoresDTO;
import com.MeLi.SocialMeli.DTO.SeguidoresDTO;
import com.MeLi.SocialMeli.exception.NotFoundVendedorException;
import com.MeLi.SocialMeli.mapper.CompradorMapper;
import com.MeLi.SocialMeli.mapper.DatosSeguidoresMapper;
import com.MeLi.SocialMeli.mapper.SeguidoresMapper;
import com.MeLi.SocialMeli.model.Comprador;
import com.MeLi.SocialMeli.model.Vendedor;
import com.MeLi.SocialMeli.repository.CompradorRepositoryImplement;
import com.MeLi.SocialMeli.repository.VendedorRepositoryImplement;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VendedorService implements VendedorServiceImplement{

    private VendedorRepositoryImplement vendedorRepositoryImplement;
    private CompradorRepositoryImplement compradorRepositoryImplement;

    public VendedorService(VendedorRepositoryImplement vendedorRepositoryImplement, CompradorRepositoryImplement compradorRepositoryImplement){
        this.vendedorRepositoryImplement = vendedorRepositoryImplement;
        this.compradorRepositoryImplement = compradorRepositoryImplement;
    }

    @Override
    public SeguidoresDTO contarSeguidores(int idVendedor) throws NotFoundVendedorException {
        Vendedor vendedor = vendedorRepositoryImplement.find(idVendedor).orElseThrow(() -> new NotFoundVendedorException(idVendedor));
        return SeguidoresMapper.seguidoresToSeguidoresDTO(vendedor);
    }

    public DatosSeguidoresDTO getInfoSeguidores(int idVendedor) throws NotFoundVendedorException {
        Vendedor vendedor = vendedorRepositoryImplement.find(idVendedor).orElseThrow(() -> new NotFoundVendedorException(idVendedor));
        HashMap<Integer, String> seguidores = vendedor.getSeguidores();
        List<CompradorDTO> seguidoresDatos = new ArrayList<>();

        for (Map.Entry<Integer, String> entry : seguidores.entrySet()) {
            Comprador comprador = compradorRepositoryImplement.find(entry.getKey()).orElseThrow(() -> new NotFoundVendedorException(idVendedor));
            seguidoresDatos.add(CompradorMapper.compradorToCompradorDTO(comprador));
        }
        return DatosSeguidoresMapper.dataVendedorToDatosSeguidoresDTO(vendedor,seguidoresDatos);
    }


}
