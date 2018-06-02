/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.event;

import es.example.model.Port;
import es.example.model.Ship;

/**
 *
 * @author kuuhaku
 */
public class NewShipEvent extends DomainEvent {

    private final String name;
    private final Port port;
    
    public NewShipEvent(long timeMillis, int shipId, String name, Port port) {
        super(timeMillis, shipId);
        this.name = name;
        this.port = port;
    }

    @Override
    public void applyOn(Ship ship) {
        ship.apply(this);
    }

    public String getName() {
        return name;
    }

    public Port getPort() {
        return port;
    }
}
