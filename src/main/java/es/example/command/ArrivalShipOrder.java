/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.command;

import es.example.event.ArrivedShipEvent;
import es.example.event.store.EventStore;

/**
 *
 * @author kuuhaku
 */
public class ArrivalShipOrder extends Command {

    private final int shipId;
    private final String port;

    public ArrivalShipOrder(EventStore eventStore, int shipId, String port) {
        super(eventStore);
        this.shipId = shipId;
        this.port = port;
    }
    
    @Override
    public void execute() {
        ArrivedShipEvent event = new ArrivedShipEvent(shipId, port);
        eventStore.store(event);
    }    
}
