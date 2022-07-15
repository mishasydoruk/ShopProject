package com.example.xyeta.controllers;

import com.example.xyeta.DTO.Responses.DisplayUserDTO;
import com.example.xyeta.Exeptions.ErrorResponse;
import com.example.xyeta.Exeptions.NotFoundExeption;
import com.example.xyeta.services.AuthService;
import com.example.xyeta.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    AuthService authService;

    @GetMapping("/user/{uuid}")
    public ResponseEntity<?> getUser(@PathVariable UUID uuid){

        if(!authService.authentificate(userService.getDatabaseUserByUuid(uuid)))
        {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        DisplayUserDTO userToSend = userService.getUserByUuid(uuid);

        if (userToSend == null)
        {
            ErrorResponse errorResponse = new NotFoundExeption( "User with uuid" + uuid.toString());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userToSend, HttpStatus.OK);
    }

}
