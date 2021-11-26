# SocialMeLi

_Una red social donde podras compartir informacion con otros vendedores, seguir al día sus mejores publicaciones para no perderte de nada nuevo._

## Para empezar 👨🏼‍💻

_Que necesitas para correr el proyecto en local_

1. Descargar el repo desde https://github.com/extanantone/meli_bootcamp_w13_ai.git en la rama [_morales_andres_]
2. Abrir el proyeto con Intellij desde la carpeta src

### Pre-requisitos 📋

```
Para este proyecto se utilizo una herramienta llamada "MapStruct" 
para generar los mapeadores, por lo que ya viene implementada desde
el archivo build.gradle. Seria conveniente instalar el plugin para el
IDE para explotar su potencial.
```

## Comentarios
El codigo se encuentra parcialmente comentado en bloque, para entender el objetivo de las funciones principales que se
ejecutan en el sistema.

## Arquitectura del proyecto

Realizado siguiendo los estandares adoptados por la industria, aplicando buenas practicas, y lo enseñado por los bootcampers
del W13 Java de MeLi. Seguimos la arq. **M**(odel) **V**(iew) **C**(ontroller) y adoptando:

1. Servicios
    + Implementa toda la logica del negocio e instancia el patron IoC y la DI.
2. Repositorios
    + Adopta la logica del CRUD basica para todos los modelos que almacenan los datos
3. Controladores
    + Expone todos los endpoints de interaccion con el usuario.
4. Data Transfer Objects
    + Implementa la manera de como se entregaran las respuestas del servidor en formato JSON.
5. Excepciones
    + Encapsula los casos en los que el sistema se podria romper y los expone al usuario con mensajes entendibles.
6. Mappers
    + Convierte los modelos a DTO dependiendo la informacion que se quiera exponer.

## Modelo de datos

Para detallar más mirá los diagramas en la carpeta de resources del proyecto.
1. Modelo para almacenar los post.
2. Modelo para almacenar los usuarios.
3. Modelo para almacenar los productos de los post.
4. Modelo para almacenar los post con promoción.
5. Modelo para almacenar las conexiones entre usuarios (quien sigue a quien).

## Carga inicial de usuarios

Se implemento un archivo de excel con una lista de 100 nombres y apellidos, la cual genero 2100 usuarios
utilizando formulas para generar nombres y apellidos aleatorios, el username es [NombreApellido{aleatorio entre 0 y 99999}]
y una edad aleatoria entre 0 y 99 (Un bebe recien nacido tambien puede ser usuario de MeLi 👶🏼).

El archivo se llama datausers.json y se carga al momento que se despliega el proyecto.

Para el caso de los post y los promo post, no se manejan productos predeterminados puesto que estos deben ser
agregados por el cliente.

## Ejecutando los endpoints ⚙️

_Puedes abrir postman y ejecutar los endpoints de la siguente manera:_
Nota: Hay un archivo en los recursos llamado _SocialMeli.postman_collection.json_ que se puede importar en postman con
las consultas realizadas.

### US 0001: Poder realizar la acción de "Follow" (seguir) a un determinado vendedor 🔩

Ejecuta el siguiente endpoint:

```
127.0.0.1:8080/users/{user_id}/follow/{user_id_to_follow}
```
```
Response DTO GenericResponseDTO como mensaje informativo.
```

Ejemplo:
+ Request: http://localhost:8080/users/25/follow/12
+ Response 200:{
  "response": {
  "code": "200",
  "response": "Usuario 25 siguiendo a 12"
  }
  }
+ Response:
    + {
      "response_code": "400",
      "message": "El usuario ya sigue a esta cuenta."
      }
    +   {
        "response_code": "404",
        "message": "El usuario no existe dentro del sistema."
        }

### US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor 🔩

Ejecuta el siguiente endpoint:

```
127.0.0.1:8080/users/{user_id}/followers/count
```
```
Response DTO: FollowersCountDTO
```
Ejemplo:
+ Request: http://localhost:8080/users/12/followers/count
+ Response 200: {
  "user_id": 12,
  "user_name": "RocíoSCATTONE91962",
  "followers_count": 1
  }
+ Response: {
  "response_code": "404",
  "message": "El usuario no existe dentro del sistema."
  }

### US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
🔩

Ejecuta el siguiente endpoint:

