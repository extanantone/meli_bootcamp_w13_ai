package com.Sprint1.SocialMeli.unit.service;

import com.Sprint1.SocialMeli.dto.FollowerDTO;
import com.Sprint1.SocialMeli.dto.PostFollowedListDTO;
import com.Sprint1.SocialMeli.dto.PostDTO;
import com.Sprint1.SocialMeli.exceptions.NotFoundException;
import com.Sprint1.SocialMeli.model.User;
import com.Sprint1.SocialMeli.repository.UserRepository;
import com.Sprint1.SocialMeli.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;



@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private ProductService productService;

	static ArrayList<FollowerDTO> followers = new ArrayList<>();
	static ArrayList<FollowerDTO> followed = new ArrayList<>();

	static User kevin = new User();
	static User jean = new User();
	static User marco = new User();
	static User gabriela = new User();



	@BeforeAll
	static void setUp () {



		marco.setUser_id(3);
		marco.setUser_name("Marco Avila");

		gabriela.setUser_id(2);
		gabriela.setUser_name("Gabriela Monzon");


		jean.setUser_id(5);
		jean.setUser_name("Jean Cardo");
		followed.add(new FollowerDTO (5, "Jean Cardo"));

		kevin.setUser_id(4);
		kevin.setUser_name("Kevin Sueldo");
		kevin.setFollowers(followers);
		kevin.setFollowed(followed);

	}


//================================== T-0005==============================

//================================== T-0006==============================

	@Test
	void testPostListDescFollowed() {

		 PostDTO post1 = new PostDTO(4,111, LocalDate.now().minusDays(7), null, 1234, 100.0);
		 PostDTO post2 = new PostDTO(4,222, LocalDate.now().minusDays(8), null, 4321, 150.0);
		 PostDTO post3 = new PostDTO(4,333, LocalDate.now().minusDays(9), null, 5676, 200.0);

		 ArrayList<PostDTO> listPostDTOs = new ArrayList<>();
		 listPostDTOs.add(post1);
		 listPostDTOs.add(post2);
		 listPostDTOs.add(post3);


		 jean.setPost(listPostDTOs);

		 when(userRepository.findUser(4)).thenReturn(Optional.of(kevin));

		 when(userRepository.findUser(5)).thenReturn(Optional.of(jean));

		 PostFollowedListDTO listFollowedPost = productService.postListFollowed(4, "date_desc");


		 verify(userRepository, atLeast(1)).findUser(anyInt());

		 Assertions.assertTrue(listFollowedPost.getPost().get(0).getDate()
				.compareTo(jean.getPost().get(1).getDate())> 0);

	}

	@Test
	void testPostListDescFollowedExceptions() {

		Assertions.assertThrows(NotFoundException.class, () -> productService.postListFollowed(6, "name_asc"));
	}


	@Test
	void testPostListAscFollowed() {

		PostDTO post1 = new PostDTO(4,111, LocalDate.now().minusDays(7), null, 1234, 100.0);
		PostDTO post2 = new PostDTO(4,222, LocalDate.now().minusDays(8), null, 4321, 150.0);
		PostDTO post3 = new PostDTO(4,333, LocalDate.now().minusDays(9), null, 5676, 200.0);

		ArrayList<PostDTO> listPostDTOs = new ArrayList<>();
		listPostDTOs.add(post1);
		listPostDTOs.add(post2);
		listPostDTOs.add(post3);


		jean.setPost(listPostDTOs);

		when(userRepository.findUser(4)).thenReturn(Optional.of(kevin));

		when(userRepository.findUser(5)).thenReturn(Optional.of(jean));

		PostFollowedListDTO listFollowedPost = productService.postListFollowed(4, "date_asc");


		verify(userRepository, atLeast(1)).findUser(anyInt());

		Assertions.assertTrue(listFollowedPost.getPost().get(0).getDate()
				.compareTo(jean.getPost().get(1).getDate())< 0);

	}

	@Test
	void testPostListAscFollowedExceptions() {

		Assertions.assertThrows(NotFoundException.class, () -> productService.postListFollowed(6, "name_asc"));
	}



//================================== T-0008==============================


	@Test
	void testPostListFollowedDate() {

		PostDTO post1 = new PostDTO(4,111, LocalDate.now().minusDays(7), null, 1234, 100.0);
		PostDTO post2 = new PostDTO(4,222, LocalDate.now().minusDays(8), null, 4321, 150.0);
		PostDTO post3 = new PostDTO(4,333, LocalDate.now().minusDays(20), null, 5676, 200.0);

		ArrayList<PostDTO> listPostDTOs = new ArrayList<>();
		listPostDTOs.add(post1);
		listPostDTOs.add(post2);
		listPostDTOs.add(post3);

		ArrayList<PostDTO> jeanListFilter = new ArrayList<>();
		jeanListFilter.add(post1);
		jeanListFilter.add(post2);


		jean.setPost(listPostDTOs);

		when(userRepository.findUser(4)).thenReturn(Optional.of(kevin));

		when(userRepository.findUser(5)).thenReturn(Optional.of(jean));

		PostFollowedListDTO listFollowedPost = productService.postListFollowed(4, "date_desc");

		verify(userRepository, atLeast(1)).findUser(anyInt());

		Assertions.assertEquals(jeanListFilter, listFollowedPost.getPost());

	}
}