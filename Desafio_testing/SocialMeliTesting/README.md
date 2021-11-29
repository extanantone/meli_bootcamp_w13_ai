# SocialMeLi

_Una red social donde podras compartir informacion con otros vendedores, seguir al día sus mejores publicaciones para no perderte de nada nuevo._

## Para empezar 👨🏼‍💻

_Que necesitas para correr el proyecto en local_

1. Descargar el repo desde https://github.com/extanantone/meli_bootcamp_w13_ai.git en la rama [_morales_andres_]
2. Abrir el proyeto con Intellij desde la carpeta src

### Pre-requisitos 📋

```
Para este proyecto se utilizo una herramienta llamada "MapStruct" 
para generar los mapeadores, por lo que ya viene implementada desde
el archivo build.gradle. Seria conveniente instalar el plugin para el
IDE para explotar su potencial.
```

## Comentarios
El codigo se encuentra parcialmente comentado en bloque, para entender el objetivo de las funciones principales que se
ejecutan en el sistema.

## Arquitectura del proyecto

Realizado siguiendo los estandares adoptados por la industria, aplicando buenas practicas, y lo enseñado por los bootcampers
del W13 Java de MeLi. Seguimos la arq. **M**(odel) **V**(iew) **C**(ontroller) y adoptando:

1. Servicios
    + Implementa toda la logica del negocio e instancia el patron IoC y la DI.
2. Repositorios
    + Adopta la logica del CRUD basica para todos los modelos que almacenan los datos
3. Controladores
    + Expone todos los endpoints de interaccion con el usuario.
4. Data Transfer Objects
    + Implementa la manera de como se entregaran las respuestas del servidor en formato JSON.
5. Excepciones
    + Encapsula los casos en los que el sistema se podria romper y los expone al usuario con mensajes entendibles.
6. Mappers
    + Convierte los modelos a DTO dependiendo la informacion que se quiera exponer.
    
## Modelo de datos

Para detallar más mirá los diagramas en la carpeta de resources del proyecto.
1. Modelo para almacenar los post.
2. Modelo para almacenar los usuarios.
3. Modelo para almacenar los productos de los post.
4. Modelo para almacenar los post con promoción.
5. Modelo para almacenar las conexiones entre usuarios (quien sigue a quien).

## Validadores ⚙️
Se aplicaron validadores a los DTO que ingresaban por medio de Payloads en POST Request.
Adicional a ello, se aplicaron validadores a los PathVariables con la clase import org.springframework.validation.annotation.Validated;
La cual agrega un anotador a la clase del controlador y agrega a cada uno de los endpoints (declarados en la interface) los validadores
correspondientes (p.e. Range, Pattern, etc) entre la declaración del PathVariable y el tipo de dato de la variable. 

## Ejecutando los Test ⚙️

Estas pruebas se realizaron dentro de la capa de servicios, ya que ejecutan la lógica del negocio
necesaria para interpretar las pruebas especificadas en el siguiente documento:
https://docs.google.com/document/d/1C9Jst8qLXTuPieumtqlUyvK7kQiqOcnq/edit

T-0001
Genera dos usuarios aleatorios y los almacena en el repositorio mockeado.
Verificar que el usuario a seguir exista. (US-0001)
Se cumple:
Permite continuar con normalidad.
```
Test: public void followUserThatExist()
```
No se cumple:
Notifica la no existencia mediante una excepción.
```
Test: public void followUserThatNotExist()
```
T-0002
Verificar que el usuario a dejar de seguir exista. (US-0007)
Genera dos usuarios aleatorios y los almacena en el repositorio mockeado, luego elimina la conexion de seguimiento.
Se cumple:
Permite continuar con normalidad.
```
Test: public void followUserThatExist()
```
No se cumple:
Notifica la no existencia mediante una excepción.
```
Test: public void unFollowUserThatNotExist()
```
T-0003
Verificar que el tipo de ordenamiento alfabético exista (US-0008)
Genera dos usuarios aleatorios y los almacena en el repositorio mockeado.
Se cumple:
Permite continuar con normalidad.
```
Test: public void checkThatNameDescSensitiveCaseAlphabeticOrderTypeExist()
```
No se cumple:
Notifica la no existencia mediante una excepción.
Genera un usuario aleatorios y toma su ID para provocar una excepción sobre el tipo de orden.

