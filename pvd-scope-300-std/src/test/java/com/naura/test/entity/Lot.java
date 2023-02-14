package com.naura.test.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "lot")
@Getter
@Setter
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;

//    @OneToOne(mappedBy = "lot", cascade = CascadeType.ALL)
//    private Ch2 ch2;

    private String id, lotid;

    private LocalDateTime starttime, endtime;
}
