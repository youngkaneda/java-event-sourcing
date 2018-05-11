package es.example.event;

import es.example.model.Cargo;

/**
 * @author Juan
 */
public class LoadEvent extends DomainEvent { 

    private Cargo cargo;

    public LoadEvent(int shipId, Cargo cargo) {
        super(System.currentTimeMillis(), shipId);        
        this.cargo = cargo;
    }

    /**
     * @return the cargo
     */
    public Cargo getCargo() {
        return cargo;
    }
}