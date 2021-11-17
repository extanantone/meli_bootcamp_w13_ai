package com.socialMeli.socialMeli.repository;
import com.socialMeli.socialMeli.model.Usuario;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.NoSuchElementException;
@Repository
public class UsuarioRepository implements IUsuarioRepository {
    ArrayList<Usuario> usuarios;
    public UsuarioRepository() {
        this.usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario(1,"Jorge"));
        usuarios.add(new Usuario(2,"Maria"));
        usuarios.add(new Usuario(3,"Pedro"));
        usuarios.add(new Usuario(4,"Sofia"));
        usuarios.add(new Usuario(5,"Carlos"));
        usuarios.add(new Usuario(6,"Sandra"));
        usuarios.add(new Usuario(7,"Felipe"));
        usuarios.add(new Usuario(8,"Camila"));
    }
    @Override
    public ArrayList<Usuario> obtenerUsuarios() {
        return this.usuarios;
    }
    public Usuario obtenerUsuario(int id){
        try {
            return this.obtenerUsuarios().stream().filter(u -> u.getUser_id() == id).findFirst().get();
        }
        catch (NoSuchElementException e){
            return null;
        }
    }
}