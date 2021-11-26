# Sprint 1 - SocialMeli - Andrés Martínez

# Decisiones de diseño

## Sobre diferenciar usuarios vendedores:
En el enunciado se observa que en lo que respecta a *"seguir"* a un usuario, siempre se hace referencia a seguir a un **vendedor** (Ej: *Obtener el resultado de la cantidad de usuarios que siguen a un determinado "**vendedor**"*). Razón por la cual tomé la decisión de discriminar entre usuarios comunes y usuarios vendedores, la manera de llevar esto a código fue agregar a la entidad ***User*** un atributo booleano llamado "***isSeller***" (si dicho atributo es TRUE, el usuario será un usuario vendedor). Vale aclarar también, que en la aplicación se agregaron validaciones para que los usuarios no puedan seguir a usuarios NO vendedores, como así también validaciones para que sólo usuarios vendedores puedan realizar publicaciones, o que sólo a usuarios vendedores se le puedan obtener sus seguidores.

## Sobre relacionar usuarios con sus seguidos y seguidores
Con respecto a cómo modelar las relaciones entre usuarios y sus seguidores y seguidos; la primera idea fue implementar dos listas en la entidad ***User***, una para los *followers* y otra para los *followeds*. Pero rápidamente descarté esta opción ya que de esa manera, estaría replicando información, lo cual no me pareció del todo correcto. Es por esto que decidí implemetar en la entidad ***User*** sólo la lista (***followeds***) de los usuarios a los que sigue el usuario en cuestión. Si bien resigno un poco de simplicidad al hacer ciertas operaciones (por ejemplo, dado un usuario obtener sus seguidores), gano capacidad de almacenaje (pensando en un caso real con implementación de BBDD) y aún más importante, no quedo atado a modificar en dos lugares distintos (lista *Followeds* de un usuario, y lista *Followers* del otro usuario) cada vez que necesito agregar o eliminar un seguidor.

## Sobre las respuestas al usuario de la API
Para lanzar los mensajes a los usuarios (de éxito o de error), se encapsula un *String* dentro de un *DTO* (**ResponseDTO**) de manera que todas las salidas de la API sean en formato *JSON*.

# Comentarios extras
## Sobre archivos de inicialización de datos
Se crearon dos archivos JSON (Users.json y Post.json) para que se puedan declarar los registros iniciales. Estos archivos se leen y se utilizan para cargar los HashMap en los respectivos repositorios.

## Sobre validaciones

* En el servicio de User, se valida:
	* Que existan los usuarios con los cuales operar.
	* Si un usuario A sigue o no a un usuario B actualmente.
	* Si se trata del mismo usuario, cuando se quiere que A siga o deje de seguir a B.
	* Si el usuario con el que se quiere operar es vendedor o no.


* En el servicio de Post, se valida:
	* Que existan los usuarios con los cuales operar.
	* Que no exista previamente un post con un determinado id.
	* Que a las publicaciones sólo las puedan hacer usuarios vendedores.
	* Que al crear una publicación de promoción, se hayan brindado los valores de *'has_promo'* y *'discount'.*

## Sobre colección de Postman 
Se agrega un archivo .json (***doc/Sprint1 - martinez_andres.json***) para importar la colección de Postman a fin de tener los request para interactuar con la API.