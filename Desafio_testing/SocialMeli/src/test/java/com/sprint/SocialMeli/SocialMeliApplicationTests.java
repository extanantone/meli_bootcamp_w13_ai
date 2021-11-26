package com.sprint.SocialMeli;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sprint.SocialMeli.dto.out.FollowedListDto;
import com.sprint.SocialMeli.dto.out.PromoPostList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SocialMeliApplicationTests {

	@Autowired
	private MockMvc mockMvc;


	private static ObjectMapper mapper;

	@BeforeAll
	public static void setUp(){
		mapper = new ObjectMapper()
				.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	}

	@BeforeEach
	void contextLoads() throws Exception {
		this.mockMvc.perform(
						post("/users/{user_id}/follow/{user_id_to_follow}", 1, 3))
				.andDo(print()).andExpect(status().isOk());

		this.mockMvc.perform(
						post("/users/{user_id}/follow/{user_id_to_follow}", 2, 3))
				.andDo(print()).andExpect(status().isOk());

		this.mockMvc.perform(
						post("/users/{user_id}/follow/{user_id_to_follow}", 1, 4))
				.andDo(print()).andExpect(status().isOk());
	}

	@Test
	void newPostValidIsOk() throws Exception {
		// Empleo el usuario con id 3 que ya es un vendedor creado en la base de datos
		String request = "{\"user_id\": 3,\n" +
				"  \"id_post\": 12,\n" +
				"  \"date\": \"02-11-2021\",\n" +
				"  \"detail\": {\n" +
				"    \"product_id\": 1,\n" +
				"    \"product_name\": \"Silla Gamer\",\n" +
				"    \"type\": \"Gamer\",\n" +
				"    \"brand\": \"Racer\",\n" +
				"    \"color\": \"Red Black\",\n" +
				"    \"notes\": \"Special Edition\"\n" +
				"  },\n" +
				"  \"category\": \"100\",\n" +
				"  \"price\": 42000\n" +
				"}\n";
		this.mockMvc.perform(
						post("/products/post")
								.contentType(MediaType.APPLICATION_JSON)
								.content(request))
				.andDo(print()).andExpect(status().isOk());
	}

	@Test
	void newPostDuplicateException() throws Exception {

		// Empleo el usuario con id 3 que ya es un vendedor creado en la base de datos
		String request = "{\"user_id\": 3,\n" +
				"  \"id_post\": 99,\n" +
				"  \"date\": \"02-11-2021\",\n" +
				"  \"detail\": {\n" +
				"    \"product_id\": 1,\n" +
				"    \"product_name\": \"Silla Gamer\",\n" +
				"    \"type\": \"Gamer\",\n" +
				"    \"brand\": \"Racer\",\n" +
				"    \"color\": \"Red Black\",\n" +
				"    \"notes\": \"Special Edition\"\n" +
				"  },\n" +
				"  \"category\": \"100\",\n" +
				"  \"price\": 42000\n" +
				"}\n";
		this.mockMvc.perform(
						post("/products/post")
								.contentType(MediaType.APPLICATION_JSON)
								.content(request))
				.andDo(print()).andExpect(status().isOk());

		// Empleo el usuario con id 3 que ya es un vendedor creado en la base de datos y el id 99 usado antes
		request = "{\"user_id\": 3,\n" +
				"  \"id_post\": 99,\n" +
				"  \"date\": \"02-11-2021\",\n" +
				"  \"detail\": {\n" +
				"    \"product_id\": 1,\n" +
				"    \"product_name\": \"Silla Gamer\",\n" +
				"    \"type\": \"Gamer\",\n" +
				"    \"brand\": \"Racer\",\n" +
				"    \"color\": \"Red Black\",\n" +
				"    \"notes\": \"Special Edition\"\n" +
				"  },\n" +
				"  \"category\": \"100\",\n" +
				"  \"price\": 42000\n" +
				"}\n";
		this.mockMvc.perform(
						post("/products/post")
								.contentType(MediaType.APPLICATION_JSON)
								.content(request))
				.andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	void tryFollowBuyerResultBadRequest() throws Exception {
		this.mockMvc.perform(
						post("/users/{user_id}/follow/{user_id_to_follow}", 1, 2))
				.andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	void getCountTwoFollowersFromASeller() throws Exception {
		this.mockMvc.perform(
				MockMvcRequestBuilders.get("/users/{user_id}/followers/count", 3))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.followers_count").value(2));
	}

	@Test
	void getListTwoFollowedFromABuyer() throws Exception {
		MvcResult result = this.mockMvc.perform(
						MockMvcRequestBuilders.get("/users/{user_id}/followed/list", 1))
				.andDo(print()).andExpect(status().isOk())
				.andReturn();

		// Deserializo la respuesta
		FollowedListDto followedListDto = mapper.readValue(result.getResponse().getContentAsString(), FollowedListDto.class);
		// Me fijo que tenga dos seguidos
		Assertions.assertEquals(2, followedListDto.getFollowed().size());
	}

	@Test
	void postAndGetTwoPromoPost() throws Exception {
		// Empleo el usuario con id 3 que ya es un vendedor creado en la base de datos
		String request = "{\"user_id\": 3,\n" +
				"  \"id_post\": 18,\n" +
				"  \"date\": \"02-11-2021\",\n" +
				"  \"detail\": {\n" +
				"    \"product_id\": 1,\n" +
				"    \"product_name\": \"Silla Gamer\",\n" +
				"    \"type\": \"Gamer\",\n" +
				"    \"brand\": \"Racer\",\n" +
				"    \"color\": \"Red Black\",\n" +
				"    \"notes\": \"Special Edition\"\n" +
				"  },\n" +
				"  \"category\": \"100\",\n" +
				"  \"price\": 43000.50,\n" +
				"  \"has_promo\": true,\n" +
				"  \"discount\": 0.40\n" +
				"}\n";
		this.mockMvc.perform(
						post("/products/promo-post")
								.contentType(MediaType.APPLICATION_JSON)
								.content(request))
				.andDo(print()).andExpect(status().isOk());

		// Empleo el usuario con id 3 que ya es un vendedor creado en la base de datos
		request = "{\"user_id\": 3,\n" +
				"  \"id_post\": 34,\n" +
				"  \"date\": \"06-11-2021\",\n" +
				"  \"detail\": {\n" +
				"    \"product_id\": 5,\n" +
				"    \"product_name\": \"Mesa\",\n" +
				"    \"type\": \"Comedor\",\n" +
				"    \"brand\": \"Pino\",\n" +
				"    \"color\": \"Madera\" \n" +
				"  },\n" +
				"  \"category\": \"75\",\n" +
				"  \"price\": 4500,\n" +
				"  \"has_promo\": true,\n" +
				"  \"discount\": 0.10\n" +
				"}\n";
		this.mockMvc.perform(
						post("/products/promo-post")
								.contentType(MediaType.APPLICATION_JSON)
								.content(request))
				.andDo(print()).andExpect(status().isOk());

		// Otra forma de comprobar que al menos tenga los elementos es que devuelva posts en las dos primeras posiciones
		// Si tiene mas seria un problema pero no puede parsearse porque el DTO tiene LocalDate y tira excepción de no soportable por jackson al querer parsearlo
		this.mockMvc.perform(
						MockMvcRequestBuilders.get("/products/{user_id}/list", 3))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.posts.[0]").exists())
				.andExpect(jsonPath("$.posts.[1]").exists());

	}

}
