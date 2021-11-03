package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

import static com.example.demo.utils.utils.RomanNumerals;

import static com.example.demo.utils.utils.englishToMorse;
import static com.example.demo.utils.utils.checkDateBetween;

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

@GetMapping("/englishToMorse/{string}")
    public String englishToMorse(@PathVariable String string){
    String morse = englishToMorse(string);
        return "The morse code of " + string + " is: " + morse;
}

@GetMapping("/dates/{year}/{month}/{day}")
    public String getYearsWithDate(@PathVariable String year,@PathVariable String month,@PathVariable String day) throws ParseException {
        String date = year + "-" + month + "-" + day;
        String years = checkDateBetween(date);
        return years;
}

}
