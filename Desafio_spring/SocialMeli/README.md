# DESAFIO SPRING
## Objetivo

*El objetivo de este desafío es aplicar los contenidos dados hasta el momento durante el BOOTCAMP MeLi (Git, Java y Spring), con la finalidad de poder implementar una API REST a partir de un enunciado propuesto, una especificación de requisitos y documentación anexada.*

## Escenario
Mercado Libre sigue creciendo y para el año que viene tiene como objetivo empezar a implementar una serie de herramientas que permitan a los compradores y vendedores tener una experiencia totalmente innovadora, en donde el lazo que los una sea mucho más cercano. 

La fecha de lanzamiento se aproxima, por lo cual es necesaria la presentación de una versión Beta de lo que va a ser conocido como “SocialMeli”, en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.
### Consideraciones:
* Los usuarios se encuentran creados por defecto (4 usuarios creados) a fines del desafío.
* Los usuarios no se distinguen entre vendedores y compradores.
* Un usuario puede seguir a cualquier usuario a excepcion de si mismo.
* Cualquier usuario puede postear un producto.
* Un producto que se desee postear es necesario todos los campos completados correctamente, caso contrario no se realizará la operacion.
## Requerimientos técnicos funcionales implementados:


>**US 0001:** Poder realizar la acción de &quot;Follow&quot; (seguir) a un determinado vendedor

| **Method** | **SIGN** |
| --- | --- |
| POST | /users/{user\_id}/follow/{user\_id\_to\_follow} |
**Ejemplo**
```sh
POST /users/1/follow/2
```
*Respuesta exitosa*
```sh
Status code 200
```
*Respuesta fallida*
```sh
Status code 400
{
  code: 400,
  message: "La operacion no se puede realizar: No se encuentra el usuario 2"
}
```

**Filtros/Parámetros:**

| **Parámetros** | **Tipo** | **Descripción/Ejemplo** |
| --- | --- | --- |
| user\_id | int | Número que identifica al usuario actual |
| user\_id\_to\_follow | int | Número que identifica al usuario a seguir |



>**US 0002:** Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor

| **Method** | **SIGN** |
| --- | --- |
| GET | /users/{user\_id}/followers/count |

**Ejemplo**

```sh
/users/3/followers/count/
```
Respuesta exitosa
```sh
Status code 200
{
  user_id: 3,
  user_name: "Carlos",
  followers_count: 2
}
```

**Filtros/Parámetros:**

| **Parámetros** | **Tipo** | **Descripción/Ejemplo** |
| --- | --- | --- |
| user\_id | int | Número que identifica a cada usuario |
| user\_name | String | Nombre de usuario asociado a la user\_id |

>**US 0003:** Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)


| **Method** | **SIGN** |
| --- | --- |
| GET | /users/{user\_id}/followers/list |

**Ejemplo**
```sh
/users/3/followers/list
```
*Respuesta exitosa*
```sh
Status code 200
{
  "user_id": 3,
  "user_name": "Pedro",
  "followers": [
    {
        "user_id": 1,
        "user_name": "Nico"
    }
  ]
}
```


**Filtros/Parámetros:**

| **Parámetros** | **Tipo** | **Descripción/Ejemplo** |
| --- | --- | --- |
| user\_id | int | Número que identifica a cada usuario |
| user\_name | String | Nombre de usuario asociado a la user\_id |

>**US 0004:** Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)

| **Method** | **SIGN** |
| --- | --- |
| GET | /users/{user\_id}/followed/list |

**Ejemplo**
```sh
/users/3/followed/list
```
*Respuesta exitosa*
```sh
Status code 200
{
  "user_id": 1,
  "user_name": "Nico",
  "followed": [
    {
        "user_id": 3,
        "user_name": "Pedro"
    }
  ]
}
```

**Filtros/Parámetros:**

| **Parámetros** | **Tipo** | **Descripción/Ejemplo** |
| --- | --- | --- |
| user\_id | int | Número que identifica a cada usuario |
| user\_name | String | Nombre de usuario asociado a la user\_id |

>**US 0005:** Dar de alta una nueva publicación


| **Method** | **SIGN** |
| --- | --- |
| POST | /products/post |

