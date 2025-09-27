package com.eSports.BattleZone.entities;

import com.eSports.BattleZone.entities.enums.EventType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String gameName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventType type;

    @Column(nullable = false)
    private double entryAmt;

    @Column(nullable = false)
    private double winAmt;

    @Column(nullable = false)
    private LocalDateTime matchTime;

    private boolean isActive;
}
