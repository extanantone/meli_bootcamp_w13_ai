package com.socialmeli.controller;

import com.socialmeli.dto.*;
import com.socialmeli.model.User;
import com.socialmeli.service.IUserService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Map;

@RestController
@Validated
public class UserController {

    private IUserService iUserService;

    public UserController(IUserService iUserService){
        this.iUserService = iUserService;
    }

    @PostMapping("/users/{userId}/follow/{sellerId}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String,String> follow(@Positive @PathVariable int userId,@Positive @PathVariable int sellerId){
        iUserService.followUser(userId,sellerId);
        return Map.of("menssage","follow");
    }

    @GetMapping("/users/{userId}/followers/count")
    public SellerFollowersCountDto getCountSeller(@Positive @PathVariable int userId){
        return iUserService.getCountBySeller(userId);
    }

    @GetMapping("/users/{userId}/followers/list")
    public FollowerListDto getFollower(@Positive @PathVariable int userId,@RequestParam(defaultValue = "") String order){
        if(order.equals("name_asc"))
            return iUserService.getFollowerListOrderByNameAsc(userId);
        else if(order.equals("name_desc"))
            return iUserService.getFollowerListOrderByNameDesc(userId);
        return iUserService.getFollowerList(userId);
    }

    @GetMapping("/users/{userId}/followed/list")
    public FollowedListDto getFollowed(@Positive @PathVariable int userId,@RequestParam(defaultValue = "") String order){
        if(order.equals("name_asc"))
            return iUserService.getFollowedListOrderByNameAsc(userId);
        else if(order.equals("name_desc"))
            return iUserService.getFollowedListOrderByNameDesc(userId);
        return  iUserService.getFollowed(userId);
    }

    @PostMapping("/products/post")
    public Map<String,String> addPost(@Valid @RequestBody PostDto dto){
        //System.out.println(dto.getDate());
        iUserService.addPost(dto);
        return Map.of("menssage","post was added");

    }

    @GetMapping("/products/followed/{id}/list")
    public ListPostDto getListPostTwoWeeks(@Positive @PathVariable int id,@RequestParam(defaultValue = "") String order){
        if(order.equals("date_asc")) return iUserService.getListDtoSubscriptionByUserAndOrderByDateAsc(id);
        else if(order.equals("date_desc")) return iUserService.getListDtoSubscriptionByUserAndOrderByDateDesc(id);
        return iUserService.getListDtoSubscriptionByUser(id);
    }

    @PostMapping("/users/{id}/unfollow/{seller}")
    public Map<String,String> unfollow(@Positive @PathVariable int id,@Positive @PathVariable int seller){
        iUserService.unfollowSeller(id,seller);
        return Map.of("menssage","Correct unfollow");
    }

    @PostMapping("/products/promo-post")
    public Map<String,String>  addPromoPost(@RequestBody DicountPostDto dto){
        iUserService.addPostDiscount(dto);
        return Map.of("menssage","add new promopost item");
    }

    @GetMapping("/products/{userId}/promo-post/count")
    public PostCount getCountPromoDiscount(@PathVariable int userId){
        return iUserService.getCountPromoDiscount(userId);
    }

    @GetMapping("/products/{seller}/list")
    public ProductDiscountListDto getProductDiscountListDto(@Positive @PathVariable int seller){
        return iUserService.getProductDiscountListDto(seller);
    }

    @PostMapping("/users")
    public Map<String, Integer> addUser(@RequestBody UserRequestDto dto){
        return Map.of("id",iUserService.addUser(dto));
    }

    @GetMapping("/users")
    public List<UserDto> getUsers(){
        return iUserService.getAllUsers();
    }

    @GetMapping("/users/sellers")
    public List<UserDto> getSellers(){
        return  iUserService.getAllSellers();
    }


}
