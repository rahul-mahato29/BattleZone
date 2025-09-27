package com.eSports.BattleZone.controllers.admin;

import com.eSports.BattleZone.dto.EventDTO;
import com.eSports.BattleZone.dto.UpdateTimeRequestDTO;
import com.eSports.BattleZone.services.admin.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        List<EventDTO> eventList = eventService.getAllEvents();
        return ResponseEntity.ok(eventList);
    }

    @GetMapping(path = "/{eventId}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable(name = "eventId") Long id) {
        EventDTO event = eventService.getEventById(id);
        return ResponseEntity.ok(event);
    }

    @GetMapping(path = "/active")
    public ResponseEntity<List<EventDTO>> getAllActiveEvent() {
        List<EventDTO> activeEvents = eventService.getAllActiveEvents();
        return ResponseEntity.ok(activeEvents);
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

    @DeleteMapping(path = "/{eventId}")
    public ResponseEntity<String> deleteEventById(@PathVariable(name = "eventId") Long id) {
        String message = eventService.deleteEventById(id);
        return ResponseEntity.ok(message);
    }
}
