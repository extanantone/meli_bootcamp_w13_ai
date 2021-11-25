# SocialMELI - Rubén Buelvas

El modelo de datos consta de 3 entidades: _Product_, _Post_ y _User_. Cada una tiene un repositorio en donde se encuentran las operaciones CRUD. Al momento de arrancar el proyecto se cargan automáticamente cuatro usuarios desde un archivo JSON que se encuentra en la carpeta _resources_.
Debido al alto grado de dependencia entre los posts y los productos, ambos con manejados por un solo servicio llamado _PostService_. Junto con _UserService_ forman la capa de servicios.
Existe un mapper para transformar entidades de la capa de datos a DTOs. También hay un manejador global de excepciones.
Para manejar las peticiones hay dos controladores. _UserController_ se encarga de los endpoints que empiezan en la ruta _/users_ y _PostController_ de los enpoints que empiezan en la ruta _/products_.

## Consideraciones

- No se diferencia entre usuarios compradores y vendedores. Todos tienen la capacidad de seguir a cualquier otro usuario, de ser seguidos y de publicar un post.
- Cuando se intenta crear un producto o post que ya existe, el sistema devolverá un error _403 Bad Request_.
- Las operaciones de _follow_ y _unfollow_ devuelven un cuerpo vacío, con el estado _200 OK_ si la operación se realizó correctamente.

## Cambios en los endpoints

- En las peticiones se cambió el campo _id_post_ por _post_id_.
- En las respuestas se cambió *follower_count*, *followed_count* y *post_count* por simplemente _count_, usando el mismo DTO para todos.
- En las respuestas se cambió _user_name_ por _username_.
- En vez de devolver _403 Bad Request_, los endpoints devuelven _404 Not Found_ cuando se intentan hacer operaciones con elementos no existentes.
- Cuando se crean elementos el sistema devuelve un _201 Created_ en vez de un _200 OK_.
