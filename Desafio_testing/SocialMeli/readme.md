En la carpeta docs, se adjunta el json de prueba y los diagramas UML.

Follow user

POST Follow

URL http://localhost:8080/users/{userId}/follow/{userIdFollow}

Si el ususario no existe o intenta seguirse a si mismo retorna BAD_REQUEST con mensaje controlado.

Ejemplo OK:

http://localhost:8080/users/1/follow/3

Si lo puede seguir retorna 200


Ejemplo BAD:

http://localhost:8080/users/1/follow/8

No puede seguir a 8 ya que 8 no existe, retorna 404

http://localhost:8080/users/1/follow/1

No puede seguirse a si mismo, retorna 404

http://localhost:8080/users/1/follow/3

Ya sigue a 3, retorna 404



unFollow User

PUT
URL http://localhost:8080/users/{userId}/follow/{userIdToUnFollow}

Si el usuario no es encontrado retorna 404 o si el usuario a dejar de seguir no es encontrado retorna 404

Ejemplo:

http://localhost:8080/users/1/follow/8

Retorna 404, no existe usuario 8

http://localhost:8080/users/8/follow/1

Retorna 404, no existe usuario 8

http://localhost:8080/users/1/follow/1

Retorna 404, no se puede dejar de seguir a si mismo

http://localhost:8080/users/1/follow/2

Retorna 404, el usuario no sigue al vendedor.

Lista de Followers
GET URL http://localhost:8080/users/3/followers/list

SI no encuentra el usuario enviado retorna 404, si si lo encuentra trae el listado.

Lista de Followed
GET URL http://localhost:8080/users/1/followed/list

SI no encuentra el usuario enviado retorna 404, si si lo encuentra trae el listado.

FollowCount
GET URL http://localhost:8080/users/3/followers/count

SI no encuentra el usuario enviado retorna 404, si si lo encuentra  realiza el conteo.

PUblicaciones

Nueva Publicacion

POST URL http://localhost:8080/products/post

JSON:

{
    "user_id": 3,
    "id_post": 8,
    "date": "11-10-2021",
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

Si no existe el usuario retorna 404, si el usuario y id post enviado ya coinciden con otra publicacion retorna 404, en caso contrario retorna 200 ok.

Traer Publicaciones

Opción 1: Trae publicaciones filtradas por las ultimas dos semanas ordenadas de manera descendente de los vendedores que sigue el usuario enviado.

GET URL http://localhost:8080/products/followed/1/list

Retorna 404 si no existe el usuario enviado, en caso contrario retorna 200  y trae el listado de las publicaciones de los vendedores seguidos.


Opción 2: Trae publicaciones ordenadas acorde al parametro ingresado date_asc o date_desc, de los vendedores a los que sigue un usuario.

GET URL http://localhost:8080/products/followed/1/list?order=date_desc

Retorna 404 si no existe el usuario enviado, en caso contrario retorna 200  y trae el listado de las publicaciones de los vendedores seguidos.

