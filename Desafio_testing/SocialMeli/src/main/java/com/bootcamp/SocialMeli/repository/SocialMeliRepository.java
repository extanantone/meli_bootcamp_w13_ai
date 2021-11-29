package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.Producto;
import com.bootcamp.SocialMeli.model.Promocion;
import com.bootcamp.SocialMeli.model.Publicacion;
import com.bootcamp.SocialMeli.model.Usuario;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Repository
public class SocialMeliRepository implements ISocialMeliRepository{

    private Map<Integer, Usuario> usuarios;
    private Map<Integer, Publicacion> publicaciones;

    private final String jsonSource = "develop/";
    private String SCOPE;

    public SocialMeliRepository() {
        Properties properties =  new Properties();
        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            this.SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.usuarios = new HashMap<>();
        List<Usuario> listaUsuarios = cargarUsuarios();
        //se cargan los usuarios del json al Map
        for (Usuario user : listaUsuarios) {
            this.usuarios.put(user.getUserId(), user);
        }
        this.publicaciones = new HashMap<>();
        cargarPublicaciones();
    }

    /**
     * Lee desde un archivo .json todos los usuarios y los devuelve en una lista.
     * @return lista de Usuario
     */
    public List<Usuario> cargarUsuarios(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:" + jsonSource + "usuarios.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Usuario>> typeRef = new TypeReference<>() {};
        List<Usuario> usuarios = null;
        try {
            usuarios = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    /**
     * Lee desde un archivo .json todas las publicaciones y las carga en el Map de publicaciones
     */
    public void cargarPublicaciones(){
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader( "src/main/resources/" + jsonSource + "publicaciones.json"))
        {
            //Read JSON file
            JSONArray publicaciones = (JSONArray) jsonParser.parse(reader);

            //itero sobre el arreglo de JSON
            for (Object json : publicaciones) {
                Integer id = Math.toIntExact((Long)((JSONObject) json).get("user_id"));
                Publicacion publicacion = parsearJsonPublicacion((JSONObject) json);
                this.usuarios.get(id).agregarPublicacion(publicacion); //vinculo la publicacion con el vendedor
                agregarPublicacion(publicacion); //se guarda en el repositorio de publicaciones
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ClassCastException e){
            e.printStackTrace();
        }
    }

    /**
     * Parsea el JSON de un posteo a un objeto Publicacion
     * @param jsonPub objeto en formato JSON
     * @return objeto Publicacion
     */
    private Publicacion parsearJsonPublicacion(JSONObject jsonPub){
        Publicacion publicacion;
        //se pueden cargar desde el json tanto publicaciones comunes como promociones
        if(jsonPub.get("has_promo") != null){ //se chequea si se está leyendo una promocion
            publicacion = new Promocion();
            ((Promocion) publicacion).setHasPromo((boolean) jsonPub.get("has_promo"));
            ((Promocion) publicacion).setDiscount((double) jsonPub.get("discount"));
        }else{
            publicacion = new Publicacion();
        }
        publicacion.setIdPost(Math.toIntExact((Long) jsonPub.get("id_post")));
        publicacion.setCategory(Math.toIntExact((Long) jsonPub.get("category")));
        publicacion.setPrice((double) jsonPub.get("price"));

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        //convierte String a LocalDate
        publicacion.setDate(LocalDate.parse((String) jsonPub.get("date"), formato));

        Producto producto = new Producto();
        JSONObject detalle = (JSONObject) jsonPub.get("detail");
        producto.setProductId(Math.toIntExact((Long) detalle.get("product_id")));
        producto.setProductName((String) detalle.get("product_name"));
        producto.setType((String) detalle.get("type"));
        producto.setBrand((String) detalle.get("brand"));
        producto.setColor((String) detalle.get("color"));
        producto.setNotes((String) detalle.get("notes"));

        publicacion.setProducto(producto);

        return publicacion;
    }

    @Override
    public Usuario buscarUsuario(Integer idUsuario){
        return this.usuarios.get(idUsuario);
    }

    @Override
    public Publicacion buscarPublicacion(Integer idPublicacion){
        return this.publicaciones.get(idPublicacion);
    }

    @Override
    public void agregarPublicacion(Publicacion publicacion){
        this.publicaciones.put(publicacion.getIdPost(), publicacion);
    }

    @Override
    public void agregarUsuario(Usuario usuario){
        this.usuarios.put(usuario.getUserId(), usuario);
    }

}
