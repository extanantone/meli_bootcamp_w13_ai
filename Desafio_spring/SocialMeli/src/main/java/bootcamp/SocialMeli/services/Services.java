package bootcamp.SocialMeli.services;

import bootcamp.SocialMeli.dto.*;
import bootcamp.SocialMeli.exception.InvalidUserException;
import bootcamp.SocialMeli.exception.NotFoundUserException;
import bootcamp.SocialMeli.model.Post;
import bootcamp.SocialMeli.model.User;
import bootcamp.SocialMeli.repository.IRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatter;


@Service
public class Services implements IService {

    public IRepository iRepository;
    private DateTimeFormatter DataTimeFormatter;


    public Services(IRepository iRepository) {
        this.iRepository = iRepository;
    }


    @Override
    public void followUser(int idUser, int idSeller) {
        User seller = iRepository.getUserById(idSeller);
        User user = iRepository.getUserById(idUser);
        if (seller == null || user == null)
            throw new NotFoundUserException("No se encontró el usuario para seguirlo");
        seller.addFollower(user);
    }

    @Override
    public CountSellerFollowersDto getCountBySeller(int idSeller) {
        User seller = iRepository.getUserById(idSeller);
        if (seller == null)
            throw new NotFoundUserException("No se encontro al vendedor");
        else if (!seller.isSeller())
            throw new InvalidUserException("El usuario ingresado no es un vendedor");
        return new CountSellerFollowersDto(seller.getId(), seller.getName(), seller.getFollowers().size());
    }

    @Override
    public ListFollowerDto getFollowerList(int idSeller) {
        User seller = iRepository.getUserById(idSeller);
        if (seller == null)
            throw new NotFoundUserException("No existe el usuario ingresado");
        else if (!seller.isSeller())
            throw new InvalidUserException("Este usuario no es vendedor");

        List<ItemFollowerDto> items = seller.getFollowers().stream()
                .map(i -> new ItemFollowerDto(i.getId(), i.getName()))
                .collect(Collectors.toList());

        return new ListFollowerDto(seller.getId(), seller.getName(), items);
    }

    @Override
    public ListFollowerDto getListFollowerAsc(int userId) {
        User seller = iRepository.getUserById(userId);
        if (seller == null)
            throw new NotFoundUserException("No existe el usuario ingresado");
        else if (!seller.isSeller())
            throw new InvalidUserException("Este usuario no es vendedor");

        List<ItemFollowerDto> items = seller.getFollowers().stream()
                .sorted(Comparator.comparing(User::getName))
                .map(i -> new ItemFollowerDto(i.getId(), i.getName()))
                .collect(Collectors.toList());

        return new ListFollowerDto(seller.getId(), seller.getName(), items);
    }

    @Override
    public ListFollowerDto getListFollowerDesc(int userId) {
        User seller = iRepository.getUserById(userId);
        if (seller == null)
            throw new NotFoundUserException("No existe el usuario ingresado");
        else if (!seller.isSeller())
            throw new InvalidUserException("Este usuario no es vendedor");

        List<ItemFollowerDto> items = seller.getFollowers().stream()
                .sorted(Comparator.comparing(User::getName).reversed())
                .map(i -> new ItemFollowerDto(i.getId(), i.getName()))
                .collect(Collectors.toList());

        return new ListFollowerDto(seller.getId(), seller.getName(), items);
    }

    @Override
    public ListFollowerDto getListFollowedAsc(int userId) {
        User user = iRepository.getUserById(userId);
        if (user == null)
            throw new NotFoundUserException("No existe el usuario ingresado");
        List<ItemFollowerDto> items = iRepository.followedUser(user)
                .stream().sorted(Comparator.comparing(User::getName))
                .map(u -> new ItemFollowerDto(u.getId(), u.getName()))
                .collect(Collectors.toList());
        return new ListFollowerDto(user.getId(), user.getName(), items);
    }

    @Override
    public ListFollowerDto getListFollowedDesc(int userId) {
        User user = iRepository.getUserById(userId);
        if (user == null)
            throw new NotFoundUserException("No existe el usuario ingresado");
        List<ItemFollowerDto> items = iRepository.followedUser(user)
                .stream().sorted(Comparator.comparing(User::getName).reversed())
                .map(u -> new ItemFollowerDto(u.getId(), u.getName()))
                .collect(Collectors.toList());
        return new ListFollowerDto(user.getId(), user.getName(), items);
    }

