package com.naura.test.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ch2")
@Getter
@Setter
public class Ch2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long num;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LotID", referencedColumnName = "lotid")
    private Lot lot;
}
