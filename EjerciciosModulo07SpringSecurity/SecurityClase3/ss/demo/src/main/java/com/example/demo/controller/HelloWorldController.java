package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class HelloWorldController {
    
    @GetMapping
    public String holaMundo(){
        return "Hola mundo";
    }

    @PostMapping
    public Map<String,Object> HiMundo(@RequestBody Map<String, Object> body){
        return Map.of("message", "Hello" + body.get("name"));
    }

    @DeleteMapping("/delete/{id}")
    public String metodoDelete(@PathVariable Integer id){
        int rest = id * 2;
        return "Se ingreso al Delete "+rest;
    }

}