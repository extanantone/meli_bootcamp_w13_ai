package com.bootcamp.demo.demo.controller;

import com.bootcamp.demo.demo.service.RomanNumbersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumbersController {
    @GetMapping("/{num}")
    public static String romanFromDecimal(@PathVariable Integer num){
        if (num < 0) {
            return "Number should be positive";
        }
        return RomanNumbersService.getRomanFromDecimal(num);
    }
}
