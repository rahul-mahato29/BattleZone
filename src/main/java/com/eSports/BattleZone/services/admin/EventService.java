package com.eSports.BattleZone.services.admin;

import com.eSports.BattleZone.dto.EventDTO;

public interface EventService {
    EventDTO createEvent(EventDTO eventDTO);

    EventDTO updateEventEntryAmountById(Long id, double updatedEntryAmt);
}
