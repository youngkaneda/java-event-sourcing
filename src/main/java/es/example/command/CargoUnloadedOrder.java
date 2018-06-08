/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.command;

import es.example.event.CargoUnloadedEvent;
import es.example.event.store.EventStore;

/**
 *
 * @author kuuhaku
 */
public class CargoUnloadedOrder extends Command {

    private final int shipId;

    public CargoUnloadedOrder(EventStore eventStore, int shipId) {
        super(eventStore);
        this.shipId = shipId;
    }

    @Override
    public void execute() {
        CargoUnloadedEvent event = new CargoUnloadedEvent(shipId);
        eventStore.store(event);
    }
}
