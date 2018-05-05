package es.example.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Juan
 */
public enum ShipFactory {
    INSTANCE;
    private Map<Integer, Ship> ships;

    public Ship createShip(String name, Port port) {
        if(ships == null)
            ships = new HashMap<>();
        int id = UUID.randomUUID().hashCode();
        Ship ship = new Ship(id, name, port);
        ships.put(id, ship);
        return ship;
    }

    public Ship getShip(int id) {
        return ships.get(id);
    }
}