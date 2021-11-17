package bootcamp.SocialMeli.services;

import bootcamp.SocialMeli.dto.CountSellerFollowersDto;
import bootcamp.SocialMeli.dto.DetallePostDto;
import bootcamp.SocialMeli.dto.ListFollowerDto;
import bootcamp.SocialMeli.dto.NewPostDto;
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
public class Services implements IService{

    public IRepository iRepository;
    private DateTimeFormatter DataTimeFormatter;


    public Services(IRepository iRepository) {
        this.iRepository = iRepository;
    }


    @Override
    public void followUser(int idUser, int idSeller) {
        User seller = iRepository.getUserById(idSeller);
        User user = iRepository.getUserById(idUser);
        if(seller==null || user==null)
            throw  new NotFoundUserException("No se encontró el usuario para seguirlo");
        seller.addFollower(user);
    }

    @Override
    public CountSellerFollowersDto getCountBySeller(int idSeller) {
        User seller = iRepository.getUserById(idSeller);
        if(seller==null)
            throw new NotFoundUserException("No se encontro al vendedor");
        else if(!seller.isSeller())
            throw new InvalidUserException("El usuario ingresado no es un vendedor");
        return new CountSellerFollowersDto(seller.getId(),seller.getName(),seller.getFollowers().size());
    }

    @Override
    public ListFollowerDto getFollowerList(int idSeller) {
        User seller = iRepository.getUserById(idSeller);
        if(seller==null)
            throw new NotFoundUserException("No existe el usuario ingresado");
        else if(!seller.isSeller())
            throw new InvalidUserException("Este usuario no es vendedor");

        List<ListFollowerDto> items= seller.getFollowers().stream()
                            .map(i->new ListFollowerDto(i.getId(), i.getName()))
                            .collect(Collectors.toList());

        return new ListFollowerDto(seller.getId(), seller.getName(), items);
    }

    @Override
    public ListFollowerDto getListFollowerAsc(int userId) {
        User seller = iRepository.getUserById(userId);
        if(seller==null)
            throw new NotFoundUserException("No existe el usuario ingresado");
        else if(!seller.isSeller())
            throw new InvalidUserException("Este usuario no es vendedor");

        List<ListFollowerDto> items = seller.getFollowers().stream()
                .sorted(Comparator.comparing(User::getName))
                .map(i->new ListFollowerDto(i.getId(),i.getName()))
                .collect(Collectors.toList());

        return new ListFollowerDto(seller.getId(),seller.getName(), items);
    }

    @Override
    public ListFollowerDto getListFollowerDesc(int userId) {
        User seller = iRepository.getUserById(userId);
        if(seller==null)
            throw new NotFoundUserException("No existe el usuario ingresado");
        else if(!seller.isSeller())
            throw new InvalidUserException("Este usuario no es vendedor");

        List<ListFollowerDto> items = seller.getFollowers().stream()
                .sorted(Comparator.comparing(User::getName).reversed())
                .map(i->new ListFollowerDto(i.getId(),i.getName()))
                .collect(Collectors.toList());

        return new ListFollowerDto(seller.getId(),seller.getName(), items);
    }

    @Override
    public ListFollowerDto getListFollowedAsc(int userId) {
        User user = iRepository.getUserById(userId);
        if(user==null)
            throw new NotFoundUserException("No existe el usuario ingresado");
        List<ListFollowerDto> items = iRepository.followedUser(user)
                .stream().sorted(Comparator.comparing(User::getName))
                .map(u->new ListFollowerDto(u.getId(),u.getName()))
                .collect(Collectors.toList());
        return new ListFollowerDto(user.getId(),user.getName(),items);
    }

    @Override
    public ListFollowerDto getListFollowedDesc(int userId) {
        User user = iRepository.getUserById(userId);
        if(user==null)
            throw new NotFoundUserException("No existe el usuario ingresado");
        List<ListFollowerDto> items = iRepository.followedUser(user)
                .stream().sorted(Comparator.comparing(User::getName).reversed())
                .map(u->new ListFollowerDto(u.getId(),u.getName()))
                .collect(Collectors.toList());
        return new ListFollowerDto(user.getId(),user.getName(),items);
    }

    @Override
    public ListFollowerDto getFollowed(int userId) {
        User user = iRepository.getUserById(userId);
        if(user==null)
            throw new NotFoundUserException("No existe el usuario ingresado");
        List<ListFollowerDto> items = iRepository.followedUser(user)
                .stream().map(u->new ListFollowerDto(u.getId(),u.getName()))
                .collect(Collectors.toList());
        return new ListFollowerDto(user.getId(),user.getName(),items);
    }

    @Override
    public void addPost(NewPostDto dto) {
        User user = iRepository.getUserById(dto.getUserId());
        if(user==null)
            throw new NotFoundUserException("No existe el usuario ingresado");
        DetallePostDto detalle = dto.getDetalle();
        System.out.println(dto.getPostId());
        user.addPost(new Post(dto.getPostId(), LocalDate.parse(dto.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")), detalle.getItemId(),
                detalle.getItemName(), detalle.getType(), dto.getCategoria(), dto.getPrecio()));
    }


}
