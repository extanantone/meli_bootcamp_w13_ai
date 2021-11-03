package com.c2spring.ejercicio.pg;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/p2")
public class controller {

    @GetMapping("/saludar")
    public ResponseEntity<String> saludar(){
        return new ResponseEntity<>("Hola mundo funciono bien!", HttpStatus.OK);
    }

    @GetMapping("/cabeceras")
    public ResponseEntity<String> probando(){
        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add("EstadoCliente", "este seria el estado si tuviera uno");
        cabecera.add("idioma", "Español");
        return new ResponseEntity("Bienvenido a la api de prueba de cabeceras",cabecera,HttpStatus.OK);
    }

    @GetMapping("/prueba2")
    public ResponseEntity<String> probandoBodyBuilder(){
        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add("EstadoCliente", "este seria el estado si tuviera uno");
        cabecera.add("idioma", "Español");
        return ResponseEntity.ok().headers(cabecera).body("Bienvenido a la api de prueba de cabeceras");
    }

    @GetMapping("/manual")
    public void manual(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String nombre = request.getParameter("nombre");
        response.setHeader("idioma","Español");
        response.setStatus(200);
        response.getWriter().println("Hola funcionando de la manera antigua " + nombre);
    }

    @GetMapping("/probandoDto")
    public ResponseEntity<UsuarioDTO> probandoDTO(@RequestParam("id") int id,
                                  @RequestParam("nombre") String nombre,
                                  @RequestParam("apellido") String apellido)
    {
        UsuarioDTO userDTO = new UsuarioDTO();
        userDTO.setApellido(apellido);
        userDTO.setNombre(nombre);
        userDTO.setId(id);
        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }


}
