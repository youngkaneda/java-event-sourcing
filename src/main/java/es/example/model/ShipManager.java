package es.example.model;

import es.example.event.ArrivalEvent;
import es.example.event.DepartureEvent;
import es.example.event.DomainEvent;
import es.example.event.LoadEvent;
import es.example.event.UnloadEvent;
import es.example.event.repository.EventStore;

/**
 * @author Juan
 */
public class ShipManager {

    private EventStore evStore;
    private final Port departurePort;

    public ShipManager() {
        departurePort = new Port("on the sea");
        evStore = EventStore.INSTANCE;
    }

    public void loadCargo(Ship ship, Cargo cargo) {
        ship.addCargo(cargo);
        LoadEvent event = new LoadEvent(ship.getId(), cargo);
        storeEvent(event);
    }

    public void unloadCargo(Ship ship) {
        ship.emptyCargo();
        UnloadEvent event = new UnloadEvent(ship.getId());
        storeEvent(event);
    }

    public void departureShip(Ship ship) {
        ship.setPort(this.departurePort);
        DepartureEvent event = new DepartureEvent(ship.getId(), this.departurePort);
        storeEvent(event);
    }

    public void arrivalShip(Ship ship, Port port) {
        ship.setPort(port);
        ArrivalEvent event = new ArrivalEvent(ship.getId(), port);
        storeEvent(event);
    }

    private void storeEvent(DomainEvent event) {
        evStore.store(event);
    }
}