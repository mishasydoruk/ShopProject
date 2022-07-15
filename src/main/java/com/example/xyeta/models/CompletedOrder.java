package com.example.xyeta.models;

import com.example.xyeta.models.Abstract.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "purchases")
@Getter
@Setter
public class CompletedOrder extends BaseEntity {

    @ManyToOne
    private User user;

    @OneToOne
    private SaledGoods goods;
}
