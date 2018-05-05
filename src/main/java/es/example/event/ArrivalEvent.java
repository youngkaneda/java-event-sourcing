package es.example.event;

import es.example.model.Port;
import es.example.model.Ship;

/**
 * @author Juan
 */
public class ArrivalEvent implements DomainEvent{

    private Port port;

    public ArrivalEvent(Port port) {
        this.port = port;
    }

	@Override
	public void process(Ship ship) {
		ship.setPort(this.port);
	}
}