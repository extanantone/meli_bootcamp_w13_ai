# **DOCUMENTACION SOCIAL MELI**

##### SocialMeli es una aplicacióm en la que nuestros usuarios compradores podrán seguir a sus vendedores favoritos, ver publicaciones y promociones

El aplicativo cuenta con 12 puntos bien definidos:

### **US-0001 - Follow**

Tanto compradores como vendedores podrán seguir a cualquier tipo de usuario. Esto fue desarrollado así porque un comprador puede convertirse en vendedor en un futuro.

**Método:** POST

**Endpoint:** localhost:8080/users/{user_id}/follow/user_id_to_follow

**Status:**

`200 - OK:`

`400 - BAR REQUEST` 
* El usuario ya sigue al vendedor vendedor_name.
* No puedes seguirte a ti mismo.
* Usuario inexistente.

### **US-0002 - Cantidad seguidores**

Cuenta la cantidad de usuarios que siguen a un vendedor.

**Método:** GET

**Endpoint:** localhost:8080/users/{user_id}/followers/count

**Status:**

`200 - OK`

* {"user_id" : identificador_usuario,
  
    "name" : "nombre",
  
    "followers_count" : "cantidad_seguidores"
  }
  
`400 - BAD REQUEST`

* Usuario inexistente

### **US-0003 ¿Quien me sigue?**

Lista de seguidores de un usuario


**Método:** GET

**Endpoint:** localhost:8080/users/{user_id}/followers/list

**Status:**

`200 - OK`

* Cadena JSON con la lista de seguidores

`400 - BAD REQUEST`

* Usuario inexistente

Este método ordena la lista de seguidores de manera descendente por defecto. En la historia de usuario US-0008 se verá en detalle dicho requerimiento

### **US-0004 ¿A quién sigo?**

**Método:** GET

**Endpoint:** localhost:8080/users/{user_id}/followeds/list

**Status:**

`200 - OK`

* Cadena JSON con la lista de seguidos

`400 - BAD REQUEST`

* Usuario inexistente

Este método ordena la lista de seguidos de manera descendente por defecto. En la historia de usuario US-0008 se verá en detalle dicho requerimiento

### **US-0005 Alta de publicación**

Este requerimiento consiste en dar de alta una nueva publicación
En este endpoint se debe mandar una cadena JSON en el body del request HTTP.
Dicho endpoint es necesario agregar los campos solicitados en el documento de especificación de requerimientos.


**Método:** POST

**Endpoint:** localhost:8080/products/newpost

**Body:** Sentencia JSON con los datos correspondientes

**Status:**

`200 - OK`

`400 - BAD REQUEST`

### **US-0006 Listado de publicación**

Este requerimiento consiste en obtener la lista de **TODAS** las publicaciones realizadas por un vendedor que se envía por parámetro. Las publicaciones mostradas son aquellas que tienen una fecha de publicacion correspondiente a 15 días previos a la fecha actual. el endpoint tiene un parametro orden que permite ordenar la lista de manera ascendente o descendente por fecha de publicacion. Si el usuario no especifica nada, la lista se ordenará de manera descendente. En la US-0009 se verá en mayor detalle.


**Método:** GET

**Endpoint:** localhost:8080/products/followed/{user_id}/list

**Body:** Sentencia JSON con los datos correspondiente.

**Status:**

`200 - OK`

* Lista de publicaciones de los vendedores que sigue el usuario
Si los vendedores no poseen publicaciones vigentes o el usuario no sigue a ningun vendedor, mostrara un JSON con el usuario y una lista de posts vacía.

`400 - BAD REQUEST`

* Usuario inexistente

### US-0007 Unfollow

Permite a los usuarios dejar de seguir vendedores/compradores.

**Método:** POST

**Endpoint:** localhost:8080/users/{user_id}/unfollow/{user_id_to_unfollow}

**Body:** Sentencia JSON con los datos correspondiente.

**Status:**

Ejemplo: Si el usuario 1 quiere dejar de seguir al usuario 2

`200 - OK` 

