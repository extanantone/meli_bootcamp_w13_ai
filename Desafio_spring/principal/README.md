## Resumen Guía :"Bootcamp Backend Java Sprint Nº 1 - Spring"

### Organización del proyecto

#### Paquetes
<ul>
<li>**configuración**: Requerido para usar la libreria de ModelMapper</li>
<li>**controladores**: 2 principales, usuarios y productos</li>
<li>**enumerados**: Para definir un enumerado de opciones para los parametros de orden</li>
<li>**servicios**: Se usaron 2 Servicios, usuarios y Publicaciones</li>
<li>**excepciones**</li>
<li>**modelos**</li>
<li>**repositorios**</li>
<li>**dto**</li>
</ul>


### Clases más relevantes

Explicaré las clases más relevantes del proyecto:

- #### Repositorio:
  En el repositorio se definieron 4 collecciones que dieron el orden al proyecto:</p>
  ''' 
  private Map<Integer, Usuario> users;
  private Map<Integer, Publicacion> posts;
  private Map<Integer, List<Publicacion>> userPosts;
  private Map<Integer, List<Usuario>> usuarioySeguidores;
  private Map<Integer, List<Usuario>> usuarioySeguidos;
  ''' 

  **users y posts**: Garantizan que exista solo un 1 usuario y un post con id unico. El repositorio tiene metodos que garantizan que al guardar un dato nuevo, la key de la coleccion sea el id unico del elemento a crear y que las excepciones de unicidad se controlen con una excepción personalizada llamada  **NegocioExcepcion**.

  **userPost**: Guarda las publicaciones de un usuario asociadas a su unico id.
  **usuariouSeguidores**: Guarda una lista que relaciona un id de usuario con sus seguidores.
  **usuariouSeguidos**: Guarda una lista que relaciona un id de usuario con las personas que lo siguen.

  De esta manera se garantiza una busqueda rapida de la informacion unicamente crenado referencias a las posiciones de memoria d elos objetos guardados en **users** y **posts**.
    
     




    
