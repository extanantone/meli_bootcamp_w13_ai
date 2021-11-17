# SocialMeli

Consideraciones:
- Todas las ids son generadas automáticamente sin tener en cuenta las enviadas en el body.
- Todos los usuarios son vendedores y pueden ser seguidos o seguir a cualquier otro.
- A pesar de tener creado el endpoint para la creacion de los promo post, el endpoint por defecto está preparado para que si se envía el valor de has_promo: true, tomar ese post como una promo.

## ToDo

- Agregar un parametro a los get de post de los usuarios seguidos para poder obtener solo los promo post.
- Modificar los fors por maps y filters
- Optimizar algunos metodos extrayendo líneas de códigos a metodos más genericos
- Manejar error en el caso de no enviar algun parametro requerido en el body
## Usuarios base

Los usuarios se crean en el repositorio de usuarios:
Por defecto solo se crean esos 4 y no existe ningun tipo de relacion entre ellos

```java
        // creación de usuarios
        User user2 = new User("Sofia");
        User user3 = new User("Tomas");
        User user4 = new User("Andres");
        User user1 = new User("Santiago");
        // Guardo los usuarios en mi "db"
        users.put(user1.getUserId(),user1);
        users.put(user2.getUserId(),user2);
        users.put(user3.getUserId(),user3);
        users.put(user4.getUserId(),user4);
```

## End point extra
GET /users:
- Retorna una lista de todos los usuarios del sistema

GET /products/{user_id}/promo-post?order={criterio}

El parametro order puede ser uno de los siguientes Strings:
- date_asc: ordena por fecha de la publicacion de forma ascendente
- date_desc: ordena por fecha de la publicacion de forma descendente
- name_asc: ordena por nombre del producto de forma ascendente
- name_desc: ordena por nombre del producto de forma descendente
 