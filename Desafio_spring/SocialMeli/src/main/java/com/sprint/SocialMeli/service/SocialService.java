package com.sprint.SocialMeli.service;

import com.sprint.SocialMeli.dto.*;
import com.sprint.SocialMeli.dto.in.PostDtoIn;
import com.sprint.SocialMeli.dto.in.PromoPostDtoIn;
import com.sprint.SocialMeli.dto.out.*;
import com.sprint.SocialMeli.exceptions.DuplicateException;
import com.sprint.SocialMeli.exceptions.NotFoundException;
import com.sprint.SocialMeli.exceptions.WrongTypeException;
import com.sprint.SocialMeli.model.*;
import com.sprint.SocialMeli.repository.ISocialRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocialService implements ISocialService{
    ISocialRepository socialRepository;

    public SocialService(ISocialRepository socialRepository){
        this.socialRepository = socialRepository;
    }


    @Override
    public void followSeller(int user_id, int user_id_to_follow) throws Exception {
        // Valido que el usuario exista y tenga el rol pretendido
        UserValidation(user_id, UserType.BUYER);
        UserValidation(user_id_to_follow, UserType.SELLER);

        // Transacciono para comprobar que se agreguen los seguidores, seguidos y actualicen en el repositorio conservando la consistencia.
        try{
            Buyer buyer = (Buyer) socialRepository.getUser(user_id);
            buyer.addFollowed(user_id_to_follow);
            socialRepository.putUser(buyer);

            Seller seller = (Seller) socialRepository.getUser(user_id_to_follow);
            seller.addFollower(user_id);
            socialRepository.putUser(seller);
        }
        catch (Exception e){
            throw new Exception("Error al seguir un usuario : " + e.getMessage());
        }


    }

    @Override
    public FollowersCountDto getSellerFollowersCount(int user_id) throws WrongTypeException, NotFoundException {
        UserValidation(user_id, UserType.SELLER);
        Seller seller = (Seller) socialRepository.getUser(user_id);

        // Devuelvo los datos del vendedor junto a su cantidad de seguidores
        return new FollowersCountDto(seller.getUser_id(),
                seller.getUser_name(),
                seller.followersCount());
    }

    @Override
    public FollowersListDto getSellerFollowersList(int user_id, String order) throws WrongTypeException, NotFoundException {
        UserValidation(user_id, UserType.SELLER);
        Seller seller = (Seller) socialRepository.getUser(user_id);


        return new FollowersListDto(seller.getUser_id(),
                seller.getUser_name(),
                // Llamo a la función de orden con la lista mapeada de cada ID de seguidores con su correspondiente usuario del repositorio
                orderUserByName(seller.getFollowersIds().stream()
                        .map(f -> socialRepository.getUser(f))
                        .collect(Collectors.toList()), order)
                        // Mapeo los datos de los seguidores al DTO de usuario
                            .stream()
                            .map(u -> new UserDto(u.getUser_id(), u.getUser_name()))
                            .collect(Collectors.toList()));
    }

    @Override
    public FollowedListDto getBuyerFollowedList(int user_id, String order) throws WrongTypeException, NotFoundException {
        UserValidation(user_id, UserType.BUYER);
        Buyer buyer = (Buyer) socialRepository.getUser(user_id);

        return new FollowedListDto(buyer.getUser_id(),
                buyer.getUser_name(),
                // Llamo a la función de orden con la lista mapeada de cada ID de seguidos con su correspondiente usuario del repositorio
                orderUserByName(buyer.getFollowedIds().stream()
                        .map(f -> socialRepository.getUser(f))
                        .collect(Collectors.toList()), order)
                        // Mapeo los datos de los seguidores al DTO de usuario
                        .stream()
                            .map(u -> new UserDto(u.getUser_id(), u.getUser_name()))
                            .collect(Collectors.toList()));
    }

    @Override
    public void newPost(PostDtoIn postDtoIn) throws Exception {
        // Uso simplemente la función de wrapper
        savePost(new Post(postDtoIn));
    }

    @Override
    public FollowedPostListDto getLastTwoWeeksPostsFromFollowed(int user_id, String order) throws WrongTypeException, NotFoundException {
        UserValidation(user_id, UserType.BUYER);
        Buyer buyer = (Buyer) socialRepository.getUser(user_id);

        // Si lo llaman sin el parámetro de orden lo asumo como si es descendiente
        if(order == null)
            order = "date_desc";

        // Inicializo los post como una lista vacía
        List<Post> posts = new ArrayList<>();
        // Obtengo la lista de usuarios seguidos por el usuario pasado
        List<Seller> sellers = buyer.getFollowedIds().stream()
                                .map(f -> (Seller) socialRepository.getUser(f))
                                .collect(Collectors.toList());

        // Por cada uno de los seguidos: obtengo sus posts, los filtro según si la fecha está dentro de las últimas dos semanas, y la agrego a la lista de posts inicializada anteriormente
        sellers.forEach(s -> posts.addAll(
                                s.getPostsIds().stream()
                                .map(p -> socialRepository.getPost(p))
                                .filter(p -> p.getDate().isAfter(LocalDate.now().minusWeeks(2).minusDays(1)))
                                .collect(Collectors.toList())));

        return new FollowedPostListDto(buyer.getUser_id(),
                // Realizo finalmente el ordenamiento y el mapeo al DTO correspondiente
                (order.equals("date_asc") ?
                        posts.stream()
                                .sorted(Comparator.comparing(Post::getDate))
                        :
                        posts.stream()
                                .sorted(Comparator.comparing(Post::getDate).reversed()))
                .map(PostDtoOut::new)
                .collect(Collectors.toList()));
    }

    @Override
    public void unfollowSeller(int user_id, int user_id_to_unfollow) throws Exception {
        // Valido la existencia y rol de cada usuario
        UserValidation(user_id, UserType.BUYER);
        UserValidation(user_id_to_unfollow, UserType.SELLER);

        // Transacciono para asegurar la consistencia
        try{
            Buyer buyer = (Buyer) socialRepository.getUser(user_id);
            buyer.deleteFollowed(user_id_to_unfollow);
            socialRepository.putUser(buyer);

            Seller seller = (Seller) socialRepository.getUser(user_id);
            seller.deleteFollower(user_id);
            socialRepository.putUser(seller);
        }
        catch(Exception e){
            throw new Exception("Error al dejar de seguir un usuario : " + e.getMessage());
        }

    }

    @Override
    public void newPromoPost(PromoPostDtoIn promoPostDtoIn) throws Exception {
        // Uso de wrapper
        savePost(new Post(promoPostDtoIn));
    }

    @Override
    public PromoPostCountDto getPromoPostCount(int user_id) throws WrongTypeException, NotFoundException {
        UserValidation(user_id, UserType.SELLER);
        return new PromoPostCountDto(user_id,
                socialRepository.getUser(user_id).getUser_name(),
                // Obtengo los post del vendedor, los filtro por si tienen promoción, obtengo la cantidad y la casteo a entero, ya que el count devuelve un long.
                (int) ((Seller)socialRepository.getUser(user_id))
                        .getPostsIds().stream()
                        .map(p -> socialRepository.getPost(p))
                        .filter(Post::isHas_promo)
                        .count());
    }

    @Override
    public PromoPostList getPromoPostList(int user_id) throws WrongTypeException, NotFoundException {
        UserValidation(user_id, UserType.SELLER);
        Seller seller = (Seller) socialRepository.getUser(user_id);

        return new PromoPostList(seller.getUser_id(),
                seller.getUser_name(),
                // Obtengo los posts, los filtro por si son de promoción y los paso al DTO correspondiente
                seller.getPostsIds().stream()
                        .map(p -> socialRepository.getPost(p))
                        .filter(Post::isHas_promo)
                        .map(PromoPostDtoOut::new)
                        .collect(Collectors.toList()));
    }

    private void UserValidation(int user_id, UserType userType) throws WrongTypeException, NotFoundException {
        // Me fijo primero que tipo de usuario quiero validar
        if (userType.equals(UserType.BUYER)){
            // Si no existe lanzo una excepción de no encontrado
            if(!socialRepository.existsUser(user_id))
                throw new NotFoundException("El comprador no se ha encontrado");
            // Si existe, pero no es del tipo buscado lanzo una excepción de tipo incorrecto
            else if(socialRepository.getUser(user_id).getUserType() != UserType.BUYER)
                throw new WrongTypeException("El usuario no es un comprador");
        }
        // Análogo a lo anterior pero con el vendedor, lo hago aparte para poder diferenciar los mensajes de cada uno
        else if (userType.equals(UserType.SELLER)){
            if(!socialRepository.existsUser(user_id))
                throw new NotFoundException("El vendedor no se ha encontrado");
            else if(socialRepository.getUser(user_id).getUserType() != UserType.SELLER)
                throw new WrongTypeException("El usuario no es un vendedor");
        }
    }

    private List<User> orderUserByName(List<User> users, String order){
        // Si es nulo porque se llamó al endpoint sin el parámetro lo tomo como ascendente
        if(order == null || order.equals("name_asc"))
            return users.stream()
                    .sorted(Comparator.comparing(User::getUser_name))
                    .collect(Collectors.toList());
        else if(order.equals("name_desc"))
            return users.stream()
                    .sorted(Comparator.comparing(User::getUser_name).reversed())
                    .collect(Collectors.toList());
        return users;
    }

    private void savePost(Post post) throws Exception {
        // Valido al usuario
        UserValidation(post.getUser_id(), UserType.SELLER);

        // Me fijo si no existía ya un post con el mismo identificador que el nuevo
        if(socialRepository.existsPost(post.getId_post()))
            throw new DuplicateException("Ya existe un post con ese identificatorio");

        // Transacciono para conservar la consistencia
        try{
            socialRepository.putPost(post);
            Seller seller = (Seller) socialRepository.getUser(post.getUser_id());
            seller.addPost(post.getId_post());
            socialRepository.putUser(seller);
        }
        catch(Exception e){
            throw new Exception("Error al crear un nuevo post : " + e.getMessage());
        }

    }
}
