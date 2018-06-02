package es.example.event;

import es.example.model.Ship;

/**
 * @author Juan
 */
public class UnloadEvent extends DomainEvent {
    
    public UnloadEvent(int shipId) {
        super(System.currentTimeMillis(), shipId);
    }
    
    @Override
    public void applyOn(Ship ship) {
        ship.apply(this);
    }
}
