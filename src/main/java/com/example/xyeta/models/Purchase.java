package com.example.xyeta.models;

import com.example.xyeta.models.Abstract.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "purchases")
@Getter
@Setter
public class Purchase extends BaseEntity {

    @ManyToOne
    private User user;
}
