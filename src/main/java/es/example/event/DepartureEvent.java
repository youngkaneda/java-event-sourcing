package es.example.event;

import es.example.model.Port;
import es.example.model.Ship;

/**
 * @author Juan
 */
public class DepartureEvent extends DomainEvent {

	private final Port port;

    public DepartureEvent(int shipId, Port port) {
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
