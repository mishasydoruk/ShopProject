package com.example.xyeta.services;

import com.example.xyeta.DTO.Responses.DisplayUserDTO;
import com.example.xyeta.DTO.Requests.UserDTO;
import com.example.xyeta.models.User;
import com.example.xyeta.repository.RoleRepository;
import com.example.xyeta.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Component
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
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public boolean createUser(UserDTO userDTO)
    {
        User userToSave = modelMapper.map(userDTO, User.class);

        if (userRepository.findUserByEmail(userToSave.getEmail()) != null) {

            return false;
        }
        else {
            userToSave.setRegistrationDate(LocalDateTime.now());
            userToSave.setRole(roleRepository.findRoleByName("ROLE_USER"));
            userToSave.setPassword(passwordEncoder.encode(userToSave.getPassword()));
            userRepository.save(userToSave);
            return true;
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
