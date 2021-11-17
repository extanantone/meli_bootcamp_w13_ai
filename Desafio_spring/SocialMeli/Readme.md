# Desafio Sprint 1: Git, Java y Sprint.

#### Pablo Guayta - Software developer.

## Introduccion

Este repositorio cuenta con la resolución del desafío 1 del Bootcamp.

Este desafío consiste en la implementación de una versión Beta de lo que va a ser conocido como “SocialMeli”, en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.

Por lo tanto, en este documento vamos a detallar las consideraciones que se tuvieron al momento de hacer este desafio.


## Como iniciar el proyecto

El proyecto se encuentra en la estructura de carpetas "/Desafio_spring/SocialMeli".
Con iniciar el proyecto y ejecutar la clase "SocialmeliApplication" se ejecutaría el código.

Además, en el proyecto contamos con un **archivo Json** llamado "usuarios.json" en el cual se encuentran cuatro usuarios, con el id del 1 al 4.
Los usuarios con id 1 y 2 estan destinados a ser compradores, mientras que los usuarios con id 3 y 4 estan destinados a ser vendedores (aunque todos los usuarios son iguales ante el manejo de la aplicacion).


## Consideraciones

Para este sistema tuvimos las siguientes consideraciones:

- Todos los usuarios que utilicen este sistema se representan mediante la clase modelo "Usuarios". Se tomo esta consideracion debido a que consideramos que todo usuario puede seguir a otro usuario debido a que se puede utilizar la misma cuenta de un usuario para pasar de ser solo un "comprador" a un "vendedor".
Por lo tanto, todos los usuarios pueden seguirse entre si.

- Los datos iniciales de los usuarios se levantan desde el repository de Usuarios.

- Para almacenar a los seguidores de cada usuario, nos centramos en crear una clase "Followers"

En la misma tenemos los siguientes atributos:

- userId (int): el id del usuario que esta asociado con el usuario para el cual se crea el registro
- usuariosSeguidos (Map<Integer, Usuarios>): en el cual contenemos a todos los usuarios seguidos por este usuario en particular.

Decidi utilizar esta estructura ya que me parecia mas comodo al momento de realizar las consultas por los usuarios seguidos de un determinado usuario, o para analizar a quien sigue.
Otra estrategia hubiera sido almacenar otro HashMap para los followers de cada usuario, pero al dejar de seguir a un determinado usuario se deberia actualizar tanto los followeds del usuario como los followers del usuario que recibio el unfollow.

- Para los DTO, decidi utilizar dos paquetes separados:
  - controllerToService: todos los DTO recibidos por el controlador o que son enviados al service.
  - serviceToController: todos los DTO que son enviados desde el service al controlador para responder.
  
- Para las publicaciones, cree una clase Post y una clase PromoPost que hereda de Post. En mi repository, todas las publicaciones son almacenadas en el mismo Map, ya que esto es permitido por el polimorfismo. Por lo tanto, endpoints como "Obtener publicaciones de los usuarios que sigo de no mas de dos semanas de antiguedad" tambien incluye las publicaciones con promocion.


## Estructura del proyecto
El proyecto se ha separado en la siguiente estructura de paquetes:

#### -comparator
Aqui se encuentran las clases tipo "Comparator" utilizadas para ordenar los response de determinados endpoints. Se encuentran las clases de ordenamiento ascendente y descendiente para el nombre de los usuarios y la fecha de las publicaciones utilizados en las US 0006, 0008 y 0009.

#### -controller
Se encuentran los controller de la aplicacion. Se separan en:
-FollowerController: administra todos los endpoints referidos a usuarios seguidos y seguidores de un usuario.
-PostController: administra todos los endpoints referidos a publicaciones de los usuarios.
-PromoPostController: administra todos los endpoints referidos a publicaciones con promocion de los usuarios.

#### -dto
Se encuentran todos los DTOs utilizados para la aplicación.

#### -exception
Paquete donde se manejan las excepciones de la aplicacion.

#### -mapper
Se encuentran los mapper utilizados en la aplicacion. Se utilizan para mapear los modelos de la aplicacion a sus correspondientes DTO y viceversa.

#### -model
Se encuentran todos los modelos utilizados para la aplicacion. 

#### -repository
Se encuentran los repositorios asociados a la aplicacion.

#### Para los usuarios: 

Obtenemos los usuarios desde un archivo JSON el cual, traslada todos los usuarios cargados. Se organizan en un HashMap con la estructura <Integer,Usuarios> , donde la clave es el id del usuario.

#### Para el repositorio de followers:

Almacenamos la informacion de la siguiente manera:
Tenemos un HashMap <Integer,Followers> en el cual la clave es el Id del usuario.


#### -service
Se encuentran los servicios asociados a la aplicacion

## Detalles de las User Stories:

## US-0001 - FollowUser
Tanto compradores como vendedores podrán seguir a cualquier tipo de usuario por la consideracion tomada de que todo usuario puede seguir a otro usuario.

### Método: 
POST
### Endpoint: 
localhost:8080/users/{user_id}/follow/{user_id_to_follow}
### Response:

200 - OK

400 - BAR REQUEST

Puede arrojar un status code 400 por alguna de las siguientes opciones:

- El usuario ya sigue al usuario con id proveniente de: user_id_to_follow.
- Si el usuario con "user_id" intenta seguirse a si mismo.
- El usuario a seguir o el usuario que este intentando seguir no se encuentren registrados (es decir, en el archivo Json).

## US-0002 - Cantidad seguidores
Nos devuelve la cantidad de usuarios que siguen a un determinado usuario.

### Método: GET

### Endpoint: 
localhost:8080/users/{user_id}/followers/count

