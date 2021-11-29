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

Para incorporar las validaciones correspondientes al proyecto fue necesario realizar los siguientes pasos en el código:

1. Se han agregado las dependecias necesarias para poder utilizar las validaciones.
   Las dependencias incluidas han sido las siguientes:
   <dependency>
   <groupId>org.modelmapper</groupId>
   <artifactId>modelmapper</artifactId>
   <version>2.4.2</version>
   </dependency>
   <dependency>
   <groupId>javax.validation</groupId>
   <artifactId>validation-api</artifactId>
   <version>2.0.1.Final</version>
   </dependency>
   <dependency>
   <groupId>org.hibernate.validator</groupId>
   <artifactId>hibernate-validator</artifactId>
   <version>6.0.13.Final</version>
   </dependency>
   <dependency>
   <groupId>org.glassfish</groupId>
   <artifactId>javax.el</artifactId>
   <version>3.0.0</version>
   </dependency>
   <dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-validation</artifactId>
   </dependency>
1. Se han agregado las validaciones correspondientes para cada variable de los DTO afectados por las validaciones solicitadas.
1. En el controlador se ha agregado el llamado @Valid dentro de la llamada al servicio que hace referencia a realizar una nueva publicación de forma tal que ejecute las validaciones correspondientes.
1. Se ha creado un DTO "ErrorDTO" el cual se mostrará los mensajes asociados a cada una de las validaciones el cual será llamado cuando se genere la excepción **"MethodArgumentNotValidException"**.

*Nota:*
- Los DTO's afectados fueron PostDTO y DetailDTO
- Dentro de PostDTO se ha agregado @Valid sobre el atributo de tipo DetailDTO ya que es necesario para que ejecute las validaciones de sus atributos.

------------


#### **TEST UNITARIOS**

- Para llevar a cabo los test unitarios, dentro de la carpeta test se ha creado un paquete llamado service. Con esto se hace referencia a que los tests unitarios serán realizados mockeando los datos del repository e inyectándolos dentor del service del sistema, específicamente dentro de la clase UserServiceTest.

- Fue necesario crear una nueva excepción "NoValidOrderException" la cual se ejecutará cuando al intentar ordenar alfabéticamente o por fecha pasándo por parámetro un orden no definido, como por ejemplo "name_asc***".

- Se ha agregado un paquete "repository" en el cual se ejecuta un test que permite determinar si pasando un ID de un usuario, el mismo existe o no.




