/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.command;

import es.example.event.ShipCreatedEvent;
import es.example.event.store.EventStore;

/**
 *
 * @author kuuhaku
 */
public class CreateShipOrder extends Command {

    private final int shipId;
    private final String name;
    private final String port;

    public CreateShipOrder(EventStore eventStore, int shipId, String name, String port) {
        super(eventStore);
        this.shipId = shipId;
        this.name = name;
        this.port = port;
    }

    @Override
    public void execute() {
        ShipCreatedEvent event = new ShipCreatedEvent(shipId, name, port);
        eventStore.store(event);
    }
}
