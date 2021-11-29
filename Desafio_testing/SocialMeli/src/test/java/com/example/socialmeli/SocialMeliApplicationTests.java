package com.example.socialmeli;

import com.example.socialmeli.dto.PostDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.example.socialmeli.unit.SocialMeliUnitUtils;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SocialMeliApplicationTests {
	@Autowired
	private MockMvc mockmvc;

	private SocialMeliUnitUtils meliUtils;
	private ObjectWriter writer;
	private ModelMapper mapper;

	@BeforeEach
	void setUp () {
		this.mapper = new ModelMapper();
		this.meliUtils = new SocialMeliUnitUtils();
		this.writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
				.writer().withDefaultPrettyPrinter();
	}

	@Test
	void validFollowShouldGetOkStatus () throws Exception {
		Integer firstUserId = 1;
		Integer secondUserId = 2;
		this.mockmvc.perform(MockMvcRequestBuilders.post(
						"/users/{user_id}/follow/{user_id_to_follow}",
						firstUserId, secondUserId))
				.andDo(print()).andExpect(status().isOk());
	}

	@Test
	void invalidUserIdInFollowShouldGetNotFoundStatus () throws Exception {
		Integer validUserId = 3;
		Integer invalidUserId = 1000;
		this.mockmvc.perform(MockMvcRequestBuilders.post(
						"/users/{user_id}/follow/{user_id_to_follow}",
						validUserId, invalidUserId))
				.andDo(print()).andExpect(status().isNotFound());
	}

	@Test
	void sameUserIdInFollowShouldGetBadRequestStatus () throws Exception {
		Integer validUserId = 4;
		this.mockmvc.perform(MockMvcRequestBuilders.post(
						"/users/{user_id}/follow/{user_id_to_follow}",
						validUserId, validUserId))
				.andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	void repeatedFollowShouldGetBadRequestStatus() throws Exception {
		Integer firstUserId = 3;
		Integer secondUserId = 4;
		this.mockmvc.perform(MockMvcRequestBuilders.post(
						"/users/{user_id}/follow/{user_id_to_follow}",
						firstUserId, secondUserId))
				.andDo(print()).andExpect(status().isOk()).andReturn();
		this.mockmvc.perform(MockMvcRequestBuilders.post(
						"/users/{user_id}/follow/{user_id_to_follow}",
						firstUserId, secondUserId))
				.andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	public void invalidUserIdInCountFollowersShouldGetNotFoundStatus () throws Exception {
		Integer invalidUserId = 500;
		this.mockmvc.perform(MockMvcRequestBuilders.get(
				"/users/{user_id}/followers/count", invalidUserId))
				.andDo(print()).andExpect(status().isNotFound());
	}

	@Test
	public void validCountFollowersShouldGetOkStatus () throws Exception {
		Integer validUserId = 2;
		this.mockmvc.perform(MockMvcRequestBuilders.get(
				"/users/{user_id}/followers/count", validUserId))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(validUserId))
				.andExpect(MockMvcResultMatchers.jsonPath("$.user_name").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").exists());
	}

	@Test
	public void invalidUserIdInGetFollowersShouldGetNotFoundStatus () throws Exception {
		Integer invalidUserId = 55;
		this.mockmvc.perform(MockMvcRequestBuilders.get(
				"/users/{user_id}/followers/list", invalidUserId))
				.andDo(print()).andExpect(status().isNotFound());
	}

	@Test
	public void validGetFollowersShouldGetOkStatus () throws Exception {
		Integer validUserId = 3;
		this.mockmvc.perform(MockMvcRequestBuilders.get(
				"/users/{user_id}/followers/list", validUserId))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(validUserId))
				.andExpect(MockMvcResultMatchers.jsonPath("$.user_name").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.followers").exists());
	}

	@Test
	public void invalidUserIdInFollowedShouldGetNotFoundStatus () throws Exception {
		Integer invalidUserId = 404;
		this.mockmvc.perform(MockMvcRequestBuilders.get(
				"/users/{user_id}/followed/list", invalidUserId))
				.andDo(print()).andExpect(status().isNotFound());
	}

	@Test
	public void validGetFollowedShouldGetOkStatus () throws Exception {
		Integer validUserId = 1;
		this.mockmvc.perform(MockMvcRequestBuilders.get(
				"/users/{user_id}/followed/list", validUserId))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(validUserId))
				.andExpect(MockMvcResultMatchers.jsonPath("$.user_name").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.followed").exists());
	}

	@Test
	void validUnFollowShouldGetOkStatus () throws Exception {
		Integer firstUserId = 1;
		Integer secondUserId = 3;
		this.mockmvc.perform(MockMvcRequestBuilders.post(
						"/users/{user_id}/follow/{user_id_to_follow}",
						firstUserId, secondUserId))
				.andDo(print()).andExpect(status().isOk());
		this.mockmvc.perform(MockMvcRequestBuilders.post(
						"/users/{user_id}/unfollow/{user_id_to_unfollow}",
						firstUserId, secondUserId))
				.andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void invalidUserIdInUnfollowShouldGetNotFoundStatus () throws Exception {
		Integer validUserId = 1;
		Integer invalidUserId = 1111;
		this.mockmvc.perform(MockMvcRequestBuilders.post(
				"/users/{user_id}/unfollow/{user_id_to_unfollow}",
				validUserId, invalidUserId))
				.andDo(print()).andExpect(status().isNotFound());
	}

	@Test
	void sameUserIdInUnFollowShouldGetBadRequestStatus () throws Exception {
		Integer validUserId = 2;
		this.mockmvc.perform(MockMvcRequestBuilders.post(
						"/users/{user_id}/unfollow/{user_id_to_unfollow}",
						validUserId, validUserId))
				.andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	void noFollowToUnFollowShouldGetBadRequestStatus () throws Exception {
		Integer firstUserId = 2;
		Integer secondUserId = 3;
		this.mockmvc.perform(MockMvcRequestBuilders.post(
						"/users/{user_id}/unfollow/{user_id_to_unfollow}",
						firstUserId, secondUserId))
				.andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	void validPostShouldGetOkStatus () throws Exception {
		PostDTO validPost = this.mapper.map(this.meliUtils.genDefaultRecentPost(1, 1,
				"Gamer Mate Tea"), PostDTO.class);
		String validPayload = this.writer.writeValueAsString(validPost);

		this.mockmvc.perform(MockMvcRequestBuilders.post("/products/post")
				.contentType(MediaType.APPLICATION_JSON).content(validPayload))
				.andDo(print()).andExpect(status().isOk());
	}

	@Test
	void invalidUserIdInPostShouldGetNotFoundStatus () throws Exception {
		Integer invalidUserId = 900;
		PostDTO invalidPost = this.mapper.map(this.meliUtils.genDefaultRecentPost(invalidUserId,
				2, "Gamer Oven"), PostDTO.class);
		String invalidPayload = this.writer.writeValueAsString(invalidPost);

		this.mockmvc.perform(MockMvcRequestBuilders.post("/products/post")
				.contentType(MediaType.APPLICATION_JSON).content(invalidPayload))
				.andDo(print()).andExpect(status().isNotFound());
	}

	@Test
	void samePostIdInPostShouldGetBadRequestStatus () throws Exception {
		PostDTO validPost = this.mapper.map(this.meliUtils.genDefaultRecentPost(3, 5,
				"Gamer Gloves"), PostDTO.class);
		PostDTO invalidPost = this.mapper.map(this.meliUtils.genDefaultRecentPost(2, 5,
				"Gamer Scarf"), PostDTO.class);
		String validPayload = this.writer.writeValueAsString(validPost);
		String invalidPayload = this.writer.writeValueAsString(invalidPost);

		this.mockmvc.perform(MockMvcRequestBuilders.post("/products/post")
				.contentType(MediaType.APPLICATION_JSON).content(validPayload))
				.andDo(print()).andExpect(status().isOk());

		this.mockmvc.perform(MockMvcRequestBuilders.post("/products/post")
				.contentType(MediaType.APPLICATION_JSON).content(invalidPayload))
				.andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	void invalidUserIdInGetFollowedPostListShouldGetNotFoundStatus () throws Exception {
		Integer invalidUserId = 555;
		String validOrder = "date_asc";

		this.mockmvc.perform(MockMvcRequestBuilders.get("/products/followed/{user_id}/list",
				invalidUserId).param("order", validOrder))
				.andDo(print()).andExpect(status().isNotFound());
	}

	@Test
	void invalidOrderInGetFollowedPostListShouldGetInternalServerErrorStatus () throws Exception {
		Integer validUserId = 2;
		String invalidOrder = null;

		this.mockmvc.perform(MockMvcRequestBuilders.get("/products/followed/{user_id}/list",
				validUserId).param("order", invalidOrder))
				.andDo(print()).andExpect(status().isInternalServerError());
	}

	@Test
	void validGetFollowedPostListShouldGetOkStatus () throws Exception {
		Integer validUserId = 3;
		String validOrder = "date_desc";

		this.mockmvc.perform(MockMvcRequestBuilders.get("/products/followed/{user_id}/list",
				validUserId).param("order", validOrder))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(validUserId))
				.andExpect(MockMvcResultMatchers.jsonPath("$.posts").exists());
	}

	@Test
	void validPromoShouldGetOkStatus () throws Exception {
		PostDTO validPromo = this.mapper.map(this.meliUtils.genDefaultRecentPromo(4, 3,
				"Gamer Stove", 25.0), PostDTO.class);
		String validPayload = this.writer.writeValueAsString(validPromo);

		this.mockmvc.perform(MockMvcRequestBuilders.post("/products/promo-post")
				.contentType(MediaType.APPLICATION_JSON).content(validPayload))
				.andDo(print()).andExpect(status().isOk());
	}

	@Test
	void invalidUserIdInPromoShouldGetNotFoundStatus () throws Exception {
		Integer invalidUserId = 90;
		PostDTO invalidPromo = this.mapper.map(this.meliUtils.genDefaultRecentPromo(invalidUserId,
				4, "Gamer Pencil Case", 21.0), PostDTO.class);
		String invalidPayload = this.writer.writeValueAsString(invalidPromo);

		this.mockmvc.perform(MockMvcRequestBuilders.post("/products/promo-post")
				.contentType(MediaType.APPLICATION_JSON).content(invalidPayload))
				.andDo(print()).andExpect(status().isNotFound());
	}

	@Test
	void invalidDiscountInPromoShouldGetBadRequestStatus () throws Exception {
		PostDTO invalidPromo = this.mapper.map(this.meliUtils.genDefaultRecentPromo(4, 6,
				"Gamer Microwave", 200.0), PostDTO.class);
		String invalidPayload = this.writer.writeValueAsString(invalidPromo);

		this.mockmvc.perform(MockMvcRequestBuilders.post("/products/promo-post")
				.contentType(MediaType.APPLICATION_JSON).content(invalidPayload))
				.andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	void samePostIdInPromoShouldGetBadRequestStatus () throws Exception {
		PostDTO validPromo = this.mapper.map(this.meliUtils.genDefaultRecentPromo(1, 7,
				"Gamer Watch", 12.0), PostDTO.class);
		PostDTO invalidPromo = this.mapper.map(this.meliUtils.genDefaultRecentPromo(3, 7,
				"Gamer Wristband", 13.0), PostDTO.class);
		String validPayload = this.writer.writeValueAsString(validPromo);
		String invalidPayload = this.writer.writeValueAsString(invalidPromo);

		this.mockmvc.perform(MockMvcRequestBuilders.post("/products/promo-post")
				.contentType(MediaType.APPLICATION_JSON).content(validPayload))
				.andDo(print()).andExpect(status().isOk());

		this.mockmvc.perform(MockMvcRequestBuilders.post("/products/promo-post")
				.contentType(MediaType.APPLICATION_JSON).content(invalidPayload))
				.andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	void validGetPromoCountShouldGetOkStatus () throws Exception {
		Integer validUserId = 3;

		this.mockmvc.perform(MockMvcRequestBuilders.get("/products/{user_id}/promo-post/count",
				validUserId)).andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(validUserId))
				.andExpect(MockMvcResultMatchers.jsonPath("$.user_name").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.promo_products_count").exists());
	}

	@Test
	void invalidUserIdInGetPromoCountShouldGetNotFoundStatus () throws Exception {
		Integer invalidUserId = 838;

		this.mockmvc.perform(MockMvcRequestBuilders.get("/products/{user_id}/promo-post/count",
				invalidUserId)).andDo(print()).andExpect(status().isNotFound());
	}

	@Test
	void validGetPromoPostsShouldGetOkStatus () throws Exception {
		Integer validUserId = 4;

		this.mockmvc.perform(MockMvcRequestBuilders.get("/products/{user_id}/list",
				validUserId)).andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(validUserId))
				.andExpect(MockMvcResultMatchers.jsonPath("$.posts").exists());
	}

	@Test
	void invalidUserIdInGetPromoPostsShouldGetNotFoundStatus () throws Exception {
		Integer invalidUserId = 11;

		this.mockmvc.perform(MockMvcRequestBuilders.get("/products/{user_id}/list",
				invalidUserId)).andDo(print()).andExpect(status().isNotFound());
	}

}
