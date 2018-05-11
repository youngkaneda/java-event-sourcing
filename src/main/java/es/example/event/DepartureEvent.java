package es.example.event;

import es.example.model.Port;

/**
 * @author Juan
 */
public class DepartureEvent extends DomainEvent {

	private Port port;

	public DepartureEvent(int shipId, Port port) {
        super(System.currentTimeMillis(), shipId);		
		this.port = port;
	}

	/**
	 * @return the port
	 */
	public Port getPort() {
		return port;
	}
}