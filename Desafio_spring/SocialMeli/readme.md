DOCUMENTACIÓN
-

CRITERIOS:
-
* Se definió que tanto los compradores como los vendedores son usuarios de la 
plataforma y por esta razón se crea una clase Usuario de la cual heredan tanto
la clase vendedor como la clase comprador.
* Para diferenciar compradores de vendedores, se estableció que únicamente los
vendedores podrían ser seguidos por compradores, pero que un comprador no puede
ser seguido por un vendedor.
* Se creó además toda la estructura de carpetas de manera independiente para
las publicaciones
---
<b>US001:</b>
Ruta: /users/{user_id}/follow/{user_id_to_follow}

En caso exitoso devuelve un STATUS 200 y los datos tanto del seguidor como
de la persona que fue seguida.

En caso no exitoso devuelve BAD_REQUEST

---
<b>US002:</b>
Ruta: /users/{user_id}/followers/count

Se obtiene el conteo solicitado mediante el método getCantSeguidores().

En caso exitoso se devuelve el conteo solicitado.

en caso no exitoso se devuelve un error NotFound mediante la excepción
NotFoundVendedorException.
---
<b>US003:</b>
Ruta: /users/{user_id}/followers/count

Se obtiene el listado solicitado mediante el método getInfoSeguidores().

En caso exitoso se devuelve el listado solicitado.

en caso no exitoso se devuelve un error NotFound mediante la excepción
NotFoundVendedorException.
---
<b>US004:</b>
Ruta: /users/{user_id}/followed/list

Se obtiene el listado de todos los vendedores a los que sigue un 
determinado usuario mediante el método listarSeguidos() del controller que
corresponde a los compradores. Este último llama al método verSeguidos()
definido en CompradorService.

En caso exitoso se devuelve el listado solicitado y Status 200

en caso no exitoso se devuelve un error según el caso: 

* Si no se encuentra el comprador, se devolverá NotFoundCompradorException.
* Si no se encuentra el vendedor, se devolverá NotFoundVendedorException
---
<b>US005:</b>
Ruta: /products/post

Permite dar de alta la publicación mediante el método de la clase 
PublicacionController llamado addNewPost(), que a la vez llama al método
addNewPub() en la capa correspondiente al servicio.

En caso exitoso se devuelve STATUS 200

en caso no exitoso se devuelve STATUS 400 BAD_REQUEST

---
<b>US006:</b>
Ruta: /products/followed/{user_id}/list

Se obtiene el listado de las publicaciones que realizaron los vendedores
a los cuales sigue un determinado usuario. Se ordenan por defecto de forma
ascendente, pero se puede especificar agregando ?order=name_desc/asc

En caso exitoso se devuelve el listado solicitado.

en caso no exitoso se devuelve un error NotFound mediante la excepción
NotFoundVendedorException.
---
<b>US007:</b>
Ruta: /users/{user_id}/unfollow/{user_id_to_unfollow}

Permite dejar de seguir a un vendedor. Esta acción se realiza afectando dos
listas: Una del comprador y otra del vendedor. La lista del comprador contiene
a los vendedores que ha seguido, mientras que la lista del vendedor contiene
a los compradores que lo han seguido. Se elimina al vendedor de la primera
lista mencionada y se elimina al comprador de la segunda.

En caso exitoso se devuelve un mensaje y STATUS 200

en caso no exitoso se devuelve un error NotFound mediante la excepción
NotFoundVendedorException en caso de que no exista el vendedor a dejar de
seguir o NotFoundCompradorException en caso tal que no exista el id del
comprador.
---
<b>US008:</b>
Rutas: 
* /users/{user_id}/followers/list?order=name_asc
* /users/{user_id}/followers/list?order=name_desc
* /users/{user_id}/followed/list?order=name_asc
* /users/{user_id}/followed/list?order=name_desc


Se obtienen los listados solicitados según la ruta elegida ordenados de forma
ascendente o descendente.

En caso exitoso se devuelve el listado solicitado de manera ordenada.

en caso no exitoso se devuelve un error NotFound mediante la excepción
NotFoundVendedorException o NotFoundComprador Exception según el caso.
STATUS 400 BAD REQUEST.



