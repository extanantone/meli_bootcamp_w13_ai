package bootcamp.SocialMeli.services;

import bootcamp.SocialMeli.dto.CountSellerFollowersDto;
import bootcamp.SocialMeli.dto.ListFollowerDto;
import bootcamp.SocialMeli.dto.NewPostDto;
import bootcamp.SocialMeli.dto.PostListDto;

public interface IService {

    void followUser(int idUser, int idSeller);

    CountSellerFollowersDto getCountBySeller(int idSeller);

    ListFollowerDto getFollowerList(int idSeller);

    ListFollowerDto getListFollowerAsc(int userId);

    ListFollowerDto getListFollowerDesc(int userId);

    ListFollowerDto getListFollowedAsc(int userId);

    ListFollowerDto getListFollowedDesc(int userId);

    ListFollowerDto getFollowed(int userId);

    void addPost(NewPostDto dto);

    PostListDto getListPostByUser(int userId);

    PostListDto getListPostByUserAsc(int id);

    PostListDto getListPostByUserDesc(int id);

    void unfollowUser(int id, int sellerId);

}
