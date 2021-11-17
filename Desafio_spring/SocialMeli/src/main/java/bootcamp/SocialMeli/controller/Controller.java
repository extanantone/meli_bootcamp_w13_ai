package bootcamp.SocialMeli.controller;
import bootcamp.SocialMeli.dto.CountSellerFollowersDto;
import bootcamp.SocialMeli.dto.ListFollowerDto;
import bootcamp.SocialMeli.dto.NewPostDto;
import bootcamp.SocialMeli.dto.PostListDto;
import bootcamp.SocialMeli.services.IService;
import bootcamp.SocialMeli.services.Services;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class Controller {

    public IService iService;

    public Controller(IService iService){
    this.iService = iService;
    }

    @PostMapping (path = "/users/{user_id}/follow/{user_id_to_follow}")
    @ResponseStatus(HttpStatus.OK)
    public void follow (@PathVariable int user_id, @PathVariable int user_id_to_follow){
        iService.followUser(user_id, user_id_to_follow);
    }

    @GetMapping (path = "/users/{user_id}/followers/count")
    public CountSellerFollowersDto getCountSeller(@PathVariable int user_id){
        return iService.getCountBySeller(user_id);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ListFollowerDto getFollower(@PathVariable int userId,@RequestParam(defaultValue = "") String order){
        if(order.equals("name_asc"))
            return iService.getListFollowerAsc(userId);
        else if(order.equals("name_desc"))
            return iService.getListFollowerDesc(userId);
        return iService.getFollowerList(userId);
    }

    @GetMapping("/users/{userId}/followed/list")
    public ListFollowerDto getFollowed(@PathVariable int userId,@RequestParam(defaultValue = "") String order) {
        if(order.equals("name_asc"))
            return iService.getListFollowedAsc(userId);
        else if(order.equals("name_desc"))
            return iService.getListFollowedDesc(userId);
        return  iService.getFollowed(userId);
    }

    @PostMapping("/products/post")
    public void addPost (@RequestBody NewPostDto dto) {
        iService.addPost(dto);
    }

    @GetMapping("/products/followed/{user_id}/list")
    public PostListDto getlistPostTwoWeekAgo(@PathVariable int user_id, @RequestParam(defaultValue = "") String order) {
        if(order.equals("date_asc"))
            return iService.getListPostByUserAsc(user_id);
        else if(order.equals("date_desc"))
            return iService.getListPostByUserDesc(user_id);
        return iService.getListPostByUser(user_id);
    }

    @PostMapping("/users/{user_id}/unfollow/{user_id_to_unfollow}")
    public void unfollow(@PathVariable int user_id, @PathVariable int user_id_to_unfollow){
        iService.unfollowUser(user_id, user_id_to_unfollow);
    }
}
