package com.SocialMeli.Sprint1SocialMeli.Service;

import com.SocialMeli.Sprint1SocialMeli.DTO.CompradorFollowedListDTO;
import com.SocialMeli.Sprint1SocialMeli.DTO.VendedorFollowersListDTO;
import com.SocialMeli.Sprint1SocialMeli.DTO.VendedorFollowesCountDTO;
import com.SocialMeli.Sprint1SocialMeli.Model.Comprador;

public interface ISocialMeliService {

    boolean addFollowed(Integer compradorId, Integer vendedorId);

    Comprador getCompradorFindId(Integer compradorId);

    VendedorFollowesCountDTO vendedorFollowesCount( Integer vendedorId);

    VendedorFollowersListDTO vendedorFollowesList(Integer vendedorId);

    CompradorFollowedListDTO compradorFollowedList(Integer compradorId);



}