### Response:

200 - OK

Respuesta Json con formato indicado en la US.
400 - BAD REQUEST

Nos devuelve un código 400 en caso de:

- No encontrar al usuario enviado por parametro.

## US-0003 ¿Quien me sigue?
Nos devuelve una lista de usuarios que siguen al usuario enviado mediante el request.

### Método: 
GET

### Endpoint:
localhost:8080/users/{user_id}/followers/list

### Response:
200 - OK

Cadena JSON con la lista de seguidores
400 - BAD REQUEST

- No encontrar al usuario enviado por parametro.

Por defecto, se devuelve la lista de seguidores ordenada de manera descendente. 

## US-0004 ¿A quién sigo?

### Método:
GET

### Endpoint:
localhost:8080/users/{user_id}/followeds/list

### Response:
200 - OK

Cadena JSON con la lista de seguidos
400 - BAD REQUEST

- No encontrar al usuario enviado por parametro.

Este método, por defecto, no realiza un ordenamiento en la lista. En la US 0008 se configura el ordenamiento.

## US-0005 Alta de publicación
Consiste en dar de alta una nueva publicación. El payload requerido es una cadena JSON en el body del request HTTP. 
Dicho endpoint es necesario agregar los campos solicitados en el documento de especificación de requerimientos.

### Método: 
POST

### Endpoint: 
localhost:8080/products/newpost

### Body: 
Sentencia JSON con los datos correspondientes

### Response:
200 - OK

400 - BAD REQUEST

## US-0006 Listado de publicaciones de los vendedores seguidos por un usuario.
Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).

### Método: 
GET

### Endpoint: 
localhost:8080/products/followed/{user_id}/list

### Body: 
Sentencia JSON con los datos correspondiente.

### Response:

200 - OK

Lista de publicaciones con menos de dos semanas de antiguedad de los vendedores que el usuario enviado por parametro sigue.. 
Si los vendedores no poseen publicaciones vigentes o el usuario no sigue a ningun vendedor, mostrara un JSON con el usuario y una lista de posts vacía.

400 - BAD REQUEST

- No encontrar al usuario enviado por parametro.



## US-0007 Unfollow
Permite a los usuarios dejar de seguir vendedores/compradores (un usuario).

### Método: 
POST

### Endpoint: 
localhost:8080/users/{user_id}/unfollow/{user_id_to_unfollow}

### Body: 
Sentencia JSON con los datos correspondiente.

### Response:

200 - OK

400 - BAD REQUEST

Errores definidos para este request:

Si el user_id no existe: "El usuario al cual se intenta identificar no se encuentra registrado."

Si el user_id_to_unfollow no existe: "Se ha registrado un problema al intentar buscar al vendedor seguido por el usuario ingresado."

Si el user_id no sigue al usuario que busca dejar de seguir: "El usuario solicitado no se encontraba siguiendo al usuario solicitado"


## US-0008 Ordenamiento por nombre
Esta requerimiento solicita ordenar por nombre de usuario (ya sea ascendente o descendente) al momento de realizar las user stories 0003 y 0004.

### Método: 
GET

### Endpoints:

Corresponden a los mismos endpoints de las US-0003 y US-0004, solo que debe añadirse este nuevo parémtro

localhost:8080/users/{user_id}/followers/list?order=name_asc
localhost:8080/users/{user_id}/followers/list?order=name_desc
localhost:8080/users/{user_id}/followed/list?order=name_asc
localhost:8080/users/{user_id}/followed/list?order=name_desc


### Response:

200 - OK

Cadena JSON con los usuarios seguidos/seguidores.
400 - BAD REQUEST

## US-0009 Ordenamiento por fecha
Esta user story es una mejora de la US-0006 y lo que permite hacer es ordenar la lista de publicaciones de los vendedores que sigue un usuario por fecha de manera ascendente o descendente. Se agrega el parámetro order en le cual se debe especificar el tipo de orden que se desea realizar. Si no se envía el parámetro el aplicativo ordenará la lista de manera descendente.

### Método: 
GET

### Endpoints:

En el caso de no especificar el parámetro order, la lista se ordenará de manera descendente.

localhost:8080/products/followed/{user_id}/list?order=date_asc
localhost:8080/products/followed/{user_id}/list?order=date_desc

### Response:

200 - OK

Cadena JSON con las publicaciones de los vendedores.
400 - BAD REQUEST

Usuario inexistente.


# Extra Bonus

## US-0010 Publicación producto en promoción
Para crear una Publicacion con promocion se crea un nuevo objeto que herede de la clase Post (promocion), para no afectar el funcionamiento de los endpoint anteriores. 

### Método: 
POST

### Endpoint: 
localhost:8080/products/promo-post

### Response:

200 - OK


400 - BAD REQUEST

- No encontrar al usuario enviado por parametro.

## US-0011 Cantidad publicaciones en Promoción
Este requerimiento consiste en contar la cantidad de publicaciones con promocion que tiene un determinado usuario.

### Método: 
GET

### Endpoint: 
localhost:8080/products/{user_id}/promo-post/count

### Response:

200 - OK

Retorna un JSON con los datos solicitados en el documento de especificación de requerimientos.
400 - BAD REQUEST

Error: Usuario inexistente

## US-0012 Lista de publicaciones en promoción
Este requerimiento consiste en mostrar las publicaciones QUE SE ENCUENTREN EN PROMOCIÓN por un determinado vendedor.

### Método: 
GET

### Endpoint: 
localhost:8080/products/{user_id}/list

### Response:

200 - OK

Retorna un JSON con los datos solicitados en el documento de especificación de requerimientos.

400 - BAD REQUEST

- No encontrar al usuario enviado por parametro.




