#Desafio Sprint 1: Git, Java y Sprint.

####Pablo Guayta - Software developer.

##Introduccion

Este repositorio cuenta con la resolución del desafio 1 del Bootcamp.

Este desafio consiste en la implementación de una versión Beta de lo que va a ser conocido como “SocialMeli”, en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.

Por lo tanto, en este documento vamos a detallar las consideraciones que se tuvieron al momento de hacer este desafio.

##Consideraciones

Para este sistema tuvimos las siguientes consideraciones:

- Todos los usuarios que utilicen este sistema se representan mediante la clase modelo "Usuarios". Se tomo esta consideracion debido a que consideramos que todo usuario puede seguir a otro usuario debido a que se puede utilizar la misma cuenta de un usuario para pasar de ser solo un "comprador" a un "vendedor".
- Los datos iniciales de los usuarios se levantan desde el repository de Usuarios.


##Estructura del proyecto
El proyecto se ha separado en la siguiente estructura de paquetes:

####-comporator
Aqui se encuentran las clases tipo "Comparator" utilizadas para ordenar los response de determinados endpoints. Se encuentran las clases de ordenamiento ascendente y descendiente para el nombre de los usuarios y la fecha de las publicaciones.

####-controller
Se encuentran los controller de la aplicacion. Se separan en:
-FollowerController: administra todos los endpoints referidos a usuarios seguidos y seguidores de un usuario.
-PostController: administra todos los endpoints referidos a publicaciones de los usuarios.
-PromoPostController: administra todos los endpoints referidos a publicaciones con promocion de los usuarios.

####-dto
Se encuentran todos los DTOs utilizados para la aplicación. Dentro se encuentran dos paquetes por distintos tipos de DTO:
-controllerToService: todos los DTO recibidos por el controlador o que son enviados al service.
-serviceToController: todos los DTO que son enviados desde el service al controlador para responder.


####-exception
Paquete donde se manejan las excepciones de la aplicacion.

####-mapper
Se encuentran los mapper utilizados en la aplicacion. Se utilizan para mapear los modelos de la aplicacion a sus correspondientes DTO y viceversa.

####-model
Se encuentran todos los modelos utilizados para la aplicacion. 

Los principales son:

-Followers

-Post

-Product

-PromoPost

-Usuarios

####-repository
Se encuentran los repositorios asociados a la aplicacion.

####-service
Se encuentran los servicios asociados a la aplicacion

##Detalles de las User Stories:

##US-0001 - FollowUser
Tanto compradores como vendedores podrán seguir a cualquier tipo de usuario por la consideracion tomada de que todo usuario puede seguir a otro usuario.

###Método: 
POST
###Endpoint: 
localhost:8080/users/{user_id}/follow/{user_id_to_follow}
###Response:

200 - OK

400 - BAR REQUEST

Puede arrojar un status code 400 por alguna de las siguientes opciones:

-El usuario ya sigue al usuario con id proveniente de: user_id_to_follow.
-Si el usuario con "user_id" intenta seguirse a si mismo.

##US-0002 - Cantidad seguidores
Nos devuelve la cantidad de usuarios que siguen a un determinado usuario vendedor.

###Método: GET

###Endpoint: 
localhost:8080/users/{user_id}/followers/count

###Response:

200 - OK

{"user_id" : identificador_usuario,

"name" : "nombre",

"followers_count" : "cantidad_seguidores" }

400 - BAD REQUEST


##US-0003 ¿Quien me sigue?
Nos devuelve una lista de usuarios que siguen al usuario enviado mediante el request.

###Método: 
GET

###Endpoint:
localhost:8080/users/{user_id}/followers/list

###Response:
200 - OK

Cadena JSON con la lista de seguidores
400 - BAD REQUEST


Por defecto, se devuelve la lista de seguidores ordenada de manera descendente. 

##US-0004 ¿A quién sigo?

###Método:
GET

###Endpoint:
localhost:8080/users/{user_id}/followeds/list

###Response:
200 - OK

Cadena JSON con la lista de seguidos
400 - BAD REQUEST

Usuario inexistente
Este método, por defecto, no realiza un ordenamiento en la lista. En la US 0008 se configura el ordenamiento.

##US-0005 Alta de publicación
Consiste en dar de alta una nueva publicación. El payload requerido es una cadena JSON en el body del request HTTP. 
Dicho endpoint es necesario agregar los campos solicitados en el documento de especificación de requerimientos.

###Método: 
POST

