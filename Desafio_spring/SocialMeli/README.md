# SocialMeli

Se contempla desarrollar una API Rest correspondiendo a una plataforma en donde los usuarios van a poder seguir a sus vendedores favoritos y enterarse de las publicaciones de estos.
Los requerimientos técnicos se pueden consultar en [este](https://docs.google.com/document/d/1GACGp97BXSvC0lNNLuPtbLgD0cGLsT-Y) documento.


## Swagger - Documentación de endpoints

Se disponibiliza la documentación de API en Swagger a través de [este](https://app.swaggerhub.com/apis/tomas-wagner/SocialMeli/1.0) link.
Allí podemos encontrar datos de los distintos endpoints generados, incluyendo ejemplos.

## Consideraciones

Los datos de precarga se incluyen en el constructor del repositorio de usuarios, para que se carguen en el momento de instanciar el mismo.

En vez de dos clases Buyer y Seller que hereden de User, se optó por implementar una única clase User, que tenga una bandera isSeller que indique si al usuario se le deben conceder permisos de vendedor (subir publicaciones, ser seguido) o no.

En caso de no encontrar un recurso se devuelve un status code 404 (Not Found. Para todo el resto de excepciones que se levanten, se devuelve un status code 400 (Bad Request).

Se contempla levantar excepciones para:
 - Recurso no encontrado al intentar obtenerlo
 - Recurso ya existente al intentar crearlo
 - Usuario ya siguiendo a otro usuario al intentar dar follow
 - Usuario intentando seguirse a sí mismo
 - Usuario no siguiendo a un usuario al intentar dar unfollow
 - Acción no permitida, al intentar realizar una acción involucrando a un usuario no-vendedor que demande privilegios de vendedor.

En endpoints que contemplen ordenamiento, se optó por no levantar excepciones al llegar un criterio de orden desconocido. En vez, simplemente se devuelve la lista de recursos buscada sin ordenar.

La aplicación se configuró para levantar el servidor en el puerto 3000.
