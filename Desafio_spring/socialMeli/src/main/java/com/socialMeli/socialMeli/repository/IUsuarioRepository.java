package com.socialMeli.socialMeli.repository;
import com.socialMeli.socialMeli.model.Usuario;
import java.util.ArrayList;
public interface IUsuarioRepository {
    ArrayList<Usuario> obtenerUsuarios();
    Usuario obtenerUsuario(int user_id);
}