package SocialMeli.service;

import SocialMeli.dto.request.NewPostDTO;
import SocialMeli.dto.request.NewUserDTO;
import SocialMeli.dto.response.list.FollowedListDTO;
import SocialMeli.dto.response.count.FollowersCountDTO;
import SocialMeli.dto.response.list.FollowersListDTO;
import SocialMeli.dto.response.list.PostListDTO;
import SocialMeli.dto.response.count.PromoCountDTO;
import SocialMeli.exception.AlredyFollowedException;
import SocialMeli.exception.NotFollowedException;
import SocialMeli.mapper.ISocialMapper;
import SocialMeli.model.Customer;
import SocialMeli.model.Post;
import SocialMeli.model.Seller;
import SocialMeli.repository.ISocialRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class SocialService implements ISocialService {

    ISocialRepository socialRepository;
    ISocialMapper socialMapper;

    public SocialService(ISocialRepository socialRepository, ISocialMapper socialMapper) {
        this.socialRepository = socialRepository;
        this.socialMapper = socialMapper;
    }

    private List<Customer> sortCustomerByName(List<Customer> userList, String type) {
        if (type != null) {
            if (type.equals("name_asc")) userList.sort(Comparator.comparing(Customer::getUserName));
            if (type.equals("name_desc")) userList.sort(Comparator.comparing(Customer::getUserName).reversed());
        }
        return userList;
    }

    private List<Seller> sortSellerByName(List<Seller> userList, String type) {
        if (type != null) {
            if (type.equals("name_asc")) userList.sort(Comparator.comparing(Seller::getUserName));
            if (type.equals("name_desc")) userList.sort(Comparator.comparing(Seller::getUserName).reversed());
        }
        return userList;
    }


    private List<Post> sortPostByDate(List<Post> postList, String type) {
        if (type != null) {
            if (type.equals("date_asc")) postList.sort(Comparator.comparing(Post::getDate));
            if (type.equals("date_asc")) postList.sort(Comparator.comparing(Post::getDate).reversed());
        }
        return postList;
    }

    @Override
    public void followSeller(int customerId, int sellerId) {
        Seller seller = socialRepository.getSeller(sellerId);
        Customer customer = socialRepository.getCustomer(customerId);
        if (!seller.getFollowersIdSet().add(customer.getUserId())) {
            throw new AlredyFollowedException();
        }
        customer.getFollowedsIdSet().add(seller.getUserId());
    }

    @Override
    public void unfollowSeller(int customerId, int sellerId) {
        Seller seller = socialRepository.getSeller(sellerId);
        Customer customer = socialRepository.getCustomer(customerId);
        if (!customer.getFollowedsIdSet().remove(sellerId)) {
            throw new NotFollowedException();
        }
        seller.getFollowersIdSet().remove(customer.getUserId());
    }

    @Override
    public FollowersCountDTO getFollowersCount(int sellerId) {
        Seller seller = socialRepository.getSeller(sellerId);
        return socialMapper.sellerToFollowersCountDTO(seller);
    }

    @Override
    public FollowersListDTO getFollowersList(int sellerId, String order) {
        Seller seller = socialRepository.getSeller(sellerId);
        return socialMapper.sellerToFollowersListDTO(seller, sortCustomerByName(socialRepository.getFollowers(sellerId), order));
    }

    @Override
    public FollowedListDTO getFollowedList(int customerId, String order) {
        Customer customer = socialRepository.getCustomer(customerId);
        return socialMapper.customerToFollowedListDTO(customer, sortSellerByName(socialRepository.getFollowed(customerId), order));
    }

    @Override
    public void newPost(NewPostDTO post) {
        socialRepository.newPost(socialMapper.newPostDTOtoPost(post));
    }

    @Override
    public PostListDTO getTwoWeeksPost(int customerId, String order) {
        return socialMapper.postListToPostListDTO(customerId, sortPostByDate(socialRepository.getCustomerPostsByDate(
                customerId, LocalDate.now().minusDays(13), LocalDate.now()), order));
    }

    @Override
    public void newUser(NewUserDTO newUser) {
        socialRepository.newUser(socialMapper.newUserDTOtoUser(newUser));
    }

    //BONUS
    @Override
    public PromoCountDTO getPromoCount(int sellerId) {
        Seller seller = socialRepository.getSeller(sellerId);
        return socialMapper.sellerToPromoCountDTO(seller, socialRepository.getSellerPromoPosts(sellerId).size());
    }

    @Override
    public PostListDTO getPromoList(int sellerId) {
        return socialMapper.promoPostListToPostListDTO(socialRepository.getSeller(sellerId), socialRepository.getSellerPromoPosts(sellerId));
    }
}
