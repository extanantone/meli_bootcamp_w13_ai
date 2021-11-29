## SocialMeli

#### US 0001 — Poder realizar la acción de "Follow" (seguir) a un determinado vendedor:
- Un usuario puede seguir a cualquier otro usuario.
- No se ha realizado distinción entre comprador o vendedor, ya que se consideró que cualquier usuario está apto para cumplir ambos roles.
- Se arroja una excepción del tipo _UserNotFoundException_ con código interno _user_not_found_ y HTTP status code 400 en los siguientes casos:
  * Si el _user_id_ no se encuentra registrado en el sistema.
  * Si el _user_id_to_follow_ no se encuentra registrado en el sistema.
- Se arroja una excepción del tipo _DeniedActionException_ con código interno _denied_action_ y HTTP status code 400 en los siguientes casos:
  * Si el _user_id_ y _user_id_to_follow_ son iguales.
  * Si un usuario intenta seguir a alguien que ya seguía.
- Si se ejecuta la acción sin inconvenientes, se retorna un ResponseEntity con código interno _performed_action_ y HTTP status code 200.

#### US 0002 — Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor:
- Si el _user_id_ no se encuentra registrado en el sistema, se arroja una excepción del tipo _UserNotFoundException_ con código interno _user_not_found_ y HTTP status code 400.
- Si se ejecuta la acción sin inconvenientes, se retorna un ResponseEntity conteniendo lo solicitado y HTTP status code 200.

#### US 0003 — Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?):
- Si el _user_id_ no se encuentra registrado en el sistema, se arroja una excepción del tipo _UserNotFoundException_ con código interno _user_not_found_ y HTTP status code 400.
- Si se ejecuta la acción sin inconvenientes, se retorna un ResponseEntity conteniendo lo solicitado y HTTP status code 200. En el caso de no contar con seguidores, _followers_ contendrá una lista vacía.

#### US 0004 — Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?):
- Si el _user_id_ no se encuentra registrado en el sistema, se arroja una excepción del tipo _UserNotFoundException_ con código interno _user_not_found_ y HTTP status code 400.
- Si se ejecuta la acción sin inconvenientes, se retorna un ResponseEntity conteniendo lo solicitado y HTTP status code 200. En el caso de no seguir a otros usuarios, _followed_ contendrá una lista vacía.

#### US 0005 — Dar de alta una nueva publicación:
- En base a lo expresado en la descripción de los parámetros, se tomó la decisión de incluir a _category_ y _price_ como atributos de la entidad _Product_ (y no de _Post_). No obstante, se ha respetado el formato del payload solicitado.
- Si el _user_id_ no se encuentra registrado en el sistema, se arroja una excepción del tipo _UserNotFoundException_ con código interno _user_not_found_ y HTTP status code 400.
- Si el _id_post_ para ese _user_id_ ya se encuentra registrado en el sistema, se arroja una excepción del tipo _DuplicateIDPostException_ con código interno _duplicate_id_ y HTTP status code 400.
- Si se ejecuta la acción sin inconvenientes, se retorna un ResponseEntity con código interno _performed_action_ y HTTP status code 200.

#### US 0006 — Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero):
- Si el _user_id_ no se encuentra registrado en el sistema, se arroja una excepción del tipo _UserNotFoundException_ con código interno _user_not_found_ y HTTP status code 400.
- Si se ejecuta la acción sin inconvenientes, se retorna un ResponseEntity conteniendo lo solicitado y HTTP status code 200.

#### US 0007 — Poder realizar la acción de "Unfollow" (dejar de seguir) a un determinado vendedor:
- Se arroja una excepción del tipo _UserNotFoundException_ con código interno _user_not_found_ y HTTP status code 400 en los siguientes casos:
  * Si el _user_id_ no se encuentra registrado en el sistema.
  * Si el _user_id_to_unfollow_ no se encuentra registrado en el sistema.
- Se arroja una excepción del tipo _DeniedActionException_ con código interno _denied_action_ y HTTP status code 400 en los siguientes casos:
  * Si el _user_id_ y _user_id_to_unfollow_ son iguales.
  * Si un usuario intenta dejar de seguir a alguien que no seguía.
- Si se ejecuta la acción sin inconvenientes, se retorna un ResponseEntity con código interno _performed_action_ y HTTP status code 200.

#### US 0008 — Ordenamiento alfabético ascendente y descendente:

`Se implementó en los endpoints creados en las US 0003 y US 0004`
- Si no se envia el RequestParam _order_ no se lleva a cabo la acción de ordenamiento (es opcional).
- Si se ejecuta la acción sin inconvenientes, se retorna un ResponseEntity conteniendo lo solicitado (orden por _user_name_ ascendente o descendente) y HTTP status code 200.

#### US 0009 — Ordenamiento por fecha ascendente y descendente:

`Se implementó en el endpoint creado en la US 0006`
- Si no se envia el RequestParam _order_ se lleva a cabo la acción de ordenamiento default (orden descendente, publicaciones más recientes primero).
- Si se ejecuta la acción sin inconvenientes (habiendo o no enviado el RequestParam _order_), se retorna un ResponseEntity conteniendo lo default o solicitado (orden por _date_ ascendente o descendente) y HTTP status code 200.