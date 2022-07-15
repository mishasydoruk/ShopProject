package com.example.xyeta.services;

import com.example.xyeta.DTO.Responses.DisplayUserDTO;
import com.example.xyeta.DTO.Requests.UserDTO;
import com.example.xyeta.Exeptions.AlreadyExistsExeption;
import com.example.xyeta.models.User;
import com.example.xyeta.repository.RoleRepository;
import com.example.xyeta.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final ModelMapper modelMapper = new ModelMapper();

    public List<User> getAllUsers(){
        return new ArrayList<>(userRepository.findAll());
    }

    @Async("asyncExecutor")
    public CompletableFuture<User> createUser(UserDTO userDTO) throws AlreadyExistsExeption {
        User userToSave = modelMapper.map(userDTO, User.class);

        if (userRepository.findUserByEmail(userToSave.getEmail()) != null) {

            throw new AlreadyExistsExeption(userToSave.toString());
        }
        else {
            userToSave.setRegistrationDate(LocalDateTime.now());
            userToSave.setRole(roleRepository.findRoleByName("ROLE_USER"));
            userToSave.setPassword(passwordEncoder.encode(userToSave.getPassword()));
            userRepository.save(userToSave);
            return CompletableFuture.completedFuture(userToSave);
        }

    }

    public DisplayUserDTO getUserByUuid(UUID uuid)
    {
        User userInDatabase = userRepository.findUserByUuid(uuid);
        if (userInDatabase == null)
        {
            return null;
        }
        DisplayUserDTO userToSend = modelMapper.map(userInDatabase, DisplayUserDTO.class);
        return userToSend;
    }

    public User getDatabaseUserByUuid(UUID uuid)
    {
        User userToSend = userRepository.findUserByUuid(uuid);

        return userToSend;
    }

    public DisplayUserDTO getUserByEmail(String email)
    {
        User userInDatabase = userRepository.findUserByEmail(email);

        if (userInDatabase == null)
        {
            return null;
        }

        DisplayUserDTO userToSend = modelMapper.map(userInDatabase, DisplayUserDTO.class);
        return userToSend;
    }

    public User getDatabaseUserByUsername(String username)
    {
        User userToSend = userRepository.findUserByUsername(username);

        return userToSend;
    }

}
