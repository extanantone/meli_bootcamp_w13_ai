Los usuarios tienen un boolean "isSeller" que pasa a ser true cuando el usuario crea su primer post.

US 01: Poder realizar la acción de "Follow" (seguir) a un determinado vendedor

- Los usuarios pueden seguir a cualquier otro usuario, sea o no vendedor
- Si el usuario1 ya seguía al usuario2, devuelve 400
- Si alguno de los usuarios no es válido, devuelve 400
- Si los ids dados son iguales, devuelve 400
- Si se ejecuta la acción sin inconvenientes, devuelve 200
    
US 02: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor

- Si el usuario no es válido, devuelve 404
- Si el usuario no es vendedor, devuelve 400
- Si se ejecuta la acción sin inconvenientes, devuelve 200 y la cantidad de seguidores (vendedores y no vendedores)

US 03: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)

- Si el usuario no es válido, devuelve 404
- Si el usuario no es vendedor, devuelve 400
- Si se ejecuta la acción sin inconvenientes, devuelve 200 y la lista de seguidores (vendedores y no vendedores)

US 04: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)

- Si el usuario no es válido, devuelve 404
- Si se ejecuta la acción sin inconvenientes, devuelve 200 y la lista de seguidores que sean vendedores

US 05: Dar de alta una nueva publicación

- Si el usuario no es válido, devuelve 400
- Se pone en true el atributo isSeller del usuario
- Si se ejecuta la acción sin inconvenientes, devuelve 200

US 06: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).

- Si el usuario no es válido, devuelve 404
- Si se ejecuta la acción sin inconvenientes, devuelve 200 y la lista de publicaciones de usuarios(vendedores) que sigue el usuario con fecha dentro de los últimos 14 días. (Las más recientes primero)

US 07: Poder realizar la acción de "Unfollow" (dejar de seguir) a un determinado vendedor.

- Los usuarios pueden dejar de seguir a cualquier otro usuario que ya sigan, sea o no vendedor
- Si el usuario1 no seguía al usuario2, devuelve 400
- Si alguno de los usuarios no es válido, devuelve 400
- Si los ids dados son iguales, devuelve 400
- Si se ejecuta la acción sin inconvenientes, devuelve 200

US 08: Ordenamiento alfabético ascendente y descendente
-- Se aplicó a los endpoints creados en los puntos US 03 y US 04--

- Si en el RequestParam "order" hay un string inválido, devuelve 400
- Si se ejecuta la acción sin inconvenientes, devuelve 200 y la lista de seguidores (vendedores o no) o vendedores a los que sigue el usuario ordenados por userName según el valor del parámetro "order" recibido.

US 09: Ordenamiento por fecha ascendente y descendente

- Si en el RequestParam "order" hay un string inválido, devuelve 400
- Si se ejecuta la acción sin inconvenientes, devuelve 200 y la lista de publicaciones de usuarios(vendedores) que sigue el usuario con fecha dentro de los últimos 14 días ordenados según el parámetro recibido.

US 10: Llevar a cabo la publicación de un nuevo producto en promoción Sign:
-- Los productos en promoción se agregaron por fuera de los productos, como nueva clase --

- Si el usuario no es válido, devuelve 400
- Se pone en true el atributo isSeller del usuario
- Si se ejecuta la acción sin inconvenientes, devuelve 200

US 11: Obtener la cantidad de productos en promoción de un determinado vendedor

- Si el usuario no es válido, devuelve 404
- Si el usuario no es vendedor, devuelve 400
- Si se ejecuta la acción sin inconvenientes, devuelve 200 y la cantidad de posts en promoción que tiene el usuario

US 0012: Obtener un listado de todos los productos en promoción de un determinado vendedor

- Si el usuario no es válido, devuelve 404
- Si el usuario no es vendedor, devuelve 400
- Si se ejecuta la acción sin inconvenientes, devuelve 200 y la lista de posts en promoción que tiene el usuario
