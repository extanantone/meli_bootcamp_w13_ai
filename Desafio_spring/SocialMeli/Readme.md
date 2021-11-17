# Desafio Sprint 1 SocialMeli

A tener en cuenta para la prueba del proyecto:

- Al iniciar el proyecto se lee un archivo de extension .json donde se carga automaticamente 4 usuarios
- Todos los usuarios pueden seguir y tener seguidores
- Los usuarios tienen el siguiente formato:
- El repository de FindUser devuelve un mensaje cuando no encuentra algun usuario `"El numero de ID: " + user_id + " no fue encontrado"`

`{  
"user_id": 1,  
"user_name":"Anibal Antonelli",
"followers": [],
"followed":[],
"post": []  
}`


## Endpoints

#### US 0001: Poder realizar la acción de "Follow" (seguir) a un determinado vendedor
POST  `/users/{user_id}/follow/{user_id_to_follow}`
RESPONSE `Status Code 200 (todo OK) ` o `
Status Code 400 (Bad Request)`
En caso de que un usuario quiera seguirse a si mismo
RESPONSE `Status Code 400 (Bad Request)
Message: "Un usuario no puede seguirse a si mismo"`


#### US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor

GET  `/users/{user_id}/followers/count`
RESPONSE `{
"user_id": 2,
"user_name": "Gabriela Monzon",
"followers_count": 0
}`

#### US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
GET  `/users/{user_id}/followers/list`
RESPONSE `{
"user_id": 4,
"user_name": "Kevin Sueldo",
"followers": [
{"user_id": 2,
"user_name": "Gabriela Monzon"}
]
}`


#### US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
GET  `/users/{user_id}/followed/list`
RESPONSE `{
"user_id": 4,
"user_name": "Kevin Sueldo",
"followed": [
{"user_id": 2,
"user_name": "Gabriela Monzon"}
]
}`

#### US 0005: Dar de alta una nueva publicación
POST  `/products/post`
PAYLOAD `{  
"user_id": 1235, "id_post": 18,  
"date": "29-04-2021", "detail": {"product_id": 1, "product_name": "Silla Gamer", "type": "Gamer",  
"brand": "Racer",  
"color": "Red & Black",  
"notes": "Special Edition"},  
"category": 100, "price": 1500.50}`
RESPONSE `Status Code 200 (todo OK) ` o `
Status Code 400 (Bad Request)`

#### US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero)
GET  `/products/followed/{user_id}/list`
RESPONSE `{  
"user_id": 4698, "posts": [
{"id_post": 32, "date": "01-05-2021",
"detail": {"product_id": 62,  
"product_name": "Headset RGB Inalámbrico",
"type": "Gamer",  
"brand": "Razer",  
"color": "Green with RGB",  
"notes": "Sin Batería"},  
"category": 120,
"price": 2800.50},
{ "id_post": 18,  
"date": "29-04-2021", "detail": {"product_id": 1, "product_name": "Silla Gamer", "type": "Gamer",  
"brand": "Racer",  
"color": "Red & Black",  
"notes": "Special Edition"},  
"category": 100, "price": 15000.50} ]
}}`

#### US 0007: Poder realizar la acción de "Unfollow" (dejar de seguir) a un determinado vendedor.
POST  `/users/{user_id}/unfollow/{user_id_to_unfollow}`
RESPONSE `Status Code 200 (todo OK) ` o `
Status Code 400 (Bad Request)`

En caso de que un usuario quiera dejar de seguirse a si mismo
RESPONSE `Status Code 400 (Bad Request)
Message: "Un usuario no puede dejar de seguirse a si mismo"`

En caso de que un usuario quiera dejar de seguir a un usuario que no seguia previamente
RESPONSE `Status Code 400 (Bad Request)
Message: "El usuario con el ID: "+user.getUser_id()+" no sigue al usuario con ID : "+userUnfollow.getUser_id()"`



#### US 0008: Ordenamiento alfabético ascendente y descendente
GET
`/users/{user_id}/followers/list?order=name_asc 			/users/{user_id}/followers/list?order=name_desc /users/{user_id}/followed/list?order=name_asc /users/{user_id}/followed/list?order=name_desc`
RESPONSE `Status Code 200 (todo OK) ` o `
Status Code 400 (Bad Request)`


####  US 0009: Ordenamiento por fecha ascendente y descendente
GET `/products/followed/{user_id}/list?order=date_asc /products/followed/{user_id}/list?order=date_desc`
    
RESPONSE `Status Code 200 (todo OK) ` o `
    Status Code 400 (Bad Request)`



## Codigo a mejorar
- Mas validaciones y excepciones
- Limpieza del codigo y refactorizacion para optimizar la API



