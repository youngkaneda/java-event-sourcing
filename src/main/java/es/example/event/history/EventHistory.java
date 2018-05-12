package es.example.event.history;

import java.util.List;
import java.util.stream.Collectors;

import es.example.event.DomainEvent;
import es.example.event.repository.EventStore;
import es.example.model.Ship;
import es.example.model.ShipFactory;
import es.example.model.ShipManager;

/**
 * @author Juan
 */
public class EventHistory {

    private EventStore eventStore;
    private ShipFactory shipFactory;
    private ShipManager shipManager;

    public EventHistory() {
        shipFactory = ShipFactory.INSTANCE;
        eventStore = EventStore.INSTANCE;
        shipManager = new ShipManager();
    }

    public Ship loadShip(int shipId) {
        Ship ship = shipFactory.getShip(shipId);
        List<DomainEvent> events = eventStore.getEvents(DomainEvent.class).stream()
                .filter((ev) -> ev.getShipId() == shipId).collect(Collectors.toList());
        events.forEach((ev) -> ev.applyOn(ship));
        return ship;
    }
}