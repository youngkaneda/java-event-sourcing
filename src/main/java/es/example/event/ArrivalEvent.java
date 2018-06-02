package es.example.event;

import es.example.model.Port;
import es.example.model.Ship;

/**
 * @author Juan
 */
public class ArrivalEvent extends DomainEvent{

    private final Port port;
    
    public ArrivalEvent(int shipId, Port port) {
        super(System.currentTimeMillis(), shipId);
        this.port = port;
    }

    @Override
    public void applyOn(Ship ship) {
        ship.apply(this);
    }

    public Port getPort() {
        return port;
    }
}