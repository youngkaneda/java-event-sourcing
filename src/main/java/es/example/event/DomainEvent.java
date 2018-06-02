package es.example.event;

import es.example.model.Ship;

/**
 * @author Juan
 */
public abstract class DomainEvent {

    private final long createdIn;
    private final int shipId;
    
    public DomainEvent(long timeMillis, int shipId) {
        this.createdIn = timeMillis;
        this.shipId = shipId;
    }

    public abstract void applyOn(Ship ship);
    
    public long getCreatedIn() {
        return createdIn;
    }

    public int getShipId() {
        return shipId;
    }
}
