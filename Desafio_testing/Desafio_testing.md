# SocialMeli

Esta API emula comportamientos que se generan entre usuarios de Meli que pueden ser:

- Seguir otros usuarios de Meli
- Realizar publicaciones de productos
- Listar publicaciones de usuarios

En La ubicacion SocialMeli/doc se puede encontrar un Postman de la coleccion de peticiones.

## Seguir (POST)

Un usuario puede seguir a otro.

### Endpoint

localhost:8080/users/{user_id}/follow/{user_id_to_follow}

### Posibles Respuestas

- ```json {
    "code": "200", 
    "message": "OK"
- ```json {
    "errorCode": "400",
    "errorMessage": "El usuario no puede seguirse a si mismo"
- ```json {
    "errorCode": "404",
    "errorMessage": "Usuario no encontrado id: X"
- ```json {
    "errorCode": "500",
    "errorMessage": "Error Interno del Servidor"
## Dejar de seguir (POST)

Un usuario puede dejar de seguir a otro.

### Endpoint

localhost:8080/users/{user_id}/unfollow/{user_id_to_follow}

### Posibles Respuestas

- ```json {
    "code": "200", 
    "message": "OK"
- ```json {
    "errorCode": "400",
    "errorMessage": "El usuario no puede dejar de seguirse a si mismo"
- ```json {
    "errorCode": "404",
    "errorMessage": "Usuario no encontrado id: X"
- ```json {
    "errorCode": "500",
    "errorMessage": "Error Interno del Servidor"
## Cantidad de seguidores (GET)

Muestra la cantidad de seguidores que tiene un usuario.

### Endpoint

localhost:8080/users/{user_id}/followers/count

### Posibles Respuestas

- ```json {
    "user_id": 1,
    "user_name": "lozano1",
    "followers_count": 1
- ```json {
    "errorCode": "404",
    "errorMessage": "Usuario no encontrado id: X"
## Lista de seguidores (GET)

Muestra la lista de seguidores que tiene un usuario.

### Endpoint

localhost:8080/users/{user_id}/followers/list?order=name_desc

### Posibles Respuestas

- ```json {
    "followers": [
        {
            "user_id": 2,
            "user_name": "lozano2"
        }
    ],
    "user_id": 1,
    "user_name": "lozano1"
- ```json {
    "errorCode": 400,
    "errorMessage": "Valor ilegal para el request param order."
- ```json {
    "errorCode": 404,
    "errorMessage": "Usuario no encontrado id: 100"
## Lista de seguidos (GET)

Muestra la lista de seguidos que tiene un usuario.

### Endpoint

localhost:8080/users/{user_id}/followed/list?order=name_desc

### Posibles Respuestas

- ```json {
    "followed": [
        {
            "user_id": 2,
            "user_name": "lozano2"
        }
    ],
    "user_id": 1,
    "user_name": "lozano1"
- ```json {
    "errorCode": 400,
    "errorMessage": "Valor ilegal para el request param order."
- ```json {
    "errorCode": 404,
    "errorMessage": "Usuario no encontrado id: 100"
## Dar de alta una publicacion (POST)

Crea un publicacion de acuento a la informacion enviada en el body.

### Endpoint

localhost:8080/products/post

### Payload

```json 
{
  "user_id": 3,
  "id_post": null,
  "date": "16-11-2021",
  "detail": {
    "product_id": 9,
    "product_name": "Silla Geimer",
    "type": "Geimer",
    "brand": "Racer",
    "color": "Red & Black",
    "notes": "Xpecial Edition"
  },
  "category": 100,
  "price": 1500.50,
  "has_promo": true,
  "discount": 0.5
}
```

### Posibles Respuestas

- ```json {
    "post_id": 7
- ```json {
    "errorCode": 400,
    "errorMessage": "Missing Body Attribute"
- ```json {
    "errorCode": 404,
    "errorMessage": "Usuario no encontrado id: 100"
## Lista de publicaciones de seguidos (GET)

Muestra la lista de publicaciones realizadas en las ultimas dos semanas por los seguidos que tiene un usuario.

### Endpoint

localhost:8080/products/followed/{user_id}/list?order=date_desc

### Posibles Respuestas

- ```json {
    "posts": [
        {
            "date": "2021-11-15",
            "detail": {
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red & Black",
                "notes": "Special Edition",
                "product_id": 1,
                "product_name": "Silla Gamer"
            },
            "category": 100,
            "price": 15000.5,
            "discount": 0.25,
            "post_id": 1,
            "has_promo": true
        },
        {
            "date": "2021-11-14",
            "detail": {
                "type": "Gamer",
                "brand": "Razer",
                "color": "Green with RGB",
                "notes": "Sin Batería",
                "product_id": 62,
                "product_name": "Headset RGB Inalámbrico"
            },
            "category": 120,
            "price": 2800.69,
            "discount": 0.1,
            "post_id": 2,
            "has_promo": true
        }
    ],
    "user_id": 2
- ```json {
    "errorCode": 400,
    "errorMessage": "Valor ilegal para el request param order."
- ```json {
    "errorCode": 404,
    "errorMessage": "Usuario no encontrado id: 100"
## Cantidad de publicaciones en promocion de usuario (GET)

Muestra la cantidad de publicaciones en promocion de usuario.

### Endpoint

localhost:8080/products/{user_id}/promo-post/count

### Posibles Respuestas

- ```json {
    "user_id": 1,
    "user_name": "lozano1",
    "promo_products_count": 4
- ```json {
    "errorCode": 404,
    "errorMessage": "Usuario no encontrado id: 100"
## Lista de publicaciones en promocion de usuario (GET)

Muestra la lista de publicaciones en promocion de usuario.

### Endpoint

localhost:8080/products/{user_id}/promo-post/list?order=date_asc

### Posibles Respuestas

- ```json {
    "posts": [
        {
            "date": "2021-11-15",
            "detail": {
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red & Black",
                "notes": "Special Edition",
                "product_id": 1,
                "product_name": "Silla Gamer"
            },
            "category": 100,
            "price": 15000.5,
            "discount": 0.25,
            "post_id": 1,
            "has_promo": true
        },
        {
            "date": "2021-11-14",
            "detail": {
                "type": "Gamer",
                "brand": "Razer",
                "color": "Green with RGB",
                "notes": "Sin Batería",
                "product_id": 62,
                "product_name": "Headset RGB Inalámbrico"
            },
            "category": 120,
            "price": 2800.69,
            "discount": 0.1,
            "post_id": 2,
            "has_promo": true
        }
    ],
    "user_id": 1,
    "user_name": "lozano1"
- ```json {
    "errorCode": 400,
    "errorMessage": "Valor ilegal para el request param order."
- ```json {
    "errorCode": 404,
    "errorMessage": "Usuario no encontrado id: 100"
## Tests

Se realizaron test unitarios y de integracion para tener un coverage del 100% en el paquete de servicio y utilitarios. La unica consideracion es que el servicio de dar de alta un post no recibe el id en la request.