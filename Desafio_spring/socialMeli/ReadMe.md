# Social MeLi

### INTRODUCCIÓN

Mercado Libre sigue creciendo y para el año que viene tiene como objetivo empezar a 
implementar una serie de herramientas que permitan a los compradores y vendedores tener
una experiencia totalmente innovadora, en donde el lazo que los una sea mucho más cercano.
Por lo cual es necesaria la presentación de una versión Beta de lo que va a ser conocido 
como “SocialMeli”, en donde los compradores van a poder seguir a sus vendedores favoritos
y enterarse de todas las novedades que los mismos posteen.

### REQUERIMIENTOS DEL SISTEMA:

1. **US 0001:** Poder realizar la acción de "Follow" (seguir) a un determinado vendedor.

    * **Restricciones:** En el sistema se tienen 2 tipos de usuario, Purchaser(comprador)
    y Seller(vendedor). Dado lo anterior, un usuario comprador solo podrá seguir a un usuario vendedor
    y un usuario vendedor solo podrá ser seguido. Por otro lado, los usuarios deben existir previamente
    en el repositorio. Adicionalmente, un usuario no podrá seguir multiples veces a otro usuario.
    
    - **Usuarios en el repositorio:**
           
        | id_user| Rol | 
        | :---   |:---:|
        | **1**  |Comprador|
        | **2**  |Comprador|
        | **3**  |Comprador|
        | **4**  |Vendedor|
        | **5**  |Vendedor|
    
    * **Entradas:**
   
      | Method | END-PONT |
      | :---       |     :---:   |
      | **POST**   |  [localhost:8080/users/{user_id}/follow/{user_id_to_follow}]() |
      | **Ejemplo** | [localhost:8080/users/1/follow/4]() |
    
3. **US 0002:** Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor.

    * **Restricciones:** Dada la restricción del requerimiento US0001, el id ingresado deberá
    corresponder al de un usuario vendedor y deberá existir previamente en el repositorio,
    en caso contrario se lanzará una excepción.
   
    * **Entradas:**

      | Method | END-PONT |
      | :---       |     :---:   |
      | **POST**   |  [localhost:8080/users/{user_id}/followers/count]() |
      | **Ejemplo** | [localhost:8080/users/4/followers/count]() |

4. **US 0003:** Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)

    * **Restricciones:** Dada la restricción del requerimiento US0001, el id ingresado deberá
      corresponder al de un usuario vendedor y deberá existir previamente en el repositorio,
      en caso contrario se lanzará una excepción.

    * **Entradas:**

      | Method | END-PONT |
      | :---        |     :---:   |
      | **POST**   |  [localhost:8080/users/{user_id}/followers/list]() |
      | **Ejemplo**  | [localhost:8080/users/4/followers/list]() |

5. **US 0004:** Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)


5. **US 0005:** Dar de alta una nueva publicación


6. **US 0006:** Obtener un listado de las publicaciones realizadas por los vendedores que 
un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha,
publicaciones más recientes primero).


7. **US 0007:** Poder realizar la acción de "Unfollow" (dejar de seguir) a un determinado vendedor.


8. **US 0008:** Ordenamiento alfabético ascendente y descendente.


9. **US 0009:** Ordenamiento por fecha ascendente y descendente.


10. **US 0010:** Llevar a cabo la publicación de un nuevo producto en promoción.


11. **US 0011:** Obtener la cantidad de productos en promoción de un determinado vendedor


12. **US 0012:** Obtener un listado de todos los productos en promoción de un determinado vendedor.


