package com.naura.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transfer")
@Getter
@Setter
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long num;

    @Column(name = "LotID")
    private String lotId;

    //@ManyToOne
//    @JoinColumn(name = "LotID")
//    private Lot lot;

    @Column(name = "MaterialName")
    private String mtName;

    @Column(name = "MaterialNameID")
    private String mtNameId;

    @Column(name = "Actor")
    private String actor;

    @Column(name = "Action")
    private String action;

    @Column(name = "Module")
    private String module;

    @Column(name = "ActParam")
    private String actparam;

    @Column(name = "trigger_time")
    private LocalDateTime triggerTime;

//    @Column(name = "collect_time")
//    private LocalDateTime collectTime;

    @Column(name = "trigger_time_ms")
    private int triggerTimeMs;
}
