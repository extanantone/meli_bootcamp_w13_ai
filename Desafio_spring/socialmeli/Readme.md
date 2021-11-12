# Documentacion

## Follow user

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