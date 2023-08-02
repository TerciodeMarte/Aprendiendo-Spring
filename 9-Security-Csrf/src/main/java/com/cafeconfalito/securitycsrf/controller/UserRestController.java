package com.cafeconfalito.securitycsrf.controller;

import com.cafeconfalito.securitycsrf.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    @GetMapping("/hola")
    public String hola(){
        return "Hello World";
    }

    @GetMapping("/api/adios")
    public String adios(){
        return "GoodBye World";
    }

    @PostMapping("/api/users")
    public String save(@RequestBody UserDTO userDTO){
        System.out.println(userDTO);
        return "OK";
    }
}
