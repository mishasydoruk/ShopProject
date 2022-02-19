package com.example.xyeta.models.Abstract;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
public abstract class NamedEntity extends BaseEntity {

    @NotBlank
    @Column(name = "name", nullable = false)
    @Getter
    @Setter
    protected String name;
}
