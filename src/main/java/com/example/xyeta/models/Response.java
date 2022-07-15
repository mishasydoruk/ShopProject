package com.example.xyeta.models;

import com.example.xyeta.models.Abstract.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "responses")
@Getter
@Setter
public class Response extends BaseEntity {

    @Column(name="text", nullable = false)
    private String text;

    @ManyToOne
    private User creator;

    @ManyToOne(cascade = CascadeType.ALL)
    private Offer offer;

    @Column(name = "price", nullable = false)
    private Float price;
}
