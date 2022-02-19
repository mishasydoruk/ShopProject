package com.example.xyeta.services;

import com.example.xyeta.DTO.Requests.AuthRequestDTO;
import com.example.xyeta.config.Jwt.JwtProvider;
import com.example.xyeta.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean checkLogin(AuthRequestDTO authRequestDTO, User user) {

        return passwordEncoder.matches(authRequestDTO.getPassword(), user.getPassword());
    }

    public boolean authentificate(User user){

        String currentUsername = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUsername = authentication.getName();
        }

        return user.getUsername().equals(currentUsername) || user.getRole().getName() == "ROLE_ADMIN";
    }

}
