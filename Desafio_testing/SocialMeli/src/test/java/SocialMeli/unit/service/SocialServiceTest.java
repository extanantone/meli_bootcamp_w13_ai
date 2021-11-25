package SocialMeli.unit.service;

import SocialMeli.dto.response.count.FollowersCountDTO;
import SocialMeli.exception.OrderMethodInexistentException;
import SocialMeli.mapper.SocialMapper;
import SocialMeli.model.Customer;
import SocialMeli.model.Post;
import SocialMeli.model.Product;
import SocialMeli.model.Seller;
import SocialMeli.repository.SocialRepository;
import SocialMeli.service.SocialService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class SocialServiceTest {
    @Mock
    SocialRepository repo;
    @Mock
    SocialMapper mapper;
    @InjectMocks
    SocialService service;

    //T-0003
    @Test
    public void alphabeticalOrderExist() {
        //arrange
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(10, "a"));
        customerList.add(new Customer(11, "b"));
        //act
        service.sortCustomerByName(customerList, "name_asc");
        service.sortCustomerByName(customerList, "name_desc");
        //assert
        Assertions.assertThrows(OrderMethodInexistentException.class,
                () -> service.sortCustomerByName(customerList, "something"));
    }

    //T-0004
    @Test
    public void alphabeticalOrderWorks() {
        //arrange
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(10, "a"));
        customerList.add(new Customer(11, "c"));
        customerList.add(new Customer(12, "b"));
        //act
        service.sortCustomerByName(customerList, "name_asc");
        String resultStrAsc = customerList.stream().reduce("", (acc, cv) -> acc + cv.getUserName(), String::concat);
        service.sortCustomerByName(customerList, "name_desc");
        String resultStrDesc = customerList.stream().reduce("", (acc, cv) -> acc + cv.getUserName(), String::concat);
        //assert
        Assertions.assertAll(
                () -> Assertions.assertEquals("abc", resultStrAsc),
                () -> Assertions.assertEquals("cba", resultStrDesc)
        );
    }

    //T-0005
    @Test
    public void dateOrderExist() {
        //arrange
        List<Post> postList = new ArrayList<>();
        Product product = new Product(1, "a", "a", "a", "a", "a");
        postList.add(new Post(4, 1, LocalDate.of(2020, 3, 10), product, 100, 1.0, false, 0));
        postList.add(new Post(4, 2, LocalDate.of(2020, 3, 11), product, 100, 1.0, false, 0));
        //act
        service.sortPostByDate(postList, "date_asc");
        service.sortPostByDate(postList, "date_desc");
        //assert
        Assertions.assertThrows(OrderMethodInexistentException.class,
                () -> service.sortPostByDate(postList, "something"));
    }

    //T-0006
    @Test
    public void dateOrderWorks() {
        //arrange
        List<Post> postList = new ArrayList<>();
        Product product = new Product(1, "a", "a", "a", "a", "a");
        postList.add(new Post(4, 1, LocalDate.of(2020, 3, 10), product, 100, 1.0, false, 0));
        postList.add(new Post(4, 3, LocalDate.of(2020, 3, 12), product, 100, 1.0, false, 0));
        postList.add(new Post(4, 2, LocalDate.of(2020, 3, 11), product, 100, 1.0, false, 0));
        //act
        service.sortPostByDate(postList, "date_asc");
        String resultStrAsc = postList.stream().reduce("", (acc, cv) -> acc + cv.getIdPost(), String::concat);
        service.sortPostByDate(postList, "date_desc");
        String resultStrDesc = postList.stream().reduce("", (acc, cv) -> acc + cv.getIdPost(), String::concat);
        //assert
        Assertions.assertAll(
                () -> Assertions.assertEquals("123", resultStrAsc),
                () -> Assertions.assertEquals("321", resultStrDesc)
        );
    }

    //T-0007
    @Test
    public void followersCount() {
        //arrange
        int id = 40;
        Seller seller = new Seller(id, "seller");
        seller.getFollowersIdSet().add(1);
        seller.getFollowersIdSet().add(2);
        seller.getFollowersIdSet().add(3);
        FollowersCountDTO expect = new FollowersCountDTO(seller.getUserId(), seller.getUserName(), seller.getPostIdSet().size());
        Mockito.when(repo.getSeller(id)).thenReturn(seller);
        Mockito.when(mapper.sellerToFollowersCountDTO(seller))
                .thenReturn(new FollowersCountDTO(seller.getUserId(), seller.getUserName(), seller.getPostIdSet().size()));
        //act
        FollowersCountDTO result = service.getFollowersCount(id);
        //assert
        Assertions.assertAll(
                () -> Mockito.verify(repo, Mockito.atLeastOnce()).getSeller(id),
                () -> Mockito.verify(mapper, Mockito.atLeastOnce()).sellerToFollowersCountDTO(seller),
                () -> Assertions.assertEquals(expect, result)
        );
    }
}
