# Spring challenge - Social MELI

Decidí estrucutar mi proyecto de la siguiente manera:

1. controller
    - ProductController => relacionado con solicitudes respecto a los productos.
    - UserController => relacionado con solicitudes respecto a los usuarios.

2. dto
    - PostDoneDTO => Todas la publicaciones hechas por un user.
    - PostDTO => el DTO que recibo como body en el post.Considerar que el campo date se toma como String.
      Luego lo paso a tipo Post (donde date es de tipo Date)
    - PostResponseDTO => post para retornar donde ya date es de tipo LocalDate.
    - ProductDTO
    - UserCountFollowersDTO => sirve como response cuando solicita la cantidad de seguidores.
    - UserDTO
    - UserFollowedDTO => sirve como response cuando solicita visualizar los seguidores.
    - UserFollowersDTO => sirve como response cuando solicita visualizar los seguidos.

3. exception
    - DuplicatesFoundException => si existe una publicación con el mismo id.
    - NotValidParamException => parámetro inválido de ordenamiento.
    - UserIdNotFoundException => si no se encuentra el id.
  
4. model
    - Post
    - Product
    - User
  
5. repository
    - ProductRepository (interface)
    
        ```
        void post(Post newPost);

        List<Post> getAllPosts();

        List<Post> getPostsById(int userId);

        List<Post> getPostListFrom2WeeksAgoAsc(int userId);

        List<Post> getPostListFrom2WeeksAgoDesc(int userId);

        ```
    - ProductRepositoryImpl
    
    - UserRepository (interface)
        ```
        List<UserDTO> getUsers();

        boolean userExists(int id);
        ```
    - UserRepositoryImpl

6. service
    - ProductService (interface)
        ```    
        List<Post> getPostList();
        List<Post> getPostListById(int userId);
        PostDoneDTO getPostListFrom2WeeksAgo(int userId, String order);

        void post(PostDTO newPost) throws ParseException;
        ```
    - ProductServiceImpl
    
    - UserService  (interface)
        ```
        UserCountFollowersDTO countFollowers (int userId);
        void followUser(int userId,int userIdToFollow);
        void unfollowUser(int userId,int userIdToFollow);
        UserDTO getUserById(int userId);
        List<UserDTO> allUsers();
        UserFollowersDTO getFollowersList(int userId);
        UserFollowersDTO orderByNameFollowers(int userId, String order);

        UserFollowedDTO getFollowedList(int userId);
        UserFollowedDTO orderByNameFollowed(int userId, String order);
        ```
    

    - UserServiceImpl 
