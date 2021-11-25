package SocialMeli.unit.repository;

import SocialMeli.exception.WrongIdException;
import SocialMeli.model.Customer;
import SocialMeli.model.Post;
import SocialMeli.model.Product;
import SocialMeli.model.Seller;
import SocialMeli.repository.SocialRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class SocialRepositoryTest {

    SocialRepository repo;

    @BeforeEach
    public void setUp() {
        repo = new SocialRepository();
    }

    //T-0001 y T-0002 devuelve Customer o genera una excepcion
    @Test
    public void customerExist() {
        //arrange
        Customer customer = new Customer(55, "testCustomer");
        repo.newUser(customer);
        //act
        Customer result = repo.getCustomer(customer.getUserId());
        //assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(customer, result),
                () -> Assertions.assertThrows(WrongIdException.class, () -> repo.getCustomer(755))
        );

    }

    //T-0001 y T-0002 devuelve Seller o genera una excepcion
    @Test
    public void sellerExist() {
        //arrange
        Seller seller = new Seller(55, "testCustomer");
        repo.newUser(seller);
        //act
        Seller result = repo.getSeller(seller.getUserId());
        //assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(seller, result),
                () -> Assertions.assertThrows(WrongIdException.class, () -> repo.getSeller(755))
        );

    }

    //T-0007 (se testea la cuenta en el service)
    @Test
    public void getFollowers() {
        //arrange
        repo.newUser(new Seller(50, "seller"));
        repo.newUser(new Customer(51, "CustomerA"));
        repo.newUser( new Customer(52, "CustomerB"));
        repo.newUser(new Customer(53, "CustomerC"));
        Seller seller = repo.getSeller(50);
        Customer customerA = repo.getCustomer(51);
        Customer customerB = repo.getCustomer(52);
        List<Customer> customerList = List.of(customerA, customerB);
        customerList.forEach(
                (c) -> {
                    c.getFollowedsIdSet().add(seller.getUserId());
                    seller.getFollowersIdSet().add(c.getUserId());
                });

        //act
        List<Customer> result = repo.getFollowers(seller.getUserId());
        //assert
        Assertions.assertArrayEquals(customerList.toArray(),result.toArray());
    }

    //T-0008 (se testea la cuenta en el service)
    @Test
    public void twoWeekPost() {
        //arrange
        repo.newUser(new Customer(10,"customer"));
        repo.newUser(new Seller(11,"seller"));
        Customer customer = repo.getCustomer(10);
        Seller seller = repo.getSeller(11);
        customer.getFollowedsIdSet().add(seller.getUserId());
        seller.getFollowersIdSet().add(customer.getUserId());
        Product product = new Product(1, "a", "a", "a", "a", "a");
        Post resultOne = new Post(11, 1, LocalDate.now(), product, 100, 1.0, false, 0);
        Post resultTwo = new Post(11, 2, LocalDate.now().minusDays(12), product, 100, 1.0, false, 0);
        repo.newPost(new Post(11, 3, LocalDate.of(2020, 11, 24), product, 100, 1.0, false, 0));
        repo.newPost(new Post(11, 4, LocalDate.of(2021, 10, 24), product, 100, 1.0, false, 0));
        repo.newPost(new Post(11, 5, LocalDate.of(2021, 11, 2), product, 100, 1.0, false, 0));
        repo.newPost(resultTwo);
        repo.newPost(resultOne);
        //act
        List<Post> result = repo.getCustomerPostsByDate(customer.getUserId(), LocalDate.now().minusDays(13), LocalDate.now());
        //assert
        Assertions.assertAll(
                () -> Assertions.assertTrue(result.contains(resultOne)),
                () -> Assertions.assertTrue(result.contains(resultTwo)),
                () -> Assertions.assertEquals(2, result.size())
        );
    }

}
