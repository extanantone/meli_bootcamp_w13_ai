package com.jpaexample.demo.controladores;

import com.jpaexample.demo.dto.NotasDto;
import com.jpaexample.demo.dto.UsuarioDto;
import com.jpaexample.demo.servicios.ServicioNotas;
import com.jpaexample.demo.servicios.Servicios;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controllers {

    private Servicios service;
    private ServicioNotas serviceNotas;


    public Controllers(Servicios service, ServicioNotas serviceNotas) {
        this.service = service;
        this.serviceNotas = serviceNotas;
    }

    @GetMapping("/")
    public String saludo(){
        return "hola mundo";
    }

    @PostMapping("/crearUser")
    public ResponseEntity<UsuarioDto> crearUser(@RequestBody UsuarioDto userInput)
    {
        return new ResponseEntity<>(service.crearUsuario(userInput), HttpStatus.OK);
    }

    @PostMapping("/crearNota")
    public ResponseEntity<NotasDto> crearNotas(@RequestBody NotasDto notaInput)
    {
        return new ResponseEntity<>(serviceNotas.crearNotas(notaInput), HttpStatus.OK);
    }

    @PutMapping("/updateUser/{dni}")
    public ResponseEntity<UsuarioDto> update(@RequestBody UsuarioDto userInput)
    {
        return new ResponseEntity<>(service.updateUser(userInput), HttpStatus.OK);
    }

    @DeleteMapping("/borrarUser/{dni}")
    public ResponseEntity<Boolean> update(@PathVariable("dni") String dni)
    {
        return new ResponseEntity<>(service.borrarUsuarios(dni), HttpStatus.OK);
    }

    @GetMapping("/obtenerUser/{dni}")
    public ResponseEntity<UsuarioDto> obtUser(@PathVariable("dni") String dni)
    {
        return new ResponseEntity<>(service.findByDni(dni), HttpStatus.OK);
    }

    @GetMapping("/obtenerUsers")
    public ResponseEntity<List<UsuarioDto>> getUsers()
    {
        return new ResponseEntity<>(service.obtenerTodos(), HttpStatus.OK);
    }


}
