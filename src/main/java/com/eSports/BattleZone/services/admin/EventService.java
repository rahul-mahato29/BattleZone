package com.eSports.BattleZone.services.admin;

import com.eSports.BattleZone.dto.EventDTO;
import com.eSports.BattleZone.dto.UpdateTimeRequestDTO;

import java.time.LocalDateTime;

public interface EventService {
    EventDTO createEvent(EventDTO eventDTO);

    EventDTO updateEventEntryAmountById(Long id, double updatedEntryAmt);

    EventDTO updateEventWinAmountById(Long id, double updatedWinAmt);

    EventDTO updateEventTimeById(Long id, UpdateTimeRequestDTO updatedTime);

    String deleteEventById(Long id);
}
