package es.example.event;

import es.example.model.Ship;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * 
 * @author kuuhaku
 */
@Entity
@PrimaryKeyJoinColumn(name = "domain_ev")
public class CargoUnloadedEvent extends DomainEvent {
    
    public CargoUnloadedEvent() {
    }
    
    public CargoUnloadedEvent(int shipId) {
        super(System.currentTimeMillis(), shipId);
    }
    
    @Override
    public void applyOn(Ship ship) {
        ship.apply(this);
    }
}
