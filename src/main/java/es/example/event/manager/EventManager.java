package es.example.event.manager;

import es.example.event.DomainEvent;
import es.example.event.repository.EventStore;
import es.example.model.Ship;

/**
 * @author Juan
 */
public class EventManager {
    
    private EventStore eventStore;

    public EventManager() {
        eventStore = EventStore.INSTANCE;
    }

    public void ProcessEvent(DomainEvent event, Ship ship) {
        event.process(ship);
        eventStore.store(event, ship.getId());
        System.out.println("an " + event.getClass() + " has occurent on " + ship.getName());
    }
}