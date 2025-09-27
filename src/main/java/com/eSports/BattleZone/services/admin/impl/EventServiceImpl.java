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
import java.util.List;
import java.util.stream.Collectors;

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
        toBeCreatedEvent.setActive(true);
        Event event = eventRepository.save(toBeCreatedEvent);

        return modelMapper.map(event, EventDTO.class);
    }

    @Override
    public List<EventDTO> getAllEvents() {
        log.info("Getting All Events");
        List<Event> eventList = eventRepository.findAll();
        return eventList
                .stream()
                .map(event -> modelMapper.map(event, EventDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EventDTO getEventById(Long id) {
        log.info("Getting the event with id : {}", id);
        Event event = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event not found id : "+ id));
        return modelMapper.map(event, EventDTO.class);
    }

    @Override
    public List<EventDTO> getAllActiveEvents() {
        log.info("Getting all active events");

        List<Event> eventList = eventRepository.findAll();
        List<Event> activeEventList = eventList.stream().filter(event -> event.isActive() == true).collect(Collectors.toList());

        return activeEventList.stream().map(activeEvent -> modelMapper.map(activeEvent, EventDTO.class)).collect(Collectors.toList());
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

        //todo - Check how to update time of an event
        Event event = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event not found with id : "+ id));
        LocalDateTime updatedMatchTime = modelMapper.map(updatedTime, LocalDateTime.class);
        event.setMatchTime(updatedMatchTime);
        event = eventRepository.save(event);

        return modelMapper.map(event, EventDTO.class);
    }

    @Override
    public String deleteEventById(Long id) {
        log.info("Deleting the event with id : {}", id);

        Event event = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event not foudn with id : "+ id));
        if(event != null) {
            eventRepository.deleteById(id);
            return "Event Successfully Deleted!!";
        }
        else {
            return "Event Not Found!!";
        }
    }


}
