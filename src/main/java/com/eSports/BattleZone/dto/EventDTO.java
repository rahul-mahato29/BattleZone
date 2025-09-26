package com.eSports.BattleZone.dto;

import com.eSports.BattleZone.entities.enums.EventType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventDTO {
    private String gameName;
    private EventType eventType;
    private double entryAmt;
    private double winAmt;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime matchTime;
}
