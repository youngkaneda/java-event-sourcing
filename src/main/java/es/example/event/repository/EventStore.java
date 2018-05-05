package es.example.event.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.example.event.DomainEvent;
import es.example.model.Ship;
import es.example.model.ShipFactory;

/**
 * @author Juan
 */
public enum EventStore {
    
    INSTANCE;
    private Map<Integer, List<DomainEvent>> events;
    private ShipFactory shipFactory;
    
    public void store(DomainEvent event, int shipId) {
        if(events == null)
            events = new HashMap<>();
        List<DomainEvent> currentShipEvents = events.get(shipId);
        if(currentShipEvents == null)
            currentShipEvents = new ArrayList<>();
        currentShipEvents.add(event);
        events.put(shipId, currentShipEvents);
    }

    public Ship loadShip(int id) {
        if(shipFactory == null)
            shipFactory = ShipFactory.INSTANCE;
        Ship ship = shipFactory.getShip(id);
        List<DomainEvent> currentShiEvents = events.get(id);
        currentShiEvents.stream().forEach((ev) -> ev.process(ship));
        return ship;
    }
}