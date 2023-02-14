package com.naura.test.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "chc")
@Getter
@Setter
public class ChC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long num;

    @Column(name = "trigger_time")
    private LocalDateTime triggerTime;

    @Column(name = "StepLogSegmentID")
    private int stepLogSegmentID;

    @Column(name = "LotID")
    private String lotId;

    @Column(name = "MaterialName")
    private String mtName;

    @Column(name = "RecipeName")
    private String rcpName;

    @Column(name = "RcpStepCounter")
    private int rcpStepCounter;

    @Column(name = "RcpStepName")
    private String rcpStepName;

    @Column(name = "RcpTotalStep")
    private int rcpTotalStep;

    @Column(name = "RcpStepTime")
    private double rcpStepTime;

    @Column(name = "RcpStepElapsedTime")
    private double rcpStepElapsedTime;

    @Column(name = "InnerPowerMin")
    private double iPMin;

    @Column(name = "InnerPowerMax")
    private double iPMax;

    @Column(name = "InnerPowerAvg")
    private double iPAvg;

    @Column(name = "InnerPowerStd")
    private double iPStd;

    @Column(name = "InnerPowerTSN")
    private int iPTSN;

    @Column(name = "InnerPowerBSN")
    private int iPBSN;
}
