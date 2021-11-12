package com.bootcamp.SocialMeli.Repository;

import com.bootcamp.SocialMeli.Model.Seguidor;
import com.bootcamp.SocialMeli.Model.Usuario;
import java.util.List;

public interface IUsuarioRepository {
    Seguidor setSeguidor(Seguidor seguidor);
    Boolean getSeguidorById(int userId, int userFolloId);
    Usuario getUsuario(int user_id);
    List<Seguidor> getSeguidor();

}
