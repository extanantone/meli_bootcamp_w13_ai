package com.bootcamp.SocialMeli.repository;

import com.bootcamp.SocialMeli.model.Producto;
import com.bootcamp.SocialMeli.model.Publicacion;
import com.bootcamp.SocialMeli.model.Usuario;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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

@Repository
public class SocialMeliRepository implements ISocialMeliRepository{

    private Map<Integer, Usuario> usuarios;
    private Map<Integer, Publicacion> publicaciones;

    private final String json_source = "develop/";

    public SocialMeliRepository() {
        this.usuarios = new HashMap<>();
        List<Usuario> listaUsuarios = cargarUsuarios();

        for (Usuario user : listaUsuarios) {
            this.usuarios.put(user.getUserId(), user);
        }
        this.publicaciones = new HashMap<>();
        cargarPublicaciones();
    }

    public List<Usuario> cargarUsuarios(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:" + json_source + "usuarios.json");
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

    public void cargarPublicaciones(){
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader( "src/main/resources/" + json_source + "publicaciones.json"))
        {
            //Read JSON file
            JSONArray publicaciones = (JSONArray) jsonParser.parse(reader);

            //itero sobre el arreglo de JSON
            for (Object json : publicaciones) {
                Integer id = Math.toIntExact((Long)((JSONObject) json).get("user_id"));
                Publicacion publicacion = parsearJsonPublicacion((JSONObject) json);
                this.usuarios.get(id).agregarPublicacion(publicacion);
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

    private Publicacion parsearJsonPublicacion(JSONObject jsonPub){
        Publicacion publicacion = new Publicacion();
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


    /*
    public List<Usuario> buscarSeguidores(Usuario vendedor){
        List<Usuario> seguidores = this.usuarios.values().stream()
                                        .filter(x -> x.getVendedoresSeguidos().contains(vendedor))
                                        .collect(Collectors.toList());
        return seguidores;
    }*/

}
