package com.example.demo.Controller;

import com.example.demo.Model.Body;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
 @GetMapping("/{test}")
 public String test(@PathVariable String test) {
  return "Hello World: " + test;
 }


 @PostMapping("/")
 public String post(@RequestBody Body body) {
  return "Hello World " + body.getTest();
 }
}
