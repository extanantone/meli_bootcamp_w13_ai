package com.socialmeli.service;

import com.socialmeli.dto.*;
import com.socialmeli.exception.InvalidSellerException;
import com.socialmeli.exception.InvalidUserException;
import com.socialmeli.exception.NotFoundUserException;
import com.socialmeli.model.Post;
import com.socialmeli.model.User;
import com.socialmeli.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{

    private IUserRepository iUserRepository;

    public UserService(IUserRepository iUserRepository){
        this.iUserRepository = iUserRepository;
    }

    @Override
    public void followUser(int idUser, int idSeller) {
        User seller = iUserRepository.getUserById(idSeller);
        User user = iUserRepository.getUserById(idUser);
        if(seller==null || user==null)
            throw  new NotFoundUserException("Not found user to follow");
        seller.addFollower(user);
    }

    @Override
    public SellerFollowersCountDto getCountBySeller(int idSeller) {
        User seller = iUserRepository.getUserById(idSeller);
        if(seller==null)
            throw new NotFoundUserException("Not found seller");
        else if(!seller.isSeller())
            throw new InvalidSellerException("Not is seller");
        return new SellerFollowersCountDto(seller.getId(),seller.getName(),seller.getFollowers().size());
    }

    @Override
    public FollowerListDto getFollowerList(int idSeller) {
        User seller = iUserRepository.getUserById(idSeller);
        if(seller==null)
            throw new NotFoundUserException("Not exist this user");
        else if(!seller.isSeller())
            throw new InvalidSellerException("Not is a seller");

        List<FollowerItemDto> items = seller.getFollowers().stream()
                                .map(i->new FollowerItemDto(i.getId(),i.getName()))
                                .collect(Collectors.toList());

        return new FollowerListDto(seller.getId(),seller.getName(), items);
    }

    @Override
    public FollowedListDto getFollowed(int userId) {
        User user = iUserRepository.getUserById(userId);
        if(user==null)
            throw new NotFoundUserException("Not exist user");
        List<FollowedItemDto> items = iUserRepository.followedUser(user)
                            .stream().map(u->new FollowedItemDto(u.getId(),u.getName()))
                            .collect(Collectors.toList());
        return new FollowedListDto(user.getId(),user.getName(),items);
    }

    @Override
    public void addPost(PostDto dto) {
        User user = iUserRepository.getUserById(dto.getUserId());
        if(user==null)
            throw new NotFoundUserException("Not exist user");
        DetailDto detail = dto.getDetail();
        //System.out.println(dto.getIdPost());
        user.addPost(new Post(dto.getIdPost(), LocalDate.parse(dto.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")),detail.getProductId(),detail.getProductName(),
                detail.getType(),detail.getBrand(),detail.getColor(),detail.getNotes(),dto.getCategory(),
                dto.getPrice(),false,0));
    }

    @Override
    public ListPostDto getListDtoSubscriptionByUser(int iduser) {
        if(iUserRepository.getUserById(iduser)==null)
            throw new NotFoundUserException("Not exist user");
        List<Post> posts =  iUserRepository.getPostLastTwoWeeksOfFollowed(iduser);
        List<PostDtoWithoutUser> pdtos = posts.stream().map(i->new PostDtoWithoutUser(i.getId(),i.getDate().toString(),new DetailDto(i.getProductId(),i.getProductName(),i.getType(),i.getBrand(),i.getColor(),i.getNotes()),i.getCategory(),String.format("%,.2f", i.getPrice()))).collect(Collectors.toList());
        return new ListPostDto(iduser,pdtos);
    }

    @Override
    public void unfollowSeller(int id, int idseller) {
        User user = iUserRepository.getUserById(id);
        User seller = iUserRepository.getUserById(idseller);
        if(user==null || seller==null)
            throw new NotFoundUserException("Not exist some user");
        else if(!seller.isSeller())
            throw  new InvalidSellerException("Not is seller user");
        seller.unfollow(user);
    }

    @Override
    public FollowerListDto getFollowerListOrderByNameAsc(int userId) {
        User seller = iUserRepository.getUserById(userId);
        if(seller==null)
            throw new NotFoundUserException("Not exist this user");
        else if(!seller.isSeller())
            throw new InvalidSellerException("Not is a seller");

        List<FollowerItemDto> items = seller.getFollowers().stream()
                .sorted(Comparator.comparing(User::getName))
                .map(i->new FollowerItemDto(i.getId(),i.getName()))
                .collect(Collectors.toList());

        return new FollowerListDto(seller.getId(),seller.getName(), items);
    }

    @Override
    public FollowerListDto getFollowerListOrderByNameDesc(int userId) {
        User seller = iUserRepository.getUserById(userId);
        if(seller==null)
            throw new NotFoundUserException("Not exist this user");
        else if(!seller.isSeller())
            throw new InvalidSellerException("Not is a seller");

        List<FollowerItemDto> items = seller.getFollowers().stream()
                .sorted(Comparator.comparing(User::getName).reversed())
                .map(i->new FollowerItemDto(i.getId(),i.getName()))
                .collect(Collectors.toList());

        return new FollowerListDto(seller.getId(),seller.getName(), items);
    }

    @Override
    public FollowedListDto getFollowedListOrderByNameAsc(int userId) {
        User user = iUserRepository.getUserById(userId);
        if(user==null)
            throw new NotFoundUserException("Not exist user");
        List<FollowedItemDto> items = iUserRepository.followedUser(user)
                .stream().sorted(Comparator.comparing(User::getName))
                .map(u->new FollowedItemDto(u.getId(),u.getName()))
                .collect(Collectors.toList());
        return new FollowedListDto(user.getId(),user.getName(),items);
    }

    @Override
    public FollowedListDto getFollowedListOrderByNameDesc(int userId) {
        User user = iUserRepository.getUserById(userId);
        if(user==null)
            throw new NotFoundUserException("Not exist user");
        List<FollowedItemDto> items = iUserRepository.followedUser(user)
                .stream().sorted(Comparator.comparing(User::getName).reversed())
                .map(u->new FollowedItemDto(u.getId(),u.getName()))
                .collect(Collectors.toList());
        return new FollowedListDto(user.getId(),user.getName(),items);
    }

    @Override
    public ListPostDto getListDtoSubscriptionByUserAndOrderByDateAsc(int id) {
        if(iUserRepository.getUserById(id)==null)
            throw new NotFoundUserException("Not exist user");
        List<Post> posts =  iUserRepository.getPostLastTwoWeeksOfFollowed(id);
        List<PostDtoWithoutUser> pdtos = posts.stream().sorted(Comparator.comparing(Post::getDate))
                .map(i->new PostDtoWithoutUser(i.getId(),i.getDate().toString(),new DetailDto(i.getProductId(),i.getProductName(),i.getType(),i.getBrand(),i.getColor(),i.getNotes()),i.getCategory(),String.format("%,.2f", i.getPrice()))).collect(Collectors.toList());
        return new ListPostDto(id,pdtos);
    }

    @Override
    public ListPostDto getListDtoSubscriptionByUserAndOrderByDateDesc(int id) {
        if(iUserRepository.getUserById(id)==null)
            throw new NotFoundUserException("Not exist user");
        List<Post> posts =  iUserRepository.getPostLastTwoWeeksOfFollowed(id);
        List<PostDtoWithoutUser> pdtos = posts.stream().sorted(Comparator.comparing(Post::getDate).reversed())
                .map(i->new PostDtoWithoutUser(i.getId(),i.getDate().toString(),new DetailDto(i.getProductId(),i.getProductName(),i.getType(),i.getBrand(),i.getColor(),i.getNotes()),i.getCategory(),String.format("%,.2f", i.getPrice()))).collect(Collectors.toList());
        return new ListPostDto(id,pdtos);
    }

    @Override
    public void addPostDiscount(DicountPostDto dto) {
        User user = iUserRepository.getUserById(dto.getUserId());
        if(user==null)
            throw new NotFoundUserException("Not exist user");
        DetailDto detail = dto.getDetail();
        user.addPost(new Post(dto.getIdPost(), LocalDate.parse(dto.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")),detail.getProductId(),detail.getProductName(),
                detail.getType(),detail.getBrand(),detail.getColor(),detail.getNotes(),dto.getCategory(),
                dto.getPrice(),dto.isHasDiscount(),dto.getDiscount()));
    }

    @Override
    public PostCount getCountPromoDiscount(int userId) {
        User user = iUserRepository.getUserById(userId);
        if(user==null)
            throw new NotFoundUserException("No exist user with given id");
        else if(!user.isSeller())
            throw  new InvalidSellerException("The user isn't seller");
        List<Post> post = iUserRepository.getPromoPostByUserId(userId);
        return new PostCount(userId,user.getName(),post.size());
    }

    @Override
    public ProductDiscountListDto getProductDiscountListDto(int seller) {
        User user = iUserRepository.getUserById(seller);
        if(user==null)
            throw new NotFoundUserException("Not exist user with given id");
        else if (!user.isSeller())
            throw new InvalidSellerException("Not is user seller");
        List<Post> posts = iUserRepository.getPromoPostByUserId(seller);
        List<DiscountDtoWithoutUser> dtos = posts.stream().map(i->
                new DiscountDtoWithoutUser(i.getId(), i.getDate().toString(),new DetailDto(i.getProductId(),i.getProductName(),i.getType(),i.getBrand(),i.getColor(),i.getNotes()),i.getCategory(),String.format("%,.2f", i.getPrice()),i.isHasDiscount(),i.getDiscount()))
                .collect(Collectors.toList());
        return new ProductDiscountListDto(seller,user.getName(),dtos);
    }

    @Override
    public Integer addUser(UserRequestDto dto) {
        User user = iUserRepository.findUserByEmail(dto.getEmail());
        if(user!=null)
            throw new InvalidUserException("Exist user with same email");
        User created = new User(dto.getUsername(),dto.getEmail(),dto.isSeller());
        iUserRepository.save(created);
        return created.getId();
    }

    @Override
    public List<UserDto> getAllUsers() {
        return iUserRepository.findAll().stream()
                .map(u->new UserDto(u.getId(),u.getEmail(),u.getName(),u.isSeller()))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> getAllSellers() {
        List<User> users =  iUserRepository.findAllSellers();
        return  users.stream()
                .map(u->new UserDto(u.getId(),u.getEmail(),u.getName(),u.isSeller()))
                .collect(Collectors.toList());
    }
}
