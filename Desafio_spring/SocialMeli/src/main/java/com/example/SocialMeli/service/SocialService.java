package com.example.SocialMeli.service;

import com.example.SocialMeli.dto.*;
import com.example.SocialMeli.exceptions.FollowException;
import com.example.SocialMeli.exceptions.MissingFieldsException;
import com.example.SocialMeli.exceptions.UserNotFoundException;
import com.example.SocialMeli.mapper.Mapper;
import com.example.SocialMeli.model.Product;
import com.example.SocialMeli.model.Publication;
import com.example.SocialMeli.model.User;
import com.example.SocialMeli.repository.ISocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocialService implements ISocialService{

    @Autowired
    ISocialRepository socialRepository;

    final static Mapper mapperDatos = new Mapper();

    @Override
    public void followUser(int userId, int userIdToFollow) {

        if (userId == userIdToFollow){
            throw new FollowException("No se permite seguirse a si mismo");
        }
        socialRepository.followUser(userId, userIdToFollow);

    }

    @Override
    public UserDataDto countFollowers(int userId) {

        User usuario = socialRepository.getUser(userId);
        int followers = usuario.getFollowers().size();
        return new UserDataDto(usuario.getUserId(),usuario.getUserName(),followers);
    }

    @Override
    public UserFollowDto listFollowers(int userId, String order) {
        User usuario = socialRepository.getUser(userId);

        UserFollowDto userDto = new UserFollowDto();
        userDto.setUserId(usuario.getUserId());
        userDto.setUserName(usuario.getUserName());
        userDto.setFollowers(new ArrayList<>());

        for (User u: usuario.getFollowers()) {
            userDto.addFollower(new UserDto(u.getUserId(),u.getUserName()));
        }

        if(order.equals("name_asc")){

            userDto.setFollowers(
                    userDto.getFollowers().stream()
                            .sorted(Comparator.comparing(UserDto::getUserName))
                            .collect(Collectors.toList()));
        }
        else if(order.equals("name_desc")){
            userDto.setFollowers(
                    userDto.getFollowers().stream()
                            .sorted(Comparator.comparing(UserDto::getUserName).reversed())
                            .collect(Collectors.toList()));
        }

        return userDto;
    }

    @Override
    public UserFollowDto listFollowed(int userId, String order) {
        User usuario = socialRepository.getUser(userId);

        UserFollowDto userDto = new UserFollowDto();
        userDto.setUserId(usuario.getUserId());
        userDto.setUserName(usuario.getUserName());
        userDto.setFollowed(new ArrayList<>());

        for (User u: usuario.getFollowed()) {
            userDto.addFollowed(new UserDto(u.getUserId(),u.getUserName()));
        }

        if(order.equals("name_asc")){

            userDto.setFollowed(
            userDto.getFollowed().stream()
                    .sorted(Comparator.comparing(UserDto::getUserName))
                    .collect(Collectors.toList()));
        }
        else if(order.equals("name_desc")){
            userDto.setFollowed(
                    userDto.getFollowed().stream()
                            .sorted(Comparator.comparing(UserDto::getUserName).reversed())
                            .collect(Collectors.toList()));
        }

        return userDto;
    }

    @Override
    public void postPublication(PublicationDto publicationDto) {

        User usuario = socialRepository.getUser(publicationDto.getUserId());
        Publication publication = new Publication();
        try {
            Product product;
            product = mapperDatos.productDtoToProduct(publicationDto.getDetail());
            publication = mapperDatos.publicationDtoToPublicacion(publicationDto,product);
            //publication.setDetail(product);
        }
        catch (Exception e){
            throw new MissingFieldsException("Valide que todos los campos esten correctos");
        }

        socialRepository.createPublication(usuario.getUserId(), publication);

    }

    @Override
    public UserDto getProductsFollowed(int userId, String order) {
        User usuario = socialRepository.getUser(userId);
        UserDto userDto = new UserDto();
        userDto.setUserId(usuario.getUserId());

        Comparator<Publication> orden = order.equals("date_asc") ? Comparator.comparing(Publication::getDate):Comparator.comparing(Publication::getDate).reversed();
        userDto.setPosts(
                usuario.getFollowed().stream()
                        .flatMap(u -> u.getPosts().stream())
                        .sorted(orden)
                        .filter(f -> f.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                        .map(publ -> {
                            ProductDto productDto;
                            productDto = mapperDatos.productToProductDto(publ.getDetail());
                            PublicationDto publicationDto = new PublicationDto();
                            publicationDto = mapperDatos.publicationToPublicacionDto(publ, productDto);

                            return publicationDto;
                        })
                        .collect(Collectors.toList()));

        return userDto;
    }

    @Override
    public void unfollowUser(int userId, int userIdToUnfollow) {

        socialRepository.unfollowUser(userId,userIdToUnfollow);
    }

    @Override
    public UserCountPromoDto countPromoPublications(int userId) {
        User usuario = socialRepository.getUser(userId);

        if (usuario == null){
            throw new UserNotFoundException("Usuario "+userId+" no encontrado");
        }
        int publicationsPromo = usuario.getPosts().stream()
                .filter(publ -> publ.isHasPromo())
                .collect(Collectors.toList())
                .size();

        return new UserCountPromoDto(usuario.getUserId(),usuario.getUserName(),publicationsPromo);

    }

    @Override
    public UserDto getPublicationsPromo(int userId, String order) {
        User usuario = socialRepository.getUser(userId);

        UserDto userDto = new UserDto();
        userDto.setUserId(usuario.getUserId());
        userDto.setUserName(usuario.getUserName());

        List<PublicationDto> pp =
            usuario.getPosts().stream()
            .filter(p -> p.isHasPromo())
            .sorted(Comparator.comparing(p -> p.getDetail().getProductName()))

            .map(publication -> {
                ProductDto productDto = new ProductDto();
                productDto = mapperDatos.productToProductDto(publication.getDetail());
                PublicationDto publicationDto = new PublicationDto();
                publicationDto = mapperDatos.publicationToPublicacionDto(publication, productDto);

                return publicationDto;
            }).collect(Collectors.toList());

        if (order.equals("name_desc")){
            Collections.reverse(pp);
        }
        userDto.setPosts(pp);
        return userDto;
    }

    @Override
    public List<User> getUsers() {
        return socialRepository.getUsers();
    }

    @Override
    public User getUser(int userId) {

        return socialRepository.getUser(userId);
    }

}
