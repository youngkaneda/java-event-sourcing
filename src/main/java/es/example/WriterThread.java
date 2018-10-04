/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.example;

import es.example.command.ArrivalShipOrder;
import es.example.command.CargoUnloadedOrder;
import es.example.command.Command;
import es.example.command.CommandHandler;
import es.example.command.CreateShipOrder;
import es.example.command.DepartureShipOrder;
import es.example.command.LoadCargoOrder;
import es.example.event.repository.JPAEventRepository;
import es.example.event.store.EventStore;
import es.example.mq.AMQProducer;
import java.util.UUID;

/**
 *
 * @author kuuhaku
 */
public class WriterThread implements Runnable {

    @Override
    public void run() {
        int id = UUID.randomUUID().hashCode();
        EventStore eventStore = new EventStore(new JPAEventRepository("event_unit"), new AMQProducer("es.ship.Topic"));
        Command command = new CreateShipOrder(eventStore, id, "Black Pearl", "Port Royal");
        CommandHandler.handle(command);
        command = new LoadCargoOrder(eventStore, id, "firestone", "bacon", "milk");
        CommandHandler.handle(command);
        command = new DepartureShipOrder(eventStore, id, "On the Sea");
        CommandHandler.handle(command);
        command = new ArrivalShipOrder(eventStore, id, "Tortuga");
        CommandHandler.handle(command);
        command = new CargoUnloadedOrder(eventStore, id);
        CommandHandler.handle(command);
        eventStore.close();
    }
}
