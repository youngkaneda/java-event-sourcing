package es.example;

import es.example.event.history.EventHistory;
import es.example.model.Cargo;
import es.example.model.Port;
import es.example.model.Ship;
import es.example.model.ShipFactory;
import es.example.model.ShipManager;

/**
 * @author Juan
 */
public class Loader {
    public static void main(String[] args) {
        System.out.println("Creating a ship");
        Ship ship = ShipFactory.INSTANCE.createShip("black pearl", new Port("port royal"));
        ShipManager shipManager = new ShipManager();
        System.out.println("Processing a set of events");
        shipManager.loadCargo(ship, new Cargo("rum", ship.getId()));
        System.out.println(ship);
        shipManager.loadCargo(ship, new Cargo("gunpowder", ship.getId()));
        System.out.println(ship);
        shipManager.departureShip(ship);
        System.out.println(ship);  
        shipManager.arrivalShip(ship, new Port("singapura"));
        System.out.println(ship);
        shipManager.unloadCargo(ship);
        System.out.println(ship);
        //System.out.println("Loading ship");
        //...
    }
}
