# Desafio Spring
Sprint 1 del desafio de spring - Bootcamp JAVA

## Descripcion
El objetivo de este desafío es aplicar los contenidos dados hasta el momento durante el BOOTCAMP MeLi (Git, Java y Spring), con la finalidad de poder implementar una API REST a partir de un enunciado propuesto, una especificación de requisitos y documentación anexada.

### Escenario
Mercado Libre sigue creciendo y para el año que viene  tiene como objetivo empezar a implementar una serie de herramientas que permitan a los compradores y vendedores tener una experiencia totalmente innovadora, en donde el lazo que los una sea mucho más cercano.
La fecha de lanzamiento se aproxima, por lo cual es necesaria la presentación de una versión Beta de lo que va a ser conocido como “SocialMeli”, en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.

## Indice
<a href="#US001">#US001</a><br>
<a href="#US002">#US002</a><br>
<a href="#US003">#US003</a><br>
<a href="#US004">#US004</a><br>
<a href="#US005">#US005</a><br>
<a href="#US006">#US006</a><br>
<a href="#US007">#US007</a><br>
<a href="#US008">#US008</a><br>
<a href="#US009">#US009</a><br>
<a href="#US010">#US010</a><br>
<a href="#US011">#US011</a><br>
<a href="#US012">#US012</a><br>


## Endpoints
### <a id="US001">US001</a>
Poder realizar la acción de "Follow" (seguir) a un determinado vendedor

```
(POST)
/users/{user_id}/follow/{user_id_to_follow}
```
| Parametros        | Tipo           | Descripcion  |
| ------------- |:-------------:| -----:|
| user_id      | int | Número que identifica al usuario actual |
| user_id_to_follow      | int      |   Número que identifica al usuario a seguir |

---

Request
```
http://localhost:8080/users/3/follow/1
```
Response
```JSON
STATUS 200 OK
{
  "message": "Todo Ok"
}
```
---

Request
```
http://localhost:8080/users/1/follow/3
```
Response
```JSON
STATUS 400 BAD REQUEST
{
  "message": "Vendedor no encontrado"
}
```
---
Request
```
http://localhost:8080/users/99/follow/1
```
Response
```JSON
STATUS 400 BAD REQUEST
{
  "message": "Usuario no encontrado"
}
```
---
### <a id="US002">US002</a>
Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
```
(GET)
/users/{user_id}/followers/count
```
| Parametros        | Tipo           | Descripcion  |
| ------------- |:-------------:| -----:|
| user_id      | int | Número que identifica al usuario actual |

---
Request
```
http://localhost:8080/users/1/followers/count/
```
Response
```JSON
STATUS 200 OK
{
  "user_id": 1,
  "user_name": "Seller1",
  "followers_count": 2
}
```
---
Request
```
http://localhost:8080/users/3/followers/count/
```
Response
```JSON
STATUS 404 NOT FOUND
{
  "message": "Vendedor no encontrado"
}
```
---
### <a id="US003">US003</a> y <a id="US008">US008</a>
Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?) permitiendo ordenamiento alfabetico ascendente y descendente por nombre de usuario
```
(GET)
/users/{user_id}/followers/list
```
| Parametros        | Tipo           | Descripcion  |
| ------------- |:-------------:| -----:|
| user_id      | int | Número que identifica al usuario actual |
| order      | String | Indica el ordenamiento por nombre de usuario |

---
Request
```
http://localhost:8080/users/1/followers/list?order=name_asc
```
Response
```JSON
STATUS 200 OK
{
  "user_id": 1,
  "user_name": "Seller1",
  "followers": [
    {
      "user_id": 3,
      "user_name": "Buyer1"
    },
    {
      "user_id": 4,
      "user_name": "Buyer2"
    }
  ]
}
```
---
Request
```
http://localhost:8080/users/1/followers/list?order=name_desc
```
Response
```JSON
STATUS 200 OK
{
  "user_id": 1,
  "user_name": "Seller1",
  "followers": [
    {
      "user_id": 4,
      "user_name": "Buyer2"
    },
    {
      "user_id": 3,
      "user_name": "Buyer1"
    }
  ]
}
```
---
Request
```
http://localhost:8080/users/99/followers/list?order=name_desc
```
Response
```JSON
STATUS 404 NOT FOUND
{
  "message": "Vendedor no encontrado"
}
```
---
Request
```
http://localhost:8080/users/1/followers/list?order=nombre
```
Response
```JSON
STATUS 400 BAD REQUEST
{
  "message": "Formato de orden incorrecto"
}
```
---
### <a id="US004">US004</a>
Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
```
(GET)
/users/{user_id}/followed/list
```
| Parametros        | Tipo           | Descripcion  |
| ------------- |:-------------:| -----:|
| user_id      | int | Número que identifica al usuario actual |

