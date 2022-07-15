package com.example.xyeta.models;

import javax.validation.constraints.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

import com.example.xyeta.models.Abstract.PersonEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends PersonEntity {

    @Column(name = "email", nullable = false, unique = true)
    @Email
    private String email;

    @NotBlank
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;

    @OneToMany(mappedBy = "author")
    private Set<Offer> offers;

    @OneToMany(mappedBy = "user")
    private Set<CompletedOrder> completedOrders;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;


    public String toString(){
        return "User with email = " + email;
    }
}