* El aplicativo verifica la existencia de ambos usuarios. Luego verifica que el usuario 1 siga al usuario 2. Si cumple con estos requisitos el estatus que devuelve es 200.

`400 - BAD REQUEST`

* Si el usuario 1 no existe --> Usuario inexistente
* Si el usuario 2 no existe --> El vendedor  no existe
* Si 1 no sigue a 2 --> No sigue al vendedor

### US-0008 Ordenamiento por nombre

Esta user story es una mejora de la US-0003 y US-0004. Consiste en ordenar la lista de seguidores/seguidos por nombre de manera ascendente o descendente. Para ello se agregó un nuevo parámetro denominado order, el cual debe especificarse el tipo de ordenamiento que deseamos para la lista.

**Método:** GET

**Endpoints:**

(Corresponden a los mismos endpoints de las US-0003 y US-0004, solo que debe añadirse este nuevo parémtro)

* localhost:8080/users/{user_id}/followers/list?order=name_asc
* localhost:8080/users/{user_id}/followers/list?order=name_desc
* localhost:8080/users/{user_id}/followed/list?order=name_asc
* localhost:8080/users/{user_id}/followed/list?order=name_desc

(*) En el caso de no especificar el parámetro order, la lista se ordenará de manera descendente.

**Status:**

`200 - OK` 

* Cadena JSON con los usuarios seguidos/seguidores.

`400 - BAD REQUEST`

* Usuario inexistente

(*) Los status corresponden a los 6 endpoints, los 4 con parámetro "orden" y los 2 sin parámetro.

### US-0009 Ordenamiento por fecha

Esta user story es una mejora de la US-0006 y lo que permite hacer es ordenar la lista de publicaciones de los vendedores que sigue un usuario por fecha de manera ascendente o descendente. Se agrega el parámetro order en le cual se debe especificar el tipo de orden que se desea realizar. Si no se envía el parámetro el aplicativo ordenará la lista de manera descendente.

**Método:** GET

**Endpoints:**

(*) En el caso de no especificar el parámetro order, la lista se ordenará de manera descendente.

* localhost:8080/products/followed/{user_id}/list?order=date_asc
* localhost:8080/products/followed/{user_id}/list?order=date_desc


**Status:**

`200 - OK`

* Cadena JSON con las publicaciones de los vendedores.

`400 - BAD REQUEST`

* Usuario inexistente.

(*) Los status corresponden a los 3 endpoints, los 2 con parámetro "orden" y aquel sin parámetro.

## Extra Bonus

### US-0010 Publicación producto en promoción

Este requerimiento consiste en crear una nueva publicación, pero esta vez debe estar en promoción, para esto, se debe agregar 2 campos adicionales con respecto a la creación de una publicación adicional, has_promo que corresponde a un boolean y un porcentaje de descuento que corresponde a un double. Para desarrollar este requerimiento se utilizó el mismo DTO que para la US-0006 realizando las modificaciones correspondientes para que ambos trabajen en amronía

**Método:** POST

**Endpoint:** localhost:8080/products/promo-post

**Status:**

`200 - OK`

`400 - BAD REQUEST`
* Usuario inexistente

### US-0011 Cantidad publicaciones en Promoción

Este requerimiento consiste en contar la cantidad de publicaciones que tiene un vendedor.

**Método:** GET

**Endpoint:** localhost:8080/products/{user_id}/promo-post/count

**Status:**

`200 - OK` 
* Retorna un JSON con los datos solicitados en el documento de especificación de requerimientos.

`400 - BAD REQUEST`
* Error: Usuario inexistente

### US-0012 Lista de publicaciones el promoción

Este requerimiento consiste en mostrar las publicaciones **QUE SE ENCUENTREN EN PROMOCIÓN** por un determinado vendedor.

**Método:** GET

**Endpoint:** localhost:8080/products/{user_id}/list

**Status:**

`200 - OK`
* Retorna un JSON con los datos solicitados en el documento de especificación de requerimientos.

`400 - BAD REQUEST`
* Error: Usuario inexistente




