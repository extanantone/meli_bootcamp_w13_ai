# SocialMeli 🫂

SocialMeli es una API que permite a los usuarios seguirse entre sí, y publicar productos, con la finalidad de poder observar las nuevas publicaciones de las personas a las cuales seguimos.

## Requisitos

 1. Java 11
 2. Maven 

## Usuarios creados 👨
Al iniciar la aplicación, se cargan los archivos de User.json

|Id| Nombre |
|--|--|
| 1 | Acomprador  |
| 2 | Bcomprador  |
| 3 | CVendedor  |
| 4 | DVendedor  |
  
## Endpoints implementados 📖

| Metodo |Ruta| Descripcion  |
|--|--|--|
| POST | [/users/{userId}/unfollow/{userIdToUnfollow}](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/user-controller/unfollow) | Permite dejar de seguir a un usuario | 
|POST |[/users/{userId}/follow/{userIdToFollow}](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/user-controller/follow) | Permite seguir a un usuario |
| GET | [/users/{userId}/followers/list](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/user-controller/followers) | Permite obtener una lista de seguidores |
| GET | [/users/{userId}/followers/count](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/user-controller/countFollowers) | Permite contar la cantidad de seguidores de un usuario |
| GET | [/users/{userId}/followed/list](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/user-controller/followed) | Permite obtener una lista de las persona a quien sigue el usuario |
| POST | [/products/promo-post](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/post-controller/createPromoPost) | Permite crear un producto en promoción |
| POST | [/products/post](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/post-controller/createPost) | Permite crear un producto normal |
| GET | [/products/{userId}/promo-post/count](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/post-controller/promoPostcount) | Permite contar la cantidad de productos en promoción de un Usuario |
| GET | [/products/{userId}/list](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/post-controller/promoPostList) | Lista todos los productos en promoción de un vendedor |
|GET |[/products/followed/{userId}/list](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/post-controller/recentFollowedProducts) | Muestra la lista de productos de los usuarios que seguimos
| GET | [/products/{userId}/post/list](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/post-controller/postList) |  Muestra la lista de productos de un usuario (*Bonus*) |

### Response

La API retorna dos posibles estados

|Caso| Estado | Respuesta |
|--|--|--|
| Éxito | HTTP 200 | Depende del endpoint asignado
| Fallo | HTTP 400 | Acción no valida

Para ver la documentación completa de los EndPoints se puede acceder a la URL

[Swagger Doc](http://localhost:8080/swagger-ui.html) después de encender el servidor


## Reglas de SocialMeli

 1. Un usuario no puede seguirse a si mismo o a alguien que ya sigue.
 2. Un usuario no puede dejar de seguir a alguien que no sigue.
 3. No se pueden publicar posts de usuarios que no existen.
 4. No se pueden repetir los ids de los posts, se encuentre o no en promoción.
 5. Se pueden repetir los ids de los productos.
 6. Cualquier usuario puede publicar posts.

## Testing

Se han agregado

Validaciones
Test unitarios
Test de integración

### En las validaciones se ha considerado:
- los String no deben contener caracteres especiales -> sólo se permiten (letras del alfabeto inglés, numeros o guion bajo)
- los Ids deben ser mayores a 0
- Todos los datos deben estar presentes a excepción de las notas de los productos
- El precio máximo de un producto es de 10.000.000$

### ToDo 

[] Pasar la responsabilidad de la generación de Ids a una clase nueva
[] Refactorizar la cantidad de DTOs

## Creditos

[David Alexander Orejuela Caicedo](https://github.com/daorejuela1)
