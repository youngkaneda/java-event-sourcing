package es.example.event;

import es.example.model.Cargo;
import es.example.model.Ship;

/**
 * @author Juan
 */
public class LoadEvent extends DomainEvent {

    private Cargo cargo;

    public LoadEvent(int shipId, Cargo cargo) {
        super(System.currentTimeMillis(), shipId);
        this.cargo = cargo;
    }

    public void applyOn(Ship ship) {
        ship.apply(this);
    }

    /**
     * @return the cargo
     */
    public Cargo getCargo() {
        return cargo;
    }
}