```
127.0.0.1:8080/users/{user_id}/followers/list
```
```
Response DTO: FollowersListDTO
```
Ejemplo:
+ Request: http://localhost:8080/users/12/followers/list
+ Response 200: {
  "user_id": 12,
  "user_name": "RocíoSCATTONE91962",
  "followers": [
  {
  "userID": 25,
  "userName": "MaríaQuiroga70055"
  }
  ]
  }
+ Response: {
  "response_code": "404",
  "message": "El usuario no existe dentro del sistema."
  }

### US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?) 🔩

Ejecuta el siguiente endpoint:

```
127.0.0.1:8080/users/{user_id}/followed/list
```
```
Response DTO: FollowedListDTO
```
Ejemplo:
+ Request: http://localhost:8080/users/25/followed/list
+ Response 200: {
  "user_id": 25,
  "user_name": "MaríaQuiroga70055",
  "followed": [
  {
  "userID": 12,
  "userName": "RocíoSCATTONE91962"
  }
  ]
  }
+ Response: {
  "response_code": "404",
  "message": "El usuario no existe dentro del sistema."
  }

### US 0005: Dar de alta una nueva publicación🔩

Ejecuta el siguiente endpoint:

```
127.0.0.1:8080/products/post
```
```
Request DTO: ProductsPostDTO (ProductsDTO)
Response DTO: GenericResponseDTO
```
Ejemplo:
+ Request: http://localhost:8080/products/post
    + Payload: {
      "user_id": 12,
      "id_post": 13,
      "date": "13-11-2021",
      "detail": {
      "product_id": 1,
      "product_name": "Silla Gamer",
      "type": "Gamer",
      "brand": "Racer",
      "color": "Red & Black",
      "notes": "Special Edition"
      },
      "category": 100,
      "price": 1500.50
      }

+ Response 200: {
  "response": {
  "code": "200",
  "response": "Post 13 agregado exitosamente"
  }
  }
+ Response:
    + {
      "response_code": "404",
      "message": "El usuario no existe dentro del sistema."
      }
    + {
      "response_code": "404",
      "message": "El post con dicho ID ya existe dentro del sistema. Cree uno nuevo con diferente ID."
      }

### US 0006: Obtener un listado de las publicaciones realizadas por los vendedores.🔩

Ejecuta el siguiente endpoint:

```
127.0.0.1:8080/products/followed/{user_id}/list
```
```
Response DTO: ProductsUserIDListDTO
```
Ejemplo:
+ Request: http://localhost:8080/products/followed/25/list
+ Response 200: {
  "user_id": 25,
  "post": [
  {
  "id_post": 13,
  "date": "2021-11-13",
  "detail": {
  "product_id": 1,
  "product_name": "Silla Gamer",
  "type": "Gamer",
  "brand": "Racer",
  "color": "Red & Black",
  "notes": "Special Edition"
  },
  "category": "100",
  "price": 1500.5
  },
  {
  "id_post": 1312,
  "date": "2021-11-15",
  "detail": {
  "product_id": 1,
  "product_name": "Silla Gamer",
  "type": "Gamer",
  "brand": "Racer",
  "color": "Red & Black",
  "notes": "Special Edition"
  },
  "category": "100",
  "price": 1500.5
  }
  ]
  }
+ Response: {
  "response_code": "404",
  "message": "El usuario no existe dentro del sistema."
  }

### US 0007: Poder realizar la acción de "Unfollow" (dejar de seguir) a un determinado vendedor. 🔩

Ejecuta el siguiente endpoint:

```
127.0.0.1:8080/users/{user_id}/unfollow/{user_id_to_unfollow}
```
```
Response DTO: GenericResponseDTO
```
Ejemplo:
+ Request: http://
+ Response 200
+ Response:

### US 0008: Ordenamiento alfabético ascendente y descendente 🔩

Ejecuta alguno de los siguientes endpoint:

```
127.0.0.1:8080/users/{user_id}/followers/list?order=name_asc
127.0.0.1:8080/users/{user_id}/followers/list?order=name_desc
127.0.0.1:8080/users/{user_id}/followed/list?order=name_asc
127.0.0.1:8080/users/{user_id}/followed/list?order=name_desc
```
```
Response DTO: FollowersListDTO & FollowedListDTO
```
Ejemplo:
+ Request: http://localhost:8080/users/25/followed/list/?order=name_desc
+ Response 200: {
  "user_id": 25,
  "user_name": "MaríaQuiroga70055",
  "followed": [
  {
  "userID": 12,
  "userName": "RocíoSCATTONE91962"
  }
  ]
  }
