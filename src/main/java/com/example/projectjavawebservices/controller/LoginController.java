package com.example.projectjavawebservices.controller;

import com.example.projectjavawebservices.dto.JwtRequestDTO;
import com.example.projectjavawebservices.services.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity <String> authenticate(@RequestBody JwtRequestDTO jwtRequestDTO){

        return loginService.authenticate(jwtRequestDTO.username(), jwtRequestDTO.password());
    }


//    @GetMapping("/validate")
//    public Boolean validate(@RequestParam String token){
//        return  loginService.validate(token);
//
//    }

}