---
Request
```
http://localhost:8080/users/3/followed/list
```
Response
```JSON
STATUS 200 OK
{
  "user_id": 3,
  "user_name": "Buyer1",
  "followed": [
    {
      "user_id": 1,
      "user_name": "Seller1"
    },
    {
      "user_id": 2,
      "user_name": "Seller2"
    }
  ]
}
```
---
Request
```
http://localhost:8080/users/99/followed/list
```
Response
```JSON
STATUS 404 NOT FOUND
{
  "message": "Usuario no encontrado"
}
```
---
### <a id="US005">US005</a>
Dar de alta una nueva publicación
```
(POST)
/products/post
```

---
Request
```
http://localhost:8080/products/post
```
```JSON
{
  "user_id": 1,
  "id_post": 1,
  "date": "12-11-2021",
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
```
Response
```JSON
STATUS 200 OK
{
  "message": "Publicacion creada correctamente"
}
```
---
Request
```
http://localhost:8080/products/post
```
```JSON
{
  "user_id": 99,
  "id_post": 1,
  "date": "12-11-2021",
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
```
Response
```JSON
STATUS 404 NOT FOUND
{
  "message": "Usuario no encontrado"
}
```
---
Request
```
http://localhost:8080/products/post
```
```JSON
{
  "user_id": 1,
  "id_post": 1,
  "date": "12-11-2021",
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
```
Response
```JSON
STATUS 400 BAD REQUEST
{
  "message": "Publicacion ya creada"
}
```
---
### <a id="US006">US006</a> y <a id="US009">US009</a>
Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero) permitiendo ordenamiento por fecha ascendente y descendente
```
(GET)
/products/{user_id}/list?order=date_asc
```
| Parametros        | Tipo           | Descripcion  |
| ------------- |:-------------:| -----:|
| user_id      | int | Número que identifica al usuario actual |

---
Request
```
http://localhost:8080/products/3/list?order=date_asc
```
Response
```JSON
STATUS 200 OK
{
  "user_id": 3,
  "posts": [
    {
      "id_post": 6,
      "date": "10-11-2021",
      "detail": {
        "product_id": 1,
        "product_name": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
      },
      "category": 100,
      "price": 1500.5
    },
    {
      "id_post": 4,
      "date": "12-11-2021",
      "detail": {
        "product_id": 1,
        "product_name": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
      },
      "category": 100,
      "price": 1500.5
    }
  ]
}
```
---
Request
```
http://localhost:8080/products/99/list?order=date_asc
```
Response
```JSON
STATUS 404 NOT FOUND
{
  "message": "Usuario no encontrado"
}
```
---
Request
```
http://localhost:8080/products/3/list?order=fecha
```
Response
```JSON
STATUS 404 NOT FOUND
{
  "message": "Formato de orden incorrecto"
}
```
---
### <a id="US007">US007</a>
Poder realizar la acción de "Unfollow" (dejar de seguir) a un determinado vendedor.
```
(POST)
/users/{user_id}/unfollow/{user_id_to_unfollow}
```
| Parametros        | Tipo           | Descripcion  |
| ------------- |:-------------:| -----:|
| user_id      | int | Número que identifica al usuario actual |
| user_id_to_unfollow      | int | Número que identifica al usuario a dejar de seguir |

