package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.utils.utils.RomanNumerals;

@RestController
public class HelloWorld {
    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name){
        return "Hello World " + name;
    }

@GetMapping("/roman/{num}")
    public String toRoman(@PathVariable Integer num){
    String romanNumber = RomanNumerals(num);
        return "The new number in roman is: "+ romanNumber;
}

}
