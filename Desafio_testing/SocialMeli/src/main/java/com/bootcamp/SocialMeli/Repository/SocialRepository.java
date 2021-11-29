package com.bootcamp.SocialMeli.Repository;

import com.bootcamp.SocialMeli.Model.PromoPublicacion;
import com.bootcamp.SocialMeli.Model.Publicacion;
import com.bootcamp.SocialMeli.Model.Seguidor;
import com.bootcamp.SocialMeli.Model.Usuario;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SocialRepository implements ISocialRepository {

    List<Seguidor> seguidores= new ArrayList<>();
    List<Usuario> usuario= new ArrayList<>();
    List<Publicacion> publicacion= new ArrayList<>();
    List<PromoPublicacion> promoPublicacion= new ArrayList<>();

    public SocialRepository(){
        usuario.add(new Usuario("Usuario1"));
        usuario.add(new Usuario("Usuario2"));
        usuario.add(new Usuario("Usuario3"));
        usuario.add(new Usuario("Usuario4"));
    }

    public void reset(){
        this.seguidores= new ArrayList<>();
        this.usuario= new ArrayList<>();
        this.publicacion= new ArrayList<>();
        this.promoPublicacion= new ArrayList<>();
        usuario.add(new Usuario("Usuario1"));
        usuario.add(new Usuario("Usuario2"));
        usuario.add(new Usuario("Usuario3"));
        usuario.add(new Usuario("Usuario4"));
    }


    @Override
    public Seguidor Follow(Seguidor seguidor) {
        seguidores.add(seguidor);
        return seguidor;
    }

    @Override
    public void setUsuario(Usuario usu) {
        usuario.add(usu);
    }

    @Override
    public void unFollow(Seguidor seguidor) {
        for (int i=0 ; i < seguidores.size();i++ ){
            if(seguidores.get(i).getIdUser().equals(seguidor.getIdUser()) && seguidores.get(i).getIdUserFollow().equals(seguidor.getIdUserFollow())){
                seguidores.remove(i);
                break;
            }
        }
    }


    @Override
    public Usuario getUsuario(Integer userId) {
        if(usuario.stream().filter(user -> user.getUserId().equals(userId)).count() >0){
            return usuario.stream().filter(user -> user.getUserId().equals(userId)).findFirst().get();
        }
        return null;
    }



    @Override
    public List<Seguidor> getSeguidor() {
        return seguidores;
    }


    @Override
    public Publicacion setPublicacion(Publicacion publi) {
        publicacion.add(publi);
        return  publi;
    }


    @Override
    public List<Publicacion> getPublicaciones(Integer id) {
        return publicacion.stream().filter(publicacion -> publicacion.getUserId().equals(id)).collect(Collectors.toList());
    }

    @Override
    public Publicacion getPublicacion(Integer id) {
        if(publicacion.stream().filter(publicacion -> publicacion.getIdPost().equals(id)).count()>0){
            return publicacion.stream().filter(publicacion -> publicacion.getIdPost().equals(id)).findFirst().get();
        }
        return null;
    }


    @Override
    public void setPromoPublic(PromoPublicacion promo) {
        promoPublicacion.add(promo);
    }

    @Override
    public PromoPublicacion getPromoPublicacion(Integer id) {
        return promoPublicacion.stream().filter(publicacion -> publicacion.getIdPost().equals(id)).findFirst().get();
    }

    @Override
    public List<PromoPublicacion> getPromoPubliList(Integer id) {
        return promoPublicacion.stream().filter(publicacion -> publicacion.getIdPost().equals(id)).collect(Collectors.toList());
    }


    @Override
    public Boolean getExisteSeguidorById(Integer usu, Integer usuFollow) {
        return seguidores.stream().filter(seguidor -> seguidor.getIdUser().equals(usu) && seguidor.getIdUserFollow().equals(usuFollow)).count() > 0;
    }

    @Override
    public Boolean getExisteSPostById(Integer usuId, Integer postId) {
        return publicacion.stream().filter(usu -> usu.getUserId().equals(usuId) && usu.getIdPost().equals(postId)).count() > 0;
    }

}
