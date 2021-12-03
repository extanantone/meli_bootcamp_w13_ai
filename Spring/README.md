# Spring challenge - Social MELI

Decidí estrucutar mi proyecto de la siguiente manera:

1. controller
    - ProductController
    - UserController

2. dto
    - PostDoneDTO
    - PostDTO
    - PostResponseDTO
    - ProductDTO
    - UserCountFollowersDTO
    - UserDTO
    - UserFollowedDTO
    - UserFollowersDTO
    - UserCountFollowersDTO

3. exception
    - DuplicatesFoundException
    - NotValidParamException
    - UserIdNotFoundException
  
4. model
    - Post
    - Product
    - User
  
5. repository
    - ProductRepository (interface)
    - ProductRepositoryImpl
    - UserRepository (interface)
    - UserRepositoryImpl

6. service
    - ProductService (interface)
    - ProductServiceImpl
    - UserService  (interface)
    - UserServiceImpl 
