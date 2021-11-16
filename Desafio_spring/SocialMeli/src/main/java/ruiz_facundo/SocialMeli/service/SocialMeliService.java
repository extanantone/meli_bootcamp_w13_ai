package ruiz_facundo.SocialMeli.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ruiz_facundo.SocialMeli.dto.*;
import ruiz_facundo.SocialMeli.exception.*;
import ruiz_facundo.SocialMeli.mapper.SocialMeliMapper;
import ruiz_facundo.SocialMeli.model.Post;
import ruiz_facundo.SocialMeli.model.User;
import ruiz_facundo.SocialMeli.repository.SocialMeliRepositoryI;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SocialMeliService implements SocialMeliServiceI {
    @Autowired
    SocialMeliRepositoryI socialRepository;
    @Autowired
    SocialMeliMapper socialMapper;

    @Override
    public void follow (Long idNewFollower, Long idNewFollowed) {
        this.checkUser(idNewFollower);
        this.checkUser(idNewFollowed);
        if (this.socialRepository.getFollowed(idNewFollower).stream().
                anyMatch(u -> u.getId().equals(idNewFollowed))) {
            throw new FollowFoundException(idNewFollower, idNewFollowed);
        }
        if (this.socialRepository.getFollowers(idNewFollowed).stream().
                anyMatch(u -> u.getId().equals(idNewFollower))) {
            throw new FollowFoundException(idNewFollower, idNewFollowed);
        }
        this.socialRepository.addFollow(idNewFollower, idNewFollowed);
    }

    @Override
    public void unfollow (Long idOldFollower, Long idOldFollowed) {
        this.checkUser(idOldFollower);
        this.checkUser(idOldFollowed);
        if (this.socialRepository.getFollowed(idOldFollower).stream().
                noneMatch(u -> u.getId().equals(idOldFollowed))) {
            throw new FollowNotFoundException(idOldFollower, idOldFollowed);
        }
        if (this.socialRepository.getFollowers(idOldFollowed).stream().
                noneMatch(u -> u.getId().equals(idOldFollower))) {
            throw new FollowNotFoundException(idOldFollower, idOldFollowed);
        }
        this.socialRepository.removeFollow(idOldFollower, idOldFollowed);
    }

    @Override
    public UserFollowersCountDTO getFollowersCount (Long idUser) {
        this.checkUser(idUser);
        User followedUser = this.socialRepository.getUser(idUser);
        return new UserFollowersCountDTO(followedUser.getId(),
                followedUser.getName(), followedUser.getFollowersCount());
    }

    @Override
    public UserFollowersDTO getFollowers (Long idUser, String criteria) {
        this.checkUser(idUser);
        User followedUser = this.socialRepository.getUser(idUser);
        List<UserDTO> followersList = this.socialRepository.getFollowers(idUser).
                stream().map(u -> this.socialMapper.UserToUserDTO(u)).
                collect(Collectors.toList());
        if (!Objects.isNull(criteria)) {
            followersList = this.orderUserDTOsByName(followersList, criteria);
        }
        return new UserFollowersDTO(followedUser.getId(), followedUser.getName(), followersList);
    }

    @Override
    public UserFollowedDTO getFollowed (Long idUser, String criteria) {
        this.checkUser(idUser);
        User followerUser = this.socialRepository.getUser(idUser);
        List<UserDTO> followedList = this.socialRepository.getFollowed(idUser).
                stream().map(u -> this.socialMapper.UserToUserDTO(u)).collect(Collectors.toList());
        if (!Objects.isNull(criteria)) {
            followedList = this.orderUserDTOsByName(followedList, criteria);
        }
        return new UserFollowedDTO(followerUser.getId(), followerUser.getName(), followedList);
    }

    @Override
    public void publish (RequestPostDTO newPostReq) {
        this.validateRequestPost(newPostReq);
        this.socialRepository.addPostToUser(newPostReq.getUserId(),
                this.socialMapper.RequestPostDTOToPost(newPostReq));
    }

    @Override
    public UserPostsDTO getRecentPosts (Long idUser, String criteria) {
        this.checkUser(idUser);
        List<Post> recentPostsByFollowed = this.socialRepository.getFollowed(idUser).stream().map(
                u -> this.socialRepository.getRecentPosts(u.getId())).
                flatMap(Collection::stream).sorted(Comparator.comparing(Post::getPublishDate,
                Collections.reverseOrder())).collect(Collectors.toList());
        if (!Objects.isNull(criteria)) {
            recentPostsByFollowed = this.orderPostsByDate(recentPostsByFollowed, criteria);
        }
        return new UserPostsDTO(idUser, recentPostsByFollowed.stream().map(
                p -> this.socialMapper.PostToPostDTO(p)).collect(Collectors.toList()));
    }

    @Override
    public void publishPromo (RequestPromotionDTO newPromoReq) {
        this.validateRequestPost(newPromoReq);
        if (!newPromoReq.isHasPromo()) {
            throw new InvalidPostException("La publicación no tiene promoción");
        }
        if (newPromoReq.getDiscount() < 0 || newPromoReq.getDiscount() > 100) {
            throw new InvalidPostException("El valor de descuento es inválido");
        }
        this.socialRepository.addPostToUser(newPromoReq.getUserId(),
                this.socialMapper.RequestPromotionDTOToPromotion(newPromoReq));
    }

    @Override
    public UserPromoCountDTO getPromosCount (Long idUser) {
        this.checkUser(idUser);
        User vendor = this.socialRepository.getUser(idUser);
        Integer promosCount = this.socialRepository.getPromoPosts(idUser).size();
        return new UserPromoCountDTO(idUser, vendor.getName(), promosCount);
    }

    @Override
    public UserNamePostsDTO getPromoPosts(Long idUser, String criteria) {
        this.checkUser(idUser);
        User vendor = this.socialRepository.getUser(idUser);
        List<Post> promos = this.socialRepository.getPromoPosts(idUser);
        if (!Objects.isNull(criteria)) {
            promos = this.orderPostsByProductName(promos, criteria);
        }
        return new UserNamePostsDTO(vendor.getId(), vendor.getName(), promos.stream().
                map(p -> this.socialMapper.PromotionToPromotionDTO(p)).collect(Collectors.toList()));
    }

    private void checkUser (Long idUser) {
        if (!this.socialRepository.isValidUser(idUser)) {
            throw new UserIdNotFoundException(idUser);
        }
    }

    private List<UserDTO> orderUserDTOsByName (List<UserDTO> inUsers, String criteria) {
        Comparator<UserDTO> criteriaComp;
        if (criteria.equals("name_asc")) {
            criteriaComp = Comparator.comparing(UserDTO::getUserName);
        } else if (criteria.equals("name_desc")) {
            criteriaComp = Comparator.comparing(UserDTO::getUserName,
                    Collections.reverseOrder());
        } else throw new InvalidSortCriteriaException();
        return this.sortUserDTOsByComparator(inUsers, criteriaComp);
    }

    private List<Post> orderPostsByDate (List<Post> inPosts, String criteria) {
        Comparator<Post> criteriaComp;
        if (criteria.equals("date_asc")) {
            criteriaComp = Comparator.comparing(Post::getPublishDate);
        } else if (criteria.equals("date_desc")) {
            criteriaComp = Comparator.comparing(Post::getPublishDate,
                    Collections.reverseOrder());
        } else throw new InvalidSortCriteriaException();
        return this.sortPostsByComparator(inPosts, criteriaComp);
    }

    private void validateRequestPost (RequestPostDTO newPostReq) {
        this.checkUser(newPostReq.getUserId());
        Long newPostId = newPostReq.getIdPost();
        if (this.socialRepository.isValidPost(newPostId)) {
            throw new PostFoundException(newPostId);
        }
        if (newPostReq.getDate().isAfter(LocalDate.now())) {
            throw new InvalidPostException("Día de publicación inválido");
        }
        if (newPostReq.getCategory() < 0) {
            throw new InvalidPostException("Categoría de publicación inválida");
        }
        if (newPostReq.getPrice() < 0) {
            throw new InvalidPostException("Precio de publicación inválido");
        }
    }

    private List<Post> orderPostsByProductName (List<Post> inPosts, String criteria) {
        Comparator<Post> criteriaComp;
        if (criteria.equals("name_asc")) {
            criteriaComp = Comparator.comparing(p -> p.getProductOnSale().getName());
        } else if (criteria.equals("name_desc")) {
            criteriaComp = Comparator.comparing(p -> p.getProductOnSale().getName(),
                    Collections.reverseOrder());
        } else throw new InvalidSortCriteriaException();
        return this.sortPostsByComparator(inPosts, criteriaComp);
    }

    private List<Post> sortPostsByComparator (List<Post> postsToBeSorted, Comparator<Post> inComp) {
        return postsToBeSorted.stream().sorted(inComp).collect(Collectors.toList());
    }

    private List<UserDTO> sortUserDTOsByComparator (List<UserDTO> userDTOsToBeSorted,
                                                Comparator<UserDTO> inComp) {
        return userDTOsToBeSorted.stream().sorted(inComp).collect(Collectors.toList());
    }
}
