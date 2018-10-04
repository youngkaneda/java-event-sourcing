/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.command;

import es.example.event.DeparturedShipEvent;
import es.example.event.store.EventStore;

/**
 *
 * @author kuuhaku
 */
public class DepartureShipOrder extends Command {

    private final int shipId;
    private final String port;

    public DepartureShipOrder(EventStore eventStore, int shipId, String port) {
        super(eventStore);
        this.port = port;
        this.shipId = shipId;
    }

    @Override
    public void execute() {
        DeparturedShipEvent event = new DeparturedShipEvent(shipId, port);
        eventStore.store(event);
    }
}
