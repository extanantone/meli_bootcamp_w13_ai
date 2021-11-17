Social Meli

Se crean 4 usuarios al subir la api
        id:1,name:"Juan"
        id:2,name:"Manuel"
        id:3,name:"Julian"
        id:4,name:"Carlos"
    El cual se crea por defecto con el atributo Tipo= Usuario.

1- El Sistema se compone de tres objetos de dominio principales y uno que se encarga de la relación Seguidor
   a- User
   b- Post
   c- PromoPost(extiende de Post)
   d- Seguidor(relación)
 
2- Funcionalidad
   * - User pude seguir a cualquier User solo una vez y no a si mismo,
   * - Cualquier user puede ser vendedor  
   * - El tipo User cambia automáticamente al momento de ingresar un Post con su id de Usuario a Vendedor 
 
* Se puede crear usuarios con Json por @RequestBody link http://localhost:8080/users/users si un usuario ya existe rompe la inserción
ejemplo
{
   {
       "user_id":5,
       "user_name":"Usuario5"
   }
   {
       "user_id":6,
       "user_name":"Usuario6"
   }
}
 
* Todo se maneja en un solo repositorio el cual tiene las cuatro listas
   List<Seguidor> seguidors = new ArrayList<>();
   List<User> users = new ArrayList<>();
   List<Post> posts = new ArrayList<>();
   List<PromoPost> promoPosts = new ArrayList<>();
   En el cual se realizan todas las operaciones.
