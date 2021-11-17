# SocialMeli 💻

### Objetivos
El objetivo de este desafío es aplicar los contenidos dados hasta el momento durante el BOOTCAMP MeLi (Git, Java y Spring), con la finalidad de poder implementar una API REST a partir de un enunciado propuesto, una especificación de requisitos y documentación anexada.

### Pautas para la actividad
El desafío que se propone a continuación consta de 2 partes:
- Desarrollar una API para un escenario determinado. En el punto A de la siguiente sección se encuentra una descripción detallada del escenario y cada uno de los requerimientos solicitados.

- Bonus. En el caso de que se completen todos los requerimientos establecidos en el punto A y aún se disponga de tiempo, se podrá realizar esta actividad que presenta un mayor nivel de complejidad.

## Features

- Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
- Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
- Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
- Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
- Dar de alta una nueva publicación.
- Obtener un listado de las publicaciones realizadas en las últimas dos semanas, por los vendedores que un usuario sigue (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
- Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.

### Cosas a tener en cuenta
- Todos los usuarios se pueden seguir entre si, asumiendo que pueden convertirse en vendedores
- No pueden seguirse a si mismos
- No pueden seguir al usuario más de una vez.
- No pasar parametros incorrectos

### Testing con Postman
Algunos test generados con postman ![PostmanJson]()

### Diagrama

![Class Diagram](https://raw.githubusercontent.com/extanantone/meli_bootcamp_w13_ai/felipe_cubillos/Desafio_spring/SocialMeli/docs/Diagram.png)
