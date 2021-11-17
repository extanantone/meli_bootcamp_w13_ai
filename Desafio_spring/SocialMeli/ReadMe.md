##REQUERIMIENTOS DEL SISTEMA
*US 0001: Poder realizar la acción de "Follow"  a un determinado vendedor.*

En el enunciado podemos encotrar 2 tipos de usuarios: vendedores y compradores. Dado que era opcional poder diferenciarlos, el sistema no diferencia si un usuario es vendedor o compradors, por lo que los usuarios pueden seguirse entre ellos. Si se trata de seguir con un usuario a ese mismo usuario lanzará un error. Si se trata de seguir a un usuario no existente o de seguir a un usuario existente con otro no existente tambien lanzará un error.

__Nota__: Nadie sigue a nadie, nadie tiene publicaciones. Existen 4 usuarios creados.

Entradas:

**METHOD**: POST
**END**-**POINT**: localhost:8080/users/{user_id}/follow/{user_id_to_follow}
**EJEMPLO:** localhost:8080/users/1/follow/2


------------


*US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor.*

Dado que no se diferencia entre compradores y vendedores, se podrá ver la cantidad de seguidores de cualquier usuario. Si se ingresa un usuario no existente lanzará un error.


**METHOD**: GET
**END**-**POINT**: localhost:8080/users/{user_id}/followers/count
**EJEMPLO:** localhost:8080/users/4/followers/count

------------



*US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)*

Dado que no el sistema no diferencia tipos de usuarios, podrá obtener el listado de cualquier usuario. Si se ingresa un usuario no existente lanzrá un error.

**METHOD**: GET
**END**-**POINT**: localhost:8080/users/{user_id}/followers/list
**EJEMPLO:** localhost:8080/users/4/followers/list


------------


*US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)*


Dado que el sistema no diferencia entre tipos de usuarios, se puede obtener el listado desde cualquier usuario . Si se ingresa un usuario inexistente lanzará un error.


**METHOD**: GET
**END**-**POINT**: localhost:8080/users/{user_id}/followed/list
**EJEMPLO:** localhost:8080/users/1/followed/list


------------


*US 0005: Dar de alta una nueva publicación*

Dado que el sistema no diferencia entre tipos de usuarios, cualquier usuario puede realizar publicaciones.

**METHOD**: POST
**END**-**POINT**: localhost:8080/products/post
**EJEMPLO:** localhost:8080/products/post

Ejemplo Body:

{
"user_id": 4,
"id_post": 3,
"date": "06-11-2021",
"detail": {
"product_id": 1,
"product_name": "Silla n",
"type": "Gamer",
"brand": "Racer",
"color": "Red & Black",
"notes": "Special Edition"
},
"category": 100,
"price": 1500.50
}


------------


*US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).*

Para este caso, he tenido en cuenta que las publicaciones deben ser de máximo dos semanas, por lo que fue necesario realizar un filtro de fecha. Por otro lado, esta acción puede ser llevada a cabo por cualquier usuario debido a que el sistema no diferencia por tipo de usuario (comprador o vendedor).

**METHOD**: GET
**END**-**POINT**: localhost:8080/products/followed/{user_id}/list
**EJEMPLO:** localhost:8080/products/followed/1/list


------------


*US 0007: Poder realizar la acción de "Unfollow" (dejar de seguir) a un determinado vendedor.*

Debido a que el sistema no diferencia entre tipos de usuarios, esta acción puede ser llevada a cabo por cualquier usuario.

**METHOD**: POST
**END**-**POINT**: localhost:8080/users/{user_id}/unfollow/{user_id_to_unfollow}
**EJEMPLO:** localhost:8080/users/1/unfollow/2


------------


*US 0008: Ordenamiento alfabético ascendente y descendente.*

Restricciones:El parámetro "name_" debe estar escrito correctamente, así como el orden seleccionado "asc" o "desc".

**METHOD**: GET
**END**-**POINT-1**: localhost:8080/users/{user_id}/followers/list
**EJEMPLO1:** localhost:8080/users/4/followers/list?order=name_asc
**EJEMPLO2:** localhost:8080/users/4/followers/list?order=name_desc
**END**-**POINT-2**: localhost:8080/users/{user_id}/followed/list
**EJEMPLO1:** localhost:8080/users/1/followed/list?order=name_asc
**EJEMPLO2:** localhost:8080/users/1/followed/list?order=name_desc


------------


*US 0009: Ordenamiento por fecha ascendente y descendente.*

Restricciones: El parámetro "date_" debe estar escrito correctamente, así como el orden seleccionado "asc" o "desc".

**METHOD**: GET
**END**-**POINT**: localhost:8080/products/followed/{user_id}/list
**EJEMPLO1:** localhost:8080/products/followed/1/list?order=date_asc
**EJEMPLO2:** localhost:8080/products/followed/1/list?order=date_desc