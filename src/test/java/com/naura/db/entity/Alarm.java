package com.naura.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alarmlog")
@Getter
@Setter
public class Alarm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;

    private String name;
    private int id;
    private String severity;
    private String message;
    private String description;
    private String poster;
    private String recovtype;
    private String recovactor;
    private LocalDateTime posttime, recovtime;
}
