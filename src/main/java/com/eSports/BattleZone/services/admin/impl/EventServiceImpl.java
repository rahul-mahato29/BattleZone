package com.eSports.BattleZone.services.admin.impl;

import com.eSports.BattleZone.dto.EventDTO;
import com.eSports.BattleZone.entities.Event;
import com.eSports.BattleZone.exceptions.ResourceNotFoundException;
import com.eSports.BattleZone.repositories.EventRepository;
import com.eSports.BattleZone.services.admin.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
        Event event = eventRepository.save(toBeCreatedEvent);

        return modelMapper.map(event, EventDTO.class);
    }

    @Override
    public EventDTO updateEventEntryAmountById(Long id, double updatedEntryAmt) {
        log.info("Updating existing event entry price with event id : {}", id);

        Event event = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event not found with id : "+ id));
        event.setEntryAmt(updatedEntryAmt);
        event = eventRepository.save(event);

        return modelMapper.map(event, EventDTO.class);
    }


}
