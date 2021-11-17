URL POST http://localhost:8080/users/{user_id}/follow/{user_id_to_follow}

Se le agrego una funcionalidad que checkea si el comprado/vendedor existe.
Ademas se le agrego otra funcionalidad que si ya el comprador n sigue al vendedor n no lo vuelve a seguir.
Devuelve su StatusCode correspondiente.

URL POST http://localhost:8080/users/{user_id}/unfollow/{user_id_to_follow}

Se le agrego una funcionalidad que checkea si el comprado/vendedor existe.
Ademas se le agrego otra funcionalidad que si ya el comprador n no seguia al vendedor n devuelve un mensaje.
Si no lo seguia lo sigue.
Devuelve su StatusCode correspondiente.

URL GET http://localhost:8080/users/{user_id}/followers/count

Checkeo si el vendedor existe, y devuelvo cuantas compradores lo siguen.


URL GET http://localhost:8080/users/{user_id}/followers/list

Realiza todo el checkeo y devuelva una lista de los compradores que siguen al vendedor n.

URL GET http://localhost:8080/users/{user_id}/followed/list

Realiza todo el chekeo y devuelve una lista con los vendedor que sigue el comprador n.

URL POST http://localhost:8080/products/post

Realiza todo el chekeo y ademas tiene una funcionalidad para buscar el post, con validaciones.
Una vez finalizadas crea el post.

URL GET http://localhost:8080/products/followed/{user_id}/list

Realiza todo el chekeo y devuelve una lista con los Post de los vendedores que sige el comprador n.

Los demas endpoint de ordenamiento funcionan como la documentacion.

GET
Ejemplos:
/users/{user_id}/followers/list?order=name_asc
/users/{user_id}/followers/list?order=name_desc
/users/{user_id}/followed/list?order=name_asc
/users/{user_id}/followed/list?order=name_desc

GET
Ejemplos:
/products/followed/{user_id}/list?order=date_asc
/products/followed/{user_id}/list?order=date_desc

