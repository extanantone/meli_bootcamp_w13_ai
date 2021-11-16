# Documentacion


### Dragramas

**Modelo**

![img](model_diagram.jpg)

**Project**

![img](project.jpg)


### Follow user

POST

URL  http://localhost:8080/users/{userid}/follow/{user_to_follow}

Si el ususario no existe envia 404

Ejemplo:

http://localhost:8080/users/1/follow/8

Si no puede seguir a un usuario envia 400

Ejemplo:

http://localhost:8080/users/1/follow/2

Si lo puede seguir envia 200

Ejemplo:

http://localhost:8080/users/1/follow/4

### Count users follow to seller (followers of seller)

GET

URL http://localhost:8080/users/{user_id}/followers/count


Estado correcto

Ejemplo:

http://localhost:8080/users/4/followers/count

Error 404 cuando no existe en usuario

Ejemplo:

http://localhost:8080/users/5/followers/count

Error 400 cuando el usuario no es un vendedor

Ejemplo:

http://localhost:8080/users/1/followers/count

## Lista de seguidores

GET 

URL http://localhost:8080/users/{userId}/followers/list

Correcto

http://localhost:8080/users/3/followers/list

404 si no existe el usuario

http://localhost:8080/users/20/followers/list

400 si no es un vendedor

http://localhost:8080/users/1/followers/list

### Lista de seguidos

GET

URL http://localhost:8080/users/{userId}/followed/list

Correcto

http://localhost:8080/users/1/followed/list

Si el usuario no existe 404

http://localhost:8080/users/20/followed/list

### Add new post

POST

URL http://localhost:8080/products/post

payload

    {
        "user_id": 3,
        "id_post": 18,
        "date": "29-04-2021",
        "detail": {
            "product_id": 1,
            "product_name": "Silla Gamer",
            "type": "Gamer",
            "brand": "Racer",
            "color": "Red & Black",
            "notes": "Special Edition"
        },
        "category": 100,
        "price": 1500.50
    }

If not exist user send 404
    
Payload 

Ejemplo:

    {
    "user_id": 30,
    "id_post": 18,
    "date": "29-04-2021",
    "detail": {
        "product_id": 1,
        "product_name": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
    },
    "category": 100,
    "price": 1500.50
    }

If user is not seller send 400

    {
    "user_id": 1,
    "id_post": 18,
    "date": "29-04-2021",
    "detail": {
        "product_id": 1,
        "product_name": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
    },
    "category": 100,
    "price": 1500.50
    }

If is a seller and not have post with same id send status 200

    {
    "user_id": 3,
    "id_post": 18,
    "date": "29-04-2021",
    "detail": {
        "product_id": 1,
        "product_name": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
    },
    "category": 100,
    "price": 1500.50
    }

if is seller and exist post with same id send 400

### List pushing by user in the last 2 weeks

GET

URL http://localhost:8080/products/followed/{user_id}/list

CORRECTO

http://localhost:8080/products/followed/1/list

404 si no existe el usuario

http://localhost:8080/products/followed/90/list

#### Unfollow user

POST

URL http://localhost:8080/users/{subscriptor}/unfollow/{seller}


400 si el usuario a desincribirse no es seller

404 si el usuario no esta inscrito al seller


### Implements orders in previos listing methods

whatch pdf

### Publish a promo post

POST

URL http://localhost:8080/products/promo-post

Payload

    {
        "user_id": 3,
        "id_post": 18,
        "date": "11-11-2021",
        "detail": {
            "product_id": 1,
            "product_name": "Silla Gamer",
            "type": "Gamer",
            "brand": "Racer",
            "color": "Red & Black",
            "notes": "Special Edition"
        },
        "category": 100,
        "price": 1500.50,
        "has_discount":true,
        "discount":0.25
    }

404 si no existe el usuario

400 si existe un post con el mismo usuario para el usuario dado


### count all promo post

GET

URL http://localhost:8080/products/{seller}/promo-post/count

404 si el usuario no existe
 
400 si el usuario no es seller



### List promo list

GET

URL http://localhost:8080/products/{seller}/list

404 si no existe el usuario


400 si el usuario no es seller

else send 200

