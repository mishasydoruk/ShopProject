package com.example.xyeta.controllers;

import com.example.xyeta.DTO.Requests.AuthRequestDTO;
import com.example.xyeta.DTO.Requests.UserDTO;
import com.example.xyeta.config.Jwt.JwtProvider;
import com.example.xyeta.models.User;
import com.example.xyeta.services.AuthService;
import com.example.xyeta.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RegisterController {

    private static Logger log = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody UserDTO user)  {

        try {
            return new ResponseEntity<>(userService.createUser(user).join(), HttpStatus.OK);
        }
        catch (Throwable e){
            log.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.IM_USED);
        }
    }


    @PostMapping("/auth")
    public ResponseEntity<?> auth(@RequestBody AuthRequestDTO request) {
        User user = userService.getDatabaseUserByUsername(request.getUsername());

        if (!authService.checkLogin(request, user)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        }
        String token = jwtProvider.generateToken(user.getUsername());
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

}
