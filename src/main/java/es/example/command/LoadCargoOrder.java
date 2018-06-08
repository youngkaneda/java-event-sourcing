/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example.command;

import es.example.event.CargoLoadedEvent;
import es.example.event.store.EventStore;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author kuuhaku
 */
public class LoadCargoOrder extends Command {

    private final int shipId;
    private final List<String> cargos;

    public LoadCargoOrder(EventStore eventStore, int shipId, String... cargos) {
        super(eventStore);
        this.shipId = shipId;
        this.cargos = Arrays.asList(cargos);
    }

    @Override
    public void execute() {
        cargos.forEach((cargo) -> eventStore.store(new CargoLoadedEvent(shipId, cargo)));
    }
}