+ Response: {
  "response_code": "404",
  "message": "El usuario no existe dentro del sistema."
  }

### US 0009: Ordenamiento por fecha ascendente y descendente 🔩

Ejecuta el siguiente endpoint:

```
127.0.0.1:8080/products/followed/{user_id}/list?order=date_asc
127.0.0.1:8080/products/followed/{user_id}/list?order=date_desc
```
```
Response DTO: ProductsUSerIDListDTO
```
Ejemplo:
+ Request: http://localhost:8080/products/followed/25/list?order=name_desc
+ Response 200: {
  "user_id": 25,
  "post": [
  {
  "id_post": 1312,
  "date": "2021-11-15",
  "detail": {
  "product_id": 1,
  "product_name": "Silla Gamer",
  "type": "Gamer",
  "brand": "Racer",
  "color": "Red & Black",
  "notes": "Special Edition"
  },
  "category": "100",
  "price": 1500.5
  },
  {
  "id_post": 13,
  "date": "2021-11-13",
  "detail": {
  "product_id": 1,
  "product_name": "Silla Gamer",
  "type": "Gamer",
  "brand": "Racer",
  "color": "Red & Black",
  "notes": "Special Edition"
  },
  "category": "100",
  "price": 1500.5
  }
  ]
  }
+ Response: {
  "response_code": "404",
  "message": "El usuario no existe dentro del sistema."
  }

### US 0010: Llevar a cabo la publicación de un nuevo producto en promoción 🔩

Ejecuta el siguiente endpoint:

```
127.0.0.1:8080/products/promo-post
```
```
Request DTO: PromoPostByUserDTO
Response DTO: GenericResponseDTO
```
Ejemplo:
+ Request: http://
    + Payload: {
      "user_id": 1569,
      "id_post": 18,
      "date": "29-04-2021",
      "detail": {
      "product_id": 1,
      "product_name": "Silla Gamer",
      "type": "Gamer",
      "brand": "Racer",
      "color": "Red & Black",
      "notes": "Special Edition"
      },
      "category": "100",
      "price": 1500.5,
      "has_promo": true,
      "discount": 0.25
      }
+ Response 200: {
  "response": {
  "code": "200",
  "response": "PromoPost agregado exitosamente"
  }
  }
+ Response:
    + {
      "response_code": "404",
      "message": "El post con dicho ID ya existe dentro del sistema. Cree uno nuevo con diferente ID."
      }
    + {
      "response_code": "404",
      "message": "El usuario no existe dentro del sistema."
      }

### US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor 🔩

Ejecuta el siguiente endpoint:

```
127.0.0.1:8080/products/{user_id}/promo-post/count
```
```
Response DTO: PromoPostCountDTO
```
Ejemplo:
+ Request: http://localhost:8080/products/1569/promo-post/count
+ Response 200: {
  "user_id": 1569,
  "user_name": "AliciaBoga87911",
  "promo_post_count": 1
  }
+ Response: {
  "response_code": "404",
  "message": "El usuario no existe dentro del sistema."
  }

### US 0012: Obtener un listado de todos los productos en promoción de un determinado vendedor 🔩

Ejecuta el siguiente endpoint:

```
127.0.0.1:8080/products/{user_id}/list
```
```
Response DTO: PromoPostDTO
```
Ejemplo:
+ Request: http://localhost:8080/products/1569/list
+ Response 200: {
  "user_id": 1569,
  "user_name": "AliciaBoga87911",
  "post": [
  {
  "id_post": 18,
  "date": "2021-04-29",
  "detail": {
  "product_id": 1,
  "product_name": "Silla Gamer",
  "type": "Gamer",
  "brand": "Racer",
  "color": "Red & Black",
  "notes": "Special Edition"
  },
  "category": "100",
  "price": 1500.5,
  "has_promo": true,
  "discount": 0.25
  }
  ]
  }
+ Response: {
  "response_code": "404",
  "message": "El usuario no existe dentro del sistema."
  }

## Construido con 🛠️

* [MapStruct](http://www.mapstruct.org/) - Plug-in para mapear objectos.
* [Spring Boot](https://start.spring.io/) - Motor del proyecto

## Autor ✒️

* **Andrés Felipe Morales Anaya** - *Todero del proyecto* - [GitHub AnFel024](https://github.com/anfel024)

## Licencia 📄

Este proyecto está bajo la Licencia de (MercadoLibre) y OpenJDK.