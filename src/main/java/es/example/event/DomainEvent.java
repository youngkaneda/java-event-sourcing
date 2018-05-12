package es.example.event;

import es.example.model.Ship;

/**
 * @author Juan
 */
public abstract class DomainEvent {

    private long createdIn;
    private int shipId;

    public DomainEvent(long timeMillis, int shipId) {
        this.createdIn = timeMillis;
        this.shipId = shipId;
    }

    public abstract void applyOn(Ship ship);

    /**
     * @return the createdIn
     */
    public long getCreatedIn() {
        return createdIn;
    }

    /**
     * @return the shipId
     */
    public int getShipId() {
        return shipId;
    }
}