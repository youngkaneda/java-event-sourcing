package es.example;

import es.example.event.history.EventHistory;
import es.example.model.Cargo;
import es.example.model.Port;
import es.example.model.Ship;
import es.example.commandes.ShipCommandImpl;

/**
 * @author Juan
 */
public class Loader {

    public static void main(String[] args) {
        System.out.println("Processing a set of events");
        ShipCommandImpl shipManager = new ShipCommandImpl();
        int shipId = shipManager.newShip("Black Pearl", new Port("Port Royal"));
        shipManager.loadCargo(shipId, new Cargo("rum"));
        shipManager.loadCargo(shipId, new Cargo("gunpowder"));
        shipManager.departureShip(shipId);
        shipManager.arrivalShip(shipId, new Port("singapura"));
        shipManager.unloadCargo(shipId);
        System.out.println("Loading ship");
        EventHistory history = new EventHistory();
        Ship loadedShip = history.loadShip(shipId);
        System.out.println(loadedShip);
    }
}
