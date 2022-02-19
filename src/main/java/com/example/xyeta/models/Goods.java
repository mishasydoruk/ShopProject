package com.example.xyeta.models;

import com.example.xyeta.models.Abstract.NamedEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="goods")
@Getter
@Setter
public class Goods extends NamedEntity {

    @ManyToMany(mappedBy = "goods")
    private Set<Category> categories;

    @OneToMany(mappedBy = "goods")
    private Set<Offer> offers;

    @Column(name = "description", nullable = false)
    public String description;

    @Column(name = "attributes", nullable = false)
    public String attributes;

    @Column(name = "creating_date", nullable = false)
    public Date creatingDate;

}
