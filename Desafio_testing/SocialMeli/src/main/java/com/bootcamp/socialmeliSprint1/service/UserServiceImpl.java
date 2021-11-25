package com.bootcamp.socialmeliSprint1.service;

import com.bootcamp.socialmeliSprint1.dto.comparator.ComparatorUserNameBasicUserDTO;
import com.bootcamp.socialmeliSprint1.dto.comparator.SortOrder;
import com.bootcamp.socialmeliSprint1.dto.response.user.BasicUserInfoDTO;
import com.bootcamp.socialmeliSprint1.dto.response.user.PurchaserFollowedListDTO;
import com.bootcamp.socialmeliSprint1.dto.response.user.SellerFollowersInfoDTO;
import com.bootcamp.socialmeliSprint1.dto.response.user.SellerFollowersListDTO;
import com.bootcamp.socialmeliSprint1.exception.sortException.BadSorterParamRequest;
import com.bootcamp.socialmeliSprint1.exception.userException.NotFoundFollower;
import com.bootcamp.socialmeliSprint1.exception.userException.NotFoundUsuarioException;
import com.bootcamp.socialmeliSprint1.entitiy.Purchaser;
import com.bootcamp.socialmeliSprint1.entitiy.Seller;
import com.bootcamp.socialmeliSprint1.exception.userException.PurchaserAlreadyFollowSeller;
import com.bootcamp.socialmeliSprint1.repository.ISocialMeliRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Service
public class UserServiceImpl implements IUserService {

    private final ISocialMeliRepository socialMeliRepository;

    public UserServiceImpl(ISocialMeliRepository repository) {
        this.socialMeliRepository = repository;
    }

    @Override
    public void addFollowed(Integer purchaserId, Integer sellerId) {

        Seller seller = socialMeliRepository.getSeller(sellerId).orElseThrow(
                ()-> new NotFoundUsuarioException(sellerId)
        );

        Purchaser purchaser = socialMeliRepository.getPurchaser(purchaserId).orElseThrow(
                () -> new NotFoundUsuarioException(purchaserId)
        );

        //        validar que NO se sigan anteriormente

        if (purchaser.getFollowed().contains(sellerId)){
            throw new PurchaserAlreadyFollowSeller(purchaserId,sellerId);
        }

        socialMeliRepository.follow(purchaserId,sellerId);
    }


    @Override
    public SellerFollowersInfoDTO getSellerFollowersCount(Integer sellerId) {

        Seller seller = socialMeliRepository.getSeller(sellerId).orElseThrow(
                ()-> new NotFoundUsuarioException(sellerId)
        );

        return new SellerFollowersInfoDTO(seller.getUserID(),seller.getUserName(), seller.getFollowers().size());
    }

    @Override
    public SellerFollowersListDTO getSellerFollowersList(Integer sellerId) {

        Seller seller = socialMeliRepository.getSeller(sellerId).orElseThrow(
                ()-> new NotFoundUsuarioException(sellerId)
        );

        List<BasicUserInfoDTO> followers = new ArrayList<>();

        socialMeliRepository.getSellerFollowers(sellerId).stream().forEach(follower ->{
            followers.add(new BasicUserInfoDTO(follower.getUserID(),follower.getUserName()));
        });

        return new SellerFollowersListDTO(sellerId, seller.getUserName(), followers);
    }

    @Override
    public PurchaserFollowedListDTO getPurchaserFollowedList(Integer purchaserId) {

        Purchaser purchaser = socialMeliRepository.getPurchaser(purchaserId).orElseThrow(
                () -> new NotFoundUsuarioException(purchaserId)
        );

        List<BasicUserInfoDTO> followed = new ArrayList<>();

        socialMeliRepository.gerPurchaserFollowed(purchaserId).stream().forEach(follow ->{
            followed.add(new BasicUserInfoDTO(follow.getUserID(),follow.getUserName()));
        });

        return new PurchaserFollowedListDTO(purchaserId,purchaser.getUserName(),followed);
    }

    @Override
    public void unFollow(Integer purchaserId, Integer sellerId) {

//        validar que existan
        Seller seller = socialMeliRepository.getSeller(sellerId).orElseThrow(
                ()-> new NotFoundUsuarioException(sellerId)
        );

        Purchaser purchaser = socialMeliRepository.getPurchaser(purchaserId).orElseThrow(
                () -> new NotFoundUsuarioException(purchaserId)
        );

//        validar que se sigan anteriormente

        if (!purchaser.getFollowed().contains(sellerId)){
            throw new NotFoundFollower(purchaserId,sellerId);
        }

        socialMeliRepository.unFollow(purchaserId,sellerId);
    }

    @Override
    public SellerFollowersListDTO getSellerFollowersListSort(Integer sellerId, String order) {

        SellerFollowersListDTO res = getSellerFollowersList(sellerId);

        var list = res.getFollowers();

        sort(list,order);

        return res;
    }

    @Override
    public PurchaserFollowedListDTO getPurchaserFollowedListSort(Integer purchaserId, String order) {

        PurchaserFollowedListDTO res = getPurchaserFollowedList(purchaserId);

        var list = res.getFollowed();

        sort(list,order);

        return res;
    }

    private void sort(List<BasicUserInfoDTO> list, String order){

        StringTokenizer st = new StringTokenizer(order,"_");

        if(st.hasMoreTokens()){
            if(!st.nextToken().equals("name")){
                throw new BadSorterParamRequest(order);
            }

            var sort = st.nextToken();

            if(sort.equals("asc")){
                list.sort( new ComparatorUserNameBasicUserDTO(SortOrder.ASC));
            }else{
                if(sort.equals("desc")) {
                    list.sort(new ComparatorUserNameBasicUserDTO(SortOrder.DESC));
                }else{
                    throw new BadSorterParamRequest(order);
                }
            }
        }else{
            throw new BadSorterParamRequest(order);
        }
    }

}
