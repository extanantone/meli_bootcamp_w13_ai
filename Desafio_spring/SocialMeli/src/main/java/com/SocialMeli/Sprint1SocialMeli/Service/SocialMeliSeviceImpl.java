package com.SocialMeli.Sprint1SocialMeli.Service;

import com.SocialMeli.Sprint1SocialMeli.DTO.*;
import com.SocialMeli.Sprint1SocialMeli.Exception.NotFoundUsuarioException;
import com.SocialMeli.Sprint1SocialMeli.Exception.PostIdDuplicateVendedor;
import com.SocialMeli.Sprint1SocialMeli.Exception.UserduplicateFollowExeption;
import com.SocialMeli.Sprint1SocialMeli.Model.Comprador;
import com.SocialMeli.Sprint1SocialMeli.Model.Producto;
import com.SocialMeli.Sprint1SocialMeli.Model.Publicacion;
import com.SocialMeli.Sprint1SocialMeli.Model.Vendedor;
import com.SocialMeli.Sprint1SocialMeli.Repository.ISocialMeliRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocialMeliSeviceImpl implements ISocialMeliService {

    final
    ISocialMeliRepository repositorio;


    public SocialMeliSeviceImpl(ISocialMeliRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public boolean addFollowed(Integer compradorId, Integer vendedorId) {

        Comprador c = repositorio.getComprador(compradorId);
        Vendedor v = repositorio.getVendedor(vendedorId);

        if (c == null) {
            throw new NotFoundUsuarioException(compradorId);
        }
        if (v == null) {
            throw new NotFoundUsuarioException(vendedorId);
        }
        if (repositorio.existsFollow(compradorId, vendedorId))
            throw new UserduplicateFollowExeption(vendedorId);

        return repositorio.follow(compradorId, vendedorId);
    }

    @Override
    public Comprador getCompradorFindId(Integer compradorId) {

        return repositorio.getComprador(compradorId);
    }

    @Override
    public VendedorFollowesCountDTO vendedorFollowesCount(Integer vendedorId) {

        Vendedor vendedor = repositorio.getVendedor(vendedorId);

        if (vendedor == null) {
            throw new NotFoundUsuarioException(vendedorId);
        }

        return new VendedorFollowesCountDTO(vendedor.getUserID(), vendedor.getUserName(), vendedor.getFollowers().size());

    }

    @Override
    public VendedorFollowersListDTO vendedorFollowesList(Integer vendedorId) {
        Vendedor vendedor = repositorio.getVendedor(vendedorId);
        if (vendedor == null) {
            throw new NotFoundUsuarioException(vendedorId);
        }

        List<Integer> followerIds = vendedor.getFollowers();
        List<Comprador> com = followerIds.stream().map(f -> repositorio.getComprador(f)).collect(Collectors.toList());

        List<CompradorIdNameDTO> compradorIdNameDTO = com.stream()
                .map(co -> new CompradorIdNameDTO(co.getUserID(), co.getUserName()))
                .collect(Collectors.toList());

        return new VendedorFollowersListDTO(vendedor.getUserID(), vendedor.getUserName(), compradorIdNameDTO);
    }

    @Override
    public CompradorFollowedListDTO compradorFollowedList(Integer compradorId) {
        Comprador comprador = repositorio.getComprador(compradorId);
        if (comprador == null) {
            throw new NotFoundUsuarioException(compradorId);
        }

        List<Integer> followerdIds = comprador.getFolloweds();
        List<Vendedor> ven = followerdIds.stream().map(f -> repositorio.getVendedor(f)).collect(Collectors.toList());

        List<VendedorIdNameDTO> vendedorIdNameDTO = ven.stream()
                .map(ve -> new VendedorIdNameDTO(ve.getUserID(), ve.getUserName()))
                .collect(Collectors.toList());

        return new CompradorFollowedListDTO(comprador.getUserID(), comprador.getUserName(), vendedorIdNameDTO);
    }

    @Override
    public void createNewPublicacion(PublicacionDTO publicacionDTO) {

        if (repositorio.getVendedor(publicacionDTO.getUserId()) == null) {
            throw new NotFoundUsuarioException(publicacionDTO.getUserId());
        }

        //Crear validacion de si existe el id de la publicacion
        // validar que producto o publicacion campos vacios
        if (repositorio.existPost(publicacionDTO.getUserId(), publicacionDTO.getIdPost()))
            throw new PostIdDuplicateVendedor(publicacionDTO.getUserId(), publicacionDTO.getIdPost());

        LocalDate fecha = LocalDate.parse(publicacionDTO.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        ProductoDTO proDTO = publicacionDTO.getDetail();
        Producto pro = new Producto(proDTO.getProductId(), proDTO.getProductName(), proDTO.getType(), proDTO.getBrand(), proDTO.getColor(), proDTO.getNotes());

        Publicacion publi = new Publicacion(publicacionDTO.getIdPost(), publicacionDTO.getCategory(), publicacionDTO.getPrice(), fecha, pro);

        repositorio.newPost(publicacionDTO.getUserId(), publi);

    }


}