```
Test: public void checkThatNameAscInsensitiveCaseAlphabeticOrderTypeNotExist()
```
T-0004
Verificar el correcto ordenamiento ascendente y descendente por nombre. (US-0008)
Genera un usuario aleatorio, Luego genera una lista de seguidres aleatoria para simular un posible retorno del repositorio
con Mockito, asi mismo, analiza si el tipo de orden es valido, y en caso positivo, retorna una respuesta.
Cabe anotar que dentro del test se ordena la lista de seguidores generada aleatoriamente.
Devuelve la lista ordenada según el criterio solicitado
```
Test: public void checkThatNameDescSensitiveCaseAlphabeticOrderTypeExist()
```
T-0005
Verificar que el tipo de ordenamiento por fecha exista (US-0009)
Genera un usuario y espera una excepción de orden no valido.
Se cumple:
Permite continuar con normalidad.
```
Test: public void checkDateAscDateOrderTypeExistAndGetSortedList()
```
No se cumple:
Notifica la no existencia mediante una excepción.
```
Test: public void checkThatDateOrderTypeNotExist()
```
T-0006
Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009)
Genera un usuario aleatorio, Luego genera una lista de seguidres aleatoria y una lista de productos aleatoria para simular un posible retorno del repositorio
con Mockito, asi mismo, analiza si el tipo de orden es valido, y en caso positivo, retorna una respuesta.
Cabe anotar que dentro del test se ordena la lista de productos por fecha generada aleatoriamente
Devuelve la lista ordenada según el criterio solicitado
```
Test: public void checkDateAscDateOrderTypeExistAndGetSortedList()
```
T-0007
Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (US-0002)
Devuelve el cálculo correcto del total de la cantidad de seguidores que posee un usuario.
Genera un usuario aleatorio, Luego genera una lista de seguidres aleatoria para simular un posible retorno del repositorio
con Mockito, asi mismo, espera que el conteo de seguidores sea acertivo.
```
Test: public void checkIfFollowersCountIsAssert()
```
T-0008
Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. (US-0006)
Devuelve únicamente los datos de las publicaciones que tengan fecha de publicación dentro de las últimas dos semanas a partir del día de la fecha.
Este emplea el mismo metodo para el T-0006 ya que, desde el servicio, ya retorna los productos filtrados de menos de dos semanas.
```
Test: public void checkDateAscDateOrderTypeExistAndGetSortedList()
```
##Test adicionales
T-0009
Verifica si un usuario existe, pero no sigue a un usuario.
```
Test: public void unFollowUserThatExistButNotFollowsUser()
```

###Test unitarios de los repositorios
####UserRepository
T-0010
Crea un nuevo usuario
Se cumple:
Permite continuar con normalidad.
```
Test: public void createNewUser()
```

T-0011
Eliminar a un usuario
Se cumple:
Permite eliminar al usuario.
```
Test: public void deleteExistingUser()
```
No se cumple:
Si el usuairo no existe, arroja una excepción.
```
Test: public void deleteNotExistingUser()
```
T-0012
Verifica si el usuario previamente insertado existe
Se cumple:
Permite continuar con normalidad.
```
Test: public void findUSerPreviouslyInserted()
```
####UserFollowRepository
T-0013
Crear una nueva conexion entre dos usuarios.
Devuelve la lista ordenada según el criterio solicitado
```
Test: public void createTwoUsersThenFollowThemSelves()
```
T-0014
Crear dos usuarios, que posteriormente se sigan, luego eliminar dicha conexión y 
verificar si el usuario aún sigue dicha cuenta
```
Test: public void CreateTwoUsersFollowThemSelvesThenUnfollow()
```
T-0015
Listar los usuarios que sigue determinada cuenta.
Se cumple:
Permite continuar con normalidad.
```
Test: public void CreateTwoUsersFollowOneOfThemAndThenGetFollowerList()
```
####PromoPostRepository
T-0016
Insertar un nuevo promopost dentro del sistema.
```
Test: public void createNewPromoPostWithOneProduct()
```
T-0017
Eliminar un promopost previamente insertado.
```
Test: public void deleteExistingPost()
```
T-0018
Verificar si un promopost es igual a alguno insertado previamente dentro del sistema.
```
Test: public void findIfPostExistsAndIsEqualsThanWereInserted()
```

####PostRepository
T-0019
Insertar un nuevo post dentro del sistema.
```
Test: public void createNewPromoPostWithOneProduct()
```
T-0020
Eliminar un post previamente insertado.
```
Test: public void deleteExistingPost()
```
T-0021
Verificar si un post es igual a alguno insertado previamente dentro del sistema.
```
Test: public void findIfPostExistsAndIsEqualsThanWereInserted()
```

##Test de integración:
T-0022
Verificar si un usuario sigue exitosamente a otro.
```
Test: public void testFollowUserAndAnalyzeResponse()
```

## Construido con 🛠️

* [MapStruct](http://www.mapstruct.org/) - Plug-in para mapear objectos.
* [Spring Boot](https://start.spring.io/) - Motor del proyecto

## Autor ✒️

* **Andrés Felipe Morales Anaya** - *Todero del proyecto* - [GitHub AnFel024](https://github.com/anfel024)

## Licencia 📄

Este proyecto está bajo la Licencia de (MercadoLibre) y OpenJDK.
