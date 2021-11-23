En Social Meli todos son usuarios, un usuario se convierte en verdedor cuando tiene una o más de una publicación.
Se ingresar 4 usuarios por default con los id: 1,2,3,4
Se desarrollaron los 9 casos soliciotados como fundamentales, faltan algunas validaciones que no se llegaron a agregar sus respectivas excepciones.
Dejo los endpoints documentados, considerando que se utiliza el puerto por default de tomcat 8080 dejo los enlaces para acceder una vez levantado el servicio

@PostMapping("/{user_id}/follow/{user_id_to_follow}")
Acceder: http://localhost:8080/users/1/follow/2
Funcionalidad: Un usuario puede seguir a otro usuario/vendedor
               Un vendedor puede seguir a otro usuario/vendedor

@GetMapping("/{user_id}/followers/count")
Acceder: http://localhost:8080/users/2/followers/count
Funcionalidad: Devuelve la cantidad de seguidores que tiene el usuario ingresado, en caso de no tener ninguno devuelve en la cantidad de seguidores 0

@GetMapping("/{user_id}/followers/list")
Acceder: http://localhost:8080/users/1/followers/list

@GetMapping("/{user_id}/followed/list")
Acceder: http://localhost:8080/users/1/followed/list
Funcionalidad: Lista de personas a las que sigue un usuario

@PostMapping("/post")
Acceder: http://localhost:8080/products/post
Funcionalidad: Permite agregar una nueva publicacion

@GetMapping("/followed/{user_id}/list")
Acceder: http://localhost:8080/products/followed/1/list
Funcionalidad: Lista de publicaciones de los vendedores a los que sigo en el rango de dos semanas

@PostMapping("/{user_id}/unfollow/{user_id_to_unfollow}")
Acceder: http://localhost:8080/users/2/unfollow/3
Funcionalidad: Un usuario/vendedor puede dejar de seguir a otro usuario/vendedor

@GetMapping(value = "/{user_id}/followers/list",params = "order")
Acceder: http://localhost:8080/users/4/followers/list?order=name_desc
Funcionalidad: Ordena la lista de seguidores de forma ascendente o descendente

@GetMapping(value = "{user_id}/followeds/list",params = "order")
Acceder: http://localhost:8080/users/2/followeds/list?order=name_desc
Funcionalidad: Ordena la lista de seguidos de forma ascendente o descendente

@GetMapping(value = "/followed/{user_id}/list",params = "order")
Acceder: http://localhost:8080/products/followed/1/list?order=date_asc
Funcionalidad: Ordena las publicaciones de los vendedores que sigue un usuario por fecha de forma ascendente o descendente






