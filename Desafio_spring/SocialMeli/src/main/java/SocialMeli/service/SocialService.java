package SocialMeli.service;

import SocialMeli.dto.request.NewPostDTO;
import SocialMeli.dto.request.NewUserDTO;
import SocialMeli.dto.response.FollowedListDTO;
import SocialMeli.dto.response.FollowersCountDTO;
import SocialMeli.dto.response.FollowersListDTO;
import SocialMeli.dto.response.PostListDTO;
import SocialMeli.exception.AlredyFollowedException;
import SocialMeli.exception.WrongIdException;
import SocialMeli.mapper.ISocialMapper;
import SocialMeli.model.Customer;
import SocialMeli.model.Seller;
import SocialMeli.repository.ISocialRepository;
import org.springframework.stereotype.Service;

@Service
public class SocialService implements ISocialService{

    ISocialRepository socialRepository;
    ISocialMapper socialMapper;

    public SocialService(ISocialRepository socialRepository, ISocialMapper socialMapper) {
        this.socialRepository = socialRepository;
        this.socialMapper = socialMapper;
    }

    private void sortByName(String type){};
    private void sortByDate(String type){};

    @Override
    public void followSeller(int customerId, int sellerId) {
        Seller seller = socialRepository.getSeller(sellerId);
        Customer customer =  socialRepository.getCustomer(customerId);
        if(!seller.getFollowersIdSet().add(customer.getUser_id())){
            throw new AlredyFollowedException();
        };
        customer.getFollowedsIdSet().add(seller.getUser_id());
    }

    @Override
    public void unfollowSeller(int customerId, int sellerId) {

    }

    @Override
    public FollowersCountDTO getFollowersCount(int sellerId) {
        Seller seller = socialRepository.getSeller(sellerId);
        return socialMapper.sellerToFollowersCountDTO(seller);
    }

    @Override
    public FollowersListDTO getFollowersList(int sellerId) {
        Seller seller = socialRepository.getSeller(sellerId);
        return socialMapper.sellerToFollowersListDTO(seller, socialRepository.getFollowers(sellerId));
    }

    @Override
    public FollowedListDTO getFollowedList(int customerId) {
        Customer customer = socialRepository.getCustomer(customerId);
        return socialMapper.customerToFollowedListDTO(customer, socialRepository.getFollowed(customerId));
    }

    @Override
    public void newPost(NewPostDTO post) {
        socialRepository.newPost(socialMapper.newPostDTOtoPost(post));
    }

    @Override
    public PostListDTO getTwoWeeksPost(int customerId) {

        return null;
    }

    @Override
    public void newUser(NewUserDTO newUser) {

    }
}
