package com.desafio_testing.principal.integration;

import com.desafio_testing.principal.dto.*;
import com.desafio_testing.principal.enumerados.EnumErrs;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sun.jdi.Method;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestIntegrationUserController {

    @Autowired
    private MockMvc mockMvc;

    private static ObjectMapper mapper;

    @BeforeAll
    private static void init(){
        mapper = new ObjectMapper();
    }

    @Test
    @Order(1)
     void verifyFollowHappy() throws Exception {

        String endPoint = "/users/{user_id}/follow/{user_id_to_follow}";

        Map<String,String> pathParams = new HashMap<>(Map.of(
           "user_id","1",
           "user_id_to_follow","2"
        ));

        MvcResult resultado = realizarPost(endPoint,"",pathParams);

        Assertions.assertAll(
                ()-> Assertions.assertEquals(200,resultado.getResponse().getStatus())
        );
    }

    @Test
    @Order(2)
    void verifyFollowSad() throws Exception {

        String endPoint = "/users/{user_id}/follow/{user_id_to_follow}";

        Map<String,String> pathParams = new HashMap<>(Map.of(
           "user_id","1",
           "user_id_to_follow","2"
        ));

        MvcResult resultado2 = realizarPost(endPoint,"",pathParams);

        ErrorDTO salidaActual = mapper.readValue(resultado2.getResponse().getContentAsString(), new TypeReference<>() {});

        Assertions.assertAll(
                ()-> Assertions.assertEquals(400,resultado2.getResponse().getStatus()),
                ()-> Assertions.assertEquals(EnumErrs.ALREADY_FOLLOWED.getCodigo(),salidaActual.getCodigoError())
        );
    }

    @Test
    @Order(3)
    void countPromoPublicationsHappy() throws Exception {

        String endPoint = "/products/{user_id}/promo-post/count";

        Map<String,String> pathVariables = new HashMap<>(Map.of(
           "user_id","1"
        ));

        MvcResult resultado = realizarGet(endPoint,pathVariables,new HashMap<>());
        ConteosDTO salidaActual = mapper.readValue(resultado.getResponse().getContentAsString(), new TypeReference<>() {});

        Assertions.assertAll(
                ()-> Assertions.assertEquals(200,resultado.getResponse().getStatus()),
                ()-> Assertions.assertNotNull(salidaActual.getPromoProductsCount())
        );
    }

    @Test
    @Order(4)
    void verifyUnFollowHappy() throws Exception {

        String endPoint = "/users/{user_id}/unfollow/{user_id_to_follow}";

        Map<String,String> pathParams = new HashMap<>(Map.of(
                "user_id","1",
                "user_id_to_follow","2"
        ));

        MvcResult resultado2 = realizarPost(endPoint,"",pathParams);

        Assertions.assertAll(
                ()-> Assertions.assertEquals(200,resultado2.getResponse().getStatus())
        );
    }

    @Test
    @Order(5)
    void verifyUnFollowSad() throws Exception {

        String endPoint = "/users/{user_id}/unfollow/{user_id_to_follow}";

        Map<String,String> pathParams = new HashMap<>(Map.of(
                "user_id","6",
                "user_id_to_follow","7"
        ));
        Map<String,String> pathParams2 = new HashMap<>(Map.of(
                "user_id","2",
                "user_id_to_follow","1"
        ));

        MvcResult resultado1 = realizarPost(endPoint,"",pathParams);
        MvcResult resultado2 = realizarPost(endPoint,"",pathParams2);

        ErrorDTO salidaActual = mapper.readValue(resultado1.getResponse().getContentAsString(), new TypeReference<>() {});
        ErrorDTO salidaActual2 = mapper.readValue(resultado2.getResponse().getContentAsString(), new TypeReference<>() {});

        Assertions.assertAll(
                ()-> Assertions.assertEquals(400,resultado1.getResponse().getStatus()),
                ()-> Assertions.assertEquals(EnumErrs.NOT_FOUND.getCodigo(),salidaActual.getCodigoError()),
                ()-> Assertions.assertEquals(EnumErrs.NOT_FOLLOWED.getCodigo(),salidaActual2.getCodigoError())
        );
    }

    @Test
    @Order(6)
    void verifyCountFollowers() throws Exception {

        verifyFollowHappy();
        String endPoint = "/users/{user_id}/followers/count";

        Map<String,String> pathParams = new HashMap<>(Map.of(
                "user_id","2"
        ));

        MvcResult resultado1 = realizarGet(endPoint,pathParams,null);
        ConteosDTO salidaActual = mapper.readValue(resultado1.getResponse().getContentAsString(), new TypeReference<>() {});

        Assertions.assertAll(
                ()-> Assertions.assertEquals(200,resultado1.getResponse().getStatus()),
                ()-> Assertions.assertNotNull(salidaActual.getFollowersCount()),
                ()-> Assertions.assertNotNull(salidaActual.getUserName()),
                ()-> Assertions.assertNotNull(salidaActual.getUserId()),
                ()-> Assertions.assertEquals(1,salidaActual.getFollowersCount())
        );
    }

    @Test
    @Order(7)
    void verifyFollowersListHappy() throws Exception {

        String endPoint = "/users/{user_id}/followers/list";

        Map<String,String> pathParams = new HashMap<>(Map.of(
                "user_id","1"
        ));

        MvcResult resultado1 = realizarGet(endPoint,pathParams,null);
        ListaUsuariosDTO salidaActual = mapper.readValue(resultado1.getResponse().getContentAsString(), new TypeReference<>() {});

        Assertions.assertAll(
                ()-> Assertions.assertEquals(200,resultado1.getResponse().getStatus())
        );
    }

    @Test
    @Order(8)
    void verifyFollowedListHappy() throws Exception {

        String endPoint = "/users/{user_id}/followed/list";

        Map<String,String> pathParams = new HashMap<>(Map.of(
                "user_id","2"
        ));

        MvcResult resultado1 = realizarGet(endPoint,pathParams,null);
        ListaUsuariosDTO salidaActual = mapper.readValue(resultado1.getResponse().getContentAsString(), new TypeReference<>() {});

        Assertions.assertAll(
                ()-> Assertions.assertEquals(200,resultado1.getResponse().getStatus())
        );
    }

    @Test
    @Order(9)
    void verifyFollowedListDescHappy() throws Exception {

        String endPoint = "/users/{user_id}/followed/list";

        Map<String,String> pathParams = new HashMap<>(Map.of(
                "user_id","2"
        ));
        Map<String,String> reqParams = new HashMap<>(Map.of(
                "order","name_desc"
        ));


        MvcResult resultado = realizarGet(endPoint,pathParams,reqParams);
        ListaUsuariosDTO salidaActual = mapper.readValue(resultado.getResponse().getContentAsString(), new TypeReference<>() {});

        Assertions.assertAll(
                ()-> Assertions.assertEquals(200,resultado.getResponse().getStatus())
        );
    }

    @Test
    @Order(9)
    void verifyFollowedListDescSad() throws Exception {

        String endPoint = "/users/{user_id}/followed/list";

        Map<String,String> pathParams = new HashMap<>(Map.of(
                "user_id","2"
        ));
        Map<String,String> reqParams = new HashMap<>(Map.of(
                "order","name_descdsadas"
        ));


        MvcResult resultado = realizarGet(endPoint,pathParams,reqParams);
        ErrorDTO salidaActual = mapper.readValue(resultado.getResponse().getContentAsString(), new TypeReference<>() {});

        Assertions.assertAll(
                ()-> Assertions.assertEquals(400,resultado.getResponse().getStatus()),
                ()-> Assertions.assertEquals(EnumErrs.PARAMETER_NOT_FOUND.getCodigo(),salidaActual.getCodigoError())
        );
    }





    private MvcResult realizarGet(String endpoint, Map<String,String> pathParams, Map<String,String> reqParams) throws Exception {

        // reemplazo PathPArams
        if(pathParams!=null)
        {
            for(Map.Entry<String,String> dato: pathParams.entrySet())
            {
                endpoint = endpoint.replaceAll("\\{" +dato.getKey() + "}", dato.getValue());
            }
        }
        if(reqParams!=null && !reqParams.isEmpty())
        {
            endpoint = endpoint.concat("?");
            // reemplazo ReqParams
            for(Map.Entry<String,String> dato: reqParams.entrySet())
            {
                endpoint = endpoint.concat(dato.getKey()).concat("=").concat(dato.getValue()).concat(",");
            }
            endpoint = endpoint.substring(0,endpoint.length()-1);
        }

        return mockMvc.perform(get(endpoint))
                .andDo(print())
                .andReturn();
    }

    private MvcResult realizarPost(String endPoint,Object payload,Map<String,String> pathParms) throws Exception {

        if(pathParms!=null)
        {
            for(Map.Entry<String,String> dato: pathParms.entrySet())
            {
                endPoint = endPoint.replaceAll("\\{" +dato.getKey() + "}", dato.getValue());
            }
        }

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS,true)
                .registerModule(new JavaTimeModule())
                .writer();

        String cuerpo = writer.writeValueAsString(payload);

        return mockMvc.perform(MockMvcRequestBuilders.post(endPoint)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(cuerpo))
                .andDo(print())
                .andReturn();

    }

}
