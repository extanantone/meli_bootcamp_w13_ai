# Sprint 1

## US 0001 - Seguir a un vendedor
#### Se manejo un solo tipo de usuario por lo tanto todos los usuarios se pueden seguir entre si.

Excepciones controladas:
* Un usuario no puede seguir ni ser seguido por un usuario que no existe.
* Un usuario no se puede seguir a si mismo.

## US 0002 - Cantidad de usuarios que siguen a un vendedor

Excepciones controladas:
* Se valida que el usuario exista.

## US 0003 - Listado de usuarios que siguen a un vendedor

Excepciones controladas:
* Se valida que el usuario exista.
* Si el usuario no tiene seguidores se retorna un listado vacio de followers.
* Se toma el parametro "order" con un valor por defecto de "name_asc".
* Si se ingresa un valor distinto para el parametro "order" se utiliza el valor por defecto.

## US 0004 - Listado de vendedores que un usuario sigue

Excepciones controladas:
* Se valida que el usuario exista.
* Si el usuario no sigue vendedores se retorna un listado vacio de followed.
* Se toma el parametro "order" con un valor por defecto de "name_asc".
* Si se ingresa un valor distinto para el parametro "order" se utiliza el valor por defecto.

## US 0005 - Dar de alta una publicación

Excepciones controladas:
* Se valida que el usuario exista.
* No se permite crear publicaciones con el mismo "id_post".
* Si no se ingresa alguno de los atributos o se ingresan mal se retorna un Status 400.

## US 0006 - Listar publicaciones de vendedores que sigo

Excepciones controladas:
* Se valida que el usuario exista.
* Se toma el parametro "order" con un valor por defecto de "date_asc".
* Si se ingresa un valor distinto para el parametro "order" se utiliza el valor por defecto.

## US 0007 - Dejar de seguir a un vendedor

Excepciones controladas:
* Se valida que ambos usuarios existan.
* Se valida que se esté siguiendo al usuario para posteriormente dejarlo de seguir.

## US 0008 - Ordenamiento alfabético ascendente y descendente
* Se manejo el ordenamiento ascendente y descendente a través del parámetro "order", tomando siempre como valor por defecto "name_asc".
* Si se ingresa un valor distinto a "name_asc" o "name_desc", se toma el valor por defecto "name_asc".
## US 0009 - Ordenamiento por fecha ascendente y descendente
* Se manejo el ordenamiento ascendente y descendente a través del parámetro "order", tomando siempre como valor por defecto "date_asc".
* Si se ingresa un valor distinto a "date_asc" o "date_desc", se toma el valor por defecto "date_asc".

## US 0010 - Llevar a cabo la publicación de un nuevo producto en promoción
* Se valida que el usuario exista.
* No se permite crear publicaciones con el mismo "id_post".
* Si no se ingresa alguno de los atributos o se ingresan mal se retorna un Status 400.

## US 0011 - Obtener la cantidad de productos en promoción de un determinado vendedor
* Se valida que el usuario exista.

## US 0012 - Obtener un listado de todos los productos en promoción de un determinado vendedor
* Se valida que el usuario exista.
* Si el usuario no tiene publicaciones en promoción solo se retorna su "user_id" y "user_name".
* Se permite ordenar las publicaciones por nombre del producto utilizando el parámetro "order" y sus valores "name_asc" o "name_desc".
* Si se ingresa un valor distinto a "name_asc" o "name_desc", se toma el valor por defecto "name_asc".