*Ejemplo*
```sh
/products/post
```
*Respuesta exitosa*
```sh
Status code 200
{
  "user_id": 3,
  "id_post": 18,
  "date": "17-09-2021",
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

*Respuesta falida*
```sh
Status code 400
{
"code": "400",
"message": "La operacion no se puede realizar: Los campos se ingresaron incorrectamente"
}
```


**Filtros/Parámetros:**

| **Parámetros** | **Tipo** | **Descripción/Ejemplo** |
| --- | --- | --- |
| user\_id | int | Número que identifica a cada usuario |
| id\_post | int | Número identificatorio de cada una de las publicaciones |
| date | LocaleDate | Fecha de la publicación en formato dd-MM-yyyy |
| product\_id | int | Número identificatorio de cada uno de los productos asociados a una publicación |
| product\_name | String | Cadena de caracteres que representa el nombre de un producto |
| type | String | Cadena de caracteres que representa el tipo de un producto |
| brand | String | Cadena de caracteres que representa la marca de un producto |
| color | String | Cadena de caracteres que representa el color de un producto |
| notes | String | Cadena de caracteres para colocar notas u observaciones de un producto |
| category | int | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |
| price | double | Precio del producto |

>**US 0006:** Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).

| **Method** | **SIGN** |
| --- | --- |
| GET | /products/followed/{user\_id}/list |

*Ejemplo*
```sh
/products/followed/2/list
```
*Respuesta exitosa*
```sh
Status code 200
{
    "user_id": 1,
    "posts": [
        {
            "id_post": 18,
            "date": "17-09-2021",
            "price": 1500.5,
            "category": 100,
            "detail": {
                "product_id": 1,
                "product_name": "Silla Gamer",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red & Black",
                "notes": "Special Edition"
            }
        },
        {
            "id_post": 28,
            "date": "19-10-2021",
            "price": 1500.5,
            "category": 100,
            "detail": {
                "product_id": 3,
                "product_name": "Teclado Gamer",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red & Black",
                "notes": "Special Edition"
            }
        }
    ]
}
```


**Filtros/Parámetros:**

| **Parámetros** | **Tipo** | **Descripción/Ejemplo** |
| --- | --- | --- |
| user\_id | int | Número que identifica a cada usuario |

>**US 0007:** Poder realizar la acción de &quot;Unfollow&quot; (dejar de seguir) a un determinado vendedor.



| **Method** | **SIGN** |
| --- | --- |
| POST | /users/{user\_id}/unfollow/{user\_id\_to\_unfollow} |


**Ejemplo**
```sh
POST /users/1/unfollow/2
```
*Respuesta exitosa*
```sh
Status code 200
```
*Respuesta fallida*
```sh
Status code 400
{
  code: 400,
  message: "La operacion no se puede realizar: No se encuentra el usuario 2"
}
```

**Filtros/Parámetros:**

| **Parámetros** | **Tipo** | **Descripción/Ejemplo** |
| --- | --- | --- |
| user\_id | int | Número que identifica al usuario actual |
| user\_id\_to\_unfollow | int | Número que identifica al usuario a dejar de seguir |

>**US 0008:** Ordenamiento alfabético ascendente y descendente



| **Method** | **SIGN** |
| --- | --- |
| GET | /users/{user\_id}/followers/list?order={order} |
| GET | /users/{user\_id}/followed/list?order={order} |


| **order** | **Description** |
| --- | --- |
| name\_asc | Alfabético ascendente. |
| name\_desc | Alfabético descendente. |

>**US 0009:** Ordenamiento por fecha ascendente y descendente


| **Method** | **SIGN** |
| --- | --- |
| GET | /products/followed/{user\_id}/list?order={order} |


| **order** | **Description** |
| --- | --- |
| date\_asc | Fecha ascendente (de más antigua a más nueva) |
| date\_desc | Fecha descendente (de más nueva a más antigua) |


## Requerimientos técnicos sin implementación:
**Extra Bonus**

**US 0010:** Llevar a cabo la publicación de un nuevo producto en promoción

**Sign**** :**

| **Method** | **SIGN** |
| --- | --- |
| POST | /products/promo-post |
| **PAYLOAD:** | {&quot;user\_id&quot;: 1569,&quot;id\_post&quot;: 18,&quot;date&quot;: &quot;29-04-2021&quot;,&quot;detail&quot;: {&quot;product\_id&quot;: 1,&quot;product\_name&quot;: &quot;Silla Gamer&quot;,&quot;type&quot;: &quot;Gamer&quot;,&quot;brand&quot;: &quot;Racer&quot;,&quot;color&quot;: &quot;Red &amp; Black&quot;,&quot;notes&quot;: &quot;Special Edition&quot;},&quot;category&quot;: &quot;100&quot;,&quot;price&quot;: 1500.5,&quot;has\_promo&quot;: true,&quot;discount&quot;: 0.25} |
| **Response** | Status Code 200 (OK)Status Code 400 (Bad request) |

**Filtros/Parámetros:**

| **Parámetros** | **Tipo** | **Descripción/Ejemplo** |
| --- | --- | --- |
| user\_id | int | Número que identifica a cada usuario |
| id\_post | int | Número identificatorio de cada una de las publicaciones |
| date | LocaleDate | Fecha de la publicación en formato **dd-MM-yyyy** |
| product\_id | int | Número identificatorio de cada uno de los productos asociados a una publicación |
| product\_name | String | Cadena de caracteres que representa el nombre de un producto |
| type | String | Cadena de caracteres que representa el tipo de un producto |
| brand | String | Cadena de caracteres que representa la marca de un producto |
| color | String | Cadena de caracteres que representa el color de un producto |
| notes | String | Cadena de caracteres para colocar notas u observaciones de un producto |
| category | int | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |
| price | double | Precio del producto |
| has\_promo | boolean | Campo true o false para determinar si un producto está en promoción o no |
| discount | double | En caso de que un producto estuviese en promoción ,establece el monto de descuento. |

**US 0011:** Obtener la cantidad de productos en promoción de un determinado vendedor

**Sign**** :**

| **Method** | **SIGN** |
| --- | --- |
| GET | /products/{user\_id}/promo-post/count |
| **Response** | { &quot;user\_id&quot; : 1569,&quot;user\_name&quot;: &quot;vendedor1&quot;,&quot;promo\_products\_count&quot;: 23} |

**Filtros/Parámetros:**

| **Parámetros** | **Tipo** | **Descripción/Ejemplo** |
| --- | --- | --- |
| user\_id | int | Número que identifica a cada usuario |
| user\_name | String | Cadena de caracteres que representa el nombre del usuario |
| promo\_products\_count | int | Cantidad numérica de productos en promoción de un determinado usuario. |

**US 0012:** Obtener un listado de todos los productos en promoción de un determinado vendedor

**Sign**** :**

| **Method** | **SIGN** |
| --- | --- |
| GET | /products/{user\_id}/list |
| **RESPONSE:** | {&quot;user\_id&quot;: 1569,&quot;user\_name&quot;: &quot;vendedor1&quot;,&quot;posts&quot;: [{&quot;id\_post&quot;: 18,&quot;date&quot;: &quot;29-04-2021&quot;,&quot;detail&quot;: {&quot;product\_id&quot;: 1,&quot;product\_name&quot;: &quot;Silla Gamer&quot;,&quot;type&quot;: &quot;Gamer&quot;,&quot;brand&quot;: &quot;Racer&quot;,&quot;color&quot;: &quot;Red &amp; Black&quot;,&quot;notes&quot;: &quot;Special Edition&quot;},&quot;category&quot;: &quot;100&quot;,&quot;price&quot;: 15000.5,&quot;has\_promo&quot;: true,&quot;discount&quot;: 0.25}, {&quot;id\_post&quot;: 32,&quot;date&quot;: &quot;01-05-2021&quot;,&quot;detail&quot;: {&quot;product\_id&quot;: 62,&quot;product\_name&quot;: &quot;Headset RGB Inalámbrico&quot;,&quot;type&quot;: &quot;Gamer&quot;,&quot;brand&quot;: &quot;Razer&quot;,&quot;color&quot;: &quot;Green with RGB&quot;,&quot;notes&quot;: &quot;Sin Batería&quot;},&quot;category&quot;: &quot;120&quot;,&quot;price&quot;: 2800.69,&quot;has\_promo&quot;: true,&quot;discount&quot;: 0.1}]} |

**Filtros/Parámetros:**

| **Parámetros** | **Tipo** | **Descripción/Ejemplo** |
| --- | --- | --- |
| user\_id | int | Número que identifica a cada usuario |
| user\_name | String | Cadena de caracteres que representa el nombre del usuario |
| id\_post | int | Número identificatorio de cada una de las publicaciones |
| date | LocaleDate | Fecha de la publicación en formato **dd-MM-yyyy** |
| product\_id | int | Número identificatorio de cada uno de los productos asociados a una publicación |
| product\_name | String | Cadena de caracteres que representa el nombre de un producto |
| type | String | Cadena de caracteres que representa el tipo de un producto |
| brand | String | Cadena de caracteres que representa la marca de un producto |
| color | String | Cadena de caracteres que representa el color de un producto |
| notes | String | Cadena de caracteres para colocar notas u observaciones de un producto |
| category | int | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |
| price | double | Precio del producto |
| has\_promo | boolean | Campo true o false para determinar si un producto está en promoción o no |
| discount | double | En caso de que un producto estuviese en promoción, establece el monto de descuento. |


### Mejorías a implementar
- Operaciones CRUD para usuarios y productos.
- Generación de los ID aleatorios y únicos.
- Implementación de base de datos.
- Agregar manejo de excepciones en la capa de repositorio.
- Realización de test.