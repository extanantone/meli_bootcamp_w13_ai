package com.bootcamp.SocialMeli.service;

import com.bootcamp.SocialMeli.dto.UsuarioDTO;
import com.bootcamp.SocialMeli.dto.request.PromocionDTO;
import com.bootcamp.SocialMeli.dto.PublicacionDTO;
import com.bootcamp.SocialMeli.dto.response.*;
import com.bootcamp.SocialMeli.exception.*;
import com.bootcamp.SocialMeli.mapper.Mapper;
import com.bootcamp.SocialMeli.model.Promocion;
import com.bootcamp.SocialMeli.model.Publicacion;
import com.bootcamp.SocialMeli.model.Usuario;
import com.bootcamp.SocialMeli.repository.ISocialMeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SocialMeliService implements ISocialMeliService{
    private final Integer CANT_DAYS_OF_2_WEEKS = 14; //cantidad de dias en 2 semanas

    private ISocialMeliRepository socialMeliRepository;

    private Mapper mapper;

    public SocialMeliService(ISocialMeliRepository socialMeliRepository, Mapper mapper) {
        this.socialMeliRepository = socialMeliRepository;
        this.mapper = mapper;
    }

    @Override
    public SuccessDTO followVendedor(Integer idSeguidor, Integer idVendedor){
        Usuario seguidor = this.socialMeliRepository.buscarUsuario(idSeguidor);
        Usuario vendedor = this.socialMeliRepository.buscarUsuario(idVendedor);

        if(idSeguidor.equals(idVendedor)) {
            throw new EqualsUserSellerException(String.format("El usuario (ID %d) no puede seguirse a sí mismo", idSeguidor));
        }else if(seguidor == null){
            throw new UserNotFoundException("No existe el usuario con ID: " + idSeguidor);
        }else if(vendedor == null){
            throw new UserNotFoundException("No existe el vendedor con ID: " + idVendedor);
        }else if(!vendedor.isVendedor()){
            throw new UserNotSellerException(String.format("El usuario (ID %d) no es un vendedor", idVendedor));
        }
        boolean loSigo = seguidor.getVendedoresSeguidos().contains(vendedor);
        if(loSigo){ //true = ya lo sigo
            throw new AlreadyFollowException(String.format("El usuario (ID %d) ya es seguidor del vendedor (ID %d)", idSeguidor, idVendedor));
        }
        seguidor.seguirVendedor(vendedor);
        vendedor.agregarSeguidor(seguidor);

        return new SuccessDTO("Followed successfully");
    }

    /**
     * Obtiene la cantidad de usuarios seguidores de un vendedor.
     * @param userId identificador del vendedor
     * @return DTO con los datos del vendedor y la cantidad de seguidores que posee
     */
    @Override
    public CantSeguidoresDTO getCantSeguidores(Integer userId) {
        Usuario vendedor = this.socialMeliRepository.buscarUsuario(userId);
        if(vendedor == null){
            throw new UserNotFoundException("No existe un vendedor con ID: " + userId);
        }else if(!vendedor.isVendedor()){
            throw new UserNotSellerException(String.format("El usuario (ID %d) no es un vendedor", userId));
        }
        CantSeguidoresDTO cantSeguidoresDTO = new CantSeguidoresDTO(vendedor.getUserId(), vendedor.getUserName(),
                                                    vendedor.getSeguidores().size());

        return cantSeguidoresDTO;
    }

    /**
     * Devuelve una lista con los datos de todos los seguidores de un vendedor.
     * @param userId identificador del vendedor.
     * @return DTO con los datos de todos los seguidores.
     */
    @Override
    public SeguidoresDTO getSeguidores(Integer userId) {
        Usuario vendedor = this.socialMeliRepository.buscarUsuario(userId);
        if(vendedor == null){
            throw new UserNotFoundException("No existe un vendedor con ID: " + userId);
        }else if(!vendedor.isVendedor()){
            throw new UserNotSellerException(String.format("El usuario (ID %d) no es un vendedor", userId));
        }

        List<UsuarioDTO> listaUsuarioDTO = new ArrayList<>();

        for (Usuario user : vendedor.getSeguidores()) {
            listaUsuarioDTO.add(new UsuarioDTO(user.getUserId(), user.getUserName()));
        }

        SeguidoresDTO seguidoresDTO = new SeguidoresDTO(vendedor.getUserId(), vendedor.getUserName(), listaUsuarioDTO);
        return seguidoresDTO;
    }

    /**
     * Igual que el método anterior pero con la diferencia que especifica el orden
     * en el que aparecen los resultados.
     * @param userId identificador del vendedor.
     * @param order orden ascendente o descendente.
     * @return DTO con los datos de todos los seguidores.
     */
    @Override
    public SeguidoresDTO getSeguidores(Integer userId, String order) {
        if(order == null){
            throw new IllegalArgumentException("Argumento null en 'order'");
        }
        SeguidoresDTO seguidoresDTO = getSeguidores(userId);
        if(order.equals("name_asc")){
            seguidoresDTO.getFollowers().sort(Comparator.comparing(UsuarioDTO::getUserName));
        }else if(order.equals("name_desc")){
            seguidoresDTO.getFollowers().sort(Comparator.comparing(UsuarioDTO::getUserName).reversed());
        }else{
            throw new IllegalArgumentException("Argumento invalido en 'order'");
        }
        return seguidoresDTO;
    }

    /**
     * Obtiene una lista de los vendedores que sigue un usuario.
     * @param userId identificador del usuario.
     * @return DTO con la lista de vendedores seguidos.
     */
    @Override
    public SeguidosDTO getVendedoresSeguidos(Integer userId) {
        Usuario usuario = this.socialMeliRepository.buscarUsuario(userId);
        if(usuario == null){
            throw new UserNotFoundException("No existe un usuario con ID: " + userId);
        }
        List<UsuarioDTO> listaUsuarioDTO = new ArrayList<>();
        for (Usuario user : usuario.getVendedoresSeguidos()) {
            listaUsuarioDTO.add(new UsuarioDTO(user.getUserId(), user.getUserName()));
        }
        SeguidosDTO seguidosDTO = new SeguidosDTO(usuario.getUserId(), usuario.getUserName(), listaUsuarioDTO);
        return seguidosDTO;
    }

    /**
     * Igual que el método anterior pero con la diferencia que especifica el orden
     * en el que aparecen los resultados.
     * @param userId identificador del usuario.
     * @param order orden ascendente o descendente.
     * @return DTO con los datos de todos los vendedores que sigue este usuario.
     */
    @Override
    public SeguidosDTO getVendedoresSeguidos(Integer userId, String order) {
        if(order == null){
            throw new IllegalArgumentException("Argumento null en 'order'");
        }
        SeguidosDTO seguidosDTO = getVendedoresSeguidos(userId);
        if(order.equals("name_asc")){
            seguidosDTO.getFollowed().sort(Comparator.comparing(UsuarioDTO::getUserName));
        }else if(order.equals("name_desc")){
            seguidosDTO.getFollowed().sort(Comparator.comparing(UsuarioDTO::getUserName).reversed());
        }else{
            throw new IllegalArgumentException("Argumento invalido en 'order'");
        }
        return seguidosDTO;
    }

    /**
     * Crea una nueva publicacion (sea promocion o no).
     * @param post DTO con los datos de la publicacion.
     * @return
     */
    @Override
    public SuccessDTO crearPublicacion(PublicacionDTO post) {
        Usuario usuario = this.socialMeliRepository.buscarUsuario(post.getUserId());
        if(usuario == null){
            throw new UserNotFoundException("No existe el usuario con ID: " + post.getUserId());
        }
        //no puede haber dos publicaciones con el mismo ID
        if(this.socialMeliRepository.buscarPublicacion(post.getIdPost()) != null){
            throw new DuplicateIDException("Ya existe una publicacion con ID: " + post.getIdPost());
        }
        if(post.getDate().isAfter(LocalDate.now())){ //chequea si la fecha de la publicacion es de hoy o dias anteriores
            throw new FutureDateException("La fecha " + post.getDate() + " es posterior al dia de hoy");
        }
        if(post.getPrice() < 0){ //precio no puede ser negativo
            throw new InvalidPriceException();
        }

        Publicacion nuevaPublicacion;
        String mensaje;

        if(post instanceof PromocionDTO){ //es una promocion?
            //se chequean los limites del porcentaje a aplicar
            if(((PromocionDTO) post).getDiscount() < 0.0 || ((PromocionDTO) post).getDiscount() > 1.0){
                throw new InvalidDiscountException();
            }
            nuevaPublicacion = this.mapper.promocionDTOToPromocion((PromocionDTO) post);
            mensaje = "Promocion creada correctamente.";
        }else{
            nuevaPublicacion = this.mapper.publicacionDTOToPublicacion(post);
            mensaje = "Publicacion creada correctamente.";
        }

        usuario.agregarPublicacion(nuevaPublicacion);
        this.socialMeliRepository.agregarPublicacion(nuevaPublicacion);

        return new SuccessDTO(mensaje);
    }

    /**
     * Obtiene las publicaciones y promociones que postearon los vendedores que sigue
     * determinado usuario en las últimas dos semanas.
     * @param userId Identificador del usuario (seguidor).
     * @return DTO con la lista de publicaciones ordenadas desde la mas reciente a la mas antigua.
     */
    @Override
    public PublicacionesDTO getPublicacionesSeguidos(Integer userId) {
        Usuario usuario = this.socialMeliRepository.buscarUsuario(userId);
        if(usuario == null){
            throw new UserNotFoundException("No existe el usuario con ID: " + userId);
        }
        List<Usuario> seguidos = usuario.getVendedoresSeguidos();
        List<Publicacion> publicaciones = new ArrayList<>();

        //junta todas las publicaciones de todos los vendedores que sigue el usuario
        for (Usuario vendedor : seguidos) {
            publicaciones.addAll(vendedor.getPublicaciones());
        }
        //se filtran publicaciones de las ultimas 2 semanas
        List<Publicacion> publicacionesRecientes = publicaciones.stream()
                                                                .filter(x -> {
                                                                    Period periodo = x.getDate().until(LocalDate.now());
                                                                    return periodo.getDays() < CANT_DAYS_OF_2_WEEKS
                                                                            && periodo.getDays() >= 0
                                                                            && periodo.getMonths() == 0
                                                                            && periodo.getYears() == 0;
                                                                })
                                                                .collect(Collectors.toList());
        //ordeno de las mas recientes a las mas antiguas (por defecto)
        publicacionesRecientes.sort(Comparator.comparing(Publicacion::getDate).reversed());

        PublicacionesDTO publicacionesDTO = this.mapper.listPublicacionToPublicacionesDTO(usuario.getUserId(), publicacionesRecientes);

        return publicacionesDTO;
    }

    /**
     * Igual que el método anterior, pero se especifica un orden para los posteos
     * segun la fecha de publicacion.
     * @param userId Identificador del cliente.
     * @param order orden ascendente o descendente.
     * @return DTO con la lista de publicaciones ordenadas.
     */
    @Override
    public PublicacionesDTO getPublicacionesSeguidos(Integer userId, String order) {
        if(order == null){
            throw new IllegalArgumentException("Argumento null en 'order'");
        }
        PublicacionesDTO publicacionesDTO = getPublicacionesSeguidos(userId);
        if(order.equals("date_asc")){
            publicacionesDTO.getPosts().sort(Comparator.comparing(PublicacionDTO::getDate));
        }else if(!order.equals("date_desc")){  //el ordenamiento por defecto es date_desc
            throw new IllegalArgumentException("Argumento invalido en 'order'");
        }
        return publicacionesDTO;
    }

    @Override
    public SuccessDTO unfollowVendedor(Integer idSeguidor, Integer idVendedor) {
        Usuario seguidor = this.socialMeliRepository.buscarUsuario(idSeguidor);
        Usuario vendedor = this.socialMeliRepository.buscarUsuario(idVendedor);
        //no se chequea si el usuario seguido es un vendedor porque eso se hace al momento de seguirlo
        if(idSeguidor.equals(idVendedor)){ //no se puede dejar de seguir a si mismo
            throw new EqualsUserSellerException(String.format("El usuario (ID %d) no puede dejar de seguirse a sí mismo", idSeguidor));
        }else if(seguidor == null){
            throw new UserNotFoundException("No existe el usuario con ID: " + idSeguidor);
        }else if(vendedor == null){
            throw new UserNotFoundException("No existe el vendedor con ID: " + idVendedor);
        }
        boolean loSeguia = seguidor.dejarDeSeguirVendedor(vendedor);
        if(!loSeguia){ //si loSeguia es falso quiere decir que vendedor no estaba en la lista de seguidos
            throw new NotFollowException(String.format("El usuario (ID %d) no es seguidor del vendedor (ID %d)", idSeguidor, idVendedor));
        }
        vendedor.eliminarSeguidor(seguidor);

        return new SuccessDTO("Unfollowed successfully");
    }

    /**
     * Obtiene la lista de promociones que tiene determinado vendedor.
     * @param userId Identificador del vendedor.
     * @return DTO con la lista de promociones.
     */
    @Override
    public PromocionesDTO getProductosEnPromocion(Integer userId) {
        Usuario vendedor = this.socialMeliRepository.buscarUsuario(userId);
        if(vendedor == null){
            throw new UserNotFoundException("No existe el usuario con ID: " + userId);
        }else if(!vendedor.isVendedor()){
            throw new UserNotSellerException(String.format("El usuario (ID %d) no es un vendedor", userId));
        }

        List<Publicacion> promociones = getPromociones(vendedor);

        List<InfoPromoDTO> promos = new ArrayList<>();
        for (Publicacion pub : promociones) {
            promos.add(this.mapper.publicacionToInfoPromoDTO((Promocion) pub));
        }

        return new PromocionesDTO(vendedor.getUserId(), vendedor.getUserName(), promos);
    }

    /**
     * Igual que el método anterior pero se especifica el orden en que se muestran las
     * promociones segun el nombre del producto.
     * @param userId Identificador del vendedor.
     * @param order orden ascendente o descendente.
     * @return DTO con la lista de promociones ordenada.
     */
    @Override
    public PromocionesDTO getProductosEnPromocion(Integer userId, String order) {
        PromocionesDTO promocionesDTO = getProductosEnPromocion(userId);

        if(order.equals("name_asc")){
            promocionesDTO.getPosts().sort(Comparator.comparing(x -> x.getDetail().getProductName()));
        }else if(order.equals("name_desc")){
            promocionesDTO.getPosts().sort(Comparator.comparing(x -> x.getDetail().getProductName()));
            Collections.reverse(promocionesDTO.getPosts());
        }else{
            throw new IllegalArgumentException("Argumento invalido en 'order'");
        }
        return promocionesDTO;
    }

    /**
     * Filtra aquellas publicaciones de un vendedor que sean promociones.
     * @param user vendedor
     * @return lista de promociones
     */
    private List<Publicacion> getPromociones(Usuario user){
        List<Publicacion> promociones = user.getPublicaciones().stream().filter(x -> x instanceof Promocion)
                                            .collect(Collectors.toList());
        return promociones;
    }

    /**
     * Obtiene la cantidad de publicaciones en promocion que tiene un vendedor.
     * @param userId Identificador del vendedor.
     * @return DTO con la cantidad de promociones.
     */
    @Override
    public CantPromocionesDTO getCantPromociones(Integer userId) {
        Usuario vendedor = this.socialMeliRepository.buscarUsuario(userId);
        if(vendedor == null){
            throw new UserNotFoundException("No existe el usuario con ID: " + userId);
        }else if(!vendedor.isVendedor()){
            throw new UserNotSellerException(String.format("El usuario (ID %d) no es un vendedor", userId));
        }

        CantPromocionesDTO cantPromocionesDTO = new CantPromocionesDTO();
        cantPromocionesDTO.setUserId(vendedor.getUserId());
        cantPromocionesDTO.setUserName(vendedor.getUserName());
        cantPromocionesDTO.setPromoProductsCount(getPromociones(vendedor).size());

        return cantPromocionesDTO;
    }

    /**
     * Crea un nuevo usuario, con ID y nombre especificados, pero sin seguidores,
     * ni vendedores seguidos, ni publicaciones.
     * @param usuarioDTO DTO con ID y nombre del usuario.
     * @return
     */
    @Override
    public SuccessDTO crearUsuario(UsuarioDTO usuarioDTO) {
        //no puede haber dos usuarios con igual ID
        if(this.socialMeliRepository.buscarUsuario(usuarioDTO.getUserId()) != null){
            throw new DuplicateIDException("Ya existe un usuario con ID: " + usuarioDTO.getUserId());
        }

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setUserId(usuarioDTO.getUserId());
        nuevoUsuario.setUserName(usuarioDTO.getUserName());

        this.socialMeliRepository.agregarUsuario(nuevoUsuario);
        return new SuccessDTO("Usuario creado exitosamente");
    }
}
