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

Para detallar más mirá los diagramas en la carpeta de binarios del proyecto.
1. Modelo para almacenar los post.
2. Modelo para almacenar los usuarios.
3. Modelo para almacenar los productos de los post.
4. Modelo para almacenar los post con promoción.
5. Modelo para almacenar las conexiones entre usuarios (quien sigue a quien).

## Ejecutando los endpoints ⚙️

_Podes abrir postman y ejecutar los endpoints de la siguente manera:_

### US 0001: Poder realizar la acción de "Follow" (seguir) a un determinado vendedor 🔩

Ejecuta el siguiente endpoint:

```
127.0.0.1:8080/users/{user_id}/follow/{user_id_to_follow}
```

### US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor 🔩

Ejecuta el siguiente endpoint:

```
127.0.0.1:8080/users/{user_id}/followers/count
```

### US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
🔩

Ejecuta el siguiente endpoint:

```
127.0.0.1:8080/users/{user_id}/followers/list
```

### US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?) 🔩

Ejecuta el siguiente endpoint:

```
127.0.0.1:8080/users/{user_id}/followed/list
```

### US 0005: Dar de alta una nu eva publicación🔩

Ejecuta el siguiente endpoint:

```
127.0.0.1:8080/products/post
```

### US 0006: Obtener un listado de las publicaciones realizadas por los vendedores.🔩

Ejecuta el siguiente endpoint:

```
127.0.0.1:8080/products/followed/{user_id}/list
```

### US 0007: Poder realizar la acción de "Unfollow" (dejar de seguir) a un determinado vendedor. 🔩

Ejecuta el siguiente endpoint:

```
127.0.0.1:8080/users/{user_id}/unfollow/{user_id_to_unfollow}
```

### US 0008: Ordenamiento alfabético ascendente y descendente 🔩

Ejecuta alguno de los siguientes endpoint:

```
127.0.0.1:8080/users/{user_id}/followers/list?order=name_asc
127.0.0.1:8080/users/{user_id}/followers/list?order=name_desc
127.0.0.1:8080/users/{user_id}/followed/list?order=name_asc
127.0.0.1:8080/users/{user_id}/followed/list?order=name_desc

```

### US 0009: Ordenamiento por fecha ascendente y descendente 🔩

Ejecuta el siguiente endpoint:

```
127.0.0.1:8080/products/followed/{user_id}/list?order=date_asc
127.0.0.1:8080/products/followed/{user_id}/list?order=date_desc

```

### US 0010: Llevar a cabo la publicación de un nuevo producto en promoción 🔩

Ejecuta el siguiente endpoint:

```
127.0.0.1:8080/products/promo-post
```

### US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor 🔩

Ejecuta el siguiente endpoint:

```
127.0.0.1:8080/products/{user_id}/promo-post/count
```

### US 0012: Obtener un listado de todos los productos en promoción de un determinado vendedor 🔩

Ejecuta el siguiente endpoint:

```
127.0.0.1:8080/products/{user_id}/list
```

## Despliegue 📦

_Agrega notas adicionales sobre como hacer deploy_

## Construido con 🛠️

_Menciona las herramientas que utilizaste para crear tu proyecto_

* [MapStruct](http://www.mapstruct.org/) - Plug-in para mapear objectos.
* [Spring Boot](https://start.spring.io/) - Motor del proyecto

## Autor ✒️

* **Andrés Felipe Morales Anaya** - *Todero del proyecto* - [GitHub An024Fel](https://github.com/an024fel)

También puedes mirar la lista de todos los [contribuyentes](https://github.com/your/project/contributors) quíenes han participado en este proyecto.

## Licencia 📄

Este proyecto está bajo la Licencia de (MercadoLoibre) y OpenJDK.
