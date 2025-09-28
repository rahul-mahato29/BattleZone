package com.eSports.BattleZone.entities;

import com.eSports.BattleZone.entities.enums.BookingStatus;
import com.eSports.BattleZone.entities.enums.EventType;
import com.eSports.BattleZone.entities.enums.Game;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "slot_booking")
public class SlotBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Game game;

    @ManyToOne
    @Column(nullable = false)
    private Event event;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventType eventType;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private User user;

    @Column(nullable = false)
    private String teamName;

    @ManyToMany
    private List<TeamMember> guests;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @Column(nullable = false, precision = 5, scale = 2)
    private double amount;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
