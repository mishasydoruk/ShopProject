package com.example.xyeta.models;

import com.example.xyeta.models.Abstract.NamedEntity;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends NamedEntity {

}
