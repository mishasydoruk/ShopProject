package com.example.xyeta.models;

import com.example.xyeta.models.Abstract.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "offers")
@Getter
@Setter
public class Offer extends BaseEntity {

    @ManyToOne
    private User user;

    @ManyToOne
    private Goods goods;

}
