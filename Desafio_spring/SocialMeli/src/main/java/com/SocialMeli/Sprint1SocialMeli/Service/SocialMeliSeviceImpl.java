package com.SocialMeli.Sprint1SocialMeli.Service;

import com.SocialMeli.Sprint1SocialMeli.DTO.*;
import com.SocialMeli.Sprint1SocialMeli.Exception.NotFoundUsuarioException;
import com.SocialMeli.Sprint1SocialMeli.Exception.PostIdDuplicateVendedorExeption;
import com.SocialMeli.Sprint1SocialMeli.Exception.UserNoFollowExeption;
import com.SocialMeli.Sprint1SocialMeli.Exception.UserduplicateFollowExeption;
import com.SocialMeli.Sprint1SocialMeli.Model.Comprador;
import com.SocialMeli.Sprint1SocialMeli.Model.Producto;
import com.SocialMeli.Sprint1SocialMeli.Model.Publicacion;
import com.SocialMeli.Sprint1SocialMeli.Model.Vendedor;
import com.SocialMeli.Sprint1SocialMeli.Repository.ISocialMeliRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
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
    public VendedorFollowersListDTO vendedorFollowesList(Integer vendedorId, String order) {
        Vendedor vendedor = repositorio.getVendedor(vendedorId);
        if (vendedor == null) {
            throw new NotFoundUsuarioException(vendedorId);
        }

        List<Integer> followerIds = vendedor.getFollowers();
        List<Comprador> com = followerIds.stream().map(repositorio::getComprador).collect(Collectors.toList());

        List<CompradorIdNameDTO> compradorIdNameDTO = com.stream()
                .map(co -> new CompradorIdNameDTO(co.getUserID(), co.getUserName()))
                .collect(Collectors.toList());

        if (order != null) {
            if (order.equalsIgnoreCase("name_asc")) {
                compradorIdNameDTO.sort(Comparator.comparing(CompradorIdNameDTO::getUserName));
            }


            if (order.equalsIgnoreCase("name_desc")) {
                compradorIdNameDTO.sort(Comparator.comparing(CompradorIdNameDTO::getUserName).reversed());
            }
        }


        return new VendedorFollowersListDTO(vendedor.getUserID(), vendedor.getUserName(), compradorIdNameDTO);
    }

    @Override
    public CompradorFollowedListDTO compradorFollowedList(Integer compradorId, String order) {
        Comprador comprador = repositorio.getComprador(compradorId);
        if (comprador == null) {
            throw new NotFoundUsuarioException(compradorId);
        }

        List<Integer> followerdIds = comprador.getFolloweds();
        List<Vendedor> ven = followerdIds.stream().map(repositorio::getVendedor).collect(Collectors.toList());

        List<VendedorIdNameDTO> vendedorIdNameDTO = ven.stream()
                .map(ve -> new VendedorIdNameDTO(ve.getUserID(), ve.getUserName()))
                .collect(Collectors.toList());

        if (order != null) {
            if (order.equalsIgnoreCase("name_asc")) {
                vendedorIdNameDTO.sort(Comparator.comparing(VendedorIdNameDTO::getUserName));
            }


            if (order.equalsIgnoreCase("name_desc")) {
                vendedorIdNameDTO.sort(Comparator.comparing(VendedorIdNameDTO::getUserName).reversed());
            }
        }

        return new CompradorFollowedListDTO(comprador.getUserID(), comprador.getUserName(), vendedorIdNameDTO);
    }

    @Override
    public void createNewPublicacion(PublicacionDTO publicacionDTO) {

        if (repositorio.getVendedor(publicacionDTO.getUserId()) == null) {
            throw new NotFoundUsuarioException(publicacionDTO.getUserId());
        }

        if (repositorio.existPost(publicacionDTO.getUserId(), publicacionDTO.getIdPost()))
            throw new PostIdDuplicateVendedorExeption(publicacionDTO.getUserId(), publicacionDTO.getIdPost());

        LocalDate fecha = LocalDate.parse(publicacionDTO.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        ProductoDTO proDTO = publicacionDTO.getDetail();
        Producto pro = new Producto(proDTO.getProductId(), proDTO.getProductName(), proDTO.getType(), proDTO.getBrand(), proDTO.getColor(), proDTO.getNotes());

        repositorio.newPost(publicacionDTO.getUserId(), new Publicacion(publicacionDTO.getIdPost(), publicacionDTO.getCategory(), publicacionDTO.getPrice(), fecha, pro , publicacionDTO.getHasPromo() !=null ? publicacionDTO.getHasPromo():false , publicacionDTO.getDiscount()));

    }

    @Override
    public CompradorPublicacionesVendedorListDTO postByVendedorOfComprador(Integer compradorId, String order) {

        Comprador comprador = repositorio.getComprador(compradorId);
        if (comprador == null) {
            throw new NotFoundUsuarioException(compradorId);
        }

        List<Integer> followerdIds = comprador.getFolloweds();
        List<Vendedor> ven = followerdIds.stream().map(repositorio::getVendedor).collect(Collectors.toList());

        List<Publicacion> publicaciones = ven.stream().flatMap(u -> u.getPosts().stream()).filter(l -> l.getDate().isAfter(LocalDate.now().minusWeeks(2))).collect(Collectors.toList());

        List<PublicacionSinUserIdDTO> publicacionSinUserIdDTO = publicaciones.stream()
                .map(p -> new PublicacionSinUserIdDTO(p.getPostId(), p.getCategory(), p.getPrice(), p.getDate(),
                        new ProductoDTO(p.getDetail().getProductId(), p.getDetail().getProductName(), p.getDetail().getType(), p.getDetail().getBrand(), p.getDetail().getColor(), p.getDetail().getNotes())))
                .collect(Collectors.toList());


        if (order != null) {
            if (order.equalsIgnoreCase("date_asc")) {
                publicacionSinUserIdDTO.sort(Comparator.comparing(PublicacionSinUserIdDTO::getDate));
            }


            if (order.equalsIgnoreCase("date_asc")) {
                publicacionSinUserIdDTO.sort(Comparator.comparing(PublicacionSinUserIdDTO::getDate).reversed());
            }
        }

        return new CompradorPublicacionesVendedorListDTO(comprador.getUserID(), publicacionSinUserIdDTO);
    }

    @Override
    public boolean unFollow(Integer compradorId, Integer vendedorId) {

        if (repositorio.getComprador(compradorId) == null) {
            throw new NotFoundUsuarioException(compradorId);
        }
        if (repositorio.getVendedor(vendedorId) == null) {
            throw new NotFoundUsuarioException(vendedorId);
        }

        if (!repositorio.existsFollow(compradorId, vendedorId))
            throw new UserNoFollowExeption(vendedorId);

        return repositorio.unFollow(compradorId, vendedorId);
    }


}
