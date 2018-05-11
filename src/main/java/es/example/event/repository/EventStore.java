package es.example.event.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import es.example.event.DomainEvent;

/**
 * @author Juan
 */
public enum EventStore {

    INSTANCE;
    private List<DomainEvent> events;

    public void store(DomainEvent event) {
        if (events == null)
            events = new ArrayList<>();
        events.add(event);
    }

    /**
     * @return the events
     */
    public List<DomainEvent> getEvents() {
        return events;
    }

    public List<DomainEvent> getEvents(Class eventType) {
		return events.stream().filter((ev) -> eventType.isAssignableFrom(ev.getClass())).collect(Collectors.toList());
    }
}