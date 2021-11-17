
# SPRING

###US-001

Se crea un archivo "users.json" con cuatro usuarios por defecto, 
en este caso cualquier usuario puede ser cliente y vendedor


Se crea un ResponseDTO que contiene el status del envio y un mensaje 
personalizado. se utiliza en respuestas 200 y 400 como lo requiere el 
ejercicio.

los errores que valida es que existan los usuarios con los dos id que 
llegan por el path, y que los dos id no sean identicos

Se crea un map de usuarios para simular la BD y cada uno de ellos contiene 
dos maps para followers y followed, esto con el fin de facilitar la 
adicion y eliminacion de uno de ellos.

###US-002

Para el conteo de followers se obtiene el size del respectivo map y se 
agrega al dato al respectivo DTO.

###US-003

El map se enlista y se agrega a su respectivo DTO, se realiza el mismo 
procedimiento en US-004

###US-005

Se crea un controller, repositorio y service por post y por user.

Para los post se realiza una lista de los mismos, ya que no hay que editar
ni eliminarlos, solo realizan respectivos filtros. 

se valida que el id del post no se repita.

###US-006

Se obtienen los followed del "user_id" y se filtran los post con cada uno
de ellos con las publicaciones de los ultimos 15 dias. luego se realiza
el respectivo "sort".

###US-008

Los ordenamientos se realizan con un if, validando dichos params, 
si el usuario llega a enviar un "order" distinto, la lista se retorna
igualmente sin ningun tipo de ordenamiento, o en su defecto, con 
los indicados en los puntos anteriores.

##BONUS

"/promo-post" y "/post" tienen la misma funcionalidad,conteo con size y
los respectivos filtros,validando has_promo




