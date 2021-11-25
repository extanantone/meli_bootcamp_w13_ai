package com.socialmeli;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.dto.DetailDto;
import com.socialmeli.dto.PostDto;
import com.socialmeli.model.User;
import com.socialmeli.repository.IUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
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


    @AfterEach
    public void setup(){
        if(!execution){
            execution=true;
            int cont = 1;
            for(User u:repository.findAll()) {
                u.setId(cont);
                users.add(u);
                cont++;
            }
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
        mock.perform(post("/users/4/unfollow/100"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldBeUnfollowUser() throws Exception{
        mock.perform(post("/users/2/follow/4")).andExpect(
                status().is2xxSuccessful());
        mock.perform(post("/users/2/unfollow/4"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void shouldntBeUnfollowNegativeUsers() throws Exception{
        mock.perform(post("/users/2/unfollow/-2"))
                .andExpect(status().isBadRequest());
    }

}
