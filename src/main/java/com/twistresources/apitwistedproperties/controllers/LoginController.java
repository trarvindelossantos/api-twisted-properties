package com.twistresources.apitwistedproperties.controllers;

import com.twistresources.apitwistedproperties.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public Object login(){
        return loginService.auth();
    }

}

