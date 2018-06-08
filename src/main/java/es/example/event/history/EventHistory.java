package es.example.event.history;

import java.util.List;
import java.util.stream.Collectors;

import es.example.event.DomainEvent;
import es.example.event.store.EventStore;
import es.example.model.Ship;

/**
 * 
 * @author kuuhaku
 */
public class EventHistory {

    private final EventStore eventStore;

    public EventHistory(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    public Ship loadShip(int shipId) {
        Ship ship = new Ship();
        List<DomainEvent> events = eventStore.getEvents().stream()
                .filter((ev) -> ev.getShipId() == shipId).collect(Collectors.toList());
        events.forEach((ev) -> ev.applyOn(ship));
        return ship;
    }
}