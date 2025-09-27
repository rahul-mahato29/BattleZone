package com.eSports.BattleZone.services.admin.impl;

import com.eSports.BattleZone.dto.EventDTO;
import com.eSports.BattleZone.dto.UpdateTimeRequestDTO;
import com.eSports.BattleZone.entities.Event;
import com.eSports.BattleZone.exceptions.ResourceNotFoundException;
import com.eSports.BattleZone.repositories.EventRepository;
import com.eSports.BattleZone.services.admin.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;

    @Override
    public EventDTO createEvent(EventDTO eventDTO) {
        log.info("Creating a new event of : {}", eventDTO.getGameName());

        //todo - check same event already present

        Event toBeCreatedEvent = modelMapper.map(eventDTO, Event.class);
//        toBeCreatedEvent.setActive(true);
        Event event = eventRepository.save(toBeCreatedEvent);

        return modelMapper.map(event, EventDTO.class);
    }

    @Override
    public EventDTO updateEventEntryAmountById(Long id, double updatedEntryAmt) {
        log.info("Updating event entry price with event id : {}", id);

        Event event = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event not found with id : "+ id));
        event.setEntryAmt(updatedEntryAmt);
        event = eventRepository.save(event);

        return modelMapper.map(event, EventDTO.class);
    }

    @Override
    public EventDTO updateEventWinAmountById(Long id, double updatedWinAmt) {
        log.info("Updating event Win Amount with event id : {}", id);

        Event event = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event not found with id : "+ id));
        event.setWinAmt(updatedWinAmt);
        event = eventRepository.save(event);

        return modelMapper.map(event, EventDTO.class);
    }

    @Override
    public EventDTO updateEventTimeById(Long id, UpdateTimeRequestDTO updatedTime) {
        log.info("Updating event time with event id : {}", id);

        Event event = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event not found with id : "+ id));
        LocalDateTime updatedMatchTime = modelMapper.map(updatedTime, LocalDateTime.class);
        event.setMatchTime(updatedMatchTime);
        event = eventRepository.save(event);

        return modelMapper.map(event, EventDTO.class);
    }


}
