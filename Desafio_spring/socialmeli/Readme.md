# Documentacion

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