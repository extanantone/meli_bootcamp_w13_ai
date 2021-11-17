# SocialMeli

_Mercado Libre sigue creciendo y para el año que viene  tiene como objetivo empezar a implementar una serie de herramientas que permitan a los compradores y vendedores tener una experiencia totalmente innovadora, en donde el lazo que los una sea mucho más cercano.
La fecha de lanzamiento se aproxima, por lo cual es necesaria la presentación de una versión Beta de lo que va a ser conocido como “SocialMeli”, en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen._

## Comenzando 🚀

_SocialMeli es la solución al desafió del Sprint 1, realizado hasta la historia de usuario numero 12, todos los end points son iguales a los de los requerimientos técnicos, también se agregó manejo de excepciones que sera explicadas a detalle mas adelante._


- **Usuarios en el repositorio:**

  | user_id| user_name | 
  | :---   |:---:|
  | **1**  |usuario uno|
  | **2**  |usuario dos|
  | **3**  |vendedor uno|
| **4**  |vendedor dos|

## End-Points 📋

1. **US 0001:** Poder realizar la acción de "Follow" (seguir) a un determinado vendedor.

   | Method | END-PONT |
            | :---       |     :---:   |
   | **POST**   |  localhost:8080/users/{user_id}/follow/{user_id_to_follow} |
   | **Ejemplo** | localhost:8080/users/1/follow/2 |
   
    * **Excepciones agregadas:** 
      * Ambos usuarios deben existir. 
      * Un usuario no se puede seguir a el mismo.
      * Un usuario no puede seguir dos veces al mismo usuario.


2. **US 0002:** Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor.
  
   | Method | END-PONT |
   | :---       |     :---:   |
   | **GET**   |  localhost:8080/users/{user_id}/followers/count |
   | **Ejemplo** | localhost:8080/users/1/followers/count |

    * **Excepciones agregadas:**
        * El usuario debe existir.




3. **US 0003:** Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)

   | Method | END-PONT |
         | :---        |     :---:   |
   | **GET**   |  localhost:8080/users/{user_id}/followers/list |
   | **Ejemplo**  | localhost:8080/users/1/followers/list |

    * **Excepciones agregadas:**
        * El usuario debe existir.
        

4. **US 0004:** Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)

   | Method | END-PONT |
         | :---        |     :---:   |
   | **GET**   |  localhost:8080/users/{user_id}/followed/list |
   | **Ejemplo**  | localhost:8080/users/1/followed/list |

    * **Excepciones agregadas:**
        * El usuario debe existir.


5. **US 0005:** Dar de alta una nueva publicación

   | Method | END-PONT |
         | :---        |     :---:   |
   | **POST**   |  localhost:8080/products/post |
   | **Ejemplo**  | localhost:8080/products/post |

   **Body**:

   ````
       {
        "user_id":1,
        "id_post":3,
        "date":"01-02-2021",
        "detail":{
            "product_id":2,
            "product_name":"banana",
            "type":"Fruta",
            "brand":"Colombia fruit company",
            "color":"amarillo",
            "notes":"Fresca"
        },
        "category":"32",
        "price":15.2
       }  
   ````
    * **Excepciones agregadas:**
        * El usuario debe existir.
        * No se puede repetir id_post
        * Debe existir un id_post (No null)
        * La estructura Json debe ser correcta (los tipos deben estar bien)
    

6. **US 0006:** Obtener un listado de las publicaciones realizadas por los vendedores que
   un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha,
   publicaciones más recientes primero).

   | Method | END-PONT |
         | :---        |     :---:   |
   | **GET**   |  localhost:8080/products/followed/{user_id}/list |
   | **Ejemplo**  | localhost:8080/products/followed/1/list |

    * **Excepciones agregadas:**
        * El usuario debe existir.

    
7. **US 0007:** Poder realizar la acción de "Unfollow" (dejar de seguir) a un determinado vendedor.

   | Method | END-PONT |
         | :---       |     :---:   |
   | **GET**   |  localhost:8080/users/{user_id}/unfollow/{user_id_to_unfollow}|
   | **Ejemplo** | localhost:8080/users/2/unfollow/1 |

    * **Excepciones agregadas:**
        * Los usuarios deben existir.
        * El usuario debe seguir al otro usuario previamente.


8. **US 0008:** Ordenamiento alfabético ascendente y descendente.

   | Method | END-PONT |
         | :---       |     :---:   |
   | **GET**   |  localhost:8080/users/{user_id}/followers/list|
   | **Ejemplo** | localhost:8080/users/1/followers/list?order=name_asc |
   | **Ejemplo** | localhost:8080/users/1/followers/list?order=name_desc|
   | **GET**   |  localhost:8080/users/{user_id}/followed/list |
   | **Ejemplo** | localhost:8080/users/1/followed/list?order=name_asc |
   | **Ejemplo** | localhost:8080/users/1/followed/list?order=name_desc |

    * **Excepciones agregadas:**
        * El usuario debe existir.
        
    * Nota: Se puede asignar otros valores a order pero solo se tendra en cuenta "name_asc" y "name_desc".
    

9. **US 0009:** Ordenamiento por fecha ascendente y descendente.

   | Method | END-PONT |
      | :---       |     :---:   |
   | **GET**   |  localhost:8080/products/followed/{user_id}/list |
   | **Ejemplo** | localhost:8080/products/followed/1/list?order=date_asc |
   | **Ejemplo** | localhost:8080/products/followed/1/list?order=date_desc |

    * **Excepciones agregadas:**
        * El usuario debe existir.

    * Nota: Se puede asignar otros valores a order pero solo se tendra en cuenta "date_asc" y "date_desc".


10. **US 0010:** Llevar a cabo la publicación de un nuevo producto en promoción.

    | Method | END-PONT |
        | :---        |     :---:   |
    | **POST**   |  localhost:8080/products/promo-post |
    | **Ejemplo**  | localhost:8080/products/promo-post |

    **Ejemplo Body**:

       ````
     {
        "user_id":1,
        "id_post":3,
        "date":"01-02-2023",
        "detail":{
            "product_id":2,
            "product_name":"banana",
            "type":"Fruta",
            "brand":"Colombia fruit company",
            "color":"amarillo",
            "notes":"Delux"
        },
        "category":"32",
        "price":15.2,
        "has_promo":true,
        "discount": 0.25
    }
    ````

    * **Excepciones agregadas:**
        * El usuario debe existir.
        * No se puede repetir id_post
        * Debe existir un id_post (No null)
        * La estructura Json debe ser correcta (los tipos deben estar bien)
    
    * Nota: en caso de no agregar has_promo y/o discount los valores seran false y 0.0 respectivamente.
    

11. **US 0011:** Obtener la cantidad de productos en promoción de un determinado vendedor

    | Method | END-PONT |
        | :---        |     :---:   |
    | **POST**   |  localhost:8080/products/{user_id}/promo-post/count |
    | **Ejemplo**  | localhost:8080/products/1/promo-post/count |

    * **Excepciones agregadas:**
        * El usuario debe existir.
    

12. **US 0012:** Obtener un listado de todos los productos en promoción de un determinado vendedor.

      | Method | END-PONT |
          | :---        |     :---:   |
      | **POST**   |  localhost:8080/products/{user_id}/list |
      | **Ejemplo**  | localhost:8080/products/1/list |
    
    * **Excepciones agregadas:**
      * El usuario debe existir.

## Construido con 🛠️

* Spring Boot - El framework usado
* Maven - Manejador de dependencias


## Autor ✒️

* **Iván René Arévalo Venegas** 