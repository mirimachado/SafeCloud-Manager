package com.project.manager.cloud.safe.security.controllers;

import com.project.manager.cloud.safe.security.dtos.AuthenticationDTO;
import com.project.manager.cloud.safe.security.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;



    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO authDTO){
        return ResponseEntity.ok(authService.login(authDTO));
    }

}