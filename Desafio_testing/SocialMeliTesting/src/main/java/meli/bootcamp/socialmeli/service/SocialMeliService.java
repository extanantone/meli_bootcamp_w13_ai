package meli.bootcamp.socialmeli.service;

import meli.bootcamp.socialmeli.dto.*;
import meli.bootcamp.socialmeli.exceptions.OrderTypeNotValidException;
import meli.bootcamp.socialmeli.exceptions.PostAlreadyExistException;
import meli.bootcamp.socialmeli.exceptions.UserExistException;
import meli.bootcamp.socialmeli.exceptions.UserFollowHimselfException;
import meli.bootcamp.socialmeli.mapper.PostMapper;
import meli.bootcamp.socialmeli.mapper.PromoProductMapper;
import meli.bootcamp.socialmeli.mapper.UserMapper;
import meli.bootcamp.socialmeli.model.Post;
import meli.bootcamp.socialmeli.model.PromoPost;
import meli.bootcamp.socialmeli.model.User;
import meli.bootcamp.socialmeli.model.UserFollow;
import meli.bootcamp.socialmeli.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocialMeliService implements ISocialMeliService{
    private final IUserRepository userRepository;

    private final IUSerFollowRepository userFollowRepository;

    private final IPostRepository postRepository;

    @Autowired
    private PromoPostRepository promoPostRepository;

    PostMapper postMapper;

    @Autowired
    private PromoProductMapper promoPostMapper;

    UserMapper userMapper;

    public SocialMeliService(
            UserMapper userMapper,
            IUserRepository userRepository,
            IUSerFollowRepository userFollowRepository,
            IPostRepository postRepository,
            PostMapper postMapper) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.userFollowRepository = userFollowRepository;
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    /**
     * @param userID Usuario seguidor.
     * @param userIDToFollow usuario a seguir.
     * @implNote Busca si los usuario existen dentro del sistema y si no es el mismo usuario
     * a quien va a seguir
     */
    @Override
    public UserFollow followUser(int userID, int userIDToFollow) {
        if (userID == userIDToFollow)
            throw new UserFollowHimselfException();
        User followerUser= userRepository.findUserById(userID);
        User userToFollow= userRepository.findUserById(userIDToFollow);
        return userFollowRepository.newUserFollow(followerUser.getUserId(), userToFollow.getUserId());
    }

    /**
     * @param userID Usuario a consultar
     * @return FollowersCountDTO
     * @implNote Cuenta los usuarios a quien sigue determinada cuenta buscando primero si el usuario existe.
     */
    @Override
    public FollowersCountDTO getFollowersCount(int userID) {
        User queryUser= userRepository.findUserById(userID);
        return new FollowersCountDTO(
            userID,
            userRepository.getUserNameById(queryUser.getUserId()),
            userFollowRepository.listUserFollowersByID(queryUser.getUserId()).size());
    }

    /**
     * @param newPost Post a agregar.
     * @implNote Agrega un post con los datos de su respectivo producto al sistema.
     */
    @Override
    public void addPost(ProductsPostDTO newPost) {
        userRepository.findUserById(newPost.getUserId());
        if (postRepository.findPostById(newPost.getIdPost()).isEmpty())
            postRepository.addPost(postMapper.productoPostDTOtoPost(newPost));
        else
            throw new PostAlreadyExistException();
    }

    /**
     * @param user_id Usuario a consultar
     * @param order En caso de estar ordenado, recive el tipo de orden (ascendente
     *              o descendente por fecha).
     * @return ProductsUserIDListDTO
     * @implNote Llama a la función de obtener la lista de productos y entrega el DTO.
     */
    @Override
    public ProductsUserIDListDTO listSortedPostByUserID(int user_id, String order){
        if (!order.equals("noOrder") && !order.equals("date_asc") && !order.equals("date_desc"))
            throw new OrderTypeNotValidException();
        else{
            boolean isOrder = !order.equals("noOrder");
            User queryUser = userRepository.findUserById(user_id);
            return new ProductsUserIDListDTO(
                    queryUser.getUserId(),
                    this.getSpecificDateList(order, queryUser.getUserId(), isOrder)
            );
        }
    }

    /**
     * @param userID Usuario seguidor.
     * @param userIDToFollow Usuario a dejar de seguir.
     * @implNote Busca si los usuarios existen, luego si este sigue al otro, y luego borra la relacion de
     * seguimiento del sistema.
     */
    @Override
    public boolean unfollowUser(int userID, int userIDToFollow) {
        User followerUser= userRepository.findUserById(userID);
        User userToFollow= userRepository.findUserById(userIDToFollow);
        if (userFollowRepository.checkUserFollow(followerUser.getUserId(), userToFollow.getUserId())) {
            userFollowRepository.unfollowUser(followerUser.getUserId(), userToFollow.getUserId());
            return true;
        }
        else
            return false;
    }

    /**
     * @param userID Id de usuario seguidor
     * @param userIDFollowed ID de usuario seguido
     */
    @Override
    public boolean checkUserFollow(int userID, int userIDFollowed) {
        return userFollowRepository.checkUserFollow(userID, userIDFollowed);
    }

    /**
     *
     * @param userID Usuario a consultar.
     * @param searchFollowers Devuelve un true si esta buscando los seguidores de un usuario, y
     *                        un false en caso tal de buscar las cuentas a las cuales sigue.
     * @param order En caso de estar ordenado, ordenar ascendente o descendentemente por nombre de
     *              usuario.
     * @param sortedResponse Devuelve un true si debe ordenar las respuestas.
     * @return FollowersListDTO
     * @implNote Funcion que reutiliza el codigo para entregar las respuestas de diferentes endpoints.
     * Tiene como objetivo devolver la lista de usuarios que siguen a una cuenta, o a quienes esta sigue.
     *
     */
    @Override
    public Object getOrderedFollowersList(int userID, boolean searchFollowers, String order, boolean sortedResponse) {
        if (sortedResponse && ((!order.equals("name_asc")) && (!order.equals("name_desc"))))
            throw new OrderTypeNotValidException();
        else {
            User queryUser = userRepository.findUserById(userID);
            if (searchFollowers)
                return new FollowersListDTO(
                        queryUser.getUserId(),
                        userRepository.getUserNameById(queryUser.getUserId()),
                        (sortedResponse)
                                ? this.getSpecificUserNameList(searchFollowers, queryUser.getUserId()).stream()
                                .sorted((order.equals("name_desc"))
                                        ? Comparator.comparing(UserDTO::getUserName).reversed()
                                        : Comparator.comparing(UserDTO::getUserName)) //Preguntar si es username o nombre_apellido
                                .collect(Collectors.toList())
                                : this.getSpecificUserNameList(searchFollowers, queryUser.getUserId())
                );
            else
                return new FollowedListDTO(
                        queryUser.getUserId(),
                        userRepository.getUserNameById(queryUser.getUserId()),
                        (sortedResponse)
                                ? this.getSpecificUserNameList(searchFollowers, queryUser.getUserId()).stream()
                                .sorted((order.equals("name_desc"))
                                        ? Comparator.comparing(UserDTO::getUserName).reversed()
                                        : Comparator.comparing(UserDTO::getUserName)) //Preguntar si es username o nombre_apellido
                                .collect(Collectors.toList())
                                : this.getSpecificUserNameList(searchFollowers, queryUser.getUserId())
                );
        }
    }

    /**
     *
     * @param productsPromoPostDTO Recibe el Promo Post a agregar.
     * @implNote Agrega un nuevo promo post al sistema.
     */
    @Override
    public void newPromoPost(ProductsPromoPostDTO productsPromoPostDTO) {
        userRepository.findUserById(productsPromoPostDTO.getUserId());
        if (promoPostRepository.findPromoPostById(productsPromoPostDTO.getIdPost()).isEmpty())
            promoPostRepository.addPromoPost(promoPostMapper.productoPromoPostDTOtoPromoPost(productsPromoPostDTO));
        else
            throw new PostAlreadyExistException();
    }

    /**
     * @param userID ID de usuario a consultar.
     * @return PromoPostCountDTO
     * @implNote Cuenta cuantos promo post tiene el usuario en el sistema.
     */
    @Override
    public PromoPostCountDTO countPromoPost(int userID) {
        User queryUser= userRepository.findUserById(userID);
        return new PromoPostCountDTO(
                userID,
                userRepository.getUserNameById(userID),
                (int) promoPostRepository.getAllList().stream()
                    .filter(post -> post.getUserId() == queryUser.getUserId()).count()
        );
    }

    /**
     * @param userID ID de usuario a consultar.
     * @return PromoPostDTO
     * @implNote Lista todos los promo post que un usuario ha publicado.
     */
    @Override
    public PromoPostDTO listPromoPostByUSer(int userID) {
        User queryUser= userRepository.findUserById(userID);
        return new PromoPostDTO(
                userID,
                userRepository.getUserNameById(queryUser.getUserId()),
                promoPostRepository.getAllList().stream()
                        .filter(promoPost -> promoPost.getUserId() == userID)
                        .map(promoPost -> promoPostMapper.promoPostToPromoPostDTO(promoPost))
                        .collect(Collectors.toList())
        );
    }

    /**
     * @return List Obtiene las listas de seguimiento, post y promo post
     */
    @Override
    public List<UserFollow> lista(){ return userFollowRepository.getAllList(); }

    @Override
    public List<Post> listaPost(){ return postRepository.getAllList(); }

    @Override
    public List<PromoPost> listaPromoPost(){ return promoPostRepository.getAllList(); }

    /**
     * @param searchFollowers ¿Busca seguidores o cuentas que sigue?
     * @param userID ID del usuario a consultar.
     * @return List<UserDTO>
     * @implNote Filtra si existe o no el usuario, luego busca dentro de la lista de conexiones de seguimiento el usuario por su ID.
     * Luego, obtiene sus seguidores o cuentas seguidas y las prepara para mapear.
     * Durante el mapeo, busca los usuarios por su ID (obtenidos del paso anterior) y los ordena
     * por su username. El filtro funciona si estoy buscando mis seguidores, tengo que listar los usuarios que me siguen
     * y luego obtener sus datos. Si no, busca los usuarios a quein sigo y obtiene sus datos para mostrarlos
     * en el response DTO.
     */
    public List<UserDTO> getSpecificUserNameList(boolean searchFollowers, int userID){
        User queryUser= userRepository.findUserById(userID);
        List<UserDTO> newList= userFollowRepository.getAllList().stream()
                .filter(userFollow ->
                        (searchFollowers)
                                ?userFollow.getFollowedUser() == queryUser.getUserId()
                                :userFollow.getUserFollower() == queryUser.getUserId())
                .map(nUserDTO -> new UserDTO(
                        (searchFollowers)
                                ?nUserDTO.getUserFollower()
                                :nUserDTO.getFollowedUser(),
                        (searchFollowers)
                                ?userRepository.getUserNameById(nUserDTO.getUserFollower())
                                :userRepository.getUserNameById(nUserDTO.getFollowedUser())
                                        ))
                .collect(Collectors.toList());

        return newList;
    }

    /**
     * @param order Obtiene el tipo de orden que quiere hacer el usuario.
     * @param userID ID del usuario a consultar.
     * @param isOrder ¿Desea que este ordenado o no?
     * @return List
     * @implNote Filtra si el usuario a consultar existe. En caso de que si, busca dentro del repositorio de posts todos
     * los post de las cuentas a quien sigue el usuario a consultar. Posteriormente limita los post de las ultimas dos
     * semanas, en caso tal de querer orden, organiza los post del response por fecha (ascendente -mas reciente primero-
     * y descendente -mas antigua primero-. En caso tal de que no se quiera ordenar, organiza los post por el id.
     * Por ultimo mapea los post para el DTO de respuesta.
     */
    public List<ProductsPostByUserDTO> getSpecificDateList(String order, int userID, boolean isOrder){
        User queryUser= userRepository.findUserById(userID);
        return postRepository.getAllList().stream()
                .filter(post ->
                        (userFollowRepository.getAllList().stream()
                                .filter(userFollow -> userFollow.getUserFollower() == queryUser.getUserId())
                                .map(UserFollow::getFollowedUser)
                                .collect(Collectors.toList())).contains(post.getUserId())
                )
                .filter(post -> (LocalDate.now().minusWeeks(2).compareTo(post.getDate()) < 0))
                .sorted((isOrder)?((order.equals("date_desc"))
                        ?Comparator.comparing(Post::getDate).reversed()
                        :Comparator.comparing(Post::getDate)):(Comparator.comparing(Post::getPostId))
                )
                .map(post -> postMapper.postToProductsPostByUserDTO(post))
                .collect(Collectors.toList()
                );
    }

    @Override
    public void addUser(NewUserDTO newUserDTO) {
        if (userRepository.userExist(newUserDTO.getUserId()))
            throw new UserExistException();
        else
            userRepository.addUser(userMapper.newUserDTOtoUser(newUserDTO));
            //userRepository.addUser(newUserDTO);
    }

    @Override
    public NewUserDTO findUserById(int userId) {
        return userMapper.userToNewUserDTO(
                userRepository.findUserById(userId)
        );
    }
}
