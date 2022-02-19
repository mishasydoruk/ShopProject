package com.example.xyeta.models.Abstract;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(name = "uuid", nullable = false)
    @Getter
    @Setter
    protected UUID uuid;

    public BaseEntity()
    {
        uuid = UUID.randomUUID();
    }


}
