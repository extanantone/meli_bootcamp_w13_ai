package com.Sprint1.SocialMeli.Service;

import com.Sprint1.SocialMeli.DTO.*;
import com.Sprint1.SocialMeli.Exceptions.BadRequestExcepcion;
import com.Sprint1.SocialMeli.Exceptions.UserNotFoundException;
import com.Sprint1.SocialMeli.Model.Post;
import com.Sprint1.SocialMeli.Model.User;
import com.Sprint1.SocialMeli.Repository.IPostRepository;
import com.Sprint1.SocialMeli.Repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class PostServiceImpl implements IPostService{
    IPostRepository postRepository;
    IUserRepository userRepository;

    public PostServiceImpl(IPostRepository postRepository, IUserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }
    @Override
    public Boolean crearPublicacion(PostShortDTO publicacion) {
        this.validaExisteUsuario(publicacion.getUserId());
        this.validaYaExistePostConId(publicacion.getIdPost());
        this.validaPublicacionDeUsuarioVendedor(publicacion.getUserId());

        Post nuevaPublicacion = new Post(publicacion);

        return postRepository.crearPublicacion(nuevaPublicacion);
    }

    @Override
    public PostListDTO obtenerListadoPostsDeVendedor(int userId, String order) {
        this.validaExisteUsuario(userId);

        List<Post> listaPosts = new ArrayList<Post>();
        User usuario = userRepository.obtenerUsuario(userId);
        PostListDTO postListResultado = new PostListDTO(userId);

        for (UserShortDTO vendedor : usuario.getFolloweds()) {
            listaPosts.addAll(postRepository.obtenerPostsPorVendedor(vendedor.getUserId()));
        }

        List<PostShortDTO> listaPostShortFiltrada = listaPosts.stream()
                .filter(post -> DAYS.between(post.getDate(), LocalDate.now()) < 15)
                .sorted(Comparator.comparing(Post::getDate))
                .map(post -> new PostShortDTO(post))
                .collect(Collectors.toList());

        if (order != null && !order.isEmpty()){
            if (order.equals("date_desc")) {
                listaPostShortFiltrada = listaPostShortFiltrada.stream()
                        .sorted(Comparator.comparing(PostShortDTO::getDate).reversed())
                        .collect(Collectors.toList());
            }
        }

        postListResultado.setPosts(listaPostShortFiltrada);

        return postListResultado;
    }

    @Override
    public Boolean crearPostPromocion(PostFullDTO publicacionFull) {
        this.validaExisteUsuario(publicacionFull.getUserId());
        this.validaYaExistePostConId(publicacionFull.getIdPost());
        this.validaPublicacionDeUsuarioVendedor(publicacionFull.getUserId());
        this.validaEsPostPromo(publicacionFull);

        Post nuevaPublicacion = new Post(publicacionFull);

        return postRepository.crearPublicacionPromocion(nuevaPublicacion);
    }

    @Override
    public PromoPostCountDTO obtenerCantPromoPost(int vendedorId) {
        this.validaExisteUsuario(vendedorId);
        this.validaEsVendedor(vendedorId);

        User usuario = userRepository.obtenerUsuario(vendedorId);
        int cantPromoPost = postRepository.obtenerCantPromoPost(vendedorId);

        PromoPostCountDTO promoPostCount = new PromoPostCountDTO(usuario);
        promoPostCount.setPromoProductsCount(cantPromoPost);

        return promoPostCount;
    }

    @Override
    public PromoPostListDTO obtenerListPromoPost(int vendedorId, String order) {
        this.validaExisteUsuario(vendedorId);
        this.validaEsVendedor(vendedorId);

        User usuario = userRepository.obtenerUsuario(vendedorId);
        List<PostFullDTO> listaPosts = postRepository.obtenerListPromoPost(vendedorId);

        if (order != null && !order.isEmpty()){
            if (order.equals("product_name_asc")) {
                listaPosts = listaPosts.stream()
                        .sorted(Comparator.comparing(p -> p.getDetail().getProductName()))
                        .collect(Collectors.toList());
            }
            else if (order.equals("product_name_asc")) {
                listaPosts = listaPosts.stream()
                        .sorted(Comparator.comparing(p -> p.getDetail().getProductName(), Comparator.reverseOrder()))
                        .collect(Collectors.toList());
            }
        }

        PromoPostListDTO promoPostList = new PromoPostListDTO(usuario);
        promoPostList.setPosts(listaPosts);

        return promoPostList;
    }

    //VALIDACIONES:
    private void validaExisteUsuario(int userId){
        if (!userRepository.existeUsuario(userId)){
            throw new UserNotFoundException("No se encontró el usuario con ID: " + userId);
        }
    }

    private void validaYaExistePostConId(int postId){
        if (postRepository.existePost(postId)){
            throw new BadRequestExcepcion("Ya existe un post con el ID: " + postId);
        }
    }

    private void validaPublicacionDeUsuarioVendedor(int userId){
        if (!userRepository.obtenerUsuario(userId).getIsSeller()){
            throw new BadRequestExcepcion("Para realizar una publicación, el usuario debe ser un usuario vendedor");
        }
    }

    private void validaEsPostPromo(PostFullDTO postF){
        if (postF.getHasPromo() == null || postF.getDiscount() == null){
            throw new BadRequestExcepcion("Para una publicación de promoción, debe indicar atributos 'has_promo' y 'discount'");
        }
    }

    private void validaEsVendedor(int userId){
        if (!userRepository.obtenerUsuario(userId).getIsSeller()){
            throw new BadRequestExcepcion("El usuario " + userId + " no es un usuario vendedor");
        }
    }
}
