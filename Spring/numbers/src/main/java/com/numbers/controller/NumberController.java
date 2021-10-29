package com.numbers.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numbers")
public class NumberController {

    @GetMapping("/{number}")
    public String getRomanNumber(@PathVariable int number){
        return formatNumber(number);
    }

    private String formatNumber(int n){
        if(n==0) return  "";
        if(n==1) return "I";
        else if(n==2) return "II";
        else  if(n==3) return  "III";
        else if(n==4) return "IV";
        else  if(n==5) return  "V";
        else if (n==6) return "VI";
        else if(n==7) return "VII";
        else  if(n==8) return  "VIII";
        else if(n==9) return "IX";
        else  if(n<20) return "X"+formatNumber(n%10);
        else  if(n<30) return  "XX"+formatNumber(n%10);
        else  if(n<40) return "XXX"+formatNumber(n%10);
        else if(n<50) return "XL"+formatNumber(n%10);
        else  if(n<60) return  "L"+formatNumber(n%10);
        else if(n<70) return "LX"+formatNumber(n%10);
        else if(n<80) return  "LXX"+formatNumber(n%10);
        else if(n<90) return  "LXXX"+formatNumber(n%10);
        else  if(n<100) return  "XC"+formatNumber(n%10);
        else if(n==100) return  "C";
        return "";
    }

}
