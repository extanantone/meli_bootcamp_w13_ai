package com.example.SocialMeli.service;

import com.example.SocialMeli.dto.*;
import com.example.SocialMeli.exceptions.*;
import com.example.SocialMeli.mapper.Mapper;
import com.example.SocialMeli.model.Product;
import com.example.SocialMeli.model.Publication;
import com.example.SocialMeli.model.User;
import com.example.SocialMeli.repository.ISocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
            throw new FollowYourselfException();
        }
        User user = this.getUserById(userId);
        User userToFollow = this.getUserById(userIdToFollow);
        if(user.getFollowers().contains(userToFollow)){
            throw new DuplicateFollowException(user.getUserId(),userToFollow.getUserId());
        }
        socialRepository.followUser(user, userToFollow);
    }

    @Override
    public UserDataDto countFollowers(int userId) {
        User usuario = this.getUserById(userId);
        int followers = usuario.getFollowers().size();
        return new UserDataDto(usuario.getUserId(),usuario.getUserName(),followers);
    }

    @Override
    public UserFollowDto listFollowers(int userId, String order) {
        User usuario = this.getUserById(userId);
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
        User usuario = this.getUserById(userId);
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
        User usuario = this.getUserById(publicationDto.getUserId());
        Publication publication;
        try {
            Product product;
            product = mapperDatos.productDtoToProduct(publicationDto.getDetail());
            publication = mapperDatos.publicationDtoToPublicacion(publicationDto,product);
        }
        catch (Exception e){
            throw new MissingFieldsException("Valide que todos los campos esten correctos");
        }
        Publication publi = usuario.getPosts().stream()
                .filter(pub -> pub.getIdPost()==publication.getIdPost())
                .findFirst()
                .orElse(null);

        if(publi != null){
            throw new DuplicatePostException(publication.getIdPost());
        }
        socialRepository.createPublication(usuario, publication);
    }

    @Override
    public UserDto getProductsFollowed(int userId, String order) {
        User usuario = this.getUserById(userId);//socialRepository.getUser(userId);
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
        User user = this.getUserById(userId);
        User userToUnfollow = this.getUserById(userIdToUnfollow);
        if(!user.getFollowed().contains(userToUnfollow)){
            throw new FollowingException(userId, userIdToUnfollow);
        }
        socialRepository.unfollowUser(user,userToUnfollow);
    }

    @Override
    public UserCountPromoDto countPromoPublications(int userId) {
        User usuario = this.getUserById(userId); //socialRepository.getUser(userId);
        int publicationsPromo = usuario.getPosts().stream()
                .filter(publ -> publ.isHasPromo())
                .collect(Collectors.toList())
                .size();
        return new UserCountPromoDto(usuario.getUserId(),usuario.getUserName(),publicationsPromo);
    }

    @Override
    public UserDto getPublicationsPromo(int userId, String order) {
        User usuario = this.getUserById(userId);//socialRepository.getUser(userId);
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
    public User getUserById(int userId) throws UserNotFoundException {
        return socialRepository.findUser(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    @Override
    public List<User> getUsers() {
        return socialRepository.getUsers();
    }

}
