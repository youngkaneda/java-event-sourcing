package es.example.event;

import es.example.model.Ship;

/**
 * @author Juan
 */
public class UnloadEvent implements DomainEvent{

    public UnloadEvent() {}

	@Override
	public void process(Ship ship) {
        ship.setCargos(null);
	}
}