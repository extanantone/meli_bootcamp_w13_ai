package com.example.test.SpringAnottations.controller;

import com.example.test.SpringAnottations.model.Employee;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class HelloRestController {

    @GetMapping (path = "{name}/{lastname}/{age}")
    public String sayHello (@PathVariable String name,
                            @PathVariable String lastname,
                            @PathVariable Integer age) {

        return ("Hola," + name + " " + lastname + " " + "Tu edad es: " + age);
    }

    //@PathVariable
    //Es una anotación que permite extraer información que es parte de la estructura
    //de la URI pero que no se trata como un par nombre=valor.
    @GetMapping("/user/{userId}")
    public void getUser (@PathVariable("userId") String userId){
        System.out.println("Mi nombre es: " + userId);
    }

    //@RequestParam

    //En una anotación que permite recibir parámetros desde una ruta mediante el método GET, para
    //trabajar con ellos e incluso poder emitir una respuesta que dependa de los parámetros que sean
    //obtenidos.
    //Cada uno de los parámetros generalmente se ubican en la URL después de un signo de pregunta
    //“?” y están anidados por un “&”.
    //● Por ejemplo: http://localhost:8080/student?name=”Horacio”&lastname=”Quiroga”

    @GetMapping(path = "/student/")
    public String testingRequestParams (@RequestParam String name,
                                      @RequestParam String lastname)
    {
        return ("Hola," + name + " " + lastname);
    }


    //Multiples parametros
    //Con el metodo post

    //La anotación @PostMapping se usa para mapear
    //solicitudes HTTP POST en métodos de controlador.
    //Es una alternativa de:
    //@RequestMapping (method = RequestMethod.POST)

    //Los métodos anotados con @PostMapping manejan
    //las solicitudes HTTP POST que coinciden con una
    //URI determinada.


    //RequestBody permite vincular solicitud HTTP con un objeto en un parametro en un metodo de nuestro controlador.
    //Permite deserializacion automatica

@PostMapping (path ="/test")
    public void addEmployee(@RequestBody Employee Employee){

}

//@ResponseBody

    //Es una anotación que es utilizada para indicar
    //el contenido de una respuesta HTTP
    //(response) dentro del cuerpo de la misma.
    //● Una respuesta HTTP no puede contener
    //objetos Java, por lo que @ResponseBody se
    //encarga de transformar los objetos a formato
    //JSON o XML.


    //Ejemplo: el método getOrders devuelve
    //una lista de órdenes. @ResponseBody se
    //encarga de transformar esa lista de objetos
    //en un json.

    @GetMapping (path ="/orders/")
    @ResponseBody
    public List<Object> getOrders() {

        //return ordersManager.getAllOrders();
        return null;
    }










}