###Endpoint: 
localhost:8080/products/newpost

###Body: 
Sentencia JSON con los datos correspondientes

###Response:
200 - OK

400 - BAD REQUEST

##US-0006 Listado de publicaciones de los vendedores seguidos por un usuario.
Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).

###Método: 
GET

###Endpoint: 
localhost:8080/products/followed/{user_id}/list

###Body: 
Sentencia JSON con los datos correspondiente.

###Response:

200 - OK
Lista de publicaciones de los vendedores que sigue el usuario. 
Si los vendedores no poseen publicaciones vigentes o el usuario no sigue a ningun vendedor, mostrara un JSON con el usuario y una lista de posts vacía.

400 - BAD REQUEST


##US-0007 Unfollow
Permite a los usuarios dejar de seguir vendedores/compradores (un usuario).

###Método: 
POST

###Endpoint: 
localhost:8080/users/{user_id}/unfollow/{user_id_to_unfollow}

###Body: 
Sentencia JSON con los datos correspondiente.

###Response:

Ejemplo: Si el usuario 1 quiere dejar de seguir al usuario 2

200 - OK

400 - BAD REQUEST

Si el usuario 1 no existe --> Usuario inexistente
Si el usuario 2 no existe --> El vendedor no existe
Si 1 no sigue a 2 --> No sigue al vendedor


##US-0008 Ordenamiento por nombre
Esta requerimiento solicita ordenar por nombre de usuario (ya sea ascendente o descendente) al momento de realizar las user stories 0003 y 0004.

###Método: 
GET

###Endpoints:

(Corresponden a los mismos endpoints de las US-0003 y US-0004, solo que debe añadirse este nuevo parémtro)

localhost:8080/users/{user_id}/followers/list?order=name_asc
localhost:8080/users/{user_id}/followers/list?order=name_desc
localhost:8080/users/{user_id}/followed/list?order=name_asc
localhost:8080/users/{user_id}/followed/list?order=name_desc


###Response:

200 - OK

Cadena JSON con los usuarios seguidos/seguidores.
400 - BAD REQUEST

##US-0009 Ordenamiento por fecha
Esta user story es una mejora de la US-0006 y lo que permite hacer es ordenar la lista de publicaciones de los vendedores que sigue un usuario por fecha de manera ascendente o descendente. Se agrega el parámetro order en le cual se debe especificar el tipo de orden que se desea realizar. Si no se envía el parámetro el aplicativo ordenará la lista de manera descendente.

###Método: 
GET

###Endpoints:

(*) En el caso de no especificar el parámetro order, la lista se ordenará de manera descendente.

localhost:8080/products/followed/{user_id}/list?order=date_asc
localhost:8080/products/followed/{user_id}/list?order=date_desc
Status:

200 - OK

Cadena JSON con las publicaciones de los vendedores.
400 - BAD REQUEST

Usuario inexistente.
(*) Los status corresponden a los 3 endpoints, los 2 con parámetro "orden" y aquel sin parámetro.

#Extra Bonus

##US-0010 Publicación producto en promoción
Este requerimiento consiste en crear una nueva publicación, pero esta vez debe estar en promoción, para esto, se debe agregar 2 campos adicionales con respecto a la creación de una publicación adicional, has_promo que corresponde a un boolean y un porcentaje de descuento que corresponde a un double. Para desarrollar este requerimiento se utilizó el mismo DTO que para la US-0006 realizando las modificaciones correspondientes para que ambos trabajen en amronía

##Método: 
POST

##Endpoint: 
localhost:8080/products/promo-post

##Response:

200 - OK

400 - BAD REQUEST

Usuario inexistente

##US-0011 Cantidad publicaciones en Promoción
Este requerimiento consiste en contar la cantidad de publicaciones que tiene un vendedor.

###Método: 
GET

##Endpoint: 
localhost:8080/products/{user_id}/promo-post/count

##Response:

200 - OK

Retorna un JSON con los datos solicitados en el documento de especificación de requerimientos.
400 - BAD REQUEST

Error: Usuario inexistente
##US-0012 Lista de publicaciones el promoción
Este requerimiento consiste en mostrar las publicaciones QUE SE ENCUENTREN EN PROMOCIÓN por un determinado vendedor.

##Método: 
GET

##Endpoint: 
localhost:8080/products/{user_id}/list

##Response:

200 - OK

Retorna un JSON con los datos solicitados en el documento de especificación de requerimientos.
400 - BAD REQUEST

Error: Usuario inexistente




