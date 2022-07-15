package com.example.xyeta.models;

import com.example.xyeta.models.Abstract.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "saled_goods")
@Getter
@Setter
public class SaledGoods extends BaseEntity {

    @OneToOne
    private Goods goods;

    @OneToOne
    private User customer;

    @Column(name = "fixed_price", nullable = false)
    private Float fixed_price;

    @Column(name = "paid", nullable = false)
    private boolean paid;

    @Column(name = "date_of_departure", nullable = false)
    private Date dateOfDeparture;
}
