package com.Travel.Project.Controller;

import com.Travel.Project.Service.AuthoriizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.server.servlet.OAuth2AuthorizationServerAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authorization")
public class AuthorizationController {

    @Autowired
    AuthoriizationService authorizationService;

    @PostMapping("register")
    public ResponseEntity<String> registerUser(@RequestParam String username,@RequestParam String password,@RequestParam String email,@RequestParam String number) {
        return authorizationService.registerUser(username,password,email,number);
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestParam String username,@RequestParam String password) {
        return authorizationService.login(username,password);
    }

    @PutMapping("update")
    public ResponseEntity<String> updatePassword(@RequestParam String username,@RequestParam String password,@RequestParam String newPassword) {
        return authorizationService.updatePassword(username,password,newPassword);
    }

    @GetMapping("get")
    public ResponseEntity<String> forgotPassword(@RequestParam String username) {
        return authorizationService.forgotPassword(username);
    }
}
