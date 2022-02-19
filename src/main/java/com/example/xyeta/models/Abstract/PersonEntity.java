package com.example.xyeta.models.Abstract;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
public abstract class PersonEntity extends BaseEntity {

    @NotBlank
    @Column(name = "username", nullable = false, unique = true)
    @Getter
    @Setter
    private String username;

}
