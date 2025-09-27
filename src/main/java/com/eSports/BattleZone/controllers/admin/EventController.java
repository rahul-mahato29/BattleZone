package com.eSports.BattleZone.controllers.admin;

import com.eSports.BattleZone.dto.EventDTO;
import com.eSports.BattleZone.dto.UpdateTimeRequestDTO;
import com.eSports.BattleZone.services.admin.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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

    @PatchMapping(path = "/{eventId}/update/entryAmt")
    public ResponseEntity<EventDTO> updateEventEntryAmountById(@PathVariable(name = "eventId") Long id, @RequestBody double updatedEntryAmt) {
        EventDTO event = eventService.updateEventEntryAmountById(id, updatedEntryAmt);
        return ResponseEntity.ok(event);
    }

    @PatchMapping(path = "/{eventId}/update/winAmt")
    public ResponseEntity<EventDTO> updateEventWinAmountById(@PathVariable(name = "eventId") Long id, @RequestBody double updatedWinAmt) {
        EventDTO event = eventService.updateEventWinAmountById(id, updatedWinAmt);
        return ResponseEntity.ok(event);
    }

    @PatchMapping(path = "/{eventId}/update/time")
    public ResponseEntity<EventDTO> updateEventTimeById(@PathVariable(name = "eventId") Long id, @RequestBody UpdateTimeRequestDTO updatedTime) {
        EventDTO event = eventService.updateEventTimeById(id, updatedTime);
        return ResponseEntity.ok(event);
    }
}
