## # **REQUERIMIENTOS TÉCNICOS FUNCIONALES DEL SISTEMA**

- *US-0001:* Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
- *US-0002:* Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
- *US-0003:* Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
- *US-0004:* Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
- *US-0005:* Dar de alta una nueva publicación.
- *US-0006:* Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
- *US-0007:* Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
- *US-0008:* Ordenamiento alfabético ascendente y descendente.
- *US-0009:* Ordenamiento por fecha ascendente y descendente.


------------

#### **VALIDACIONES**

Para incorporar las validaciones correspondientes al proyecto fue necesario realizar los siguientes cambios en el código:

1. Se han agregado la dependencia **"spring-boot-starter-validation"**, necesaria para poder utilizar las validaciones.
1. Se han agregado las validaciones correspondientes para cada variable de los DTO que fue requerido validar.
1. En el controlador se ha agregado la notacion @Valid dentro de la llamada al servicio, que hace referencia a realizar una nueva publicación de forma tal que ejecute las validaciones correspondientes.
1. Se ha creado un DTO "ErrorDTO" el cual mostrará los mensajes asociados a cada una de las validaciones. Será llamado cuando se genere la excepción **"MethodArgumentNotValidException"**.

*Nota:*
- Los DTO's afectados fueron PostDTO y DetailDTO.
- En la mayoria de los DTO se han reemplazado las anotaciones **@Getter** y **@Setter** por **@Data**, para facilitar la comparacion de objetos por el valor de sus atributos.
- Dentro de PostDTO se ha agregado **@Valid** sobre el atributo del tipo **DetailDTO** ya que es necesario para que ejecute las validaciones de sus atributos.

------------


#### **TEST UNITARIOS**

- Para llevar a cabo los test unitarios, dentro de la carpeta test se ha creado un paquete llamado service, que incliye la clase **UserServiceTest**. Esta clase contiene los test del service, para los cuales fue necesario mockear algunos métodos del repositorio.
- Tambien se creo un paquete repository, con **UserRepositoryTest** que contiene un par de validaciones simples sobre el metodo **getUser()** del repositorio. En esta clase no fue necesario mockear nada.
- Fue necesario crear una nueva excepción "NoValidOrderException" la cual se lanzará al intentar ordenar alfabéticamente o por fecha, pasándo por parámetro un orden incorrecto, como por ejemplo "name_asc***".




