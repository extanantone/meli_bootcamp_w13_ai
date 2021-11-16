package com.example.socialmeli.demo.repository;


import com.example.socialmeli.demo.comparator.AscendingUserName;
import com.example.socialmeli.demo.comparator.DescendingUserName;
import com.example.socialmeli.demo.dto.controllerToService.DTOFollowUser;
import com.example.socialmeli.demo.dto.controllerToService.DTOUnfollowUser;
import com.example.socialmeli.demo.model.Followers;
import com.example.socialmeli.demo.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class FollowerRepository implements IFollowerRepository{

    //Contiene los IDs de todos los usuarios (compradores o vendedores) y sus seguidores
    private Map<Integer, Followers> listaDeFollowers = new HashMap<>();


    @Autowired
    IUserRepository usuarioRepository;


    @Override
    public void addUserToRepository(int userID) {

        Followers userFollowed = new Followers(userID);
        listaDeFollowers.put(userID, userFollowed);

    }


    //US 0001
    @Override
    public void FollowUser(DTOFollowUser request) {

        //Obtenemos los datos de la request
        int followerUserId = request.getUserId();
        int followedUserId = request.getUserIdToFollow();

        Usuarios userToFollow = new Usuarios();

        try {
            //Nos fijamos si el usuario alguna vez ha seguido a alguien
            Followers userFollowedList = listaDeFollowers.get(followerUserId);


            if (userFollowedList == null) {
                addUserToRepository(followerUserId);
                userFollowedList = listaDeFollowers.get(followerUserId);
            }

            userToFollow = usuarioRepository.obtenerUsuarioPorID(followedUserId);

            if(listaDeFollowers.get(followerUserId).getUsuariosSeguidos().get(followedUserId) == null){
                listaDeFollowers.get(followerUserId).getUsuariosSeguidos().put(followedUserId, userToFollow);
            }
            else
                throw new RuntimeException();


        }
        catch (Exception e){
            throw new RuntimeException();
        }

    }


    @Override
    public void unFollowUser(DTOUnfollowUser request) {

        int userId = request.getUserId();
        int userToUnfollowId = request.getUserIdToUnfollow();

        try {
            listaDeFollowers.get(userId).getUsuariosSeguidos().remove(userToUnfollowId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Opcion B: con lista
        //List<FollowerCompradorVendedor> aux;
        //aux = listaDeFollows.stream().filter(x-> x.getCompradorId() == userId && x.getVendedorId() == userToUnfollowId).collect(Collectors.toList());
        //listaDeFollows.removeAll(aux);

    }

    @Override
    public List<Usuarios> getUsersWhoFollowsToUserId(int vendedorUserId, String order) {

        List<Usuarios> seguidoresDelVendedor = new ArrayList<>();

        for (Map.Entry<Integer,Followers> usuarios: listaDeFollowers.entrySet()) {

            if(usuarios.getValue().getUsuariosSeguidos().containsKey(vendedorUserId)){
                Usuarios usuarioSeguidor = new Usuarios();
                usuarioSeguidor = usuarioRepository.obtenerUsuarioPorID(usuarios.getKey());
                seguidoresDelVendedor.add(usuarioSeguidor);
            }

        }

        if(order!=null){

            if(order.equals("name_asc"))
                seguidoresDelVendedor = seguidoresDelVendedor.stream().sorted(new AscendingUserName()).collect(Collectors.toList());
            else if(order.equals("name_desc"))
                seguidoresDelVendedor = seguidoresDelVendedor.stream().sorted(new DescendingUserName()).collect(Collectors.toList());

        }

        return seguidoresDelVendedor;

    }

    @Override
    public List<Usuarios> getUsersFollowedByUserId(int userId, String order) {

        Followers userFollowers = new Followers();
        List<Usuarios> response = new ArrayList<>();

        userFollowers = listaDeFollowers.get(userId);

        if(userFollowers!= null){
            response = new ArrayList<>(userFollowers.getUsuariosSeguidos().values());
        }

        if(order!=null){

            if(order.equals("name_asc"))
                response = response.stream().sorted(new AscendingUserName()).collect(Collectors.toList());
            else if(order.equals("name_desc"))
               response = response.stream().sorted(new DescendingUserName()).collect(Collectors.toList());

        }

        return response;


    }


}
