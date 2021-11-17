BOOTCAMP BACKEND JAVA SPRINT Nº 1 - SPRING
Autor: Vanesa Belén Garro

Consideraciones Generales:
 * Se condidera que cualquier usuario puede ser un usuario común y un vendedor al mismo tiempo.
 * En el proyecto se colocó un archivo en src/main/resources/Users.json con 4 usuarios sin asociaciones,
 es decir, que no se siguen entre ellos ni tienen post. Los mismos son leidos al iniciar.
  *Al no utilizarse una base de datos, una vez detenida la aplicación todos los post, promos y acciones
 de seguimiento se destruyen, es decir, si se detiene la aplicación y luego se vuelve a levantar, solo estarán
 lo 4 usuarios iniciales.

 Concideraciones de desarrollo:
  * Proyecto Generado con SprintBoot, desarrollada con Java 11 y Maven para control de dependencias.
  * Se utilizó la estructura Map para llevar el listado de USUARIOS. Cada Usuario lleva su lista de FOLLOWERS y FOLLOWED,
  para una facil busqueda de listad.
  * Se utilizó una LinkedList para llevar los post y otra para los promos. Cada post y promo tiene el ID del Usuario
  dueño del post y promo. El ID del post es unico, es decir, si el usuario1 publicó el post1 el usuario2 no puede publicar
  el post1. Por otro lado el id del producto es unico por usuario, es decir si el usuario1 al publicar un post publica el
  producto1, ese usuario deberá en el proximo post publicar el producto2. Si bien el id del post y el id de los productos
  son unicos, no es necesario que sean correlativos.
  * Por defecto al API se encuentra corriendo en el puerto 8080
  * Las respuestas se envian mediante JSON y un HttpStatus.


  REQUERIMIENTOS DEL SISTEMA

  *US 0001: Poder realizar la acción de "Follow" (Seguir) a un determinado vendedor.
      POST: /users/{user_id}/follow/{user_id_to_follow}
      EJ: localhost:8080/users/1/follow/3

      Posibles resultados:
          - Si alguno de los usuarios no existe, se informa mediante un mensaje y Status Code 400.
          - Si ambos usuario existen y usuario 1 ya segue a usuario 3 (Siguiendo el ejemplo antes mencionado), devuelve
          mensaje de que ya encuentra siguiendolo y Status Code 400.
          - Si ambos usuario existen y usuario 1 no sigue a usuario 3 (Siguiendo el ejemplo antes mencionado), devuelve
                mensaje y Status Code 200.

  *US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor.
      GET: /users/{user_id}/followers/count
      EJ: localhost:8080/users/3/followers/count

      Posibles resultados:
          - Si el usuario no existe, se informa mediante un mensaje y Status Code 400.
          - Si el usuario existen retorna Json con la cantidad y Status Code 200.

  *US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
      GET: /users/{user_id}/followers/list
      EJ: localhost:8080/users/3/followers/list

      Posibles resultados:
           - Si el usuario no existe, se informa mediante un mensaje y Status Code 400.
           - Si el usuario existen retorna Json con la lista de usuarios que siguen a un vendedor y Status Code 200.

  *US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
       GET: /users/{user_id}/followers/list
       EJ: localhost:8080/users/1/followed/list

       Posibles resultados:
            - Si el usuario no existe, se informa mediante un mensaje y Status Code 400.
            - Si el usuario existen retorna Json con la lista y Status Code 200.

  *US 0005: Dar de alta una nueva publicación
      POST: /products/post
      EJ: localhost:8080/products/post

            Consideración:
            * id_post debe ser un número mayor que cero, y no haber un post con ese id.
            * date no puede ser null y debe ser menor o igual a la fecha de hoy
            * price y category deben ser mayor que cero
            * detail debe existir y se exige que product_id, product_name y type al menos tengan valor, el resto los considero
            no obligatorios.
            * product_id no debe repetirse por usuario.
            * No se exige correlatividad ni de product_id ni id_post.
            * Formato de date: dd-MM-yyyy (24-06-2021)

            Posibles resultados:
                  - Si el usuario no existe, se informa mediante un mensaje y Status Code 400.
                  - Si el post_id es menor o igual a cero, se informa mediante un mensaje y Status Code 400.
                  - Si date no es enviada o es mayor a la fecha actual, se informa mediante un mensaje y Status Code 400.
                  - Si detail no es enviado o atributos como product_id, type y product_name no son enviados (el resto
                  los tomo como no obligatorios), se informa mediante un mensaje y Status Code 400.
                  - Si el usuario existe y los datos son correctos retorna mensaje y Status Code 200.

  *US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas
  dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
      GET: /products/followed/{user_id}/list
      EJ: localhost:8080/products/followed/1/list

      Posibles resultados:
          - Si el usuario no existe, se informa mediante un mensaje y Status Code 400.
          - Si el usuario existe retorna Json con la lista y Status Code 200.

 *US 0007: Poder realizar la acción de "Unfollow" (dejar de seguir) a un determinado vendedor.
      POST: /users/{user_id}/unfollow/{user_id_to_unfollow}
      EJ: localhost:8080/users/1/unfollow/3

      Posibles resultados:
           - Si alguno de los usuarios no existe, se informa mediante un mensaje y Status Code 400.
           - Si ambos usuario existen y usuario 1 no sigue a usuario 3 (Siguiendo el ejemplo antes mencionado), devuelve
           mensaje de que no se encuentra siguiendo y Status Code 400.
           - Si ambos usuario existen y usuario 1 sigue a usuario 3 (Siguiendo el ejemplo antes mencionado), devuelve
           mensaje y Status Code 200.

 *US 0008: Ordenamiento alfabético ascendente y descendente
      GET:  /users/{user_id}/followers/list?order=name_asc
            /users/{user_id}/followers/list?order=name_desc
            /users/{user_id}/followed/list?order=name_asc
            /users/{user_id}/followed/list?order=name_desc
      EJ: localhost:8080/users/1/followed/list?order=name_asc
          localhost:8080/users/1/followed/list?order=name_desc
          localhost:8080/users/3/followers/list?order=name_asc
          localhost:8080/users/3/followers/list?order=name_desc

      Posibles resultados:
           - Si el usuario no existe, se informa mediante un mensaje y Status Code 400.
           - Si el usuario no sigue a nadie o no es seguido retorna mensaje y Status Code 400.
           - Si order no es igualado a name_desc o name_asc retorna mensaje y Status Code 400.
           - Si el usuario existe y es seguido o sigue a alguien(segun endpoint), devuelve
           mensaje y Status Code 200.

 *US 0009: Ordenamiento por fecha ascendente y descendente
      GET:  /products/followed/{user_id}/list?order=date_asc
            /products/followed/{user_id}/list?order=date_desc
      EJ: calhost:8080/products/followed/1/list?order=date_asc
          calhost:8080/products/followed/1/list?order=date_desc

      Posibles resultados:
           - Si el usuario no existe, se informa mediante un mensaje y Status Code 400.
           - Si el usuario no sigue a nadie muestra Json con lista vacia y Status Code 200.
           - Si order no es igualado a date_desc o date_asc retorna mensaje y Status Code 400.
           - Si el usuario existe, devuelve Json y Status Code 200.


  *US 0010: Llevar a cabo la publicación de un nuevo producto en promoción
       POST: /products/promo-post
       EJ: localhost:8080/products/promo-post

             Consideración:
             * Considero las promociones como una lista aparte de los post, por lo cual las promos tienen el id_post
             independiente de los post del US 0005.
             * id_post debe ser un número mayor que cero, y no haber un post con ese id.
             * date no puede ser null y debe ser menor o igual a la fecha de hoy
             * price, category y discount deben ser mayor que cero
             * detail debe existir y se exige que product_id, product_name y type al menos tengan valor, el resto los considero
             no obligatorios.
             * product_id no debe repetirse por usuario.
             * No se exige correlatividad ni de product_id ni id_post.
             * Formato de date: dd-MM-yyyy (24-06-2021)
             * Si has_promo es false, se considera que no es una promo y no se almacena.
             * discount se considera un porcentaje de descuento, si se quiere un 10% de descuento, debe enviarse 10.

             Posibles resultados:
                   - Si el usuario no existe, se informa mediante un mensaje y Status Code 400.
                   - Si el post_id es menor o igual a cero, se informa mediante un mensaje y Status Code 400.
                   - Si date no es enviada o es mayor a la fecha actual, se informa mediante un mensaje y Status Code 400.
                   - Si detail no es enviado o atributos como product_id, type y product_name no son enviados (el resto
                   los tomo como no obligatorios), se informa mediante un mensaje y Status Code 400.
                   - Si has_promo es false, se informa mediante un mensaje y Status Code 400.
                   - Si el usuario existe y los datos son correctos retorna mensaje y Status Code 200.

  *US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor
       GET: /products/{user_id}/promo-post/count
       EJ: localhost:8080/products/3/promo-post/count

       Posibles resultados:
           - Si el usuario no existe, se informa mediante un mensaje y Status Code 400.
           - Si el usuario existe retorna Json con la cantidad y Status Code 200.

  *US 0012: Obtener un listado de todos los productos en promoción de un determinado vendedor
      GET: /products/{user_id}/list
      EJ: localhost:8080/products/3/list

      Posibles resultados:
          - Si el usuario no existe, se informa mediante un mensaje y Status Code 400.
          - Si el usuario existe retorna Json con la lista y Status Code 200.


MEJORA PLANTEADA:

*US 0013: Obtener un listado de todos los productos en promoción de un determinado vendedor ordenados por fecha de
publicación
    GET: /products/{user_id}/list?order=date_asc
         /products/{user_id}/list?order=date_desc
    EJ: localhost:8080/products/3/list?order=date_desc

    Posibles resultados:
        - Si el usuario no existe, se informa mediante un mensaje y Status Code 400.
        - Si order no es igualado a date_desc o date_asc retorna mensaje y Status Code 400.
        - Si el usuario existe, devuelve Json y Status Code 200.
