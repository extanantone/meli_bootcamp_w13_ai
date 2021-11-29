package com.bootcamp.SocialMeli.integration;

import com.bootcamp.SocialMeli.dto.*;
import com.bootcamp.SocialMeli.model.Seguidor;
import com.bootcamp.SocialMeli.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestSocialMeli {

    @Autowired
    MockMvc mockMvc;
    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JSR310Module())
                .writer().withDefaultPrettyPrinter();

    }

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void reset(){

        userRepository.reset();
    }

    @Test
    void testpostfollow()  throws Exception {
        SeguidorDTO  seguidorDTO = new SeguidorDTO("Juan",1,"Julian",3);
        String seguidorJson = writer.writeValueAsString(seguidorDTO);

        ResultMatcher expectdStatus = status().isOk();
        ResultMatcher expectedJson = content().json(seguidorJson);
        ResultMatcher expextedContentype = content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                "/users/{user_id}/follow/{user_id_follow}", 1,3);

        mockMvc.perform(request).andDo(MockMvcResultHandlers.print())
                .andExpect(expextedContentype)
                .andExpect(expectedJson)
                .andExpect(expectdStatus);
    }

    @Test
    void getfollowers() throws Exception{

        userRepository.setSeguidor(new Seguidor(1,3));
        MesiguenCabtidadDTO mesiguenDTO = new MesiguenCabtidadDTO(3,"Julian",1);

        String userJson = writer.writeValueAsString(mesiguenDTO);

        ResultMatcher expectdStatus = status().isOk();
        ResultMatcher expectedJson = content().json(userJson);
        ResultMatcher expextedContentype = content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/users/{user_id}/followers/count", 3);

        mockMvc.perform(request).andDo(MockMvcResultHandlers.print())
                .andExpect(expextedContentype)
                .andExpect(expectedJson)
                .andExpect(expectdStatus);

    }

    @Test
    void getfollowersList() throws Exception{

        MesiguenDTO mesiguenDTO = new MesiguenDTO(3,"Julian",new ArrayList<UserDTO>());

        String mesiguenJson = writer.writeValueAsString(mesiguenDTO);

        ResultMatcher expectdStatus = status().isOk();
        ResultMatcher expectedJson = content().json(mesiguenJson);
        ResultMatcher expextedContentype = content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/users/{user_id}/followers/list", 3);

        mockMvc.perform(request).andDo(MockMvcResultHandlers.print())
                .andExpect(expextedContentype)
                .andExpect(expectedJson)
                .andExpect(expectdStatus);

    }

    @Test
    void getfollowed() throws Exception{

        MesiguenDTO mesiguenDTO = new MesiguenDTO(3,"Usuario:Julian",new ArrayList<UserDTO>());

        String mesiguenJson = writer.writeValueAsString(mesiguenDTO);

        ResultMatcher expectdStatus = status().isOk();
        ResultMatcher expectedJson = content().json(mesiguenJson);
        ResultMatcher expextedContentype = content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/users/{user_id}/followed/list", 3);

        mockMvc.perform(request).andDo(MockMvcResultHandlers.print())
                .andExpect(expextedContentype)
                .andExpect(expectedJson)
                .andExpect(expectdStatus);

    }

    @Test
    void whensetPostThenCreatePostOK() throws Exception {
        DetailDTO detailDTO = new DetailDTO(1,"Zapatos","Zapatilla","EQ","Red","Especiales");
        PostDTO postDTO =  new PostDTO(3,1,
                LocalDate.parse("25-11-2021", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        detailDTO,
                        10,25000D
        );

        String postDtoJson = writer.writeValueAsString(postDTO);

        ResultMatcher expectdStatus = status().isOk();

        System.out.println(postDtoJson);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                "/products/post").contentType(MediaType.APPLICATION_JSON).content(postDtoJson);


        mockMvc.perform(request).andDo(MockMvcResultHandlers.print())
               .andExpect(expectdStatus);


    }

    @Test
    void whensetPromoPostThenCreatePromoPostOK() throws Exception {
        DetailDTO detailDTO = new DetailDTO(1,"Zapatos","Zapatilla","EQ","Red","Especiales");
        PromopostDTO promopostDTO=  new PromopostDTO(3,1,
                LocalDate.parse("25-11-2021", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                detailDTO,
                10,25000D,
                true,
                2.5
        );

        String postDtoJson = writer.writeValueAsString(promopostDTO);

        ResultMatcher expectdStatus = status().isOk();

        System.out.println(postDtoJson);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                "/products/promopost").contentType(MediaType.APPLICATION_JSON).content(postDtoJson);


        mockMvc.perform(request).andDo(MockMvcResultHandlers.print())
                .andExpect(expectdStatus);


    }



    @Test
    void whengetPublicacionespromoCountThenCount0 () throws Exception{

        PromoPostCoutDTO promoPostCoutDTO = new PromoPostCoutDTO(3,"Julian",0);

        String mesiguenJson = writer.writeValueAsString(promoPostCoutDTO);

        ResultMatcher expectdStatus = status().isOk();
        ResultMatcher expectedJson = content().json(mesiguenJson);
        ResultMatcher expextedContentype = content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/products/{user_id}/promo-post/count", 3);

        mockMvc.perform(request).andDo(MockMvcResultHandlers.print())
                .andExpect(expextedContentype)
                .andExpect(expectedJson)
                .andExpect(expectdStatus);

    }



}
