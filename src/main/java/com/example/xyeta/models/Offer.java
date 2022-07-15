package com.example.xyeta.models;

import com.example.xyeta.models.Abstract.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "offers")
@Getter
@Setter
public class Offer extends BaseEntity {

    @ManyToOne
    private User author;

    @ManyToOne
    private Goods goods;

    @Column(name = "price", nullable = false)
    private Float price;

    @OneToMany(mappedBy = "offer")
    private Set<Response> responses;
}
