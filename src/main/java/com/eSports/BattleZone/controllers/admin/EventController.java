package com.eSports.BattleZone.controllers.admin;

import com.eSports.BattleZone.dto.EventDTO;
import com.eSports.BattleZone.services.admin.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/admins/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping
    public ResponseEntity<EventDTO> createEvent(@RequestBody EventDTO eventDTO) {
        EventDTO event = eventService.createEvent(eventDTO);
        return ResponseEntity.ok(event);
    }

    @PatchMapping(path = "/update/{eventId}")
    public ResponseEntity<EventDTO> updateEventEntryAmountById(@PathVariable(name = "eventId") Long id, @RequestBody double updatedEntryAmt) {
        EventDTO event = eventService.updateEventEntryAmountById(id, updatedEntryAmt);
        return ResponseEntity.ok(event);
    }
}
