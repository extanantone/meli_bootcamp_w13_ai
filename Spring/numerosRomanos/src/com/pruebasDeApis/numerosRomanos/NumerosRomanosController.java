package com.pruebasDeApis.numerosRomanos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class NumerosRomanosController {
	//@RestController
	@GetMapping ("/{numero}")
	public String devolverNumeroRomano(@PathVariable int numero){
		HashMap<Integer,String> map = new HashMap();
		map.put(1,"I");
		map.put(2,"II");
		map.put(3,"III");
		map.put(4,"IV");
		map.put(5,"V");
		map.put(7,"VII");
		map.put(10,"X");
		map.put(13,"XIII");
		map.put(50,"C");

		return map.get(numero);


	}
}
