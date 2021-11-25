package com.sprint.SocialMeli.service;

import com.sprint.SocialMeli.dto.*;
import com.sprint.SocialMeli.dto.in.PostDtoIn;
import com.sprint.SocialMeli.dto.in.PromoPostDtoIn;
import com.sprint.SocialMeli.dto.out.*;
import com.sprint.SocialMeli.exceptions.DuplicateException;
import com.sprint.SocialMeli.exceptions.InvalidOrderException;
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
    public void followSeller(int userId, int userIdToFollow) throws Exception {
        // Valido que el usuario exista y tenga el rol pretendido
        UserValidation(userId, UserType.BUYER);
        UserValidation(userIdToFollow, UserType.SELLER);

        // Transacciono para comprobar que se agreguen los seguidores, seguidos y actualicen en el repositorio conservando la consistencia.
        try{
            Buyer buyer = (Buyer) socialRepository.getUser(userId);
            buyer.addFollowed(userIdToFollow);
            socialRepository.createUser(buyer);

            Seller seller = (Seller) socialRepository.getUser(userIdToFollow);
            seller.addFollower(userId);
            socialRepository.createUser(seller);
        }
        catch (Exception e){
            throw new Exception("Error al seguir un usuario : " + e.getMessage());
        }


    }

    @Override
    public FollowersCountDto getSellerFollowersCount(int userId) throws WrongTypeException, NotFoundException {
        UserValidation(userId, UserType.SELLER);
        Seller seller = (Seller) socialRepository.getUser(userId);

        // Devuelvo los datos del vendedor junto a su cantidad de seguidores
        return new FollowersCountDto(seller.getUserId(),
                seller.getUserName(),
                seller.followersCount());
    }

    @Override
    public FollowersListDto getSellerFollowersList(int userId, String order) throws WrongTypeException, NotFoundException, InvalidOrderException {
        UserValidation(userId, UserType.SELLER);
        Seller seller = (Seller) socialRepository.getUser(userId);


        return new FollowersListDto(seller.getUserId(),
                seller.getUserName(),
                // Llamo a la función de orden con la lista mapeada de cada ID de seguidores con su correspondiente usuario del repositorio
                orderUserByName(seller.getFollowersIds().stream()
                        .map(f -> socialRepository.getUser(f))
                        .collect(Collectors.toList()), order)
                        // Mapeo los datos de los seguidores al DTO de usuario
                            .stream()
                            .map(u -> new UserDto(u.getUserId(), u.getUserName()))
                            .collect(Collectors.toList()));
    }

    @Override
    public FollowedListDto getBuyerFollowedList(int userId, String order) throws WrongTypeException, NotFoundException, InvalidOrderException {
        UserValidation(userId, UserType.BUYER);
        Buyer buyer = (Buyer) socialRepository.getUser(userId);

        return new FollowedListDto(buyer.getUserId(),
                buyer.getUserName(),
                // Llamo a la función de orden con la lista mapeada de cada ID de seguidos con su correspondiente usuario del repositorio
                orderUserByName(buyer.getFollowedIds().stream()
                        .map(f -> socialRepository.getUser(f))
                        .collect(Collectors.toList()), order)
                        // Mapeo los datos de los seguidores al DTO de usuario
                        .stream()
                            .map(u -> new UserDto(u.getUserId(), u.getUserName()))
                            .collect(Collectors.toList()));
    }

    @Override
    public void newPost(PostDtoIn postDtoIn) throws Exception {
        // Uso simplemente la función de wrapper
        savePost(new Post(postDtoIn));
    }

    @Override
    public FollowedPostListDto getLastTwoWeeksPostsFromFollowed(int userId, String order) throws WrongTypeException, NotFoundException, InvalidOrderException {
        UserValidation(userId, UserType.BUYER);
        Buyer buyer = (Buyer) socialRepository.getUser(userId);

        // Si lo llaman sin el parámetro de orden lo asumo como si es descendiente
        if(order == null)
            order = "date_desc";
        else if(!order.equals("date_asc") && !order.equals("date_desc"))
            throw new InvalidOrderException("El ordenamiento especificado es inválido");

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

        return new FollowedPostListDto(buyer.getUserId(),
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
    public void unfollowSeller(int userId, int userIdToUnfollow) throws Exception {
        // Valido la existencia y rol de cada usuario
        UserValidation(userId, UserType.BUYER);
        UserValidation(userIdToUnfollow, UserType.SELLER);

        // Transacciono para asegurar la consistencia
        try{
            Buyer buyer = (Buyer) socialRepository.getUser(userId);
            buyer.deleteFollowed(userIdToUnfollow);
            socialRepository.createUser(buyer);

            Seller seller = (Seller) socialRepository.getUser(userIdToUnfollow);
            seller.deleteFollower(userId);
            socialRepository.createUser(seller);
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
    public PromoPostCountDto getPromoPostCount(int userId) throws WrongTypeException, NotFoundException {
        UserValidation(userId, UserType.SELLER);
        return new PromoPostCountDto(userId,
                socialRepository.getUser(userId).getUserName(),
                // Obtengo los post del vendedor, los filtro por si tienen promoción, obtengo la cantidad y la casteo a entero, ya que el count devuelve un long.
                (int) ((Seller)socialRepository.getUser(userId))
                        .getPostsIds().stream()
                        .map(p -> socialRepository.getPost(p))
                        .filter(Post::isHasPromo)
                        .count());
    }

    @Override
    public PromoPostList getPromoPostList(int userId) throws WrongTypeException, NotFoundException {
        UserValidation(userId, UserType.SELLER);
        Seller seller = (Seller) socialRepository.getUser(userId);

        return new PromoPostList(seller.getUserId(),
                seller.getUserName(),
                // Obtengo los posts, los filtro por si son de promoción y los paso al DTO correspondiente
                seller.getPostsIds().stream()
                        .map(p -> socialRepository.getPost(p))
                        .filter(Post::isHasPromo)
                        .map(PromoPostDtoOut::new)
                        .collect(Collectors.toList()));
    }

    private void UserValidation(int userId, UserType userType) throws WrongTypeException, NotFoundException {
        // Me fijo primero que tipo de usuario quiero validar
        if (userType.equals(UserType.BUYER)){
            // Si no existe lanzo una excepción de no encontrado
            if(!socialRepository.existsUser(userId))
                throw new NotFoundException("El comprador con identificatorio " + userId + " no se ha encontrado");
            // Si existe, pero no es del tipo buscado lanzo una excepción de tipo incorrecto
            else if(socialRepository.getUser(userId).getUserType() != UserType.BUYER)
                throw new WrongTypeException("El usuario con identificatorio " + userId + " no es un comprador");
        }
        // Análogo a lo anterior pero con el vendedor, lo hago aparte para poder diferenciar los mensajes de cada uno
        else if (userType.equals(UserType.SELLER)){
            if(!socialRepository.existsUser(userId))
                throw new NotFoundException("El vendedor con identificatorio " + userId + " no se ha encontrado");
            else if(socialRepository.getUser(userId).getUserType() != UserType.SELLER)
                throw new WrongTypeException("El usuario con identificatorio " + userId + " no es un vendedor");
        }
    }

    private List<User> orderUserByName(List<User> users, String order) throws InvalidOrderException {
        // Si es nulo porque se llamó al endpoint sin el parámetro lo tomo como ascendente
        if(order == null || order.equals("name_asc"))
            return users.stream()
                    .sorted(Comparator.comparing(User::getUserName))
                    .collect(Collectors.toList());
        else if(order.equals("name_desc"))
            return users.stream()
                    .sorted(Comparator.comparing(User::getUserName).reversed())
                    .collect(Collectors.toList());
        else
            throw new InvalidOrderException("El ordenamiento especificado es inválido");
    }

    private void savePost(Post post) throws Exception {
        // Valido al usuario
        UserValidation(post.getUserId(), UserType.SELLER);

        // Me fijo si no existía ya un post con el mismo identificador que el nuevo
        if(socialRepository.existsPost(post.getIdPost()))
            throw new DuplicateException("Ya existe un post con ese identificador");

        // Transacciono para conservar la consistencia
        try{
            socialRepository.createPost(post);
            Seller seller = (Seller) socialRepository.getUser(post.getUserId());
            seller.addPost(post.getIdPost());
            socialRepository.createUser(seller);
        }
        catch(Exception e){
            throw new Exception("Error al crear un nuevo post : " + e.getMessage());
        }

    }
}
