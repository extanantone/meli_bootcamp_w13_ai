package bootcamp.SocialMeli.controller;

import bootcamp.SocialMeli.dto.*;
import bootcamp.SocialMeli.services.IService;
import bootcamp.SocialMeli.services.Services;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.List;



@RestController
public class Controller {

    public IService iService;

    public Controller(IService iService) {
        this.iService = iService;
    }

    @PostMapping(path = "/users/{user_id}/follow/{user_id_to_follow}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> follow(@PathVariable int user_id, @PathVariable int user_id_to_follow) {
        iService.followUser(user_id, user_id_to_follow);
        return Map.of("message", "Acabas de seguir al usuario "+ user_id_to_follow);
    }

    @GetMapping(path = "/users/{user_id}/followers/count")
    public CountSellerFollowersDto getCountSeller(@PathVariable int user_id) {
        return iService.getCountBySeller(user_id);
    }

    @GetMapping("/users/{user_id}/followers/list")
    public ListFollowerDto getFollower(@PathVariable int user_id, @RequestParam(defaultValue = "") String order) {
        if (order.equals("name_asc"))
            return iService.getListFollowerAsc(user_id);
        else if (order.equals("name_desc"))
            return iService.getListFollowerDesc(user_id);
        return iService.getFollowerList(user_id);
    }

    @GetMapping("/users/{userId}/followed/list")
    public ListFollowerDto getFollowed(@PathVariable int userId, @RequestParam(defaultValue = "") String order) {
        if (order.equals("name_asc"))
            return iService.getListFollowedAsc(userId);
        else if (order.equals("name_desc"))
            return iService.getListFollowedDesc(userId);
        return iService.getFollowed(userId);
    }

    @PostMapping("/products/post")
    public Map<String, String> addPost(@RequestBody NewPostDto dto) {
        iService.addPost(dto);
        return Map.of("message", "Agregaste una nueva publicación");
    }

    @GetMapping("/products/followed/{user_id}/list")
    public PostListDto getlistPostTwoWeekAgo(@PathVariable int user_id, @RequestParam(defaultValue = "") String order) {
        if (order.equals("date_asc"))
            return iService.getListPostByUserAsc(user_id);
        else if (order.equals("date_desc"))
            return iService.getListPostByUserDesc(user_id);
        return iService.getListPostByUser(user_id);
    }

    @PostMapping("/users/{user_id}/unfollow/{user_id_to_unfollow}")
    public Map<String, String> unfollow(@PathVariable int user_id, @PathVariable int user_id_to_unfollow) {
        iService.unfollowUser(user_id, user_id_to_unfollow);
        return Map.of("message", "Dejaste de seguir al usuario " + user_id_to_unfollow);
    }

    @PostMapping("/users")
    public Map<String, Integer> addUser(@RequestBody UserRequestDto dto){
        return Map.of("id",iService.addUser(dto));
    }

    @GetMapping("/users")
    public List<UsuariosDto> getUsers(){
        return iService.getAllUsers();
    }

    @GetMapping("/users/sellers")
    public List<UsuariosDto> getSellers(){
        return  iService.getAllSellers();
    }
}
