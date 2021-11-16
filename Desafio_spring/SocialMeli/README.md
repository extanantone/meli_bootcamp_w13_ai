# Documentación de cada endpoint

### Endpoints relacionados a usuarios -/users/{user_id}
* /follow/{user_id_to_follow} Retorna OK (código 200) en caso de éxito
  o un bad request en caso de error, si el error es origen de la ausencia de 
  alguno de los 2 usuarios transferidos en el path, también devuelve un JSON
  indicando cuál fue el usuario inexistente.
  

* /followers/count Retorna status 200 con el número de seguidores en el JSON solicitado, si el usuario
  proporcionado no existe retorna un status 400, indicando en un JSON
  que el usuario no existe
  

* /followers/list Retorna un status 200 con el JSON solicitado, el orden por defecto
  es por orden de llegada a la lista (¿Quién siguió primero?)
  pero se puede especificar si ordenarlos por nombre, ascendente o descendente,
  si se especifica un parámetro orden y no tiene uno de los dos términos correctos,
  devuelve por defecto un orden descendente. En caso de error por usuario no encontrado,
  retorna un status 400 con un JSON indicando el usuario que falló en ser encontrado.
  

* /followed/list Retorna un status 200 con el JSON solicitado, el orden por defecto
  es por orden de llegada a la lista (¿Quién seguí primero?)
  pero se puede especificar si ordenarlos por nombre, ascendente o descendente,
  si se especifica un parámetro orden y no tiene uno de los dos términos correctos,
  devuelve por defecto un orden descendente. En caso de error por usuario no encontrado,
  retorna un status 400 con un JSON indicando el usuario que falló en ser encontrado.
  "order" es, por tanto, un parámetro opcional.
  

* /unfollow/{user_id_to_unfollow} Retorna OK (código 200) en caso de éxito
  o un bad request en caso de error, si el error es origen de la ausencia de
  alguno de los 2 usuarios transferidos en el path, también devuelve un JSON
  indicando cuál fue el usuario inexistente.
  

### Endpoints relacionados a los productos -/products
* /post Retorna OK en caso de éxito. Reporta bad request si el usuario indicado
  para hacer el post no existe con un JSON explicándolo, si el post (el id) ya existe,
  retorna éxito pero no genera ningún cambio.
  

* /followed/{user_id}/list Retorna OK con el JSON especificado, el orden por defecto,
  es de fecha descendente, si se especifica puede solicitarse de forma ascendente,
  en caso de equivocarse en la definición del parámetro "order", también devuelve, por
  defecto en fecha descendente. "order" es, por tanto, un parámetro opcional.