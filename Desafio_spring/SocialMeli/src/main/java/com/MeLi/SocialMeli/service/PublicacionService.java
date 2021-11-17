package com.MeLi.SocialMeli.service;

import com.MeLi.SocialMeli.DTO.CompradorDTO;
import com.MeLi.SocialMeli.DTO.PubVendedoresDTO;
import com.MeLi.SocialMeli.DTO.PublicacionDTO;
import com.MeLi.SocialMeli.DTO.VendedorDTO;
import com.MeLi.SocialMeli.exception.NotFoundCompradorException;
import com.MeLi.SocialMeli.exception.NotFoundVendedorException;
import com.MeLi.SocialMeli.exception.NotPubException;
import com.MeLi.SocialMeli.mapper.CompradorMapper;
import com.MeLi.SocialMeli.mapper.PublicacionMapper;
import com.MeLi.SocialMeli.model.Comprador;
import com.MeLi.SocialMeli.model.Producto;
import com.MeLi.SocialMeli.model.Publicacion;
import com.MeLi.SocialMeli.model.Vendedor;
import com.MeLi.SocialMeli.repository.CompradorRepositoryImplement;
import com.MeLi.SocialMeli.repository.PublicacionRepositoryImplement;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PublicacionService implements PublicacionServiceImplement{

    private PublicacionRepositoryImplement publicacionRepositoryImplement;
    private CompradorRepositoryImplement compradorRepositoryImplement;
    private CompradorServiceImplement compradorServiceImplement;

    public PublicacionService(PublicacionRepositoryImplement publicacionRepositoryImplement, CompradorRepositoryImplement compradorRepositoryImplement, CompradorServiceImplement compradorServiceImplement){
        this.publicacionRepositoryImplement = publicacionRepositoryImplement;
        this.compradorRepositoryImplement = compradorRepositoryImplement;
        this.compradorServiceImplement = compradorServiceImplement;
    }

    @Override
    public Publicacion addNewPub(PublicacionDTO pubDTO) throws NotPubException {
        try{
            Publicacion pub = new PublicacionMapper().PublicacionDTOToPublicacion(pubDTO);
            return publicacionRepositoryImplement.nuevaPublicacion(pub);
        }catch (Exception e){
            throw(new NotPubException());
        }
    }

    @Override
    public PubVendedoresDTO obtenerPublicaciones(int idUser, String order) throws NotFoundVendedorException, NotFoundCompradorException {

        ArrayList publicacionesUsuario = new ArrayList();
        LocalDate fechaActual = LocalDate.now();
        List<VendedorDTO> vendedores = compradorServiceImplement.verSeguidos(idUser, "name_asc").getFollowed();

        for(int i = 0; i < vendedores.size(); i++){
            List<Publicacion> publicacionesVendedor = publicacionRepositoryImplement.publicacionesVendedor(vendedores.get(i).getUser_id());
            publicacionesUsuario.addAll(publicacionesVendedor.stream().filter(pub -> pub.getDate().isAfter(fechaActual.minusDays(14))).collect(Collectors.toList()));
        }

        return new PubVendedoresDTO(idUser,publicacionesUsuario);
    }
}
