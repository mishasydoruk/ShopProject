package com.example.xyeta.models;

import com.example.xyeta.models.Abstract.NamedEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="categories")
@Getter
@Setter
public class Category extends NamedEntity {

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Goods> goods;
}
