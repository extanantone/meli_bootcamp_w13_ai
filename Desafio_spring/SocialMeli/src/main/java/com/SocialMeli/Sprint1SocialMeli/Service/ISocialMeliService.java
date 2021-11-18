package com.SocialMeli.Sprint1SocialMeli.Service;

import com.SocialMeli.Sprint1SocialMeli.DTO.*;
import com.SocialMeli.Sprint1SocialMeli.Model.Comprador;

public interface ISocialMeliService {

    boolean addFollowed(Integer compradorId, Integer vendedorId);

    Comprador getCompradorFindId(Integer compradorId);

    VendedorFollowesCountDTO vendedorFollowesCount( Integer vendedorId);

    VendedorFollowersListDTO vendedorFollowesList(Integer vendedorId, String order);

    CompradorFollowedListDTO compradorFollowedList(Integer compradorId, String order);

    void createNewPublicacion(PublicacionDTO publicacionDTO);

    CompradorPublicacionesVendedorListDTO postByVendedorOfComprador(Integer compradorId, String order);

    boolean unFollow(Integer compradorId, Integer vendedorId);

    PublicacionConDescuentoCountDTO getProductoPromoCount(Integer vendedorId);





}
