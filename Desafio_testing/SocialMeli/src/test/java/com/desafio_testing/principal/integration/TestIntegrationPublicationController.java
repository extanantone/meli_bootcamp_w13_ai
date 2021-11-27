package com.desafio_testing.principal.integration;

import com.desafio_testing.principal.dto.*;
import com.desafio_testing.principal.enumerados.EnumErrs;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
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
class TestIntegrationPublicationController {

    @Autowired
    private MockMvc mockMvc;

    private static ObjectMapper mapper;

    @BeforeAll
    private static void init(){
        mapper = new ObjectMapper();
    }

    @Test
    @Order(1)
    void createPublicationPromoHappy() throws Exception {

        ProductoDTO productoDTO = new ProductoDTO(1,"prod1","cosa","patito","negro","notas");
        PublicacionesDTO payload =  new PublicacionesDTO(30,1, LocalDate.now(),productoDTO,100,null,1000.0,true,10.0);

        String endPoint = "/products/promo-post";
        MvcResult resultado = realizarPost(endPoint,payload);

        Assertions.assertAll(
                ()-> Assertions.assertEquals(200,resultado.getResponse().getStatus())
        );
    }

    @Test
    @Order(2)
    void createPublicationHappy() throws Exception {

        ProductoDTO productoDTO = new ProductoDTO(1,"prod1","cosa","patito","negro","notas");
        PublicacionesDTO payload =  new PublicacionesDTO(3,1, LocalDate.now(),productoDTO,100,null,1000.0,false,10.0);

        String endPoint = "/products/post";
        MvcResult resultado = realizarPost(endPoint,payload);

        Assertions.assertAll(
                ()-> Assertions.assertEquals(200,resultado.getResponse().getStatus())
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
                ()-> Assertions.assertEquals(1,salidaActual.getPromoProductsCount())
        );
    }

    @Test
    void getPublicationsFollowerHappy() throws Exception {

        String endPoint = "/products/followed/{user_id}/list";

        Map<String,String> pathVariables = new HashMap<>(Map.of(
           "user_id","1"
        ));
        Map<String,String> reqParams = new HashMap<>(Map.of(
                "order","date_asc"
        ));

        MvcResult resultado = realizarGet(endPoint,pathVariables,reqParams);
        ListaPublicacionesDTO salidaActual = mapper.readValue(resultado.getResponse().getContentAsString(), new TypeReference<>() {});

        Assertions.assertAll(
                ()-> Assertions.assertEquals(200,resultado.getResponse().getStatus()),
                ()-> Assertions.assertNotNull(salidaActual.getUserId()),
                ()-> Assertions.assertNotNull(salidaActual.getPosts())
        );
    }

    @Test
    void getPublicationsPromoFollowerHappy() throws Exception {

        String endPoint = "/products/{user_id}/list";

        Map<String,String> pathVariables = new HashMap<>(Map.of(
           "user_id","1"
        ));

        MvcResult resultado = realizarGet(endPoint,pathVariables,null);
        ListaPublicacionesDTO salidaActual = mapper.readValue(resultado.getResponse().getContentAsString(), new TypeReference<>() {});

        Assertions.assertAll(
                ()-> Assertions.assertEquals(200,resultado.getResponse().getStatus()),
                ()-> Assertions.assertNotNull(salidaActual.getUserId()),
                ()-> Assertions.assertNotNull(salidaActual.getPosts())
        );
    }

    @Test
    void createPublicationSad() throws Exception {

        ProductoDTO productoDTO = new ProductoDTO(1,"prod1","cosa","patito","negro","notas");
        PublicacionesDTO payload =  new PublicacionesDTO(10,1, LocalDate.now(),productoDTO,100,null,1000.0,false,10.0);

        String endPoint = "/products/post";
        MvcResult resultado = realizarPost(endPoint,payload);
        MvcResult resultado2 = realizarPost(endPoint,payload);
        ErrorDTO error = mapper.readValue(resultado2.getResponse().getContentAsString(), new TypeReference<>(){});

        Assertions.assertAll(
                ()-> Assertions.assertEquals(200,resultado.getResponse().getStatus()),
                ()-> Assertions.assertEquals(400,resultado2.getResponse().getStatus()),
                ()-> Assertions.assertEquals(EnumErrs.DUPLICATED.getCodigo(),error.getCodigoError())
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

    private MvcResult realizarPost(String endPoint,Object payload) throws Exception {
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
