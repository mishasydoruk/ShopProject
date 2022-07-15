package com.example.xyeta.models;

import com.example.xyeta.models.Abstract.NamedEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role extends NamedEntity {

}
