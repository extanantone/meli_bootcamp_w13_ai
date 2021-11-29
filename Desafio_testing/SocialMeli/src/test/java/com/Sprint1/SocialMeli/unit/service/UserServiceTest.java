package com.Sprint1.SocialMeli.unit.service;

import com.Sprint1.SocialMeli.dto.FollowCountDTO;
import com.Sprint1.SocialMeli.dto.FollowedListDTO;
import com.Sprint1.SocialMeli.dto.FollowerDTO;
import com.Sprint1.SocialMeli.dto.FollowersListDTO;
import com.Sprint1.SocialMeli.exceptions.NotFoundException;
import com.Sprint1.SocialMeli.model.User;
import com.Sprint1.SocialMeli.repository.UserRepository;
import com.Sprint1.SocialMeli.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.atLeastOnce;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	static ArrayList<FollowerDTO> followers = new ArrayList<>();
	static ArrayList<FollowerDTO> followed = new ArrayList<>();

	static FollowerDTO follower1 = new FollowerDTO();
	static FollowerDTO follower2 = new FollowerDTO();

	static FollowerDTO followed1 = new FollowerDTO();
	static FollowerDTO followed2 = new FollowerDTO();

	static User kevin = new User();

	@BeforeAll
	 static void setUp () {


		follower1.setUser_id(2);
		follower1.setUser_name("Gabriela Monzon");
		followers.add(follower1);

		follower2.setUser_id(3);
		follower2.setUser_name("Marco Avila");
		followers.add(follower2);


		followed2.setUser_id(3);
		followed2.setUser_name("Marco Avila");
		followed.add(followed2);

		followed1.setUser_id(2);
		followed1.setUser_name("Gabriela Monzon");
		followed.add(followed1);


		kevin.setUser_id(4);
		kevin.setUser_name("Kevin Sueldo");
		kevin.setFollowers(followers);
		kevin.setFollowed(followed);

	}

//================================== T-0001==============================
	@Test
	void testUserToFollowIsValidId() {
		User user = new User(1, "Anibal Antonelli");


		when(userRepository.findUser(1)).thenReturn(Optional.of(user));


		Optional<User> userFollowing = this.userRepository.findUser(1);


		verify(userRepository, atLeastOnce()).findUser(Mockito.anyInt());


		Assertions.assertTrue(userFollowing.isPresent());

	}

	@Test
	void testUserToFollowIsValidIdExceptions() {

		Assertions.assertThrows(NotFoundException.class, () -> userService.followSeller(5, 5));
	}



//================================== T-0002==============================


	@Test
	void testUserToUnfollowIsValidId() {
		User user = new User(1, "Anibal Antonelli");


		when(userRepository.findUser(1)).thenReturn(Optional.of(user));


		Optional<User> userUnFollowing = userRepository.findUser(1);


		verify(userRepository, atLeastOnce()).findUser(Mockito.anyInt());


		Assertions.assertTrue(userUnFollowing.isPresent());
	}

	@Test
	void testUserToUnfollowIsValidIdExceptions() {

		Assertions.assertThrows(NotFoundException.class, () -> userService.unfollowSeller(5, 5));
	}


//================================== T-0003==============================

//================================== T-0004==============================

	//================== ASC =====================
	@Test
	void testFollowerListAsc() {

		when(userRepository.findUser(4)).thenReturn(Optional.of(kevin));

		FollowersListDTO followersSorted = userService.followerList(4, "name_asc");

		verify(userRepository, atLeast(1)).findUser(anyInt());

		Assertions.assertTrue(followersSorted.getFollowers().get(0).getUser_name().compareTo(kevin.getFollowers().get(1).getUser_name())< 0);
	}

	@Test
	void testFollowerAscListExceptions() {

		Assertions.assertThrows(NotFoundException.class, () -> userService.followerList(5, "name_asc"));
	}

	//================== DESC =====================
	@Test
	void testFollowerListDesc() {

		when(userRepository.findUser(4)).thenReturn(Optional.of(kevin));

		FollowersListDTO followersSorted = userService.followerList(4, "name_desc");

		verify(userRepository, atLeast(1)).findUser(anyInt());

		Assertions.assertTrue(followersSorted.getFollowers().get(0).getUser_name().compareTo(followersSorted.getFollowers().get(1).getUser_name())> 0);

	}

	@Test
	void testFollowerListDescExceptions() {

		Assertions.assertThrows(NotFoundException.class, () -> userService.followerList(5, "name_desc"));
	}



	//================== ASC =====================
	@Test
	void testFollowedAscList() {

		when(userRepository.findUser(4)).thenReturn(Optional.of(kevin));

		FollowedListDTO followedSorted = userService.followedList(4, "name_asc");

		verify(userRepository, atLeast(1)).findUser(anyInt());

		Assertions.assertTrue(followedSorted.getFollowed().get(0).getUser_name().compareTo(followedSorted.getFollowed().get(1).getUser_name())< 0);
	}

	@Test
	void testFollowedListAscExceptions() {

		Assertions.assertThrows(NotFoundException.class, () -> userService.followerList(5, "name_asc"));
	}


	//================== DESC =====================
	@Test
	void testFollowedDescList() {

		when(userRepository.findUser(4)).thenReturn(Optional.of(kevin));

		FollowedListDTO followedSorted = userService.followedList(4, "name_desc");

		verify(userRepository, atLeast(1)).findUser(anyInt());

		Assertions.assertTrue(followedSorted.getFollowed().get(0).getUser_name().compareTo(kevin.getFollowed().get(1).getUser_name())> 0);
	}

	@Test
	void testFollowedListDescExceptions() {

		Assertions.assertThrows(NotFoundException.class, () -> userService.followerList(5, "name_desc"));
	}


//================================== T-0007==============================

	@Test
	void testFollowerCount() {

		when(userRepository.findUser(4)).thenReturn(Optional.of(kevin));

		FollowCountDTO followCountDTO = userService.followerCount(4);

		verify(userRepository, atLeast(1)).findUser(anyInt());

		Assertions.assertEquals(kevin.getFollowers().size(), followCountDTO.getFollowers_count());
	}

}