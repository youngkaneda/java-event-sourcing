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

    private final String port;

    public DepartureShipOrder(EventStore eventStore, String port) {
        super(eventStore);
        this.port = port;
    }

    @Override
    public void execute() {
        DeparturedShipEvent event = new DeparturedShipEvent(0, port);
        eventStore.store(event);
    }
}
