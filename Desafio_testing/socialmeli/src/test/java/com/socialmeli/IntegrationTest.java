package com.socialmeli;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.dto.DetailDto;
import com.socialmeli.dto.PostDto;
import com.socialmeli.model.User;
import com.socialmeli.repository.IUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private IUserRepository repository;

    private boolean execution=false;

    private List<User> users = new ArrayList<>();

    private ObjectMapper mapper = new ObjectMapper();


    @BeforeEach
    public void setup(){
        if(!execution){
            int cont = 1;
            for(User u:repository.findAll()) {
                u.setId(cont);
                users.add(u);
                cont++;
            }
            execution=true;
        }
        // Clear Memory data
        repository.findAll().clear();
        for(User u:users){
            repository.save(u);
            u.setPosts(new ArrayList<>());
            u.setFollowers(new ArrayList<>());
        }

    }


    @Test
    public void shouldntBeFollowUserIfFollowerIsNegative() throws Exception {
        mock.perform(post("/users/-1/follow/2")).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldntBeFollowUserIfFollowedIsNegative() throws Exception {
        mock.perform(post("/users/2/follow/-2")).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldBeFollowValidUser() throws Exception{
        mock.perform(post("/users/2/follow/4")).andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public  void shouldntBeFollowUnexistUser() throws Exception{
        mock.perform(post("/users/2/follow/4000")).andDo(MockMvcResultHandlers.print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void shouldBeAddPost() throws Exception{
        PostDto post = new PostDto(3,1,"01-01-2021",new DetailDto(1,"shoes","shoes","app","black","ok"),1,1);
        String json = mapper.writeValueAsString(post);
        mock.perform(post("/products/post").contentType("application/json").content(json)).andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void shouldntBeAddPostIfUserIsNull() throws Exception{
        PostDto post = new PostDto(null,1,"01-01-2021",new DetailDto(1,"shoes","shoes","app","black","ok"),1,1);
        String json = mapper.writeValueAsString(post);
        mock.perform(post("/products/post").contentType("application/json").content(json)).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldntBeAddPostIfUserNotExist() throws Exception{
        PostDto post = new PostDto(20,1,"01-01-2021",new DetailDto(1,"shoes","shoes","app","black","ok"),1,1);
        String json = mapper.writeValueAsString(post);
        mock.perform(post("/products/post").contentType("application/json").content(json)).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldntBeAddRepeatPostId() throws Exception{
        PostDto post = new PostDto(3,1,"01-01-2021",new DetailDto(1,"shoes","shoes","app","black","ok"),1,1);
        String json = mapper.writeValueAsString(post);
        mock.perform(post("/products/post").contentType("application/json").content(json)).andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
        mock.perform(post("/products/post").contentType("application/json").content(json)).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldntBeUnfollowUnexistUser() throws Exception{
        mock.perform(post("/users/4/unfollow/100")).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldBeUnfollowUser() throws Exception{
        mock.perform(post("/users/2/follow/4"))
                .andDo(MockMvcResultHandlers.print()).andExpect(
                status().is2xxSuccessful());
        mock.perform(post("/users/2/unfollow/4"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void shouldntBeUnfollowNegativeUsers() throws Exception{
        mock.perform(post("/users/2/unfollow/-2"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldntBeCountFollowerList() throws Exception{
        mock.perform(get("/users/70/followers/count"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldBeCountFollowers() throws Exception{
        mock.perform(post("/users/2/follow/4"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
        mock.perform(get("/users/4/followers/count"))
                .andExpect(status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$.followers_count").value(1))
                 .andExpect(jsonPath("$.user_id").value(4));
    }

    @Test
    public  void shouldntBeCountFollowersOfNegativeUser() throws Exception{
        mock.perform(get("/users/-70/followers/count"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public  void shouldntBeCountFollowersNotSeller() throws Exception{
        mock.perform(get("/users/1/followers/count"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void  shouldntBeListFollowersUnexistUser() throws Exception{
        mock.perform(get("/users/70/followers/list"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void  shouldntBeListFollowersWithNegativeUserId() throws Exception{
        mock.perform(get("/users/-70/followers/list"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldntBeListFollowersIfUserIsntSeller() throws Exception{
        mock.perform(get("/users/1/followers/list"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldBeListUsers() throws Exception{
        mock.perform(post("/users/2/follow/4"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
        mock.perform(get("/users/4/followers/list"))
                .andExpect(status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$.followers[0].user_id").value(2))
                .andExpect(jsonPath("$.user_id").value(4));
    }

    @Test
    public void shouldBeListFollowedList() throws Exception{
        mock.perform(post("/users/2/follow/4"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
        mock.perform(get("/users/2/followed/list"))
                .andExpect(status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$.followed[0].user_id").value(4))
                .andExpect(jsonPath("$.user_id").value(2));
    }

    @Test
    public void shouldntBeListFollowedListIfUserUnexist() throws Exception{
        mock.perform(get("/users/90/followed/list"))
                .andExpect(status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void  shouldntBeListNegativeUser() throws Exception{
        mock.perform(get("/users/-90/followed/list"))
                .andExpect(status().isBadRequest())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void shouldBeListPostOfLas2Weeks() throws Exception{
        mock.perform(post("/users/2/follow/4")).andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
        LocalDate date = LocalDate.now();

        String current = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        PostDto post = new PostDto(4,1,current,new DetailDto(1,"shoes","shoes","app","black","ok"),1,1);
        String json = mapper.writeValueAsString(post);
        mock.perform(post("/products/post").contentType("application/json").content(json)).andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
        mock.perform(get("/products/followed/2/list")).andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.posts.length()").value(1));
    }

    @Test
    public void shouldntGetItemPostIfNotIs2WeeksOld() throws Exception{
        mock.perform(post("/users/2/follow/4")).andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
        LocalDate date = LocalDate.now().minusWeeks(3);
        String current = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        PostDto post = new PostDto(4,1,current,new DetailDto(1,"shoes","shoes","app","black","ok"),1,1);
        String json = mapper.writeValueAsString(post);
        mock.perform(post("/products/post").contentType("application/json").content(json)).andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
        mock.perform(get("/products/followed/2/list")).andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.posts.length()").value(0));
    }

    @Test
    public void shouldBeFindItemsForNegativePost() throws  Exception{
        mock.perform(get("/products/followed/-2/list")).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldListAllUsers() throws Exception{
        mock.perform(get("/users"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.length()").value(4));
    }

    @Test
    public void shouldFindAllSellers() throws Exception{
        mock.perform(get("/users/sellers"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].seller").value(true))
                .andExpect(jsonPath("$[1].seller").value(true));
    }


}
