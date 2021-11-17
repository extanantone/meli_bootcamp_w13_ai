package com.socialMeli.socialMeli.service;
import com.socialMeli.socialMeli.dto.ConteoDeSeguidoresDTO;
import com.socialMeli.socialMeli.dto.PublicacionDTO;
import com.socialMeli.socialMeli.dto.SeguidoresUsuarioDTO;
import com.socialMeli.socialMeli.dto.SeguidosUsuarioDTO;
import java.util.ArrayList;
import java.util.List;
public interface IUsuarioService {
    ConteoDeSeguidoresDTO conteoDeSeguidores(int user_id);
    SeguidoresUsuarioDTO mostrarSeguidores(int user_id,String criterio);
    SeguidosUsuarioDTO mostrarSeguidos(int user_id,String criterio);
    void seguirUsuario(int user_id, int user_id_to_follow);
    ConteoDeSeguidoresDTO contabilizarSeguidores(int user_id);
    SeguidoresUsuarioDTO mostrarSeguidoresDelUsuario(int user_id, String criterio);
    SeguidosUsuarioDTO mostrarSeguidosDelUsuario(int user_id, String order);
    void agregarPublicacion(PublicacionDTO publicacionDto);
    ArrayList<PublicacionDTO> mostrarPublicaciones(int user_id);
    List<PublicacionDTO> consultarPublicacionesDeUnUsuarioEn2Semanas(int user_id, String order);
    void dejarDeSeguirA(int user_id, int user_id_to_unfollow);
}