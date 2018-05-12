package es.example.event;

import es.example.model.Port;
import es.example.model.Ship;

/**
 * @author Juan
 */
public class DepartureEvent extends DomainEvent {

	private Port port;

	public DepartureEvent(int shipId, Port port) {
        super(System.currentTimeMillis(), shipId);		
		this.port = port;
	}

	public void applyOn(Ship ship) {
        ship.apply(this);
    }

	/**
	 * @return the port
	 */
	public Port getPort() {
		return port;
	}
}