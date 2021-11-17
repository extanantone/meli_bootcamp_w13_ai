**** SOCIAL MELI *****

Contamos con 2 usuarios compradores y 2 usuarios vendedores. 
Tener en consideración: 
* Los compradores pueden seguir a los vendedores. 
* Los vendedores pueden publicar un nuevo post. 

ENDPOINTS: 

*Se adjunta link de colección de postman con los distintos endpoints de cada punto del ejercicio:*
--> **https://go.postman.co/workspace/My-Workspace~3f7942cf-cffc-4441-8d82-f3dfbb95fdce/collection/2228514-fb91a167-fe3f-4ce9-941a-b9cbdc61c5b6**

**1.-** *Poder realizar la acción de “Follow” (seguir) a un determinado vendedor:*


* **"/users/{user_id}/follow/{user_id_to_follow}"** --> POST
 
 
**2.-** *Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor:*

* **"/users/{user_id}/followers/count"** --> GET


**3.-** *Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?):*

* **"/users/{user_id}/followers/list"** --> GET

* **"/users/{user_id}/followed/list?order=name_asc"** --> GET

* **"/users/{user_id}/followed/list?order=name_desc"** --> GET


**4.-** *Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?):*

* **"/users/{userId}/followed/list"** --> GET

* **"/users/{userId}/followed/list?order=name_asc"** --> GET

* **"/users/{userId}/followed/list?order=name_desc"** --> GET


**5.-** *Dar de alta una nueva publicación:*

* **"/products/post"**  --> POST

*BODY:*

*{
    "user_id": 3,
    "post_id": 45,
    "date": "23-11-2021",
    "categoria": 24,
    "precio": 3800.00, 
    "detalle": {
        "item_id": 224, 
        "item_name": "Escoba",
        "type": "trapeador"
    }
}*

**6.-** *Obtener un listado de las publicaciones realizadas en las últimas dos semanas, por los vendedores que un usuario sigue (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero):*

* **"/products/followed/{user_id}/list"** --> GET

* **"/products/followed/{user_id}/list?order=date_asc"** --> GET

* **"/products/followed/{user_id}/list?order=date_desc"** --> GET


**7.-** *Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor:*

* **"/users/{user_id}/unfollow/{user_id_to_unfollow}"** --> POST
