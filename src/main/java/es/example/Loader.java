package es.example;

import es.example.event.ArrivalEvent;
import es.example.event.DepartureEvent;
import es.example.event.LoadEvent;
import es.example.event.UnloadEvent;
import es.example.event.manager.EventManager;
import es.example.event.repository.EventStore;
import es.example.model.Cargo;
import es.example.model.Port;
import es.example.model.Ship;
import es.example.model.ShipFactory;

/**
 * @author Juan
 */
public class Loader {
    public static void main(String[] args) {
        System.out.println("Creating a ship");
        Ship ship = ShipFactory.INSTANCE.createShip("black pearl", new Port("port royal"));
        EventManager eventManager = new EventManager();
        System.out.println("Processing a set of events");
        eventManager.ProcessEvent(new LoadEvent(new Cargo("gunpowder"), new Cargo("rum")), ship);
        System.out.println(ship);
        eventManager.ProcessEvent(new DepartureEvent(), ship);
        System.out.println(ship);  
        eventManager.ProcessEvent(new ArrivalEvent(new Port("singapura")), ship);
        System.out.println(ship);
        eventManager.ProcessEvent(new UnloadEvent(), ship);
        System.out.println(ship);
        System.out.println("Loading ship");
        Ship loadedShip = EventStore.INSTANCE.loadShip(ship.getId());
        System.out.println(loadedShip);
    }
}
