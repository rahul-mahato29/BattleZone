package com.eSports.BattleZone.dto;

import com.eSports.BattleZone.entities.enums.EventType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    private String gameName;
    private EventType type;

    private double entryAmt;
    private double winAmt;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime matchTime;

    private boolean isActive;
}
