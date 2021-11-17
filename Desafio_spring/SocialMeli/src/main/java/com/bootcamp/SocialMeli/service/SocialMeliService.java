package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.CountDTO;
import com.bootcamp.SocialMeli.dto.FollowedDTO;
import com.bootcamp.SocialMeli.dto.FollowerDTO;
import com.bootcamp.SocialMeli.dto.ProductoDTO;
import com.bootcamp.SocialMeli.dto.PublicationDTO;
import com.bootcamp.SocialMeli.dto.UserDTO;
import com.bootcamp.SocialMeli.dto.UserPublicationDTO;
import com.bootcamp.SocialMeli.exception.NotFoundUserId;
import com.bootcamp.SocialMeli.mapper.PublicationMapper;
import com.bootcamp.SocialMeli.model.Producto;
import com.bootcamp.SocialMeli.model.Publication;
import com.bootcamp.SocialMeli.model.User;
import com.bootcamp.SocialMeli.repository.ISocialMeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SocialMeliService implements ISocialMeliService {
    @Autowired
    ISocialMeliRepository iSocialMeliRepository;
    @Autowired
    PublicationMapper publicationMapper;

    public void checkUser(Integer user_id) {
        if (!iSocialMeliRepository.checkUser(user_id)) {
            throw new NotFoundUserId(user_id);
        }
    }

    public UserDTO userToUserDTO(User userD) {
        return new UserDTO(userD.getUser_id(), userD.getUser_name());
    }

    public PublicationDTO publicationToPublicationDTO(Publication publication) {
        ProductoDTO detail = this.detailsProd(publication.getDetails());
        return new PublicationDTO(publication.getUser_id(), publication.getId_post(),
                publication.getDate(), detail,
                publication.getCategory(), publication.getPrice());
    }

    public ProductoDTO detailsProd(Producto producto) {
        return new ProductoDTO(producto.getProduct_id(), producto.getProduct_name(),
                producto.getType(), producto.getBrand(), producto.getColor(), producto.getNotes());
    }

    @Override
    public void newFollow(Integer user_id, Integer user_id_to_follow) {
        this.checkUser(user_id);
        this.checkUser(user_id_to_follow);
        iSocialMeliRepository.newFollow(user_id, user_id_to_follow);
    }

    @Override
    public CountDTO followerCount(Integer user_id) {
        this.checkUser(user_id);
        User follower = this.iSocialMeliRepository.userId(user_id);
        return new CountDTO(follower.getUser_id(),
                follower.getUser_name(),
                follower.followersCount());
    }

    @Override
    public FollowerDTO followerList(Integer user_id, String order) {
        this.checkUser(user_id);
        User followerUser = this.iSocialMeliRepository.userId(user_id);
        List<UserDTO> followerList = this.iSocialMeliRepository.followerList(user_id).stream()
                .map(i -> userToUserDTO(i)).collect(Collectors.toList());
        if (!Objects.isNull(order)) {
            followerList = this.orderName(followerList, order);
        }
        return new FollowerDTO(followerUser.getUser_id(),
                followerUser.getUser_name(),
                followerList);
    }

    @Override
    public FollowedDTO followedList(Integer user_id, String order) {
        this.checkUser(user_id);
        User followed = this.iSocialMeliRepository.userId(user_id);
        List<UserDTO> followedList = this.iSocialMeliRepository.followedList(user_id).stream()
                .map(i -> userToUserDTO(i)).collect(Collectors.toList());
        if (!Objects.isNull(order)) {
            followedList = this.orderName(followedList, order);
        }
        return new FollowedDTO(followed.getUser_id(),
                followed.getUser_name(),
                followedList);
    }

    @Override
    public Publication newPublication(PublicationDTO publicationDTO) {
        return iSocialMeliRepository.createPublication(
                PublicationMapper.newPublication(publicationDTO));
    }

    @Override
    public void deleteFollow(Integer user_id, Integer user_id_to_unfollow) {
        if (user_id.equals(user_id_to_unfollow)) {
            iSocialMeliRepository.deleteFollow(user_id, user_id_to_unfollow);
            iSocialMeliRepository.deleteFollow(user_id, user_id_to_unfollow);
        }
    }

    @Override
    public UserPublicationDTO recentPublication(Integer user_id, String order) {
        this.checkUser(user_id);
        List<Publication> recentPost = this.iSocialMeliRepository.followedList(user_id).stream()
                .map(i -> this.iSocialMeliRepository.recentPublication(i.getUser_id())).flatMap(
                        Collection::stream).sorted(Comparator.comparing(Publication::getDate,
                        Collections.reverseOrder())).collect(Collectors.toList());
        if (Objects.nonNull(order)) {
            recentPost = this.orderPost(recentPost, order);
        }
        return new UserPublicationDTO(user_id, recentPost.stream().map(p ->
                this.publicationToPublicationDTO(p)).collect(Collectors.toList()));
    }

    private List<UserDTO> orderName(List<UserDTO> users, String order) {
        Comparator<UserDTO> orderType;
        if (order.equals("name_asc")) {
            orderType = Comparator.comparing(UserDTO::getUser_name);
        } else if (order.equals("name_desc")) {
            orderType = Comparator.comparing(UserDTO::getUser_name,
                    Collections.reverseOrder());
        } else return null;
        return this.comparatorUser(users, orderType);
    }

    private List<UserDTO> comparatorUser(List<UserDTO> users, Comparator<UserDTO> orderType) {
        return users.stream().sorted(orderType).collect(Collectors.toList());
    }

    private List<Publication> orderPost(List<Publication> publications, String order) {
        Comparator<Publication> orderComparator;
        if (order.equals("date_asc")) {
            orderComparator = Comparator.comparing(Publication::getDate);
        } else if (order.equals("date_desc")) {
            orderComparator = Comparator.comparing(Publication::getDate,
                    Collections.reverseOrder());
        } else return null;
        return this.comparatorPublication(publications, orderComparator);
    }

    private List<Publication> comparatorPublication(List<Publication> publicationA,
                                                    Comparator<Publication> orderType) {
        return publicationA.stream().sorted(orderType).collect(Collectors.toList());
    }
}