---
Request
```
http://localhost:8080/users/3/unfollow/1
```
Response
```JSON
STATUS 200 OK
{
  "message": "Todo Ok",
}
```
---
Request
```
http://localhost:8080/users/3/unfollow/4
```
Response
```JSON
STATUS 404 NOT FOUND
{
  "message": "Vendedor no encontrado"
}
```
---
Request
```
http://localhost:8080/users/99/unfollow/1
```
Response
```JSON
STATUS 404 NOT FOUND
{
  "message": "Usuario no encontrado"
}
```
---
# Extra Bonus

### <a id="US010">US010</a>
Llevar a cabo la publicación de un nuevo producto en promoción
```
(POST)
/products/promo-post
```

---
Request
```
http://localhost:8080/products/promo-post
```
```JSON
{
  "user_id": 1,
  "id_post": 7,
  "date": "12-11-2021",
  "detail": {
    "product_id": 1,
    "product_name": "Silla Gamer",
    "type": "Gamer",
    "brand": "Racer",
    "color": "Red & Black",
    "notes": "Special Edition"
  },
  "category": 100,
  "price": 1500.50,
  "has_promo": true,
  "discount": 0.1
}
```
Response
```JSON
STATUS 200 OK
{
  "message": "Publicacion creada correctamente"
}
```
---
Request
```
http://localhost:8080/products/post
```
```JSON
{
  "user_id": 99,
  "id_post": 8,
  "date": "12-11-2021",
  "detail": {
    "product_id": 1,
    "product_name": "Silla Gamer",
    "type": "Gamer",
    "brand": "Racer",
    "color": "Red & Black",
    "notes": "Special Edition"
  },
  "category": 100,
  "price": 1500.50,
  "has_promo": true,
  "discount": 0.1
}
```
Response
```JSON
STATUS 404 NOT FOUND
{
  "message": "Usuario no encontrado"
}
```
---
Request
```
http://localhost:8080/products/post
```
```JSON
{
  "user_id": 1,
  "id_post": 7,
  "date": "12-11-2021",
  "detail": {
    "product_id": 1,
    "product_name": "Silla Gamer",
    "type": "Gamer",
    "brand": "Racer",
    "color": "Red & Black",
    "notes": "Special Edition"
  },
  "category": 100,
  "price": 1500.50,
  "has_promo": true,
  "discount": 0.1
}
```
Response
```JSON
STATUS 400 BAD REQUEST
{
  "message": "Publicacion ya creada"
}
```
---
### <a id="US011">US011</a>
Obtener la cantidad de productos en promoción de un determinado vendedor
```
(GET)
/products/{user_id}/promo-post/count
```
| Parametros        | Tipo           | Descripcion  |
| ------------- |:-------------:| -----:|
| user_id      | int | Número que identifica al usuario actual |

---
Request
```
http://localhost:8080/products/1/promo-post/count
```
Response
```JSON
STATUS 200 OK
{
  "user_id": 1,
  "user_name": "Seller1",
  "promo_products_count": 2
}
```
---
Request
```
http://localhost:8080/products/4/promo-post/count
```
Response
```JSON
STATUS 404 NOT FOUND
{
  "message": "Vendedor no encontrado"
}
```
---

### <a id="US012">US012</a>
Obtener un listado de todos los productos en promoción de un determinado vendedor
```
(GET)
/products/{user_id}/list
```
| Parametros        | Tipo           | Descripcion  |
| ------------- |:-------------:| -----:|
| user_id      | int | Número que identifica al usuario actual |

---
Request
```
http://localhost:8080/products/3/list
```
Response
```JSON
STATUS 200 OK
{
  "user_id": 1,
  "posts": [
    {
      "id_post": 1,
      "date": "12-11-2021",
      "detail": {
        "product_id": 1,
        "product_name": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
      },
      "category": 100,
      "price": 1500.5,
      "has_promo": true,
      "discount": 0.1
    },
    {
      "id_post": 2,
      "date": "10-11-2021",
      "detail": {
        "product_id": 1,
        "product_name": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
      },
      "category": 100,
      "price": 1500.5,
      "has_promo": true,
      "discount": 0.1
    }
  ]
}
```
---
Request
```
http://localhost:8080/products/99/list
```
Response
```JSON
STATUS 404 NOT FOUND
{
  "message": "Usuario no encontrado"
}
```
---