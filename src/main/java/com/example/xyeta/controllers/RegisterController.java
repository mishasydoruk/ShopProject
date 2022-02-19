package com.example.xyeta.controllers;

import com.example.xyeta.DTO.Requests.AuthRequestDTO;
import com.example.xyeta.DTO.Responses.DisplayUserDTO;
import com.example.xyeta.DTO.Requests.UserDTO;
import com.example.xyeta.Exeptions.ErrorResponse;
import com.example.xyeta.Exeptions.NotFoundResponse;
import com.example.xyeta.config.Jwt.JwtProvider;
import com.example.xyeta.models.User;
import com.example.xyeta.services.AuthService;
import com.example.xyeta.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserDTO user){

        if(userService.createUser(user)) {
            return ResponseEntity.ok("ok");
        }
        else return new ResponseEntity<>(HttpStatus.IM_USED);
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
