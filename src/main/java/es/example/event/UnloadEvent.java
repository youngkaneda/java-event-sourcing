package es.example.event;

/**
 * @author Juan
 */
public class UnloadEvent extends DomainEvent {

	public UnloadEvent(int shipId) {
        super(System.currentTimeMillis(), shipId);				
	}
}