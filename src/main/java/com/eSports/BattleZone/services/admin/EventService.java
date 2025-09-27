package com.eSports.BattleZone.services.admin;

import com.eSports.BattleZone.dto.EventDTO;
import com.eSports.BattleZone.dto.UpdateTimeRequestDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface EventService {
    EventDTO createEvent(EventDTO eventDTO);

    List<EventDTO> getAllEvents();

    EventDTO getEventById(Long id);

    EventDTO updateEventEntryAmountById(Long id, double updatedEntryAmt);

    EventDTO updateEventWinAmountById(Long id, double updatedWinAmt);

    EventDTO updateEventTimeById(Long id, UpdateTimeRequestDTO updatedTime);

    String deleteEventById(Long id);
}
