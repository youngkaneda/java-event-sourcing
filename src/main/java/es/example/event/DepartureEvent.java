package es.example.event;

import es.example.model.Port;
import es.example.model.Ship;

/**
 * @author Juan
 */
public class DepartureEvent implements DomainEvent {

	@Override
	public void process(Ship ship) {
		ship.setPort(new Port("on the sea"));
	}
}