    @Override
    public ListFollowerDto getFollowed(int userId) {
        User user = iRepository.getUserById(userId);
        if (user == null)
            throw new NotFoundUserException("No existe el usuario ingresado");
        List<ItemFollowerDto> items = iRepository.followedUser(user)
                .stream().map(u -> new ItemFollowerDto(u.getId(), u.getName()))
                .collect(Collectors.toList());
        return new ListFollowerDto(user.getId(), user.getName(), items);
    }

    @Override
    public void addPost(NewPostDto dto) {
        User user = iRepository.getUserById(dto.getUserId());
        if (user == null)
            throw new NotFoundUserException("No existe el usuario ingresado");
        DetallePostDto detalle = dto.getDetalle();
        System.out.println(dto.getPostId());
        user.addPost(new Post(dto.getPostId(), LocalDate.parse(dto.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")), detalle.getItemId(),
                detalle.getItemName(), detalle.getType(), dto.getCategoria(), dto.getPrecio()));
    }

    @Override
    public PostListDto getListPostByUser(int userId) {
        if (iRepository.getUserById(userId) == null)
            throw new NotFoundUserException("No existe el usuario ingresado");
        List<Post> posts = iRepository.getLastPostTwoWeekAgo(userId);
        List<DataPostDto> productos = posts.stream().map(i -> new DataPostDto(i.getPostId(), i.getPrecio(), i.getCategoria(),
                new DetallePostDto(i.getItemId(), i.getItemName(), i.getType()), i.getDate().toString())).collect(Collectors.toList());
        return new PostListDto(userId, productos);
    }

    @Override
    public PostListDto getListPostByUserAsc(int id) {
        if (iRepository.getUserById(id) == null)
            throw new NotFoundUserException("No existe el usuario ingresado");
        List<Post> posts = iRepository.getLastPostTwoWeekAgo(id);
        List<DataPostDto> productos = posts.stream().sorted(Comparator.comparing(Post::getDate))
                .map(i -> new DataPostDto(i.getPostId(), i.getPrecio(), i.getCategoria(),
                        new DetallePostDto(i.getItemId(), i.getItemName(), i.getType()), i.getDate().toString())).collect(Collectors.toList());
        return new PostListDto(id, productos);
    }

    @Override
    public PostListDto getListPostByUserDesc(int id) {
        if (iRepository.getUserById(id) == null)
            throw new NotFoundUserException("No existe el usuario ingresado");
        List<Post> posts = iRepository.getLastPostTwoWeekAgo(id);
        List<DataPostDto> productos = posts.stream().sorted(Comparator.comparing(Post::getDate).reversed())
                .map(i -> new DataPostDto(i.getPostId(), i.getPrecio(), i.getCategoria(),
                        new DetallePostDto(i.getItemId(), i.getItemName(), i.getType()), i.getDate().toString())).collect(Collectors.toList());
        return new PostListDto(id, productos);
    }

    @Override
    public void unfollowUser(int id, int userId) {
        User user = iRepository.getUserById(id);
        User vendedor = iRepository.getUserById(userId);
        if (user == null || vendedor == null)
            throw new NotFoundUserException("Ninguno de los usuarios ingresado existe");
        else if (!vendedor.isSeller())
            throw new InvalidUserException("El usuario ingresado no es vendedor");
        vendedor.unfollow(user);
    }

    @Override
    public Integer addUser(UserRequestDto dto) {
        User user = iRepository.findUserByLastName(dto.getLastname());
        if (user != null)
            throw new InvalidUserException("Ya existe un usuario con ese apellido");
        User created = new User(dto.getUsername(), dto.getLastname(), dto.isSeller());
        iRepository.save(created);
        return created.getId();
    }

    @Override
    public List<UsuariosDto> getAllUsers() {
        return iRepository.findAll().stream()
                .map(u -> new UsuariosDto(u.getId(), u.getLastname(), u.getName(), u.isSeller()))
                .collect(Collectors.toList());
    }

    @Override
    public List<UsuariosDto> getAllSellers() {
        List<User> users = iRepository.findAllVendedores();
        return users.stream()
                .map(u -> new UsuariosDto(u.getId(), u.getLastname(), u.getName(), u.isSeller()))
                .collect(Collectors.toList());
    }

}
