# Desafio Spring Readme =)

## Antes de comenzar

  - Se dejan creados 4 users:
    + Customer: (Id : 1, Name: "Customer a")
    + Customer: (Id : 2, Name: "Customer b")
    + Seller:   (Id : 3, Name: "Seller a")
    + Seller:   (Id : 4, Name: "Seller b") 
                                                         
  - No hay ninguna publicacion creada

  - No hay ningún seguidor, ni seguido.

  - Pueden cargarse nuevos users realizando un `POST` al endpoint `localhost:8080/user/newUser` con la siguiente data
  
      `{
        "user_id" : 50,
        "user_name" : "new_user",
        "seller" : true
      }`
  
     Si en vez de un vendedor se requiere un comprador puede enviarse el parámetro `seller: false`

## Pruebas
Se comparte el link de Postman con el que fueron realizados los tests: `https://go.postman.co/workspace/My-Workspace~fd5a518b-bbbe-43dc-8eb1-5d75776bf417/collection/18145130-9590e9d8-2a54-4c9a-9e50-9787fa17cd0a`

## Consideraciones

### Modelos

Se ha planteado el siguiente esquema:

- Un modelo de tipo comprador (Customer) y otro de tipo vendedor (Seller) que heredan de la clase abstracta User
- Además un modelo de tipo publicación (Post) que contiene un modelo de tipo Producto (Product)
- Las relacion entre compradores y vendedores se considera ManyToMany de forma que cada modelo posee un array de enteros 
con sus respectivos seguidores o seguidos.
- La relacion vendedor publicacion se consideró OneToMany, de esta forma el vendedor posee un array con ids de sus post
y el post solo un entero con el id de su creador

### Excepciones

Las excepciones se han trabajado con un GlobalHandlerException que en todos los casos implementa un Exception DTO con un mensaje.
Se han realizado las siguientes excepciones:
- AlreadtFollowedException (Al intentar seguir a un usuario ya seguido)
- NotFollowedException (Al intentar dar unfollow a un usuario no seguido)
- RepeatedIdException (Al intentar crear un nuevo Post o User con una ID ya utilizada)
- WrongIdException (Al utilizar ids incorrectas, como por ejemplo intentar seguir a un usuario que no existe)

### DTOS
Por comodidad se han dividido en dos grupos Resquest y Response. Dentro de Response a su vez existen los subgrupos List y Count,
que contienen respectivamente las listas y las cuentas. Todos los DTOS que resquieren userName y userId heredan del DTO UserDTO.

### Mapper
El mapper ha sido realizado sin dependencias e implementado en todos los casos por la capa de Service.

### Service
En todos los casos es la única capa en comunicarse con la capa de Repository, Al igual que Mapper y Repository contiene una
Interfaz donde se declaran sus métodos.

### Repository
El repository carga los datos iniciales con el metodo loadData() llamado desde el constructor. Se han creado 3 hashMaps
para almacenar datos. Uno para Sellers, otro para Customers y otro para Posts, utilizando sus ids como keys.

### Bonus
El bonus fue realizado de forma que no altere las respuestas de las historias de usuarios anteriores. Se modificó el modelo
de Post añadiendo las dos variables necesarias y con el mapper se filtraron a la hora de llevarlas al DTO. Se utilizo el mismo
DTO con la instruccion `@JsonInclude(JsonInclude.Include.NON_NULL)`. Los PromoPost se mostraran el la lista de post de la US006,
con el atributto `hasPromo : true` para indicar que pertenecen a la promocion.

## Por mejorar
  - Implementación de la dependencia ModelMapper para realizar los mapeos
